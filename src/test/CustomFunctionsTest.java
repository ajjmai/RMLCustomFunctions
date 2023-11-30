package test;

import main.CustomFunctions;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class CustomFunctionsTest {

    @Test
    void statuteWorkIRI() throws URISyntaxException {
        String docNumber = "1501";
        String docYear = "1993";
        String result = CustomFunctions.statuteWorkIRI(docNumber, docYear);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501" , result);
//        assertEquals(new URI("http://ldf.fi/lawsampo/eli/statute/1993/1501") , result);

    }

    @Test
    void statuteVersionOriginalIRI() {
        String docNumber = "1501";
        String docYear = "1993";
        String result = CustomFunctions.statuteVersionOriginalIRI(docNumber, docYear);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/original" , result);
    }

    @Test
    void statuteVersionConsolidatedIRI() {
        String docNumber = "1501";
        String docYear = "1993";
        String version = "@20031301";
        String result = CustomFunctions.statuteVersionConsolidatedIRI(docNumber, docYear, version);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/consolidated/20031301" , result);
    }

//    Section of Law Work
    @Test
    void sectionOfLawWorkIRIPart() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1";
        String result = CustomFunctions.sectionOfLawWorkIRI(docNumber, docYear, eId);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1" , result);
    }

    @Test
    void sectionOfLawWorkIRIChapter() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_2";
        String result = CustomFunctions.sectionOfLawWorkIRI(docNumber, docYear, eId);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/2" , result);
    }
    @Test
    void sectionOfLawWorkIRISection() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_20";
        String result = CustomFunctions.sectionOfLawWorkIRI(docNumber, docYear, eId);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/20" , result);
    }
    @Test
    void sectionOfLawWorkIRISectionWithVersion() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_18dv20191113";
        String result = CustomFunctions.sectionOfLawWorkIRI(docNumber, docYear, eId);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/18d" , result);
    }
    @Test
    void sectionOfLawWorkIRISubsection() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_20__subsec_1";
        String result = CustomFunctions.sectionOfLawWorkIRI(docNumber, docYear, eId);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/20/subsec/1" , result);
    }
    @Test
    void sectionOfLawWorkIRISubsectionParagraph() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_21__subsec_1__para_1";
        String result = CustomFunctions.sectionOfLawWorkIRI(docNumber, docYear, eId);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/21/subsec/1/para/1" , result);
    }
    @Test
    void sectionOfLawWorkIRISubsectionParagraphWithVersion() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_21__subsec_1v20071312__para_1v20071312";
        String result = CustomFunctions.sectionOfLawWorkIRI(docNumber, docYear, eId);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/21/subsec/1/para/1" , result);
    }

    //    Section of Law Version - Original
    @Test
    void sectionOfLawVersionOriginalIRIPart() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1";
        String result = CustomFunctions.sectionOfLawVersionOriginalIRI(docNumber, docYear, eId);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/original" , result);
    }

    @Test
    void sectionOfLawVersionOriginalIRIChapter() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_2";
        String result = CustomFunctions.sectionOfLawVersionOriginalIRI(docNumber, docYear, eId);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/2/original" , result);
    }
    @Test
    void sectionOfLawVersionOriginalIRISection() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_20";
        String result = CustomFunctions.sectionOfLawVersionOriginalIRI(docNumber, docYear, eId);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/20/original" , result);
    }
    @Test
    void sectionOfLawVersionOriginalIRISubsection() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_20__subsec_1";
        String result = CustomFunctions.sectionOfLawVersionOriginalIRI(docNumber, docYear, eId);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/20/subsec/1/original" , result);
    }
    @Test
    void sectionOfLawVersionOriginalIRISubsectionParagraph() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_21__subsec_1__para_1";
        String result = CustomFunctions.sectionOfLawVersionOriginalIRI(docNumber, docYear, eId);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/21/subsec/1/para/1/original" , result);
    }

    //    Section of Law Version - Consolidated

    @Test
    void sectionOfLawVersionConsolidatedIRIChapterWithVersion() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3av19941486";
        String result = CustomFunctions.sectionOfLawVersionConsolidatedIRI(docNumber, docYear, eId);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3a/consolidated/19941486" , result);
    }

    @Test
    void sectionOfLawVersionConsolidatedIRISectionWithVersion() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_18dv20191113";
        String result = CustomFunctions.sectionOfLawVersionConsolidatedIRI(docNumber, docYear, eId);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/18d/consolidated/20191113" , result);
    }
    @Test
    void sectionOfLawVersionConsolidatedIRISubsectionWithVersion() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3av19941486__sec_26v19941486__subsec_3v20211113";
        String result = CustomFunctions.sectionOfLawVersionConsolidatedIRI(docNumber, docYear, eId);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3a/sec/26/subsec/3/consolidated/20211113" , result);
    }

    @Test
    void sectionOfLawVersionConsolidatedIRISubsectionParagraphWithVersion() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_21__subsec_1v20071312__para_1v20071312";
        String result = CustomFunctions.sectionOfLawVersionConsolidatedIRI(docNumber, docYear, eId);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/21/subsec/1/para/1/consolidated/20071312" , result);
    }

    @Test
    void amendedByStatuteWorkIRI() {
        String version = "@19931501";
        String result = CustomFunctions.amendedByStatuteWorkIRI(version);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501" , result);
    }
    @Test
    void amendedByStatuteWorkIRIWithLeadingZeros() {
        String version = "@19930001";
        String result = CustomFunctions.amendedByStatuteWorkIRI(version);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1" , result);
    }

    @Test
    void lssStatuteIRI() {
        String docNumber = "1501";
        String docYear = "1993";
        String result = CustomFunctions.lssStatuteIRI(docNumber, docYear);
        assertEquals("http://ldf.fi/lawsampo/statute_eli_sd_1993_1501", result);
    }
    @Test
    void preliminaryWorkIRIShortYear() {
        String identifier = "HE 88/93";
        String result = CustomFunctions.preliminaryWorkIRI(identifier);
        assertEquals("http://ldf.fi/lawsampo/eli/HE/1993/88", result);
    }

    @Test
    void preliminaryWorkIRI() {
        String identifier = "HE 123/1993";
        String result = CustomFunctions.preliminaryWorkIRI(identifier);
        assertEquals("http://ldf.fi/lawsampo/eli/HE/1993/123", result);
    }

    @Test
    void governmentProposalURIShortYear() {
        String identifier = "HE 88/93";
        String result = CustomFunctions.governmentProposalURI(identifier);
        assertEquals("https://www.eduskunta.fi/FI/Vaski/sivut/trip.aspx?triptype=ValtiopaivaAsiat&docid=HE+88/1993", result);
    }
    @Test
    void governmentProposalURI() {
        String identifier = "HE 88/1993";
        String result = CustomFunctions.governmentProposalURI(identifier);
        assertEquals("https://www.eduskunta.fi/FI/Vaski/sivut/trip.aspx?triptype=ValtiopaivaAsiat&docid=HE+88/1993", result);
    }

    @Test
    void sectionOfLawVersionOriginalFiIRI() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_20";
        String result = CustomFunctions.sectionOfLawVersionOriginalFiIRI(docNumber, docYear, eId);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/20/original/fin", result);
    }

    @Test
    void sectionOfLawVersionOriginalFiTextIRI() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_20";
        String result = CustomFunctions.sectionOfLawVersionOriginalFiTextIRI(docNumber, docYear, eId);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/20/original/fin/txt", result);
    }

    @Test
    void sectionOfLawVersionConsolidatedFiIRI() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_21__subsec_1v20071312__para_1v20071312";
        String result = CustomFunctions.sectionOfLawVersionConsolidatedFiIRI(docNumber, docYear, eId);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/21/subsec/1/para/1/consolidated/20071312/fin", result);
    }

    @Test
    void sectionOfLawVersionConsolidatedFiTextIRI() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_21__subsec_1v20071312__para_1v20071312";
        String result = CustomFunctions.sectionOfLawVersionConsolidatedFiTextIRI(docNumber, docYear, eId);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/21/subsec/1/para/1/consolidated/20071312/fin/txt", result);
    }

    @Test
    void formatHeading() {
        String heading = "Myynti ja yhteisöhankinta Suomessa (29.12.1994/1486)\n                  ";
        String result = CustomFunctions.formatHeading(heading);
        assertEquals("Myynti ja yhteisöhankinta Suomessa (29.12.1994/1486)", result);
    }
    @Test
    void formatHeadingEmptyString() {
        String heading = "";
        String result = CustomFunctions.formatHeading(heading);
        assertEquals("", result);
    }
}