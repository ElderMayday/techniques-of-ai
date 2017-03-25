package Car;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Created by root on 3/21/17.
 */
public class Map {
    private ArrayList<Line> lines;
    private ArrayList<Line> checkpoints;

    private double startX;
    private double startY;
    private double startDegree;

    public Map(int testMapNr) {
        this.lines = new ArrayList<Line>();
        this.checkpoints = new ArrayList<Line>();
		/*
		 * ugly line values for the maps
		 */
        if (testMapNr == 1) {

            this.startX = 400;
            this.startY = 400;
            this.startDegree = 0;

            int x1 = 50;
            int y1 = 50;
            int x2 = 750;
            int y2 = 50;
            int x3 = 750;
            int y3 = 550;
            int x4 = 50;
            int y4 = 550;

            int x5 = 150;
            int y5 = 150;
            int x6 = 650;
            int y6 = 150;
            int x7 = 650;
            int y7 = 450;
            int x8 = 150;
            int y8 = 450;

            this.addLine(new Line(new Point(x1, y1), new Point(x2, y2)));
            this.addLine(new Line(new Point(x2, y2), new Point(x3, y3)));
            this.addLine(new Line(new Point(x3, y3), new Point(x4, y4)));
            this.addLine(new Line(new Point(x4, y4), new Point(x1, y1)));
            this.addLine(new Line(new Point(x5, y5), new Point(x6, y6)));
            this.addLine(new Line(new Point(x6, y6), new Point(x7, y7)));
            this.addLine(new Line(new Point(x7, y7), new Point(x8, y8)));
            this.addLine(new Line(new Point(x8, y8), new Point(x5, y5)));
        } else if(testMapNr == 2) {

            this.startX = 130;
            this.startY = 400;
            this.startDegree = 260;

            this.addLine(new Line(new Point(49,279), new Point(38,154)));
            this.addLine(new Line(new Point(38,154), new Point(41,97)));
            this.addLine(new Line(new Point(41,97), new Point(57,50)));
            this.addLine(new Line(new Point(57,50), new Point(86,29)));
            this.addLine(new Line(new Point(86,29), new Point(131,20)));
            this.addLine(new Line(new Point(131,20), new Point(196,22)));
            this.addLine(new Line(new Point(196,22), new Point(265,25)));
            this.addLine(new Line(new Point(265,25), new Point(346,22)));
            this.addLine(new Line(new Point(346,22), new Point(427,13)));
            this.addLine(new Line(new Point(427,13), new Point(481,16)));
            this.addLine(new Line(new Point(481,16), new Point(527,26)));
            this.addLine(new Line(new Point(527,26), new Point(577,47)));
            this.addLine(new Line(new Point(577,47), new Point(610,79)));
            this.addLine(new Line(new Point(610,79), new Point(628,116)));
            this.addLine(new Line(new Point(628,116), new Point(638,146)));
            this.addLine(new Line(new Point(638,146), new Point(662,164)));
            this.addLine(new Line(new Point(662,164), new Point(689,176)));
            this.addLine(new Line(new Point(689,176), new Point(721,187)));
            this.addLine(new Line(new Point(721,187), new Point(759,205)));
            this.addLine(new Line(new Point(759,205), new Point(780,239)));
            this.addLine(new Line(new Point(780,239), new Point(786,280)));
            this.addLine(new Line(new Point(786,280), new Point(784,312)));
            this.addLine(new Line(new Point(784,312), new Point(782,355)));
            this.addLine(new Line(new Point(782,355), new Point(769,384)));
            this.addLine(new Line(new Point(769,384), new Point(740,409)));
            this.addLine(new Line(new Point(740,409), new Point(712,418)));
            this.addLine(new Line(new Point(712,418), new Point(673,428)));
            this.addLine(new Line(new Point(673,428), new Point(627,440)));
            this.addLine(new Line(new Point(627,440), new Point(554,435)));
            this.addLine(new Line(new Point(554,435), new Point(500,443)));
            this.addLine(new Line(new Point(500,443), new Point(465,475)));
            this.addLine(new Line(new Point(465,475), new Point(436,516)));
            this.addLine(new Line(new Point(436,516), new Point(409,543)));
            this.addLine(new Line(new Point(409,543), new Point(368,559)));
            this.addLine(new Line(new Point(368,559), new Point(311,560)));
            this.addLine(new Line(new Point(311,560), new Point(259,542)));
            this.addLine(new Line(new Point(259,542), new Point(220,511)));
            this.addLine(new Line(new Point(220,511), new Point(183,477)));
            this.addLine(new Line(new Point(183,477), new Point(119,453)));
            this.addLine(new Line(new Point(119,453), new Point(80,424)));
            this.addLine(new Line(new Point(80,424), new Point(63,369)));
            this.addLine(new Line(new Point(63,369), new Point(51,306)));
            this.addLine(new Line(new Point(51,306), new Point(48,279)));
            this.addLine(new Line(new Point(151,269), new Point(139,214)));
            this.addLine(new Line(new Point(139,214), new Point(135,181)));
            this.addLine(new Line(new Point(135,181), new Point(135,141)));
            this.addLine(new Line(new Point(135,141), new Point(150,123)));
            this.addLine(new Line(new Point(150,123), new Point(176,117)));
            this.addLine(new Line(new Point(176,117), new Point(215,111)));
            this.addLine(new Line(new Point(215,111), new Point(250,118)));
            this.addLine(new Line(new Point(250,118), new Point(287,121)));
            this.addLine(new Line(new Point(287,121), new Point(325,119)));
            this.addLine(new Line(new Point(325,119), new Point(368,116)));
            this.addLine(new Line(new Point(368,116), new Point(400,111)));
            this.addLine(new Line(new Point(400,111), new Point(439,114)));
            this.addLine(new Line(new Point(439,114), new Point(482,121)));
            this.addLine(new Line(new Point(482,121), new Point(506,143)));
            this.addLine(new Line(new Point(506,143), new Point(524,176)));
            this.addLine(new Line(new Point(524,176), new Point(533,200)));
            this.addLine(new Line(new Point(533,200), new Point(554,211)));
            this.addLine(new Line(new Point(554,211), new Point(590,224)));
            this.addLine(new Line(new Point(590,224), new Point(634,232)));
            this.addLine(new Line(new Point(634,232), new Point(653,249)));
            this.addLine(new Line(new Point(653,249), new Point(671,287)));
            this.addLine(new Line(new Point(671,287), new Point(672,317)));
            this.addLine(new Line(new Point(672,317), new Point(662,337)));
            this.addLine(new Line(new Point(662,337), new Point(637,347)));
            this.addLine(new Line(new Point(637,347), new Point(575,351)));
            this.addLine(new Line(new Point(575,351), new Point(534,351)));
            this.addLine(new Line(new Point(534,351), new Point(490,357)));
            this.addLine(new Line(new Point(490,357), new Point(457,367)));
            this.addLine(new Line(new Point(457,367), new Point(429,392)));
            this.addLine(new Line(new Point(429,392), new Point(397,414)));
            this.addLine(new Line(new Point(397,414), new Point(378,430)));
            this.addLine(new Line(new Point(378,430), new Point(342,433)));
            this.addLine(new Line(new Point(342,433), new Point(309,426)));
            this.addLine(new Line(new Point(309,426), new Point(275,412)));
            this.addLine(new Line(new Point(275,412), new Point(234,400)));
            this.addLine(new Line(new Point(234,400), new Point(209,383)));
            this.addLine(new Line(new Point(209,383), new Point(180,353)));
            this.addLine(new Line(new Point(180,353), new Point(162,327)));
            this.addLine(new Line(new Point(162,327), new Point(153,296)));
            this.addLine(new Line(new Point(153,296), new Point(150,268)));


            this.checkpoints.add(new Line(new Point(479,18), new Point(460,111)));
            this.checkpoints.add(new Line(new Point(580,56), new Point(500,130)));
            this.checkpoints.add(new Line(new Point(626,128), new Point(536,183)));
            this.checkpoints.add(new Line(new Point(666,173), new Point(636,224)));
            this.checkpoints.add(new Line(new Point(670,270), new Point(759,223)));
            this.checkpoints.add(new Line(new Point(673,327), new Point(771,366)));
            this.checkpoints.add(new Line(new Point(620,352), new Point(643,427)));
            this.checkpoints.add(new Line(new Point(518,361), new Point(534,427)));
            this.checkpoints.add(new Line(new Point(416,410), new Point(465,464)));
            this.checkpoints.add(new Line(new Point(365,437), new Point(386,541)));
            this.checkpoints.add(new Line(new Point(302,429), new Point(234,511)));
            this.checkpoints.add(new Line(new Point(209,392), new Point(144,454)));
            //this.checkpoints.add(new Line(new Point(167,348), new Point(74,385)));
            this.checkpoints.add(new Line(new Point(145,278), new Point(58,291)));
            this.checkpoints.add(new Line(new Point(133,216), new Point(50,221)));
            this.checkpoints.add(new Line(new Point(129,149), new Point(45,141)));
            this.checkpoints.add(new Line(new Point(159,117), new Point(119,32)));
            this.checkpoints.add(new Line(new Point(234,108), new Point(232,32)));
            this.checkpoints.add(new Line(new Point(323,110), new Point(314,33)));
            this.checkpoints.add(new Line(new Point(395,104), new Point(388,25)));

        }
    }

    public void drawMap(Graphics g) {
        g.setColor(Color.BLACK);
        for (Line l : lines) {
            l.drawLine(g);
        }
    }

    public void addLine(Line l) {
        this.lines.add(l);
    }

    public ArrayList<Line> getLines() {
        return this.lines;
    }

    public ArrayList<Line> getCheckpoints() {
        return this.checkpoints;
    }

    public double getStartX() {
        return this.startX;
    }

    public double getStartY() {
        return this.startY;
    }

    public double getStartDegree() {
        return this.startDegree;
    }
}
