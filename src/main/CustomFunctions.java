package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class CustomFunctions {

    public static String statuteWorkIRI(String docNumber, String year) {
        if (docNumber == null || docNumber.isBlank()) {
            throw new IllegalArgumentException("statuteVersionConsolidatedIRI: docNumber cannot be null or empty");
        } else if (year == null || year.isBlank()) {
            throw new IllegalArgumentException("statuteVersionConsolidatedIRI: year cannot be null or empty");
        }
        return "http://ldf.fi/lawsampo/eli/statute/" + year + "/" + docNumber;
    }

    public static String statuteVersionOriginalIRI(String docNumber, String year) {
        if (docNumber == null || docNumber.isBlank()) {
            throw new IllegalArgumentException("statuteVersionConsolidatedIRI: docNumber cannot be null or empty");
        } else if (year == null || year.isBlank()) {
            throw new IllegalArgumentException("statuteVersionConsolidatedIRI: year cannot be null or empty");
        }
        return statuteWorkIRI(docNumber, year) + "/original";
    }

    public static String statuteVersionConsolidatedIRI(String docNumber, String year) {
        if (docNumber == null || docNumber.isBlank()) {
            throw new IllegalArgumentException("statuteVersionConsolidatedIRI: docNumber cannot be null or empty");
        } else if (year == null || year.isBlank()) {
            throw new IllegalArgumentException("statuteVersionConsolidatedIRI: year cannot be null or empty");
        }
        return statuteWorkIRI(docNumber, year) + "/consolidated";
    }

    public static String sectionOfLawWorkIRI(String docNumber, String year, String eId) {
        if (eId == null || eId.isBlank()) {
            throw new IllegalArgumentException("sectionOfLawWorkIRI: eId cannot be null or empty");
        }

        String iri = statuteWorkIRI(docNumber, year) + "/" + eId.replaceAll("_+", "/").replaceAll("v\\d{8}", "");

        if (iri.endsWith("/crossHeading")) {
            return iri + "/1";
        } else if (iri.contains("subpara")) {
            return iri.replaceAll("(/\\d+([a-z]+))$", "/$2");
        }
        else {
            return iri;
        }
    }

    public static String sectionOfLawVersionOriginalIRI(String docNumber, String year, String eId) {
        if (eId == null || eId.isBlank()) {
            throw new IllegalArgumentException("sectionOfLawVersionOriginalIRI: eId cannot be null or empty");
        }
        if (!isOriginalVersion(eId)) {
            return null;
        }
        return sectionOfLawWorkIRI(docNumber, year, eId) + "/original";
    }

    public static String sectionOfLawVersionConsolidatedIRI(String docNumber, String year, String eId, String version) {
        if (eId == null || eId.isBlank()) {
            throw new IllegalArgumentException("sectionOfLawVersionConsolidatedIRI: eId cannot be null or empty");
        }
        if (version != null) {
            return sectionOfLawWorkIRI(docNumber, year, eId) + "/consolidated/" + version.replace("@", "");
        }
        if (isOriginalVersion(eId)) {
            return null;
        }

        String versionFromEid = getStatuteIdFromEid(eId);
        return sectionOfLawWorkIRI(docNumber, year, eId) + "/consolidated/" + versionFromEid;
    }

    public static String sectionOfLawVersionIRI(String docNumber, String year, String eId, String version) {
        if (eId == null || eId.isBlank()) {
            throw new IllegalArgumentException("sectionOfLawVersionIRI: eId cannot be null or empty");
        }
        if (version != null) {
            return sectionOfLawWorkIRI(docNumber, year, eId) + "/" + version.replace("@", "");
        }
        if (isOriginalVersion(eId)) {
            return sectionOfLawWorkIRI(docNumber, year, eId) + "/" + year + paddedDocNumber(docNumber);
        }
        String versionFromEid = getStatuteIdFromEid(eId);
        return sectionOfLawWorkIRI(docNumber, year, eId) + "/" + versionFromEid;
    }

    public static String sectionOfLawVersionOriginalFiIRI(String docNumber, String year, String eId) {
        if (eId == null || eId.isBlank()) {
            throw new IllegalArgumentException("sectionOfLawVersionOriginalFiIRI: eId cannot be null or empty");
        }

        if (!isOriginalVersion(eId)) {
            return null;
        }
        return sectionOfLawVersionOriginalIRI(docNumber, year, eId) + "/fin";
    }

    public static String sectionOfLawVersionOriginalFiTextIRI(String docNumber, String year, String eId) {
        if (eId == null || eId.isBlank()) {
            throw new IllegalArgumentException("sectionOfLawVersionOriginalFiTextIRI: eId cannot be null or empty");
        }

        if (!isOriginalVersion(eId)) {
            return null;
        }
        return sectionOfLawVersionOriginalFiIRI(docNumber, year, eId) + "/txt";
    }

    public static String sectionOfLawVersionConsolidatedFiIRI(String docNumber, String year, String eId,
                                                              String version) {
        if (eId == null || eId.isBlank()) {
            throw new IllegalArgumentException("sectionOfLawVersionConsolidatedFiIRI: eId cannot be null or empty");
        }

        if (version == null && isOriginalVersion(eId)) {
            return null;
        }

        return sectionOfLawVersionConsolidatedIRI(docNumber, year, eId, version) + "/fin";
    }

    public static String sectionOfLawVersionConsolidatedFiTextIRI(String docNumber, String year, String eId,
                                                                  String version) {
        if (eId == null || eId.isBlank()) {
            throw new IllegalArgumentException("sectionOfLawVersionConsolidatedFiTextIRI: eId cannot be null or empty");
        }

        if (version == null && isOriginalVersion(eId)) {
            return null;
        }
        return sectionOfLawVersionConsolidatedFiIRI(docNumber, year, eId, version) + "/txt";
    }

    public static String sectionOfLawVersionFiTextIRI(String docNumber, String year, String eId, String version) {
        if (eId == null || eId.isBlank()) {
            throw new IllegalArgumentException("sectionOfLawVersionFiTextIRI: eId cannot be null or empty");
        }

        return sectionOfLawVersionFiIRI(docNumber, year, eId, version) + "/txt";
    }

    public static String sectionOfLawVersionFiIRI(String docNumber, String year, String eId, String version) {
        if (eId == null || eId.isBlank()) {
            throw new IllegalArgumentException("sectionOfLawVersionFiIRI: eId cannot be null or empty");
        }
        return sectionOfLawVersionIRI(docNumber, year, eId, version) + "/fin";
    }

    public static String amendedByStatuteWorkIRI(String eId, String version) {
        if (eId == null || eId.isBlank()) {
            throw new IllegalArgumentException("amendedByStatuteWorkIRI: eId cannot be null or empty");
        }

        if (version == null && isOriginalVersion(eId)) {
            return null;
        }

        if (version != null) {
            String year = version.substring(1, 5);
            String number = version.substring(5).replaceFirst("^0+(?!$)", "");
            return statuteWorkIRI(number, year);
        } else {
            String versionFromEid = getStatuteIdFromEid(eId);
            String year = versionFromEid.substring(0, 4);
            String number = versionFromEid.substring(4).replaceFirst("^0+(?!$)", "");
            return statuteWorkIRI(number, year);
        }
    }

    public static boolean isSectionOfLawAmendedByStatute(String statute, String eId, String version) {
        if (eId == null || eId.isBlank()) {
            throw new IllegalArgumentException("isSectionOfLawAmendedByStatute: eId cannot be null or empty");
        }

        if (version == null && isOriginalVersion(eId) || statute == null) {
            return false;
        }
        String amendedBy = amendedByStatuteLocalId(eId, version);

        return amendedBy.equals(statute);
    }

    private static String amendedByStatuteLocalId(String eId, String version) {
        if (eId == null || eId.isBlank()) {
            throw new IllegalArgumentException("amendedByStatuteLocalId: eId cannot be null or empty");
        }

        if (version == null && isOriginalVersion(eId)) {
            return null;
        }

        if (version != null) {
            String year = version.substring(1, 5);
            String number = version.substring(5).replaceFirst("^0+(?!$)", "");
            return number + "/" + year;
        } else {
            String versionFromEid = getStatuteIdFromEid(eId);
            String year = versionFromEid.substring(0, 4);
            String number = versionFromEid.substring(4).replaceFirst("^0+(?!$)", "");
            return number + "/" + year;
        }
    }

    public static String lssStatuteIRI(String docNumber, String year) {
        return "http://ldf.fi/lawsampo/statute_eli_sd_" + year + "_" + docNumber;
    }

    public static String preliminaryWorkIRI(String identifier) {
        if (identifier == null) {
            return null;
        }
        String[] parts = identifier.split(" ");
        String[] yearAndNumber = parts[1].split("/");
        String year = yearAndNumber[1].length() == 2 ? "19" + yearAndNumber[1] : yearAndNumber[1];
        return "http://ldf.fi/lawsampo/eli/" + parts[0] + "/" + year + "/" + yearAndNumber[0];
    }

    public static String governmentProposalURL(String identifier) {
        if (identifier == null) {
            return null;
        }
        String[] parts = identifier.split(" ");
        String[] yearAndNumber = parts[1].split("/");
        String year = yearAndNumber[1].length() == 2 ? "19" + yearAndNumber[1] : yearAndNumber[1];
        return "https://www.eduskunta.fi/FI/Vaski/sivut/trip.aspx?triptype=ValtiopaivaAsiat&docid=" + parts[0] + "+"
                + yearAndNumber[0] + "/" + year;
    }

    public static String finlexUrl(String identifier) {
        if (identifier == null) {
            return null;
        }

        String[] parts = identifier.split("/");
        String year = parts[1];
        String number = paddedDocNumber(parts[0]);

        return "https://www.finlex.fi/fi/laki/alkup/"+ year + "/" + year + number;
    }

    public static String trimOrNull(String str) {
        if (str == null || str.isBlank()) {
            return null;
        }
        return str.strip();
    }

    public static String getSectionOfLawClass(String eId, Boolean versionLevel) {
        if (eId == null || eId.isBlank()) {
            throw new IllegalArgumentException("getSectionOfLawClass: eId cannot be null or empty");
        }

        String version = versionLevel ? "Version" : "";
        String sectionOfLaw = getSectionOfLaw(eId);
        return sectionOfLaw != null ? sectionOfLaw + version : null;
    }

    public static String getSectionOfLawNumber(String eId) {
        if (eId == null || eId.isBlank()) {
            throw new IllegalArgumentException("getSectionOfLawNumber: eId cannot be null or empty");
        }

        String cleanedEid = eId.replaceAll("_+", "/").replaceAll("v\\d{8}", "");

        Pattern pattern = Pattern.compile("\\w+$");
        Matcher matcher = pattern.matcher(cleanedEid);

        if (matcher.find()) {
            String result = matcher.group();
            if (result.contains("crossHeading")) {
                return "1";
            } else if (eId.contains("subpara")) {
                return result.replaceAll("\\d+", "");
            } else if (eId.contains("para") && result.equals("intro")) {
                Pattern paraPattern = Pattern.compile("para/(\\d+)/intro");
                Matcher paraMatcher = paraPattern.matcher(cleanedEid);

                if (paraMatcher.find()) {
                    return paraMatcher.group(1);
                }
            }
            return result;
        } else {
            return null;
        }
    }

    public static boolean isCrossHeading(String eId) {
        if (eId == null || eId.isBlank()) {
            throw new IllegalArgumentException("isCrossHeading: eId cannot be null or empty");
        }
        return eId.contains("crossHeading");
    }

    public static boolean isDirectChild(String parent, String child) {
        if (parent == null || parent.isBlank() || child == null || child.isBlank()) {
            throw new IllegalArgumentException("isDirectChild: eId cannot be null or empty");
        }
        String[] parentParts = parent.replaceAll("v\\d{8}", "").split("__");
        String[] childParts = child.replaceAll("v\\d{8}", "").split("__");

        if (childParts.length != parentParts.length + 1) {
            return false;
        }
        return IntStream.range(0, parentParts.length)
                .allMatch(i -> parentParts[i].equals(childParts[i]));
    }

    public static String getVersionClass(String eId, String version) {
        if (eId == null || eId.isBlank()) {
            throw new IllegalArgumentException("getVersionClass: eId cannot be null or empty");
        }

        if (version == null && isOriginalVersion(eId)) {
            return "http://data.finlex.fi/schema/sfl/Original";
        } else {
            return "http://data.finlex.fi/schema/sfl/Consolidated";
        }
    }

    private static String paddedDocNumber(String number) {
        return String.format("%04d", Integer.parseInt(number));
    }

    private static String getSectionOfLaw(String eId) {
        if (eId.contains("intro")) {
            return "http://data.finlex.fi/schema/sfl/Paragraph";
        } else if (eId.contains("crossHeading")) {
            return "http://data.finlex.fi/schema/sfl/Subheading";
        } else if (eId.contains("subpara")) {
            return "http://data.finlex.fi/schema/sfl/Subparagraph";
        } else if (eId.contains("para")) {
            return "http://data.finlex.fi/schema/sfl/Paragraph";
        } else if (eId.contains("subsec")) {
            return "http://data.finlex.fi/schema/sfl/Subsection";
        } else if (eId.contains("sec")) {
            return "http://data.finlex.fi/schema/sfl/Section";
        } else if (eId.contains("chp")) {
            return "http://data.finlex.fi/schema/sfl/Chapter";
        } else if (eId.contains("part")) {
            return "http://data.finlex.fi/schema/sfl/Part";
        }
        return null;
    }

    private static boolean isOriginalVersion(String eId) {
        String regex = "v\\d{8}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(eId);

        return !matcher.find();
    }

    private static String getStatuteIdFromEid(String eId) {
        String regex = "v\\d{8}(?!.*v\\d{8})";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(eId);

        String versionFromEid = "";

        if (matcher.find()) {
            versionFromEid = matcher.group().replace("v", "");
        }
        return versionFromEid;
    }
}