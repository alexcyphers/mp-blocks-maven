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
   * Test trimmed on an asciiblock using different
   * horizontal alignments.
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
  } // testTrimmedHorizontal()





  /**
   * Test trimmed on an asciiblock using different vertical
   * alignments.
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
        + "fg\n"
        + "kl\n",
        TestUtils.toString(trimmedCenter),
        "M: Correct contents of center-aligned trimmed");
    assertEquals(
      "" 
        + "pq\n"
        + "uv\n",
        TestUtils.toString(trimmedBottom),
        "M: Correct contents of bottom-aligned trimmed");
  } // testTrimmedVertical()


   /**
   * Test trimmed on an asciiblock using higher widths than heights.
   */
  @Test
  public void testTrimmedHigherWidth() {
    AsciiBlock trimmedLeft = new Trimmed(alpha, HAlignment.LEFT, VAlignment.TOP,
                                     3, 2);
    AsciiBlock trimmedFullWidth = new Trimmed(alpha, HAlignment.CENTER, VAlignment.BOTTOM,
                                     5, 2);
    AsciiBlock trimmedFlat = new Trimmed(alpha, HAlignment.CENTER, VAlignment.TOP,
                                     3, 1);
    

    assertEquals(3, trimmedLeft.width(), "Width of 3");
    assertEquals(5, trimmedFullWidth.width(), "Width of 5");
    assertEquals(3, trimmedFlat.width(), "Width of 3");
    assertEquals(2, trimmedLeft.height(), "Height of 2");
    assertEquals(2, trimmedFullWidth.height(), "Height of 2");
    assertEquals(1, trimmedFlat.height(), "Height of 1");

    assertEquals(
      "" 
        + "abc\n"
        + "fgh\n",
        TestUtils.toString(trimmedLeft),
        "M: Correct contents of left-aligned trimmed");
    assertEquals(
      "" 
        + "pqrst\n"
        + "uvwxy\n",
        TestUtils.toString(trimmedFullWidth),
        "M: Correct contents of full width trimmed");
    assertEquals(
      "" 
        + "bcd\n",
        TestUtils.toString(trimmedFlat),
        "M: Correct contents of flat trimmed");
  } // testTrimmedHigherWidth()



   /**
   * Test trimmed on an asciiblock using higher heights than
   * widths.
   */
  @Test
  public void testTrimmedHigherHeight() {
    AsciiBlock trimmedFullHeight = new Trimmed(alpha, HAlignment.LEFT, VAlignment.TOP,
                                     2, 5);
    AsciiBlock trimmedBottom = new Trimmed(alpha, HAlignment.CENTER, VAlignment.BOTTOM,
                                     2, 3);
    AsciiBlock trimmedThin = new Trimmed(alpha, HAlignment.CENTER, VAlignment.TOP,
                                     1, 4);
    

    assertEquals(2, trimmedFullHeight.width(), "Width of 2");
    assertEquals(2, trimmedBottom.width(), "Width of 2");
    assertEquals(1, trimmedThin.width(), "Width of 1");
    assertEquals(5, trimmedFullHeight.height(), "Height of 5");
    assertEquals(3, trimmedBottom.height(), "Height of 3");
    assertEquals(4, trimmedThin.height(), "Height of 4");

    assertEquals(
      "" 
        + "ab\n"
        + "fg\n"
        + "kl\n"
        + "pq\n"
        + "uv\n",
        TestUtils.toString(trimmedFullHeight),
        "M: Correct contents of full height trimmed");
    assertEquals(
      "" 
        + "lm\n"
        + "qr\n"
        + "vw\n",
        TestUtils.toString(trimmedBottom),
        "M: Correct contents of bottom-aligned trimmed");
    assertEquals(
      "" 
        + "c\n"
        + "h\n"
        + "m\n"
        + "r\n",
        TestUtils.toString(trimmedThin),
        "M: Correct contents of thin trimmed");
  } // testTrimmedHigherHeight()

  

  /**
   * Test trimmed on an asciiblock without trimming any
   * part of the ascii block.
   */
  @Test
  public void testTrimmedFullBlock() {
    AsciiBlock trimmedFullBlock = new Trimmed(alpha, HAlignment.LEFT, VAlignment.TOP,
                                     5, 5);
    

    assertEquals(5, trimmedFullBlock.width(), "Width of 5");
    assertEquals(5, trimmedFullBlock.height(), "Height of 5");

    assertEquals(
      "" 
        + "abcde\n"
        + "fghij\n"
        + "klmno\n"
        + "pqrst\n"
        + "uvwxy\n",
        TestUtils.toString(trimmedFullBlock),
        "M: Correct contents of full block trimmed");
  } // testTrimmedFullBlock()



    /**
   * Test trimmed on an asciiblock while trimming the entire
   * ascii block.
   */
  @Test
  public void testTrimmedEmptyBlock() {
    AsciiBlock trimmedEmpty = new Trimmed(alpha, HAlignment.LEFT, VAlignment.TOP,
                                     0, 0);
    

    assertEquals(0, trimmedEmpty.width(), "Width of 0");
    assertEquals(0, trimmedEmpty.height(), "Height of 0");

    assertEquals("",
        TestUtils.toString(trimmedEmpty),
        "M: Correct contents of empty block trimmed");
  } // testTrimmedEmptyBlock()
} // class TestNewBlock
