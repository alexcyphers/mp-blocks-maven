package edu.grinnell.csc207;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.grinnell.csc207.blocks.AsciiBlock;
import edu.grinnell.csc207.blocks.Boxed;
import edu.grinnell.csc207.blocks.Empty;

/**
 * Tests of the new block.
 */
public class TestNewBlock {
  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  /**
   * A placeholder.
   */
  @Test
  public void placeholder() {
    assertEquals("hello", "hello");
  } // placeholder()


  /**
   * Do we successfully build the empty block?
   */
  @Test
  public void testTrimmedEmpty() {
    AsciiBlock trimmed = new Boxed(new Empty());
  }


  
  

} // class TestNewBlock
