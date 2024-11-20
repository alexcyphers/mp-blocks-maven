package edu.grinnell.csc207.blocks;

/**
 * A text block surrounded by a single letter.
 *
 * @author Samuel A. Rebelsky
 * @author Alex Cyphers
 */
public class Surrounded implements AsciiBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The stuff in the box.
   */
  AsciiBlock contents;

  /**
   * The character we put around the box.
   */
  String surroundChar;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new block with the specified contents.
   *
   * @param blockContents
   *   The contents of the block.
   *
   * @param theChar
   *   The character that we use to surround the block.
   */
  public Surrounded(AsciiBlock blockContents, char theChar) {
    this.contents = blockContents;
    this.surroundChar = Character.toString(theChar);
  } // Surrounded(AsciiBlock)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   *
   * @param i the number of the row
   *
   * @return row i.
   *
   * @exception Exception
   *   If the row is invalid.
   */
  public String row(int i) throws Exception {
    int h = this.contents.height();
    int w = this.contents.width();
    if (i == 0) {
      // The top of the box
      return this.surroundChar + this.surroundChar.repeat(w) + this.surroundChar;
    } else if (i == h + 1) {
      // The bottom of the box
      return this.surroundChar + this.surroundChar.repeat(w) + this.surroundChar;
    } else if ((i > 0) && (i <= h)) {
      // Stuff within the box
      return this.surroundChar + this.contents.row(i - 1) + this.surroundChar;
    } else {
      throw new Exception("Invalid row " + i);
    } // if/else
  } // row(int)

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  public int height() {
    return 2 + this.contents.height();
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the number of columns
   */
  public int width() {
    return 2 + this.contents.width();
  } // width()

  /**
   * Determine if another block is structurally equivalent to this block.
   *
   * @param other
   *   The block to compare to this block.
   *
   * @return true if the two blocks are structurally equivalent and
   *    false otherwise.
   */
  public boolean eqv(AsciiBlock other) {
    return ((other instanceof Surrounded) && (this.eqv((Surrounded) other)));
  } // eqv(AsciiBlock)



   /**
   * Determine if another surrounded is structurally equivalent to this surrounded.
   *
   * @param other
   *   The rect to compare to this surrounded.
   *
   * @return true if the two blocks are structurally equivalent and
   *    false otherwise.
   */
  public boolean eqv(Surrounded other) {
    return (this.surroundChar.equals(other.surroundChar)) && this.contents.eqv(other.contents);
  } // eqv(Surrounded)
} // class Surrounded
