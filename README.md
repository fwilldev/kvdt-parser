# KVDT-Parser

Analysiert [KVDT-Dateien](https://de.wikipedia.org/wiki/KVDT) (.CON-Dateien) und gibt sie in einem für Menschen lesbaren Format als CSV und HTML aus.

In den Dateien werden die einzelnen Container entsprechend getrennt und mit Feldkennung, Beschreibung und Wert dargestellt.

Referenz ist die [KVDT-Datensatzbeschreibung](https://update.kbv.de/ita-update/Abrechnung/KBV_ITA_VGEX_Datensatzbeschreibung_KVDT.pdf) der KBV.

Die Applikation wurde auf Basis von Maven und GraalVM gebaut und unterstützt GraalVM's ahead-of-time compilation um ein natives Image für bessere Performance zu erzeugen.

Natürlich kann die Applikation auch ganz normal mit Maven ein .jar erzeugen oder in jeder IDE laufen.

## 🚧TODOS

- Verifizierung der Dateien
- Lesen verschlüsselter KVDT-Dateien
- Release Pipelines

## Anwendung

Die Applikation ist eine reine Konsolen-Anwendung.

### Systemvorraussetzungen

Installierte Software:
- Maven
- JDK 21 (z.B. Eclipse Temurin oder OpenJDK)
- GraalVM for JDK 21 (Optional)

#### Starten

In der Konsole einfach den Pfad zur .CON Datei als Argument übergeben - dies können auch mehrere Dateien sein. Dabei kann das native-image verwendet werden, oder eben die .jar.

```./kvdt-parser /pfad/zur/con/Beispiel.CON```

Die CSV- und HTML-Dateien befinden sich dann im selben Pfad wie die kvdt-parser-Anwendung.

#### Selbst kompilieren

Alle relevanten Dateien werden im ``/target`` Ordner gespeichert.

.jar erzeugen:

```./mvnw clean package``` 

Konfiguration des GraalVM Agents im ```/target/native-image``` Ordner zu erzeugen:

```./mvnw -Pnative -Dagent exec:exec@java-agent``` 

Native-Image bauen:

```./mvnw -Pnative -Dagent package```


# kvdt-parser
