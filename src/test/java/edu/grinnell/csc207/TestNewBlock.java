package edu.grinnell.csc207;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.grinnell.csc207.blocks.AsciiBlock;
import edu.grinnell.csc207.blocks.Boxed;
import edu.grinnell.csc207.blocks.Empty;
import edu.grinnell.csc207.blocks.HAlignment;
import edu.grinnell.csc207.blocks.HComp;
import edu.grinnell.csc207.blocks.Line;
import edu.grinnell.csc207.blocks.Rect;
import edu.grinnell.csc207.blocks.Trimmed;
import edu.grinnell.csc207.blocks.VAlignment;
import edu.grinnell.csc207.blocks.VComp;

/**
 * Tests of the new block.
 */
public class TestNewBlock {
  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  static AsciiBlock alpha;
  /**
   * A placeholder.
   */
  @Test
  public void placeholder() {
    assertEquals("hello", "hello");
  } // placeholder()


    /**
   * Set up the global.
   */
  @BeforeAll
  public static void setup() throws Exception {
    try {
      // Globals for HComp tests
      AsciiBlock[] block = new AsciiBlock[]{new Line("abcde"),
                                          new Line("fghij"),
                                          new Line("klmno"),
                                          new Line("pqrst"),
                                          new Line("uvwxy")};
      alpha = new VComp(HAlignment.LEFT, block);
    } catch (Exception e) {
      // Do nothing; we shouldn't get exceptions.
    } // try/catch
  }


  /**
   * Test trimmed on an asciiblock using left horizontal alignment
   * and top vertical alignment.
   */
  @Test
  public void testTrimmedHorizontal() {
    AsciiBlock trimmedLeft = new Trimmed(alpha, HAlignment.LEFT, VAlignment.TOP,
                                     2, 2);
    AsciiBlock trimmedCenter = new Trimmed(alpha, HAlignment.CENTER, VAlignment.TOP,
                                     2, 2);
    AsciiBlock trimmedRight = new Trimmed(alpha, HAlignment.RIGHT, VAlignment.TOP,
                                     2, 2);

    assertEquals(2, trimmedLeft.width(), "Width of 2");
    assertEquals(2, trimmedCenter.width(), "Width of 2");
    assertEquals(2, trimmedRight.width(), "Width of 2");
    assertEquals(2, trimmedLeft.height(), "Height of 2");
    assertEquals(2, trimmedCenter.height(), "Height of 2");
    assertEquals(2, trimmedRight.height(), "Height of 2");

    assertEquals(
      "" 
        + "ab\n"
        + "fg\n",
        TestUtils.toString(trimmedLeft),
        "M: Correct contents of left-aligned trimmed");
    assertEquals(
      "" 
        + "bc\n"
        + "gh\n",
        TestUtils.toString(trimmedCenter),
        "M: Correct contents of center-aligned trimmed");
    assertEquals(
      "" 
        + "de\n"
        + "ij\n",
        TestUtils.toString(trimmedRight),
        "M: Correct contents of right-aligned trimmed");
        
  }





    /**
   * Test trimmed on an asciiblock using left horizontal alignment
   * and top vertical alignment.
   */
  @Test
  public void testTrimmedVertical() {
    AsciiBlock trimmedTop = new Trimmed(alpha, HAlignment.LEFT, VAlignment.TOP,
                                     2, 2);
    AsciiBlock trimmedCenter = new Trimmed(alpha, HAlignment.LEFT, VAlignment.CENTER,
                                     2, 2);
    AsciiBlock trimmedBottom = new Trimmed(alpha, HAlignment.LEFT, VAlignment.BOTTOM,
                                     2, 2);

    assertEquals(2, trimmedTop.width(), "Width of 2");
    assertEquals(2, trimmedCenter.width(), "Width of 2");
    assertEquals(2, trimmedBottom.width(), "Width of 2");
    assertEquals(2, trimmedTop.height(), "Height of 2");
    assertEquals(2, trimmedCenter.height(), "Height of 2");
    assertEquals(2, trimmedBottom.height(), "Height of 2");

    assertEquals(
      "" 
        + "ab\n"
        + "fg\n",
        TestUtils.toString(trimmedTop),
        "M: Correct contents of top-aligned trimmed");
    assertEquals(
      "" 
        + "ab\n"
        + "fg\n",
        TestUtils.toString(trimmedCenter),
        "M: Correct contents of center-aligned trimmed");
    assertEquals(
      "" 
        + "ab\n"
        + "fg\n",
        TestUtils.toString(trimmedBottom),
        "M: Correct contents of bottom-aligned trimmed");
        
  }



  /**
   * Test trimmed on an asciiblock using right horizontal alignment
   * and top vertical alignment.
   */
  @Test
  public void testTrimmedRightTop() {
    AsciiBlock trimmed = new Trimmed(alpha, HAlignment.RIGHT, VAlignment.TOP,
                                     2, 2);
    assertEquals(2, trimmed.width(), "Width of 2");
    assertEquals(2, trimmed.height(), "Height of 2");
    assertEquals(
      "" 
        + "de\n"
        + "ij\n",
        TestUtils.toString(trimmed),
        "M: Correct contents of left-aligned top-aligned trimmed");
  }



    /**
   * Test trimmed on an asciiblock using right horizontal alignment
   * and top vertical alignment.
   */
  @Test
  public void testTrimmedHigherWidth() {
    AsciiBlock trimmed = new Trimmed(alpha, HAlignment.CENTER, VAlignment.TOP,
                                     3, 2);
    assertEquals(3, trimmed.width(), "Width of 2");
    assertEquals(2, trimmed.height(), "Height of 2");
    assertEquals(
      "" 
        + "bcd\n"
        + "ghi\n",
        TestUtils.toString(trimmed),
        "M: Correct contents of left-aligned top-aligned trimmed");
  }



   /**
   * Test trimmed on an asciiblock using right horizontal alignment
   * and top vertical alignment.
   */
  @Test
  public void testTrimmedRightAlignment() {
    AsciiBlock trimmed = new Trimmed(alpha, HAlignment.CENTER, VAlignment.TOP,
                                     2, 2);
    assertEquals(2, trimmed.width(), "Width of 2");
    assertEquals(2, trimmed.height(), "Height of 2");
    assertEquals(
      "" 
        + "bcd\n"
        + "ghi\n",
        TestUtils.toString(trimmed),
        "M: Correct contents of left-aligned top-aligned trimmed");
  }

  

} // class TestNewBlock
