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
      alpha = new VComp(HAlignment.LEFT, new AsciiBlock{"abcde"}) {
        
      };
      
      
      
      
      new Line("abcde"),
                         new Line("fghij"),
      new Line("klmno"),
      new Line("pqrst"),
      new Line("uvwxy"));
    } catch (Exception e) {
      // Do nothing; we shouldn't get exceptions.
    } // try/catch



  /**
   * Do we successfully build the empty block?
   */
  @Test
  public void testTrimmedEmpty() {
    //AsciiBlock block = new HComp(HAlignment.LEFT, );
    AsciiBlock[] block = new AsciiBlock[]{new Line("abcde"),
                                          new Line("fghij"),
                                          new Line("klmno"),
                                          new Line("pqrst"),
                                          new Line("uvwxy")};

    
    AsciiBlock trimmed = new Trimmed(block, HAlignment.LEFT, 
                                     VAlignment.TOP, 2,
                                     2);

    
  }






  

} // class TestNewBlock
