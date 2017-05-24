package Car;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 3/27/17.
 * returns straight lines and curves as building blocks for the map
 * One block is 100x100, so in a 800x600 map, we can place 8x6 parts
 */

public class MapBuildingBlock {

    /* takes a 2d array as input and creates the resulting map with the building blocks
    0 = empty
    1 = vertical
    2 = horizontal
    3 = curve bottom to right
    4 = curve bottom to left
    5 = curve top to right
    6 = curve top to left

     */
    public static List<Line> formMapFromBlockData(int[][] data) {
        List<Line> lines = new ArrayList<Line>();
        for (int y = 0; y < data.length; y++) {
            for (int x = 0; x < data[y].length; x++) {
                if (data[y][x] == 1) {
                    lines.addAll(verticalPiece(x*100,y*100));

                } else if(data[y][x] == 2) {
                    lines.addAll(horizontalPiece(x*100, y*100));

                } else if(data[y][x] == 3) {
                    lines.addAll(curveBottomToRightPiece(x*100, y*100));

                } else if(data[y][x] == 4) {
                    lines.addAll(curveBottomToLeftPiece(x*100, y*100));

                } else if(data[y][x] == 5) {
                    lines.addAll(curveTopToRightPiece(x*100, y*100));

                } else if(data[y][x] == 6) {
                    lines.addAll(curveTopToLeftPiece(x*100, y*100));
                }
            }
        }
        return lines;
    }

    public static List<Line> verticalPiece(int x, int y) {
        List<Line> lines = new ArrayList<Line>();

        // left side
        lines.add(new Line(new Point(5+x, y), new Point(5+x, 100+y)));
        // right side
        lines.add(new Line(new Point(95+x, y), new Point(95+x, 100+y)));

        return lines;
    }

    public static List<Line> horizontalPiece(int x, int y) {
        List<Line> lines = new ArrayList<Line>();

        // top side
        lines.add(new Line(new Point(x, 5+y), new Point(x+100, 5+y)));
        // bottom side
        lines.add(new Line(new Point(x, 95+y), new Point(x+100, 95+y)));

        return lines;
    }

    public static List<Line> curveBottomToRightPiece(int x, int y) {
        List<Line> lines = new ArrayList<Line>();

        // inner curve
        lines.add(new Line(new Point(x+95, y+100), new Point(x+100, 95+y)));

        // outer curve
        lines.add(new Line(new Point(x+5, y+100), new Point(x+33, y+33)));
        lines.add(new Line(new Point(x+33, y+33), new Point(x+100, 5+y)));

        return lines;
    }

    public static List<Line> curveTopToRightPiece(int x, int y) {
        List<Line> lines = new ArrayList<Line>();

        // inner curve
        lines.add(new Line(new Point(x+95, y), new Point(x+100, y + 5)));

        // outer curve
        lines.add(new Line(new Point(x+5, y), new Point(x+33, y+67)));
        lines.add(new Line(new Point(x+33, y+67), new Point(x+100, y + 95)));

        return lines;
    }

    public static List<Line> curveTopToLeftPiece(int x, int y) {
        List<Line> lines = new ArrayList<Line>();

        // inner curve
        lines.add(new Line(new Point(x, y+5), new Point(x+5, y)));

        // outer curve
        lines.add(new Line(new Point(x, y+95), new Point(x+67, y+67)));
        lines.add(new Line(new Point(x+67, y+67), new Point(x+95, y)));

        return lines;
    }

    public static List<Line> curveBottomToLeftPiece(int x, int y) {
        List<Line> lines = new ArrayList<Line>();

        // inner curve
        lines.add(new Line(new Point(x, y+95), new Point(x+5, y+100)));

        // outer curve
        lines.add(new Line(new Point(x, y+5), new Point(x+67, y+33)));
        lines.add(new Line(new Point(x+67, y+33), new Point(x+95, y+100)));

        return lines;
    }

}
