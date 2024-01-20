package test;

import main.CustomFunctions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SectionOfLawClassAndNumberTest {
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
        String eId = "part_1__chp_9__crossHeading";
        String result = CustomFunctions.getSectionOfLawNumber(eId);
        assertEquals("1", result);
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
