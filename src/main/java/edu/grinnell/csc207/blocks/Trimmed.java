package edu.grinnell.csc207.blocks;

/**
 * A trimmed ASCII block.
 *
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */
public class Trimmed implements AsciiBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The original block.
   */
  AsciiBlock block;

  /**
   * Which part of the block do we keep horizontally?
   */
  HAlignment halign;

  /**
   * Which part of the block do we keep vertically?
   */
  VAlignment valign;

  /**
   * How much of the block do we keep horizontally?
   */
  int width;

  /**
   * How much of the block do we keep vertically?
   */
  int height;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new block with the specified contents.
   *
   * @param original
   *   The original block.
   * @param horiz
   *   How the trimmed block is horizontally aligned on the original.
   * @param vert
   *   How the trimmed block is vertically aligned on the original.
   * @param trimmedWidth
   *   The width of the trimmed block.
   * @param trimmedHeight
   *   The height of the trimmed block.
   */
  public Trimmed(AsciiBlock original, HAlignment horiz, VAlignment vert,
      int trimmedWidth, int trimmedHeight) {
    this.block = original;
    this.halign = horiz;
    this.valign = vert;
    this.width = trimmedWidth;
    this.height = trimmedHeight;
  } // Trimmed(AsciiBlock, HAlignment, VAlignment, int, int)

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
    int newRow = 0;
    int height = block.height();
    int width = block.width();

    if(valign == VAlignment.CENTER) {
      if(height() - height > 0) {
        newRow = (height - height()) / 2;
      } else {
        newRow = 0;
      } // if/else
    } else if (valign == VAlignment.BOTTOM) {
      if(height() - height > 0) {
        newRow = height - height();
      } else {
        newRow = 0;
      } // if/else
    } // if/else
    
    newRow = newRow + i;
    int col = 0;

    if(halign == HAlignment.CENTER) {
      if(width - width() > 0) {
        col = (width - width()) / 2;
      } else {
        col = 0;
      } // if/else
    } else if (halign == HAlignment.RIGHT) {
      if(width - width() > 0) {
        col = width - width();
      } else {
        col = 0;
      } // if/else
    } // if/else
    
    String initialRow = block.row(newRow);

    if((col + width()) > initialRow.length()) {
      return initialRow.substring(col, initialRow.length());
    } else {
      return initialRow.substring(col, col + width());
    }

  } // row(int)

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  public int height() {
    if(block.height() > height) {
      return height;
    } else {
      return block.height();
    } // if/else
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the number of columns
   */
  public int width() {
    if(block.width() > width) {
      return width;
    } else {
      return block.width();
    } // if/else
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
    return false;       // STUB
  } // eqv(AsciiBlock)
} // class Trimmed
