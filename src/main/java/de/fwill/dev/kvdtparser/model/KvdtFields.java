package de.fwill.dev.kvdtparser.model;


import lombok.Data;
import vjson.JSON;
import vjson.deserializer.rule.ArrayRule;
import vjson.deserializer.rule.ObjectRule;
import vjson.deserializer.rule.StringRule;

import java.util.*;

public final class KvdtFields {

    public static final String FIELD_DEFINITIONS = "[\n" +
            " {\n" +
            "   \"description\": \"Softwareverantwortlicher (SV)\",\n" +
            "   \"field\": \"0102\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Software\",\n" +
            "   \"field\": \"0103\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"KBV-Prüfnummer\",\n" +
            "   \"field\": \"0105\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Email-Adresse des SV\",\n" +
            "   \"field\": \"0111\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Strasse des SV\",\n" +
            "   \"field\": \"0121\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"PLZ des SV\",\n" +
            "   \"field\": \"0122\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Ort des SV\",\n" +
            "   \"field\": \"0123\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Telefonnummer des SV\",\n" +
            "   \"field\": \"0124\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Telefaxnummer des SV\",\n" +
            "   \"field\": \"0125\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Regionaler Systembetreuer SB\",\n" +
            "   \"field\": \"0126\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Strasse des SB\",\n" +
            "   \"field\": \"0127\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"PLZ des SB\",\n" +
            "   \"field\": \"0128\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Ort des SB\",\n" +
            "   \"field\": \"0129\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Telefonnummer des SB\",\n" +
            "   \"field\": \"0130\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Telefaxnummer des SB\",\n" +
            "   \"field\": \"0131\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Release-Stand der Software\",\n" +
            "   \"field\": \"0132\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Betriebs- (BSNR) oder Nebenbetriebsstättennummer (NBSNR)\",\n" +
            "   \"field\": \"0201\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Krankenhaus-IK (im Rahmen der ASV-Abrechnung)\",\n" +
            "   \"field\": \"0213\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Empfänger\",\n" +
            "   \"field\": \"0214\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"(N)BSNR-/Krankenhaus-Bezeichnung\",\n" +
            "   \"field\": \"0203\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Straße der (N)BSNR-/Krankenhaus-Adresse\",\n" +
            "   \"field\": \"0205\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Telefonnummer\",\n" +
            "   \"field\": \"0208\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Telefaxnummer\",\n" +
            "   \"field\": \"0209\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Arztname/Erläuterung\",\n" +
            "   \"field\": \"0211\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Lebenslange Arztnummer (LANR)\",\n" +
            "   \"field\": \"0212\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"PLZ der (N)BSNR-/Krankenhaus-Adresse\",\n" +
            "   \"field\": \"0215\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Ort der (N)BSNR-/Krankenhaus-Adresse\",\n" +
            "   \"field\": \"0216\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"E-Mail der Betriebsstätte/Praxis/Krankenhaus\",\n" +
            "   \"field\": \"0218\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Titel des Arztes\",\n" +
            "   \"field\": \"0219\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Arztvorname\",\n" +
            "   \"field\": \"0220\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Namenszusatz des Arztes\",\n" +
            "   \"field\": \"0221\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"ASV-Teamnummer\",\n" +
            "   \"field\": \"0222\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Pseudo-LANR für Krankenhausärzte im Rahmen der ASV-Abrechnung\",\n" +
            "   \"field\": \"0223\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Produkttypversion des Konnektors\",\n" +
            "   \"field\": \"0224\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"TI-Fachanwendung\",\n" +
            "   \"field\": \"0225\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Systemunterstützung\",\n" +
            "   \"field\": \"0226\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Ablaufdatum des Konnektor-Zertifikats\",\n" +
            "   \"field\": \"0227\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Produktname des Konnektors\",\n" +
            "   \"field\": \"0228\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Abrechnung von (zertifikatspflichtigen) Laborleistungen\",\n" +
            "   \"field\": \"0300\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"pnSD/uu-Analysen\",\n" +
            "   \"field\": \"0301\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Gerätetyp\",\n" +
            "   \"field\": \"0302\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Hersteller\",\n" +
            "   \"field\": \"0303\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Analyt-ID\",\n" +
            "   \"field\": \"0304\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"RV-Zertifikat\",\n" +
            "   \"field\": \"0305\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Patientennummer\",\n" +
            "   \"field\": \"3000\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Schein-ID\",\n" +
            "   \"field\": \"3003\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Kennziffer SA\",\n" +
            "   \"field\": \"3005\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"CDM Version\",\n" +
            "   \"field\": \"3006\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Datum und Uhrzeit der Onlineprüfung und -aktualisierung (Timestamp)\",\n" +
            "   \"field\": \"3010\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Ergebnis der Onlineprüfung und -aktualisierung\",\n" +
            "   \"field\": \"3011\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Error-Code\",\n" +
            "   \"field\": \"3012\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Prüfziffer des Fachdienstes\",\n" +
            "   \"field\": \"3013\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Namenszusatz\",\n" +
            "   \"field\": \"3100\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Name\",\n" +
            "   \"field\": \"3101\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Vorname\",\n" +
            "   \"field\": \"3102\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Geburtsdatum\",\n" +
            "   \"field\": \"3103\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Titel\",\n" +
            "   \"field\": \"3104\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Versichertennummer\",\n" +
            "   \"field\": \"3105\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Straße\",\n" +
            "   \"field\": \"3107\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Versichertenart\",\n" +
            "   \"field\": \"3108\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Versichertenart\",\n" +
            "   \"field\": \"3108\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Versichertenart\",\n" +
            "   \"field\": \"3108\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Hausnummer\",\n" +
            "   \"field\": \"3109\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Geschlecht\",\n" +
            "   \"field\": \"3110\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Geschlecht\",\n" +
            "   \"field\": \"3110\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Geschlecht\",\n" +
            "   \"field\": \"3110\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Geschlecht\",\n" +
            "   \"field\": \"3110\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Geschlecht\",\n" +
            "   \"field\": \"3110\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"PLZ\",\n" +
            "   \"field\": \"3112\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Ort\",\n" +
            "   \"field\": \"3113\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Wohnsitzländercode\",\n" +
            "   \"field\": \"3114\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Anschriftenzusatz\",\n" +
            "   \"field\": \"3115\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"WOP\",\n" +
            "   \"field\": \"3116\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Versicherten-ID\",\n" +
            "   \"field\": \"3119\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Vorsatzwort\",\n" +
            "   \"field\": \"3120\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Postfach PLZ\",\n" +
            "   \"field\": \"3121\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Postfach Ort\",\n" +
            "   \"field\": \"3122\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Postfach\",\n" +
            "   \"field\": \"3123\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Postfach Wohnsitzländercode\",\n" +
            "   \"field\": \"3124\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Image-ID für eingescannte Scheine\",\n" +
            "   \"field\": \"3300\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Dauerdiagnose (ICD-Code)\",\n" +
            "   \"field\": \"3673\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Diagnosesicherheit Dauerdiagnose\",\n" +
            "   \"field\": \"3674\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Seitenlokalisation Dauerdiagnose\",\n" +
            "   \"field\": \"3675\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Diagnosenerläuterung Dauerdiagnose\",\n" +
            "   \"field\": \"3676\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Diagnosenausnahmetatbestand Dauerdiagnosen\",\n" +
            "   \"field\": \"3677\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Quartal\",\n" +
            "   \"field\": \"4101\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Ausstellungsdatum\",\n" +
            "   \"field\": \"4102\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Probenentnahmedatum\",\n" +
            "   \"field\": \"4116\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Vermittlungs-/Kontaktart\",\n" +
            "   \"field\": \"4103\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Abrechnungs-VKNR\",\n" +
            "   \"field\": \"4104\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Ergänzende Informationen zur Vermittlungs-/Kontaktart\",\n" +
            "   \"field\": \"4105\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Kostenträger-Abrechnungsbereich (KTAB)\",\n" +
            "   \"field\": \"4106\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Vermittlungscode\",\n" +
            "   \"field\": \"4114\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Zulassungsnummer (mobiles Lesegerät)\",\n" +
            "   \"field\": \"4108\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Letzter Einlesetag der Versichertenkarte im Quartal\",\n" +
            "   \"field\": \"4109\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Versicherungsschutz Ende\",\n" +
            "   \"field\": \"4110\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Kostentraegerkennung\",\n" +
            "   \"field\": \"4111\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Tag der Terminvermittlung\",\n" +
            "   \"field\": \"4115\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Gebührenordnung\",\n" +
            "   \"field\": \"4121\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Abrechnungsgebiet\",\n" +
            "   \"field\": \"4122\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Personenkreis/Untersuchungskategorie\",\n" +
            "   \"field\": \"4123\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Personenkreis/Untersuchungskategorie\",\n" +
            "   \"field\": \"4123\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Personenkreis/Untersuchungskategorie\",\n" +
            "   \"field\": \"4123\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Personenkreis/Untersuchungskategorie\",\n" +
            "   \"field\": \"4123\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Personenkreis/Untersuchungskategorie\",\n" +
            "   \"field\": \"4123\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Personenkreis/Untersuchungskategorie\",\n" +
            "   \"field\": \"4123\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Personenkreis/Untersuchungskategorie\",\n" +
            "   \"field\": \"4123\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Personenkreis/Untersuchungskategorie\",\n" +
            "   \"field\": \"4123\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Personenkreis/Untersuchungskategorie\",\n" +
            "   \"field\": \"4123\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Personenkreis/Untersuchungskategorie\",\n" +
            "   \"field\": \"4123\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Personenkreis/Untersuchungskategorie\",\n" +
            "   \"field\": \"4123\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Personenkreis/Untersuchungskategorie\",\n" +
            "   \"field\": \"4123\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"SKT-Zusatzangaben\",\n" +
            "   \"field\": \"4124\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Gültigkeitszeitraum von bis\",\n" +
            "   \"field\": \"4125\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"SKT-Bemerkungen\",\n" +
            "   \"field\": \"4126\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Besondere Personengruppe\",\n" +
            "   \"field\": \"4131\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"DMP-Kennzeichnung\",\n" +
            "   \"field\": \"4132\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Versicherungsschutz Beginn\",\n" +
            "   \"field\": \"4133\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Kostenträgername\",\n" +
            "   \"field\": \"4134\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Hash-String Implantateregister\",\n" +
            "   \"field\": \"4135\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Unfall, Unfallfolgen\",\n" +
            "   \"field\": \"4202\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Eingeschränkter Leistungsanspruch gemäß §16 Abs. 3a SGB V\",\n" +
            "   \"field\": \"4204\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Auftrag\",\n" +
            "   \"field\": \"4205\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Mutm. Tag der Entbindung\",\n" +
            "   \"field\": \"4206\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Diagnose/Verdachtsdiagnose\",\n" +
            "   \"field\": \"4207\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Befund/Medikation\",\n" +
            "   \"field\": \"4208\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Behandlungstag bei IVD-Leistungen\",\n" +
            "   \"field\": \"4214\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Befund/Medikation\",\n" +
            "   \"field\": \"4209\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"(N)BSNR des Erstveranlassers des Erstveranlassers\",\n" +
            "   \"field\": \"4217\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"(N)BSNR des Überweisers des Erstveranlassers\",\n" +
            "   \"field\": \"4218\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Überweisung von anderen Ärzten\",\n" +
            "   \"field\": \"4219\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Überweisung an\",\n" +
            "   \"field\": \"4220\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Kurativ/Präventiv/ESS/bei belegärztlicher Behandlung\",\n" +
            "   \"field\": \"4221\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Kurativ/Präventiv/ESS/bei belegärztlicher Behandlung\",\n" +
            "   \"field\": \"4221\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Kurativ/Präventiv/ESS/bei belegärztlicher Behandlung\",\n" +
            "   \"field\": \"4221\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Kurativ/Präventiv/ESS/bei belegärztlicher Behandlung\",\n" +
            "   \"field\": \"4221\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"ASV-Teamnummer des Erstveranlassers\",\n" +
            "   \"field\": \"4225\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"ASV-Teamnummer des Überweisers\",\n" +
            "   \"field\": \"4226\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Ausnahmeindikation\",\n" +
            "   \"field\": \"4229\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Stationäre Behandlung von bis\",\n" +
            "   \"field\": \"4233\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Anerkannte Psychotherapie\",\n" +
            "   \"field\": \"4234\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Datum des Anerkennungsbescheides\",\n" +
            "   \"field\": \"4235\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Abklärung somatischer Ursachen vor Aufnahme einer Psychotherapie\",\n" +
            "   \"field\": \"4236\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Scheinuntergruppe\",\n" +
            "   \"field\": \"4239\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Lebenslange Arztnummer (LANR) des Erstveranlassers\",\n" +
            "   \"field\": \"4241\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Lebenslange Arztnummer (LANR) des Überweisers\",\n" +
            "   \"field\": \"4242\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Weiterbehandelnder Arzt\",\n" +
            "   \"field\": \"4243\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Bewilligte Leistung\",\n" +
            "   \"field\": \"4244\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Anzahl bewilligter Leistungen\",\n" +
            "   \"field\": \"4245\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Anzahl abgerechneter Leistungen\",\n" +
            "   \"field\": \"4246\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Antragsdatum (des Anerkennungsbescheides)\",\n" +
            "   \"field\": \"4247\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Pseudo-LANR (für Krankenhausärzte im Rahmen der ASV-Abrechnung) des Erstveranlasser\",\n" +
            "   \"field\": \"4248\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Pseudo-LANR (für Krankenhausärzte im Rahmen der ASV-Abrechnung) des Überweiser\",\n" +
            "   \"field\": \"4249\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Kombinationsbehandlung aus Einzel- und Gruppentherapie\",\n" +
            "   \"field\": \"4250\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Durchführungsart der Kombinationsbehandlung\",\n" +
            "   \"field\": \"4251\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Gesamtanzahl bewilligter Therapieeinheiten für den Versicherten\",\n" +
            "   \"field\": \"4252\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Bewilligte GOP für den Versicherten\",\n" +
            "   \"field\": \"4253\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Anzahl der abgerechneten GOPen für den Versicherten\",\n" +
            "   \"field\": \"4254\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Gesamtanzahl bewilligter Therapieeinheiten für die Bezugsperson\",\n" +
            "   \"field\": \"4255\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Bewilligte GOP für die Bezugsperson\",\n" +
            "   \"field\": \"4256\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Anzahl der abgerechneten GOPen für die Bezugsperson\",\n" +
            "   \"field\": \"4257\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Kurart\",\n" +
            "   \"field\": \"4261\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Durchführung als Kompaktkur\",\n" +
            "   \"field\": \"4262\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Genehmigte Kurdauer in Wochen\",\n" +
            "   \"field\": \"4263\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Anreisetag\",\n" +
            "   \"field\": \"4264\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Abreisetag\",\n" +
            "   \"field\": \"4265\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Kurabbruch am\",\n" +
            "   \"field\": \"4266\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Bewiligte Kurverlängerung in Wochen\",\n" +
            "   \"field\": \"4267\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Bewiligungsdatum Kurverlängerung\",\n" +
            "   \"field\": \"4268\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Verhaltenspräventive Maßnahmen angeregt\",\n" +
            "   \"field\": \"4269\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Verhaltenspräventive Maßnahmen durchgeführt\",\n" +
            "   \"field\": \"4270\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Kompaktkur nicht möglich\",\n" +
            "   \"field\": \"4271\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Leistungstag\",\n" +
            "   \"field\": \"5000\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Gebührennummer (GNR)\",\n" +
            "   \"field\": \"5001\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Art der Untersuchung\",\n" +
            "   \"field\": \"5002\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Arztnummer\",\n" +
            "   \"field\": \"5003\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Multiplikator\",\n" +
            "   \"field\": \"5005\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Um-Uhrzeit\",\n" +
            "   \"field\": \"5006\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"DKM\",\n" +
            "   \"field\": \"5008\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Freier Begründungstext\",\n" +
            "   \"field\": \"5009\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Chargennummer\",\n" +
            "   \"field\": \"5010\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Sachkosten-Bezeichnung\",\n" +
            "   \"field\": \"5011\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Sachkosten/Materialkosten in Cent\",\n" +
            "   \"field\": \"5012\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Prozent der Leistung\",\n" +
            "   \"field\": \"5013\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Organ\",\n" +
            "   \"field\": \"5015\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Name des Arztes\",\n" +
            "   \"field\": \"5016\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Besuchort bei Hausbesuchen\",\n" +
            "   \"field\": \"5017\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Zone bei Besuchen\",\n" +
            "   \"field\": \"5018\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Erbringungsort/Standort des Gerätes\",\n" +
            "   \"field\": \"5019\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Wiederholungsuntersuchung\",\n" +
            "   \"field\": \"5020\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Jahr der letzten Krebsfrüherkennungsuntersuchung\",\n" +
            "   \"field\": \"5021\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"GO-Nummern-Zusatz\",\n" +
            "   \"field\": \"5023\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"GNR-Zusatzkennzeichen poststationär erbrachte Leistungen\",\n" +
            "   \"field\": \"5024\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Aufnahmedatum\",\n" +
            "   \"field\": \"5025\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Entlassungsdatum\",\n" +
            "   \"field\": \"5026\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"OP-Datum\",\n" +
            "   \"field\": \"5034\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"OP-Schlüssel\",\n" +
            "   \"field\": \"5035\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"GNR als Begründung\",\n" +
            "   \"field\": \"5036\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Gesamt-Schnitt-Naht-Zeit (Minuten)\",\n" +
            "   \"field\": \"5037\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Komplikation\",\n" +
            "   \"field\": \"5038\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Patientennummer der eDokumentation Hautkrebs-Screening\",\n" +
            "   \"field\": \"5040\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Seitenlokalisation OPS\",\n" +
            "   \"field\": \"5041\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Mengenangabe KM / AM\",\n" +
            "   \"field\": \"5042\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Einheit KM / AM\",\n" +
            "   \"field\": \"5043\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"OMIM-G-Kode des untersuchten Gens\",\n" +
            "   \"field\": \"5070\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"OMIM-P-Kode (Art der Erkrankung)\",\n" +
            "   \"field\": \"5071\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Gen-Name\",\n" +
            "   \"field\": \"5072\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Art der Erkrankung\",\n" +
            "   \"field\": \"5073\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Name Hersteller/ Lieferant\",\n" +
            "   \"field\": \"5074\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Artikel-/ Modellnummer\",\n" +
            "   \"field\": \"5075\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"(N)BSNR des Ortes der Leistungserbringung\",\n" +
            "   \"field\": \"5098\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Krankenhaus-IK (im Rahmen der ASV-Abrechnung)\",\n" +
            "   \"field\": \"5102\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Lebenslange Arztnummer (LANR) des Vertragsarztes/Vertragspsychotherapeuten\",\n" +
            "   \"field\": \"5099\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Lebenslange Arztnummer (LANR) des Vertragspsychotherapeuten\",\n" +
            "   \"field\": \"4299\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"ASV-Teamnummer des Vertragsarztes\",\n" +
            "   \"field\": \"5100\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Pseudo-LANR (für Krankenhausärzte im Rahmen der ASV-Abrechnung) des LE\",\n" +
            "   \"field\": \"5101\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"ICD-Code\",\n" +
            "   \"field\": \"6001\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Diagnosesicherheit\",\n" +
            "   \"field\": \"6003\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Seitenlokalisation\",\n" +
            "   \"field\": \"6004\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Diagnosenerläuterung\",\n" +
            "   \"field\": \"6006\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Diagnosenausnahmetatbestand\",\n" +
            "   \"field\": \"6008\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Empfänger\",\n" +
            "   \"field\": \"9102\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Erstellungsdatum\",\n" +
            "   \"field\": \"9103\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Verwendeter Zeichensatz\",\n" +
            "   \"field\": \"9106\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Abrechnungsquartal\",\n" +
            "   \"field\": \"9204\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Version der Satzbeschreibung\",\n" +
            "   \"field\": \"9212\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Version verwendeter Stammdatei\",\n" +
            "   \"field\": \"9213\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Prüfmodul-Version\",\n" +
            "   \"field\": \"9230\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Steuerdatei-Version\",\n" +
            "   \"field\": \"9231\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Prüfergebnis\",\n" +
            "   \"field\": \"9232\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Prüfdatum\",\n" +
            "   \"field\": \"9234\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Prüfzeit\",\n" +
            "   \"field\": \"9235\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Name der geprüften Datei\",\n" +
            "   \"field\": \"9236\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"AVWG-Prüfnummer der AVS\",\n" +
            "   \"field\": \"9250\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"HMV-Prüfnummer\",\n" +
            "   \"field\": \"9251\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Anzahl Teilabrechnungen\",\n" +
            "   \"field\": \"9260\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Abrechnungsteil x von y \",\n" +
            "   \"field\": \"9261\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Systeminterner Parameter\",\n" +
            "   \"field\": \"9901\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"enthaltene Datenpakete dieser Datei\",\n" +
            "   \"field\": \"9132\"\n" +
            " },\n" +
            " {\n" +
            "   \"description\": \"Erstellungsdatum ADT-Datenpaket\",\n" +
            "   \"field\": \"9115\"\n" +
            " }\n" +
            "]\n";

    public static final Map<String, String> CONTENT = new HashMap<>() {{
        this.putAll(init());
    }};
    private KvdtFields() {

    }

    private static Map<String, String> init() {
        Map<String, String> map = new HashMap<>();
        ArrayRule<List, Field> rule = new ArrayRule<>(ArrayList::new, List::add, new ObjectRule<>(Field::new)
                .put("field", Field::setField, StringRule.get())
                .put("description", Field::setDescription, StringRule.get()));
        List<Field> fields = JSON.deserialize(FIELD_DEFINITIONS, rule);
        fields.forEach(field -> map.put(field.getField(), field.getDescription()));
        return map;
    }

    @Data
    private static class Field {
        protected String description;
        protected String field;
    }
}
