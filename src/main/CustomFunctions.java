package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomFunctions {

    public static String statuteWorkIRI(String docNumber, String year) {
        return "http://ldf.fi/lawsampo/eli/statute/" + year + "/" + docNumber;
    }

    public static String statuteVersionOriginalIRI(String docNumber, String year) {
        return statuteWorkIRI(docNumber, year) + "/original";
    }

    public static String statuteVersionConsolidatedIRI(String docNumber, String year) {
        return statuteWorkIRI(docNumber, year) + "/consolidated";
    }

    public static String sectionOfLawWorkIRI(String docNumber, String year, String eId) {
        return statuteWorkIRI(docNumber, year) + "/" + eId.replaceAll("_+", "/").replaceAll("v\\d{8}", "");
    }

    public static String sectionOfLawVersionOriginalIRI(String docNumber, String year, String eId) {
        if (!isOriginalVersion(eId)) {
            return null;
        }
        return statuteWorkIRI(docNumber, year) + "/" + eId.replaceAll("_+", "/") + "/original";
    }

    public static String sectionOfLawVersionConsolidatedIRI(String docNumber, String year, String eId, String version) {
        if (version != null) {
            return statuteWorkIRI(docNumber, year) + "/" + eId.replaceAll("_+", "/").replaceAll("v\\d{8}", "")
                    + "/consolidated/" + version.replace("@", "");
        }

        if (isOriginalVersion(eId)) {
            return null;
        }

        String versionFromEid = getStatuteIdFromEid(eId);

        return statuteWorkIRI(docNumber, year) + "/" + eId.replaceAll("_+", "/").replaceAll("v\\d{8}", "")
                + "/consolidated/" + versionFromEid;
    }

    public static String sectionOfLawVersionOriginalFiIRI(String docNumber, String year, String eId) {
        if (!isOriginalVersion(eId)) {
            return null;
        }
        return sectionOfLawVersionOriginalIRI(docNumber, year, eId) + "/fin";
    }

    public static String sectionOfLawVersionOriginalFiTextIRI(String docNumber, String year, String eId) {
        if (!isOriginalVersion(eId)) {
            return null;
        }
        return sectionOfLawVersionOriginalFiIRI(docNumber, year, eId) + "/txt";
    }

    public static String sectionOfLawVersionConsolidatedFiIRI(String docNumber, String year, String eId, String version) {
        if (version == null && isOriginalVersion(eId)) {
            return null;
        }

        return sectionOfLawVersionConsolidatedIRI(docNumber, year, eId, version) + "/fin";
    }

    public static String sectionOfLawVersionConsolidatedFiTextIRI(String docNumber, String year, String eId, String version) {
        if (version == null && isOriginalVersion(eId)) {
            return null;
        }
        return sectionOfLawVersionConsolidatedFiIRI(docNumber, year, eId, version) + "/txt";
    }

    public static String amendedByStatuteWorkIRI(String eId, String version) {
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

    public static String amendedByStatuteLocalId(String eId, String version) {
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
        String[] parts = identifier.split(" ");
        String[] yearAndNumber = parts[1].split("/");
        String year = yearAndNumber[1].length() == 2 ? "19" + yearAndNumber[1] : yearAndNumber[1];
        return "http://ldf.fi/lawsampo/eli/" + parts[0] + "/" + year + "/" + yearAndNumber[0];
    }

    public static String governmentProposalURL(String identifier) {
        String[] parts = identifier.split(" ");
        String[] yearAndNumber = parts[1].split("/");
        String year = yearAndNumber[1].length() == 2 ? "19" + yearAndNumber[1] : yearAndNumber[1];
        return "https://www.eduskunta.fi/FI/Vaski/sivut/trip.aspx?triptype=ValtiopaivaAsiat&docid=" + parts[0] + "+"
                + yearAndNumber[0] + "/" + year;
    }

    public static String trimOrNull(String str) {
        if (str == null || str.isBlank()) {
            return null;
        }
        return str.strip();
    }

    public static String getSectionOfLawClass(String eId, Boolean versionLevel) {
        String version = versionLevel ? "Version" : "";
        String sectionOfLaw = getSectionOfLaw(eId);
        return sectionOfLaw != null ? sectionOfLaw + version : null;
    }

    public static String getSectionOfLawNumber(String eId) {
        String regex = "\\w+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(eId.replaceAll("_+", "/").replaceAll("v\\d{8}", ""));

        if (matcher.find()) {
            return matcher.group();
        } else {
            return null;
        }
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

        if (matcher.find()) {
            return false;
        } else {
            return true;
        }
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