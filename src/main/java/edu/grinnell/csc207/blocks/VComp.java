package edu.grinnell.csc207.blocks;

import java.util.Arrays;

/**
 * The vertical composition of blocks.
 *
 * @author Samuel A. Rebelsky
 * @author Alex Cyphers
 * @author Your Name Here
 */
public class VComp implements AsciiBlock {
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
  HAlignment align;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a vertical composition of two blocks.
   *
   * @param alignment
   *   The way in which the blocks should be aligned.
   * @param topBlock
   *   The block on the top.
   * @param bottomBlock
   *   The block on the bottom.
   */
  public VComp(HAlignment alignment, AsciiBlock topBlock,
      AsciiBlock bottomBlock) {
    this.align = alignment;
    this.blocks = new AsciiBlock[] {topBlock, bottomBlock};
  } // VComp(HAlignment, AsciiBlock, AsciiBlock)

  /**
   * Build a vertical composition of multiple blocks.
   *
   * @param alignment
   *   The alignment of the blocks.
   * @param blocksToCompose
   *   The blocks we will be composing.
   */
  public VComp(HAlignment alignment, AsciiBlock[] blocksToCompose) {
    this.align = alignment;
    this.blocks = Arrays.copyOf(blocksToCompose, blocksToCompose.length);
  } // VComp(HAlignment, AsciiBLOCK[])

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

    for (int j = 0; j < blocks.length; j++) {

      if (i >= blocks[j].height()) {
        i -= blocks[j].height();
      } else {
        int width = blocks[j].width();
        String str = blocks[j].row(i);
        int spaces = 0;

        if (this.align == HAlignment.CENTER) {
          spaces = (width() - width) / 2;
        } else if (this.align == HAlignment.RIGHT) {
          spaces = width() - width;
        } // if/else
        return " ".repeat(spaces) + str + " ".repeat(width() - width - spaces);
      } // if/else
    } // for-loop
    throw new Exception("Index out of range");
  } // row(int)

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  public int height() {
    int h = 0;

    for (int i = 0; i < blocks.length; i++) {
      h += blocks[i].height();
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
      if (blocks[i].width() > w) {
        w = this.blocks[i].width();
      } // if
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
    return ((other instanceof VComp) && (this.eqv((VComp) other)));
  } // eqv(AsciiBlock)



   /**
   * Determine if another Vcomp is structurally equivalent to this VComp.
   *
   * @param other
   *   The VComp to compare to this VComp.
   *
   * @return true if the two blocks are structurally equivalent and
   *    false otherwise.
   */
  public boolean eqv(VComp other) {
    if ((this.align != other.align) || (this.blocks.length != other.blocks.length)) {
      return false;
    } // if

    for (int i = 0; i < this.blocks.length; i++) {
      if (!this.blocks[i].eqv(other.blocks[i])) {
        return false;
      } // if
    } // for-loop
    return true;
  } // eqv(VComp)
} // class VComp
