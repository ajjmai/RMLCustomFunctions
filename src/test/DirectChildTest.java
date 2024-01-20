package test;

import main.CustomFunctions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DirectChildTest {
    @Test
    void partAndChapterDirectChild() {
        String part = "part_1";
        String chapter = "part_1__chp_9";
        boolean result = CustomFunctions.isDirectChild(part, chapter);
        assertTrue(result);
    }

    @Test
    void partAndChapterNotDirectChild() {
        String part = "part_1";
        String chapter = "part_4__chp_9";
        boolean result = CustomFunctions.isDirectChild(part, chapter);
        assertFalse(result);
    }

    @Test
    void partAndSubsectionNotDirectChild() {
        String part = "part_1";
        String chapter = "part_1__chp_9__sec_94bv19941486__subsec_2v20101392";
        boolean result = CustomFunctions.isDirectChild(part, chapter);
        assertFalse(result);
    }

    @Test
    void chapterAndCrossheadingDirectChild() {
        String part = "part_1__chp_2";
        String chapter = "part_1__chp_2__crossHeading_11";
        boolean result = CustomFunctions.isDirectChild(part, chapter);
        assertTrue(result);
    }

    @Test
    void chapterAndSectionDirectChild() {
        String part = "part_1__chp_12";
        String chapter = "part_1__chp_12__sec_124v19941486";
        boolean result = CustomFunctions.isDirectChild(part, chapter);
        assertTrue(result);
    }

    @Test
    void sectionAndSubsectionDirectChild() {
        String part = "part_1__chp_2__sec_9v19941486";
        String chapter = "part_1__chp_2__sec_9v19941486__subsec_1v19941486";
        boolean result = CustomFunctions.isDirectChild(part, chapter);
        assertTrue(result);
    }

    @Test
    void subSectionAndIntroDirectChild() {
        String part = "part_1__chp_2__sec_13av19940377__subsec_2v20030325";
        String chapter = "part_1__chp_2__sec_13av19940377__subsec_2v20030325__intro";
        boolean result = CustomFunctions.isDirectChild(part, chapter);
        assertTrue(result);
    }

    @Test
    void subSectionAndParaDirectChild() {
        String part = "part_1__chp_2__sec_13av19940377__subsec_2v20030325";
        String chapter = "part_1__chp_2__sec_13av19940377__subsec_2v20030325__para_3v20030325";
        boolean result = CustomFunctions.isDirectChild(part, chapter);
        assertTrue(result);
    }

    @Test
    void subSectionAndIntroNotDirectChild() {
        String part = "part_1__chp_2__sec_13av19940377__subsec_2v20030325";
        String chapter = "part_1__chp_2__sec_1v19940377__subsec_2v20030325__intro";
        boolean result = CustomFunctions.isDirectChild(part, chapter);
        assertFalse(result);
    }
}
