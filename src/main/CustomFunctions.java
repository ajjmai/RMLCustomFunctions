package main;/*
 x ?statute_work IRI  <http://ldf.fi/lawsampo/statute/eli/1993/1501>
 x ?statute_version_original IRI <http://ldf.fi/lawsampo/statute/eli/1993/1501/original>
 x ?statute_version_consolidated IRI <http://ldf.fi/lawsampo/statute/eli/1993/1501/consolidated>
 x ?section_of_law_work IRI <http://ldf.fi/lawsampo/statute/eli/1993/1501/part/1/chp/7/sec/79a/subsec/2>

 x ?section_of_law_version IRI
    <http://ldf.fi/lawsampo/statute/eli/1993/1501/part/1/chp/7/sec/79a/subsec/2/original>
    <http://ldf.fi/lawsampo/statute/eli/1993/1501/part/1/chp/7/sec/79a/subsec/2/consolidated/12345678>

 x ?amended_by IRI (work taso) <http://ldf.fi/lawsampo/statute/eli/1993/1501>

 x ?preliminary_work IRI <http://ldf.fi/lawsampo/statute/eli/HE/1993/88>
 x ?government_proposal_url IRI <https://www.eduskunta.fi/FI/Vaski/sivut/trip.aspx?triptype=ValtiopaivaAsiat&docid=HE+88/1993>

 x ?id_local "1501/1993"
 x ?lss_statute IRI <http://ldf.fi/lawsampo/statute_eli_sd_1993_1501>

 x?statute_version_original_fi IRI <http://ldf.fi/lawsampo/statute/eli/1993/1501/part/1/chp/4/sec/33a/original/fin>
 x?statute_version_consolidated_fi IRI <http://ldf.fi/lawsampo/statute/eli/1993/1501/part/1/chp/4/sec/33a/consolidated/20071061/fin>

 X?statute_version_original_fi_txt IRI <http://ldf.fi/lawsampo/statute/eli/1993/1501/part/1/chp/4/sec/33a/original/fin/txt>
 x?statute_version_consolidated_fi_txt IRI <http://ldf.fi/lawsampo/statute/eli/1993/1501/part/1/chp/4/sec/33a/consolidated/20071061/fin/txt>

 ?section_of_law_number_short "133c"
 ?section_of_law_number_int 133
 ?section_of_law_number_letter "c"
 ?section_of_law_number_str   "133 c §"

 x ?section_of_law_heading stripped string "Kunnanvaltuuston päätösvalta"

 */


public class CustomFunctions {
//    public static void main(String[] args) {
//        System.out.println("Hello world!");
//    }

    public static String getStatuteNumberForIRIs(String docNumber, String year) {
        return year + "/" + docNumber;
    }
    public static String idLocal(String docNumber, String year) {
        return  docNumber + "/" + year;
    }

    public static String statuteWorkIRI(String docNumber, String year) {
        return "http://ldf.fi/lawsampo/eli/statute/" + year + "/" + docNumber ;
    }
    public static String statuteVersionOriginalIRI(String docNumber, String year) {
        return statuteWorkIRI(docNumber, year) + "/original" ;
    }

    public static String statuteVersionConsolidatedIRI(String docNumber, String year, String version) {
        return statuteWorkIRI(docNumber, year) + "/consolidated/" + version.substring(1);
    }

    public static String sectionOfLawWorkIRI(String docNumber, String year, String eId) {
        return statuteWorkIRI(docNumber, year) + "/" +
                eId.replaceAll("_+", "/").replaceAll("v\\d{8}", "");
    }

    public static String sectionOfLawVersionOriginalIRI(String docNumber, String year, String eId) {
        return statuteWorkIRI(docNumber, year) + "/" +
                eId.replaceAll("_+", "/") + "/original";
    }
    public static String sectionOfLawVersionConsolidatedIRI(String docNumber, String year, String eId) {
        String version = eId.substring(eId.length() - 8);
        return statuteWorkIRI(docNumber, year) + "/" +
                eId.replaceAll("_+", "/").replaceAll("v\\d{8}", "") +
                "/consolidated/" + version;
    }

    public static String sectionOfLawVersionOriginalFiIRI(String docNumber, String year, String eId) {
        return sectionOfLawVersionOriginalIRI(docNumber, year, eId) + "/fin" ;
    }
    public static String sectionOfLawVersionOriginalFiTextIRI(String docNumber, String year, String eId) {
        return sectionOfLawVersionOriginalFiIRI(docNumber, year, eId) + "/txt" ;
    }

    public static String sectionOfLawVersionConsolidatedFiIRI(String docNumber, String year, String eId) {
        return sectionOfLawVersionConsolidatedIRI(docNumber, year, eId) + "/fin";
    }
    public static String sectionOfLawVersionConsolidatedFiTextIRI(String docNumber, String year, String eId) {
        return sectionOfLawVersionConsolidatedFiIRI(docNumber, year, eId) + "/txt";
    }

    public static String amendedByStatuteWorkIRI(String version) {
        String year = version.substring(1, 5);
        String number = version.substring(5).replaceFirst("^0+(?!$)", "");
        return statuteWorkIRI(number, year);
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

    public static String governmentProposalURI(String identifier) {
        String[] parts = identifier.split(" ");
        String[] yearAndNumber = parts[1].split("/");
        String year = yearAndNumber[1].length() == 2 ? "19" + yearAndNumber[1] : yearAndNumber[1];
        return "https://www.eduskunta.fi/FI/Vaski/sivut/trip.aspx?triptype=ValtiopaivaAsiat&docid="+ parts[0] + "+" + yearAndNumber[0] + "/" + year;
    }

    public static String formatHeading(String heading) {
        return heading.strip();
    }


}