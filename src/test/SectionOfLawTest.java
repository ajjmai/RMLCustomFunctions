package test;

import main.CustomFunctions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SectionOfLawTest {
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

    @Test
    void sectionOfLawWorkIRIFirstCrossHeading() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_2__crossHeading";
        String result = CustomFunctions.sectionOfLawWorkIRI(docNumber, docYear, eId);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/2/crossHeading/1", result);
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

    @Test
    void sectionOfLawVersionOriginalIRIFirstCrossHeading() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_2__crossHeading";
        String result = CustomFunctions.sectionOfLawVersionOriginalIRI(docNumber, docYear, eId);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/2/crossHeading/1/original", result);
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
    void sectionOfLawVersionConsolidatedIRIFirstCrossHeading() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_2__crossHeading";
        String result = CustomFunctions.sectionOfLawVersionConsolidatedIRI(docNumber, docYear, eId, "@20100686");
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/2/crossHeading/1/consolidated/20100686", result);
    }

    @Test
    void sectionOfLawVersionIRIPart() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1";
        String result = CustomFunctions.sectionOfLawVersionIRI(docNumber, docYear, eId, null);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/19931501", result);
    }

    @Test
    void sectionOfLawVersionIRIChapter() {
        String docNumber = "501";
        String docYear = "1993";
        String eId = "part_1__chp_2";
        String result = CustomFunctions.sectionOfLawVersionIRI(docNumber, docYear, eId, null);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/501/part/1/chp/2/19930501", result);
    }

    @Test
    void sectionOfLawVersionIRISection() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_20";
        String result = CustomFunctions.sectionOfLawVersionIRI(docNumber, docYear, eId, null);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/20/19931501", result);
    }

    @Test
    void sectionOfLawVersionIRISubsection() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_20__subsec_1";
        String result = CustomFunctions.sectionOfLawVersionIRI(docNumber, docYear, eId, null);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/20/subsec/1/19931501", result);
    }

    @Test
    void sectionOfLawVersionIRISubsectionParagraph() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_21__subsec_1__para_1";
        String result = CustomFunctions.sectionOfLawVersionIRI(docNumber, docYear, eId, null);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/21/subsec/1/para/1/19931501", result);
    }

    @Test
    void sectionOfLawVersionIRIFirstCrossHeading() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_2__crossHeading";
        String result = CustomFunctions.sectionOfLawVersionIRI(docNumber, docYear, eId, null);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/2/crossHeading/1/19931501", result);
    }

    //    Section of Law Version - Consolidated

    @Test
    void sectionOfLawVersionIRIChapterWithVersion() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3av19941486";
        String result = CustomFunctions.sectionOfLawVersionIRI(docNumber, docYear, eId, null);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3a/19941486", result);
    }

    @Test
    void sectionOfLawVersionIRISectionWithVersion() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_18dv20191113";
        String result = CustomFunctions.sectionOfLawVersionIRI(docNumber, docYear, eId, null);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/18d/20191113", result);
    }

    @Test
    void sectionOfLawVersionIRISubsectionWithVersion() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3av19941486__sec_26v19941486__subsec_3v20211113";
        String result = CustomFunctions.sectionOfLawVersionIRI(docNumber, docYear, eId, null);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3a/sec/26/subsec/3/20211113", result);
    }

    @Test
    void sectionOfLawVersionIRISubsectionParagraphWithVersion() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_21__subsec_1v20071312__para_1v20071312";
        String result = CustomFunctions.sectionOfLawVersionIRI(docNumber, docYear, eId, null);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/21/subsec/1/para/1/20071312", result);
    }

    @Test
    void sectionOfLawVersionIRIIntroWithVersion() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_2__sec_8cv20100686__subsec_1v20100686__intro";
        String result = CustomFunctions.sectionOfLawVersionIRI(docNumber, docYear, eId, null);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/2/sec/8c/subsec/1/intro/20100686", result);
    }

    @Test
    void sectionOfLawVersionIRICrossHeadingWithVersion() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_2__crossHeading_9";
        String result = CustomFunctions.sectionOfLawVersionIRI(docNumber, docYear, eId, "@20100686");
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/2/crossHeading/9/20100686", result);
    }

    @Test
    void sectionOfLawVersionIRIFirstCrossHeadingWithVersion() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_2__crossHeading";
        String result = CustomFunctions.sectionOfLawVersionIRI(docNumber, docYear, eId, "@20100686");
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/2/crossHeading/1/20100686", result);
    }

    @Test
    void sectionOfLawVersionOriginalFiIRI() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_20";
        String result = CustomFunctions.sectionOfLawVersionFiIRI(docNumber, docYear, eId, null);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/20/19931501/fin", result);
    }

    @Test
    void sectionOfLawVersionOriginalFiTextIRI() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_20";
        String result = CustomFunctions.sectionOfLawVersionFiTextIRI(docNumber, docYear, eId, null);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/20/19931501/fin/txt", result);
    }

    @Test
    void sectionOfLawVersionConsolidatedFiIRI() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_21__subsec_1v20071312__para_1v20071312";
        String result = CustomFunctions.sectionOfLawVersionFiIRI(docNumber, docYear, eId, null);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/21/subsec/1/para/1/20071312/fin", result);
    }

    @Test
    void sectionOfLawVersionConsolidatedFiTextIRI() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_21__subsec_1v20071312__para_1v20071312";
        String result = CustomFunctions.sectionOfLawVersionFiTextIRI(docNumber, docYear, eId, null);
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/21/subsec/1/para/1/20071312/fin/txt", result);
    }

    @Test
    void sectionOfLawVersionConsolidatedWithVersionFiIRI() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_21__subsec_1v20071312__para_1v20071312";
        String result = CustomFunctions.sectionOfLawVersionFiIRI(docNumber, docYear, eId, "@20100686");
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/21/subsec/1/para/1/20100686/fin", result);
    }

    @Test
    void sectionOfLawVersionConsolidatedWithVersionFiTextIRI() {
        String docNumber = "1501";
        String docYear = "1993";
        String eId = "part_1__chp_3__sec_21__subsec_1v20071312__para_1v20071312";
        String result = CustomFunctions.sectionOfLawVersionFiTextIRI(docNumber, docYear, eId, "@20100686");
        assertEquals("http://ldf.fi/lawsampo/eli/statute/1993/1501/part/1/chp/3/sec/21/subsec/1/para/1/20100686/fin/txt", result);
    }

}
