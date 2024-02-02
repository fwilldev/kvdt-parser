package de.fwill.dev.kvdtparser;

import de.fwill.dev.kvdtparser.model.KvdtFields;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import me.tongfei.progressbar.ProgressBar;
import me.tongfei.progressbar.ProgressBarBuilder;

import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@Slf4j
public class ConParser {

    static final Pattern CON_PATTERN = Pattern.compile("^(?:Q_)?Z01[\\d]{9}_\\d{2}\\.\\d{2}\\.\\d{4}_\\d{2}\\.\\d{2}\\.[cC][oO][nN]$");
    static final String HTML_HEAD = "<html>\n" +
            "<head>\n" +
            "<style>\n" +
            "body {\n" +
            "  font-family: arial, sans-serif;\n" +
            "}\n" +
            "table {\n" +
            "  font-family: arial, sans-serif;\n" +
            "  border-collapse: collapse;\n" +
            "  width: 100%;\n" +
            "}\n" +
            "\n" +
            "td, th {\n" +
            "  border: 1px solid #999494;\n" +
            "  text-align: left;\n" +
            "  padding: 8px;\n" +
            "}\n" +
            "\n" +
            "tr:nth-child(even) {\n" +
            "  background-color: #dddddd;\n" +
            "}\n" +
            "</style>\n" +
            "</head>";

    @SneakyThrows
    public static void parse(String file) {
        Path conFile = Paths.get(file);
        StringBuilder csv = new StringBuilder();
        StringBuilder html = new StringBuilder();
        StringBuilder summaryHtml = new StringBuilder();
        String lastCode = "";
        Map<String, BigDecimal> cipherAmount = new HashMap<>();
        if (CON_PATTERN.matcher(conFile.getFileName().toString()).matches()) {
            Map<String, String> fieldMap = KvdtFields.CONTENT;
            try (Stream<String> lines = Files.lines(conFile, Charset.forName("ISO-8859-15"))) {
                html.append(HTML_HEAD);
                summaryHtml.append(HTML_HEAD);
                summaryHtml.append("<body>");
                summaryHtml.append("<h1>KVDT Parser</h1> ")
                        .append("<h2>Zusammenfassung für Datei:")
                        .append(file)
                        .append(" vom ")
                        .append(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm").format(LocalDateTime.now()))
                        .append("</h2>");

                html.append("<body>");
                html.append("<h1>KVDT Parser</h1> ")
                        .append("<h2>Ergebnis für Datei:")
                        .append(file)
                        .append(" vom ")
                        .append(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm").format(LocalDateTime.now()))
                        .append("</h2>");
                csv.append("Feldkennung;").append("Beschreibung;").append("Wert").append(System.lineSeparator());
                for (String line : ProgressBar.wrap(lines.toList(), new ProgressBarBuilder()
                        .setTaskName(conFile.getFileName().toString())
                        .continuousUpdate())) {
                    String key = line.substring(3, 7);
                    String value = line.substring(7);
                    if (key.equals("8000")) {
                        csv.append("Satzart;");
                        if (html.toString().contains("<table>")) {
                            html.append("</table>");
                        }
                        html.append("<h3>Satzart: ");
                        switch (value) {
                            case "con0" -> {
                                csv.append("Container Header;").append(System.lineSeparator());
                                html.append("Container Header</h3>");
                            }
                            case "besa" -> {
                                csv.append("Betriebsstättendaten;").append(System.lineSeparator());
                                html.append("Betriebsstättendaten</h3>");

                            }
                            case "rvsa" -> {
                                csv.append("Ringversuchszertifikate;").append(System.lineSeparator());
                                html.append("Ringversuchszertifikate</h3>");
                            }
                            case "con9" -> {
                                csv.append("Container Abschluss;").append(System.lineSeparator());
                                html.append("Container Abschluss</h3>");

                            }
                            case "adt0" -> {
                                csv.append("ADT Datenpaket Header;").append(System.lineSeparator());
                                html.append("ADT Datenpaket Header</h3>");
                            }
                            case "adt9" -> {
                                csv.append("ADT Datenpaket Abschluss;").append(System.lineSeparator());
                                html.append("ADT Datenpaket Abschluss</h3>");
                            }
                            case "0101" -> {
                                csv.append("Ambulante Behandlung;").append(System.lineSeparator());
                                html.append("Ambulante Behandlung</h3>");
                            }
                            case "0102" -> {
                                csv.append("Überweisung;").append(System.lineSeparator());
                                html.append("Überweisung</h3>");

                            }
                            case "0103" -> {
                                csv.append("Belegärztliche Behandlung;").append(System.lineSeparator());
                                html.append("Belegärztliche Behandlung</h3>");
                            }
                            case "0104" -> {
                                csv.append("Notfalldienst/Vertretung/Notfall;").append(System.lineSeparator());
                                csv.append("Belegärztliche Behandlung</h3>");
                            }
                            default -> {
                                csv.append("Unbekannt").append(value).append(";").append(System.lineSeparator());
                                csv.append("Unbekannt</h3>");
                            }
                        }
                        html.append("<table>")
                                .append("<tr>")
                                .append("<th>")
                                .append("Feldkennung")
                                .append("</th>")
                                .append("<th>")
                                .append("Beschreibung")
                                .append("</th>")
                                .append("<th>")
                                .append("Wert")
                                .append("</th>")
                                .append("</tr>");
                        continue;
                    }
                    if (fieldMap.get(key) != null) {
                        if (key.equals("5001")) {
                            lastCode = value;
                            // how often appears a cipher?
                            if (cipherAmount.containsKey(lastCode)) {
                                cipherAmount.computeIfPresent(lastCode, (s, bigDecimal) -> bigDecimal.add(BigDecimal.ONE));
                            } else {
                                cipherAmount.put(lastCode, BigDecimal.ONE);
                            }
                        }
                        // apply multiplicator for the last processed code if multiplicator is present
                        if (key.equals("5005")) {
                            if (!lastCode.isBlank()) {
                                // substract by one because we add 1 to that cypher if a cypher is found
                                cipherAmount.computeIfPresent(lastCode, (s, bigDecimal) -> bigDecimal.add(new BigDecimal(value)).subtract(BigDecimal.ONE));
                            }
                        }
                        html.append("<tr>")
                                .append("<td>")
                                .append(key)
                                .append("</td>")
                                .append("<td>")
                                .append(fieldMap.get(key))
                                .append("</td>")
                                .append("<td>")
                                .append(value)
                                .append("</td>")
                                .append("</tr>")
                        ;
                        csv.append(key).append(";").append(fieldMap.get(key)).append(";").append(value).append(System.lineSeparator());
                    } else {
                        log.info("Unbekannte Feldkennung: {}", key);
                        html.append("<tr>")
                                .append("<td>")
                                .append(key)
                                .append("</td>")
                                .append("<td>")
                                .append("Unbekannt")
                                .append("</td>")
                                .append("<td>")
                                .append(value)
                                .append("</td>")
                                .append("</tr>");
                        csv.append(key).append(";").append("Unbekannt").append(";").append(value).append(System.lineSeparator());
                    }

                }
            }
        }
        summaryHtml.append("<table>")
                .append("<tr>")
                .append("<td>")
                .append("Ziffer")
                .append("</td>")
                .append("<td>")
                .append("Anzahl")
                .append("</td>")
                .append("</tr>");
        cipherAmount.forEach((cipher, amount) -> {
            summaryHtml
                    .append("<tr>")
                    .append("<td>")
                    .append(cipher)
                    .append("</td>")
                    .append("<td>")
                    .append(amount)
                    .append("</td>")
                    .append("</tr>");
        });
        summaryHtml.append("</table>");
        BigDecimal totalSum = cipherAmount.values().stream().reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
        summaryHtml.append("<h2>Gesamt: ").append(totalSum).append("</h2>");
        summaryHtml.append("</body></html>");
        html.append("</body></html>");
        try (FileOutputStream fos = new FileOutputStream(conFile.getFileName().toString() + "_ergebnis.csv")) {
            byte[] csvBytes = csv.toString().getBytes();
            fos.write(csvBytes);
        }
        try (FileOutputStream fosHtml = new FileOutputStream(conFile.getFileName().toString() + "_ergebnis.html")) {
            byte[] htmlBytes = html.toString().getBytes();
            fosHtml.write(htmlBytes);
        }
        try (FileOutputStream fosHtmlSummary = new FileOutputStream(conFile.getFileName().toString() + "_zusammenfassung.html")) {
            byte[] htmlBytes = summaryHtml.toString().getBytes();
            fosHtmlSummary.write(htmlBytes);
        }
      /*  try (FileOutputStream outputStream = new FileOutputStream(conFile.getFileName().toString() + "_ergebnis.pdf")) {
            ITextRenderer renderer = new ITextRenderer();
            SharedContext sharedContext = renderer.getSharedContext();
            sharedContext.setPrint(true);
            sharedContext.setInteractive(false);
            renderer.setDocumentFromString(html.toString());
            renderer.layout();
            renderer.createPDF(outputStream);
        }*/
    }

}
