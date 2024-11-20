package edu.grinnell.csc207.blocks;

import java.util.Arrays;

/**
 * The horizontal composition of blocks.
 *
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */
public class HComp implements AsciiBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The blocks.
   */
  AsciiBlock[] blocks;

  /**
   * How the blocks are aligned.
   */
  VAlignment align;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a horizontal composition of two blocks.
   *
   * @param alignment
   *   The way in which the blocks should be aligned.
   * @param leftBlock
   *   The block on the left.
   * @param rightBlock
   *   The block on the right.
   */
  public HComp(VAlignment alignment, AsciiBlock leftBlock,
      AsciiBlock rightBlock) {
    this.align = alignment;
    this.blocks = new AsciiBlock[] {leftBlock, rightBlock};
  } // HComp(VAlignment, AsciiBlock, AsciiBlock)

  /**
   * Build a horizontal composition of multiple blocks.
   *
   * @param alignment
   *   The alignment of the blocks.
   * @param blocksToCompose
   *   The blocks we will be composing.
   */
  public HComp(VAlignment alignment, AsciiBlock[] blocksToCompose) {
    this.align = alignment;
    this.blocks = Arrays.copyOf(blocksToCompose, blocksToCompose.length);
  } // HComp(Alignment, AsciiBLOCK[])

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
   *   if i is outside the range of valid rows.
   */
  public String row(int i) throws Exception {

    String str = "";
    int index;

    for (int j = 0; j < blocks.length; j++) {
      int height = blocks[j].height();

      if (this.align == VAlignment.TOP) {
        index = i;
      } else if (this.align == VAlignment.BOTTOM) {
        index = i - (height() - height);
      } else {
        index = i - ((height() - height) / 2);
      } // if/else


      if (index >= 0 && index < blocks[j].height()) {
        str += this.blocks[j].row(index);
      } else {
        str += " ".repeat(this.blocks[j].width());
      } // if/else
    } // for-loop
    return str;
  } // row(int)



  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  public int height() {

    int h = 0;

    for (int i = 0; i < blocks.length; i++) {
      if (this.blocks[i].height() > h) {
        h = this.blocks[i].height();
      } // if-statement
    } // for-loop

    return h;
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the number of columns
   */
  public int width() {
    int w = 0;

    for (int i = 0; i < blocks.length; i++) {
      w += this.blocks[i].width();
    } // for-loop

    return w;
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
    return ((other instanceof HComp) && (this.eqv((HComp) other)));
  } // eqv(AsciiBlock)


    /**
   * Determine if another Hcomp is structurally equivalent to this HComp.
   *
   * @param other
   *   The HComp to compare to this HComp.
   *
   * @return true if the two blocks are structurally equivalent and
   *    false otherwise.
   */
  public boolean eqv(HComp other) {
    if ((this.align != other.align) || (this.blocks.length != other.blocks.length)) {
      return false;
    } // if

    for (int i = 0; i < this.blocks.length; i++) {
      if (!this.blocks[i].eqv(other.blocks[i])) {
        return false;
      } // if
    } // for-loop
    return true;
  } // eqv(HComp)
} // class HComp
