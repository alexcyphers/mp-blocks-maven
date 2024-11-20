package edu.grinnell.csc207.main;

import edu.grinnell.csc207.blocks.AsciiBlock;
import edu.grinnell.csc207.blocks.Rect;
import edu.grinnell.csc207.blocks.Line;
import edu.grinnell.csc207.blocks.HAlignment;
import edu.grinnell.csc207.blocks.HComp;
import edu.grinnell.csc207.blocks.VAlignment;
import edu.grinnell.csc207.blocks.VComp;

import java.io.PrintWriter;

/**
 * Create and print an amazing 80x24 ASCII artwork.
 *
 * @author Alex Cyphers
 * @author Your Name Here
 */
public class Art80x24 {
  /**
   * Create the artwork.
   *
   * @param args
   *   Command-line arguments (currently ignored).
   *
   * @exception Exception
   *   If something goes wrong with one of the underlying classes.
   */
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    AsciiBlock line1 = new Line("* * * * * * ");
    AsciiBlock line2 = new Line(" * * * * * ");
    AsciiBlock[] lines = {line1, line2, line1, line2, line1, line2, line1, line2, line1};

    AsciiBlock stars = new VComp(HAlignment.LEFT, lines);
    AsciiBlock rightLineFull = new Rect('=', 68, 2);
    AsciiBlock rightLineBlank = new Rect(' ', 68, 2);

    AsciiBlock[] rightStripeLines = {rightLineFull, rightLineBlank, rightLineFull, rightLineBlank};
    AsciiBlock rightStripes = new VComp(HAlignment.LEFT, rightStripeLines);

    AsciiBlock topFlag = new HComp(VAlignment.TOP, new AsciiBlock[] {stars, rightStripes});

    AsciiBlock bottomLineFull = new Rect('=', 80, 2);
    AsciiBlock bottomLineBlank = new Rect(' ', 80, 2);
    AsciiBlock lastLine = new Rect(' ', 80, 1);

    AsciiBlock[] bottomStripeLines = {bottomLineFull,
                                      bottomLineBlank,
                                      bottomLineFull,
                                      bottomLineBlank,
                                      bottomLineFull,
                                      bottomLineBlank,
                                      lastLine};

    AsciiBlock bottomFlag = new VComp(HAlignment.LEFT, bottomStripeLines);

    AsciiBlock flag = new VComp(HAlignment.LEFT, new AsciiBlock[] {topFlag, bottomFlag});


    AsciiBlock.print(pen, flag);
    pen.close();
  } // main(String[])
} // class Art80x24
