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

    //    Section of Law Work
    @Test
    void sectionOfLawWorkIRIPart() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1";
        String result = CustomFunctions.sectionOfLawWorkIRI(docNumber, docYear, eId);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1", result);
    }

    @Test
    void sectionOfLawWorkIRIChapter() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_2";
        String result = CustomFunctions.sectionOfLawWorkIRI(docNumber, docYear, eId);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/2", result);
    }

    @Test
    void sectionOfLawWorkIRISection() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_20";
        String result = CustomFunctions.sectionOfLawWorkIRI(docNumber, docYear, eId);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/20", result);
    }

    @Test
    void sectionOfLawWorkIRISectionWithVersion() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_18dv20191113";
        String result = CustomFunctions.sectionOfLawWorkIRI(docNumber, docYear, eId);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/18d", result);
    }

    @Test
    void sectionOfLawWorkIRISubsection() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_20__subsec_1";
        String result = CustomFunctions.sectionOfLawWorkIRI(docNumber, docYear, eId);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/20/subsec/1", result);
    }

    @Test
    void sectionOfLawWorkIRISubsectionParagraph() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_21__subsec_1__para_1";
        String result = CustomFunctions.sectionOfLawWorkIRI(docNumber, docYear, eId);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/21/subsec/1/para/1", result);
    }

    @Test
    void sectionOfLawWorkIRISubsectionParagraphWithVersion() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_21__subsec_1v20071312__para_1v20071312";
        String result = CustomFunctions.sectionOfLawWorkIRI(docNumber, docYear, eId);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/21/subsec/1/para/1", result);
    }

    //    Section of Law Version - Original
    @Test
    void sectionOfLawVersionOriginalIRIPart() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1";
        String result = CustomFunctions.sectionOfLawVersionOriginalIRI(docNumber, docYear, eId);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/original", result);
    }

    @Test
    void sectionOfLawVersionOriginalIRIChapter() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_2";
        String result = CustomFunctions.sectionOfLawVersionOriginalIRI(docNumber, docYear, eId);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/2/original", result);
    }

    @Test
    void sectionOfLawVersionOriginalIRISection() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_20";
        String result = CustomFunctions.sectionOfLawVersionOriginalIRI(docNumber, docYear, eId);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/20/original", result);
    }

    @Test
    void sectionOfLawVersionOriginalIRISubsection() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_20__subsec_1";
        String result = CustomFunctions.sectionOfLawVersionOriginalIRI(docNumber, docYear, eId);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/20/subsec/1/original", result);
    }

    @Test
    void sectionOfLawVersionOriginalIRISubsectionParagraph() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_21__subsec_1__para_1";
        String result = CustomFunctions.sectionOfLawVersionOriginalIRI(docNumber, docYear, eId);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/21/subsec/1/para/1/original", result);
    }

    @Test
    void sectionOfLawVersionOriginalIRIReturnsNullForNotOriginal() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_21__subsec_1v20071312__para_1v20071312";
        String result = CustomFunctions.sectionOfLawVersionOriginalIRI(docNumber, docYear, eId);
        assertNull(result);
    }

    //    Section of Law Version - Consolidated

    @Test
    void sectionOfLawVersionConsolidatedIRIChapterWithVersion() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3av19941486";
        String result = CustomFunctions.sectionOfLawVersionConsolidatedIRI(docNumber, docYear, eId, null);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3a/consolidated/19941486", result);
    }

    @Test
    void sectionOfLawVersionConsolidatedIRISectionWithVersion() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_18dv20191113";
        String result = CustomFunctions.sectionOfLawVersionConsolidatedIRI(docNumber, docYear, eId, null);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/18d/consolidated/20191113", result);
    }

    @Test
    void sectionOfLawVersionConsolidatedIRISubsectionWithVersion() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3av19941486__sec_26v19941486__subsec_3v20211113";
        String result = CustomFunctions.sectionOfLawVersionConsolidatedIRI(docNumber, docYear, eId, null);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3a/sec/26/subsec/3/consolidated/20211113", result);
    }

    @Test
    void sectionOfLawVersionConsolidatedIRISubsectionParagraphWithVersion() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_21__subsec_1v20071312__para_1v20071312";
        String result = CustomFunctions.sectionOfLawVersionConsolidatedIRI(docNumber, docYear, eId, null);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/21/subsec/1/para/1/consolidated/20071312", result);
    }

    @Test
    void sectionOfLawVersionConsolidatedIRIIntroWithVersion() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_2__sec_8cv20100686__subsec_1v20100686__intro";
        String result = CustomFunctions.sectionOfLawVersionConsolidatedIRI(docNumber, docYear, eId, null);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/2/sec/8c/subsec/1/intro/consolidated/20100686", result);
    }

    @Test
    void sectionOfLawVersionConsolidatedIRICrossHeadingWithVersion() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_2__crossHeading_9";
        String result = CustomFunctions.sectionOfLawVersionConsolidatedIRI(docNumber, docYear, eId, "@20100686");
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/2/crossHeading/9/consolidated/20100686", result);
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
        String eId = "\"part_1__chp_3av19941486__sec_26v19941486__subsec_3v20211113\"";
        String result = CustomFunctions.amendedByStatuteWorkIRI(eId, null);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/2021/1113", result);
    }

    void amendedByStatuteLocalId() {
        String eId = "part_1__chp_2__crossHeading_9";
        String version = "@19931501";
        String result = CustomFunctions.amendedByStatuteLocalId(eId, version);
        assertEquals("1501/1993", result);
    }

    @Test
    void amendedByStatuteLocalIdWithLeadingZeros() {
        String eId = "part_1__chp_2__crossHeading_9";
        String version = "@19930001";
        String result = CustomFunctions.amendedByStatuteLocalId(eId, version);
        assertEquals("1/1993", result);
    }

    @Test
    void amendedByStatuteLocalIdFromEid() {
        String eId = "part_1__chp_3av19941486__sec_26v19941486__subsec_3v20211113";
        String result = CustomFunctions.amendedByStatuteLocalId(eId, null);
        assertEquals("1113/2021", result);
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
    void getPartClass() {
        String eId = "part_1";
        String result = CustomFunctions.getSectionOfLawClass(eId, false);
        assertEquals("http://data.finlex.fi/schema/sfl/Part", result);
    }
    @Test
    void getChapterClass() {
        String eId = "part_1__chp_1";
        String result = CustomFunctions.getSectionOfLawClass(eId, false);
        assertEquals("http://data.finlex.fi/schema/sfl/Chapter", result);
    }

    @Test
    void getSectionClass() {
        String eId = "part_1__chp_2__sec_4v20091780";
        String result = CustomFunctions.getSectionOfLawClass(eId, false);
        assertEquals("http://data.finlex.fi/schema/sfl/Section", result);
    }

    @Test
    void getSubsectionClass() {
        String eId = "part_1__chp_2__sec_4v20091780__subsec_1v20091780";
        String result = CustomFunctions.getSectionOfLawClass(eId, false);
        assertEquals("http://data.finlex.fi/schema/sfl/Subsection", result);
    }

    @Test
    void getParagraphVersionClass() {
        String eId = "part_1__chp_2__sec_8cv20100686__subsec_1v20100686__para_2v20100686";
        String result = CustomFunctions.getSectionOfLawClass(eId, true);
        assertEquals("http://data.finlex.fi/schema/sfl/ParagraphVersion", result);
    }
    @Test
    void getSubParagraphVersionClass() {
        String eId = "part_1__chp_9__sec_94__subsec_1__para_14v20091359__subpara_av20091359";
        String result = CustomFunctions.getSectionOfLawClass(eId, true);
        assertEquals("http://data.finlex.fi/schema/sfl/SubparagraphVersion", result);
    }

    @Test
    void getIntroClass() {
        String eId = "part_1__chp_9__sec_94bv19941486__subsec_2v20101392__intro";
        String result = CustomFunctions.getSectionOfLawClass(eId, false);
        assertEquals("http://data.finlex.fi/schema/sfl/Paragraph", result);
    }

    @Test
    void getSubheadingClass() {
        String eId = "part_1__chp_9__crossHeading_4";
        String result = CustomFunctions.getSectionOfLawClass(eId, false);
        assertEquals("http://data.finlex.fi/schema/sfl/Subheading", result);
    }

//    String eId = "part_1__chp_9__sec_94bv19941486__subsec_2v20101392__intro";
//    String eId = "part_1__chp_9__crossHeading_4";
//    String eId = "part_1__chp_9__sec_94__subsec_1__para_14v20091359__subpara_av20091359";
//
//
//    String eId = "part_1__chp_3__sec_18dv20191113";





    @Test
    void getSectionOfLawNumberSubsec() {
    String eId = "part_1__chp_9__sec_94bv19941486__subsec_2v20101392";
    String result = CustomFunctions.getSectionOfLawNumber(eId);
    assertEquals("2", result);
    }
    @Test
    void getSectionOfLawNumberSectionWithLetter() {
    String eId = "part_1__chp_3__sec_18dv20191113";
    String result = CustomFunctions.getSectionOfLawNumber(eId);
    assertEquals("18d", result);
    }
    @Test
    void getSectionOfLawNumberCrossHeading() {
    String eId = "part_1__chp_9__crossHeading_4";
    String result = CustomFunctions.getSectionOfLawNumber(eId);
    assertEquals("4", result);
    }
    @Test
    void getSectionOfLawNumberSubparagrap() {
    String eId = "part_1__chp_9__sec_94__subsec_1__para_14v20091359__subpara_av20091359";
    String result = CustomFunctions.getSectionOfLawNumber(eId);
    assertEquals("a", result);
    }
    @Test
    void getSectionOfLawNumberChapter() {
    String eId = "part_1__chp_9";
    String result = CustomFunctions.getSectionOfLawNumber(eId);
    assertEquals("9", result);
    }
    @Test
    void getSectionOfLawNumberNullForIntro() {
    String eId = "part_1__chp_9__sec_94bv19941486__subsec_2v20101392__intro";
    String result = CustomFunctions.getSectionOfLawNumber(eId);
    assertEquals("intro", result);
    }

}