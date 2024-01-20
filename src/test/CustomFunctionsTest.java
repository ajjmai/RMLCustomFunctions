package test;

import main.CustomFunctions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomFunctionsTest {

    @Test
    void statuteWorkIRI() {
        String docNumber = "1501";
        String docYear = "1993";
        String result = CustomFunctions.statuteWorkIRI(docNumber, docYear);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501", result);

    }

    @Test
    void statuteVersionOriginalIRI() {
        String docNumber = "1501";
        String docYear = "1993";
        String result = CustomFunctions.statuteVersionOriginalIRI(docNumber, docYear);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/original", result);
    }

    @Test
    void statuteVersionConsolidatedIRI() {
        String docNumber = "1501";
        String docYear = "1993";
        String result = CustomFunctions.statuteVersionConsolidatedIRI(docNumber, docYear);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/consolidated", result);
    }


    @Test
    void amendedByStatuteWorkIRI() {
        String eId = "part_1__chp_2__crossHeading_9";
        String version = "@19931501";
        String result = CustomFunctions.amendedByStatuteWorkIRI(eId, version);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501", result);
    }

    @Test
    void amendedByStatuteWorkIRIWithLeadingZeros() {
        String eId = "part_1__chp_2__crossHeading_9";
        String version = "@19930001";
        String result = CustomFunctions.amendedByStatuteWorkIRI(eId, version);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1", result);
    }

    @Test
    void amendedByStatuteWorkIRIFromEid() {
        String eId = "part_1__chp_3av19941486__sec_26v19941486__subsec_3v20211113";
        String result = CustomFunctions.amendedByStatuteWorkIRI(eId, null);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/2021/1113", result);
    }

    @Test
    void isSectionOfLawAmendedByStatuteMatchWithEid() {
        String statute = "1113/2021";
        String eId = "part_1__chp_3av19941486__sec_26v19941486__subsec_3v20211113";
        boolean result = CustomFunctions.isSectionOfLawAmendedByStatute(statute, eId, null);
        assertTrue(result);
    }

    @Test
    void isSectionOfLawAmendedByStatuteMatchWithVersion() {
        String statute = "1/1993";
        String eId = "part_1__chp_2__crossHeading_9";
        String version = "@19930001";
        boolean result = CustomFunctions.isSectionOfLawAmendedByStatute(statute, eId, version);
        assertTrue(result);
    }

    @Test
    void isSectionOfLawAmendedByStatuteNotMatchWithEid() {
        String statute = "870/202";
        String eId = "part_1__chp_3av19941486__sec_26v19941486__subsec_3v20211113";
        boolean result = CustomFunctions.isSectionOfLawAmendedByStatute(statute, eId, null);
        assertFalse(result);
    }
    @Test
    void isSectionOfLawAmendedByStatuteNotMatchWithVersion() {
        String statute = "1/1994";
        String eId = "part_1__chp_3av19941486__sec_26v19941486__subsec_3v20211113";
        String version = "@19930001";
        boolean result = CustomFunctions.isSectionOfLawAmendedByStatute(statute, eId, version);
        assertFalse(result);
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
        String result = CustomFunctions.governmentProposalURL(identifier);
        assertEquals("https://www.eduskunta.fi/FI/Vaski/sivut/trip.aspx?triptype=ValtiopaivaAsiat&docid=HE+88/1993", result);
    }

    @Test
    void governmentProposalURI() {
        String identifier = "HE 88/1993";
        String result = CustomFunctions.governmentProposalURL(identifier);
        assertEquals("https://www.eduskunta.fi/FI/Vaski/sivut/trip.aspx?triptype=ValtiopaivaAsiat&docid=HE+88/1993", result);
    }

   @Test
   void finlexUrlOneZeroPadding() {
        String identifier = "758/2008";
        String result = CustomFunctions.finlexUrl(identifier);
        assertEquals("https://www.finlex.fi/fi/laki/alkup/2008/20080758", result);
   }

   @Test
   void finlexUrlThreeZeroPadding() {
        String identifier = "8/2008";
        String result = CustomFunctions.finlexUrl(identifier);
        assertEquals("https://www.finlex.fi/fi/laki/alkup/2008/20080008", result);
   }
   @Test
   void finlexUrl() {
        String identifier = "1767/1995";
        String result = CustomFunctions.finlexUrl(identifier);
        assertEquals("https://www.finlex.fi/fi/laki/alkup/1995/19951767", result);
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
        String result = CustomFunctions.sectionOfLawVersionConsolidatedFiIRI(docNumber, docYear, eId, null);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/21/subsec/1/para/1/consolidated/20071312/fin", result);
    }

    @Test
    void sectionOfLawVersionConsolidatedFiTextIRI() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_21__subsec_1v20071312__para_1v20071312";
        String result = CustomFunctions.sectionOfLawVersionConsolidatedFiTextIRI(docNumber, docYear, eId, null);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/21/subsec/1/para/1/consolidated/20071312/fin/txt", result);
    }

    @Test
    void trimOrNullWithStringContainingWhitespace() {
        String str = "Myynti ja yhteisöhankinta Suomessa (29.12.1994/1486)\n                  ";
        String result = CustomFunctions.trimOrNull(str);
        assertEquals("Myynti ja yhteisöhankinta Suomessa (29.12.1994/1486)", result);
    }

    @Test
    void trimOrNullWithEmptyString() {
        String str = "";
        String result = CustomFunctions.trimOrNull(str);
        assertNull(result);
    }
    @Test
    void trimOrNullWithNullString() {
        String result = CustomFunctions.trimOrNull(null);
        assertNull(result);
    }

    @Test
    void isCrossHeadingReturnsTrueForCrossHeading() {
    String eId = "part_1__chp_9__crossHeading";
    boolean result = CustomFunctions.isCrossHeading(eId);
    assertTrue(result);
    }

    @Test
    void isCrossHeadingReturnsFalseForOther() {
    String eId = "part_1__chp_9__sec_94bv19941486__subsec_2v20101392__intro";
    boolean result = CustomFunctions.isCrossHeading(eId);
    assertFalse(result);
    }

    @Test
    void getVersionClassForOriginalVersion() {
        String eId="part_1__chp_2__sec_2";
        String result = CustomFunctions.getVersionClass(eId, null);
        assertEquals("http://data.finlex.fi/schema/sfl/Original", result);
    }

    @Test
    void getVersionClassForConsolidatedVersion() {
        String eId="part_1__chp_2__sec_2";
        String version = "@19930001";
        String result = CustomFunctions.getVersionClass(eId, version);
        assertEquals("http://data.finlex.fi/schema/sfl/Consolidated", result);
    }

    @Test
    void getVersionClassForConsolidatedVersionWithoutVersion() {
        String eId="part_1__chp_9__sec_94bv19941486__subsec_2v20101392__intro";
        String result = CustomFunctions.getVersionClass(eId, null);
        assertEquals("http://data.finlex.fi/schema/sfl/Consolidated", result);
    }
}