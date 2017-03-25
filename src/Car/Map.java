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
            this.checkpoints.add(new Line(new Point(145,278), new Point(58,291)));
            this.checkpoints.add(new Line(new Point(133,216), new Point(50,221)));
            this.checkpoints.add(new Line(new Point(129,149), new Point(45,141)));
            this.checkpoints.add(new Line(new Point(159,117), new Point(119,32)));
            this.checkpoints.add(new Line(new Point(234,108), new Point(232,32)));
            this.checkpoints.add(new Line(new Point(323,110), new Point(314,33)));
            this.checkpoints.add(new Line(new Point(395,104), new Point(388,25)));

        } else if (testMapNr == 3) {

            this.startX = 130;
            this.startY = 300;
            this.startDegree = 255;

            this.addLine(new Line(new Point(26,158), new Point(24,113)));
            this.addLine(new Line(new Point(24,113), new Point(24,81)));
            this.addLine(new Line(new Point(24,81), new Point(34,57)));
            this.addLine(new Line(new Point(34,57), new Point(64,38)));
            this.addLine(new Line(new Point(64,38), new Point(94,34)));
            this.addLine(new Line(new Point(94,34), new Point(148,33)));
            this.addLine(new Line(new Point(148,33), new Point(189,32)));
            this.addLine(new Line(new Point(189,32), new Point(244,36)));
            this.addLine(new Line(new Point(244,36), new Point(272,36)));
            this.addLine(new Line(new Point(272,36), new Point(309,53)));
            this.addLine(new Line(new Point(309,53), new Point(329,73)));
            this.addLine(new Line(new Point(329,73), new Point(346,105)));
            this.addLine(new Line(new Point(346,105), new Point(350,139)));
            this.addLine(new Line(new Point(350,139), new Point(352,166)));
            this.addLine(new Line(new Point(352,166), new Point(368,181)));
            this.addLine(new Line(new Point(368,181), new Point(391,182)));
            this.addLine(new Line(new Point(391,182), new Point(413,181)));
            this.addLine(new Line(new Point(413,181), new Point(438,167)));
            this.addLine(new Line(new Point(438,167), new Point(455,138)));
            this.addLine(new Line(new Point(455,138), new Point(458,99)));
            this.addLine(new Line(new Point(458,99), new Point(465,72)));
            this.addLine(new Line(new Point(465,72), new Point(477,45)));
            this.addLine(new Line(new Point(477,45), new Point(502,29)));
            this.addLine(new Line(new Point(502,29), new Point(535,27)));
            this.addLine(new Line(new Point(535,27), new Point(557,27)));
            this.addLine(new Line(new Point(557,27), new Point(609,27)));
            this.addLine(new Line(new Point(609,27), new Point(633,24)));
            this.addLine(new Line(new Point(633,24), new Point(688,28)));
            this.addLine(new Line(new Point(688,28), new Point(736,42)));
            this.addLine(new Line(new Point(736,42), new Point(757,53)));
            this.addLine(new Line(new Point(757,53), new Point(776,76)));
            this.addLine(new Line(new Point(776,76), new Point(786,101)));
            this.addLine(new Line(new Point(786,101), new Point(790,134)));
            this.addLine(new Line(new Point(790,134), new Point(790,167)));
            this.addLine(new Line(new Point(790,167), new Point(790,197)));
            this.addLine(new Line(new Point(790,197), new Point(785,238)));
            this.addLine(new Line(new Point(785,238), new Point(777,261)));
            this.addLine(new Line(new Point(777,261), new Point(758,280)));
            this.addLine(new Line(new Point(758,280), new Point(706,295)));
            this.addLine(new Line(new Point(706,295), new Point(683,297)));
            this.addLine(new Line(new Point(683,297), new Point(661,304)));
            this.addLine(new Line(new Point(661,304), new Point(652,322)));
            this.addLine(new Line(new Point(652,322), new Point(648,339)));
            this.addLine(new Line(new Point(648,339), new Point(655,361)));
            this.addLine(new Line(new Point(655,361), new Point(661,372)));
            this.addLine(new Line(new Point(661,372), new Point(675,381)));
            this.addLine(new Line(new Point(675,381), new Point(696,388)));
            this.addLine(new Line(new Point(696,388), new Point(731,403)));
            this.addLine(new Line(new Point(731,403), new Point(750,423)));
            this.addLine(new Line(new Point(750,423), new Point(769,464)));
            this.addLine(new Line(new Point(769,464), new Point(780,499)));
            this.addLine(new Line(new Point(780,499), new Point(781,541)));
            this.addLine(new Line(new Point(781,541), new Point(772,570)));
            this.addLine(new Line(new Point(772,570), new Point(749,587)));
            this.addLine(new Line(new Point(749,587), new Point(720,593)));
            this.addLine(new Line(new Point(720,593), new Point(684,594)));
            this.addLine(new Line(new Point(684,594), new Point(649,593)));
            this.addLine(new Line(new Point(649,593), new Point(605,593)));
            this.addLine(new Line(new Point(605,593), new Point(568,589)));
            this.addLine(new Line(new Point(568,589), new Point(547,582)));
            this.addLine(new Line(new Point(547,582), new Point(513,564)));
            this.addLine(new Line(new Point(513,564), new Point(494,555)));
            this.addLine(new Line(new Point(494,555), new Point(472,549)));
            this.addLine(new Line(new Point(472,549), new Point(445,549)));
            this.addLine(new Line(new Point(445,549), new Point(398,547)));
            this.addLine(new Line(new Point(398,547), new Point(367,553)));
            this.addLine(new Line(new Point(367,553), new Point(320,560)));
            this.addLine(new Line(new Point(320,560), new Point(297,567)));
            this.addLine(new Line(new Point(297,567), new Point(253,571)));
            this.addLine(new Line(new Point(253,571), new Point(199,575)));
            this.addLine(new Line(new Point(199,575), new Point(158,577)));
            this.addLine(new Line(new Point(158,577), new Point(111,577)));
            this.addLine(new Line(new Point(111,577), new Point(74,552)));
            this.addLine(new Line(new Point(74,552), new Point(41,519)));
            this.addLine(new Line(new Point(41,519), new Point(22,455)));
            this.addLine(new Line(new Point(22,455), new Point(21,418)));
            this.addLine(new Line(new Point(21,418), new Point(27,386)));
            this.addLine(new Line(new Point(27,386), new Point(45,364)));
            this.addLine(new Line(new Point(45,364), new Point(66,346)));
            this.addLine(new Line(new Point(66,346), new Point(79,320)));
            this.addLine(new Line(new Point(79,320), new Point(75,301)));
            this.addLine(new Line(new Point(75,301), new Point(65,273)));
            this.addLine(new Line(new Point(65,273), new Point(49,238)));
            this.addLine(new Line(new Point(49,238), new Point(30,158)));
            this.addLine(new Line(new Point(30,158), new Point(24,152)));
            this.addLine(new Line(new Point(132,150), new Point(128,123)));
            this.addLine(new Line(new Point(128,123), new Point(138,117)));
            this.addLine(new Line(new Point(138,117), new Point(157,116)));
            this.addLine(new Line(new Point(157,116), new Point(184,122)));
            this.addLine(new Line(new Point(184,122), new Point(215,121)));
            this.addLine(new Line(new Point(215,121), new Point(234,119)));
            this.addLine(new Line(new Point(234,119), new Point(256,124)));
            this.addLine(new Line(new Point(256,124), new Point(281,183)));
            this.addLine(new Line(new Point(281,183), new Point(285,209)));
            this.addLine(new Line(new Point(285,209), new Point(301,233)));
            this.addLine(new Line(new Point(301,233), new Point(326,241)));
            this.addLine(new Line(new Point(326,241), new Point(365,251)));
            this.addLine(new Line(new Point(365,251), new Point(398,255)));
            this.addLine(new Line(new Point(398,255), new Point(446,254)));
            this.addLine(new Line(new Point(446,254), new Point(491,239)));
            this.addLine(new Line(new Point(491,239), new Point(514,213)));
            this.addLine(new Line(new Point(514,213), new Point(531,183)));
            this.addLine(new Line(new Point(531,183), new Point(536,153)));
            this.addLine(new Line(new Point(536,153), new Point(543,119)));
            this.addLine(new Line(new Point(543,119), new Point(554,109)));
            this.addLine(new Line(new Point(554,109), new Point(571,100)));
            this.addLine(new Line(new Point(571,100), new Point(599,100)));
            this.addLine(new Line(new Point(599,100), new Point(626,100)));
            this.addLine(new Line(new Point(626,100), new Point(656,100)));
            this.addLine(new Line(new Point(656,100), new Point(684,109)));
            this.addLine(new Line(new Point(684,109), new Point(704,120)));
            this.addLine(new Line(new Point(704,120), new Point(718,142)));
            this.addLine(new Line(new Point(718,142), new Point(724,164)));
            this.addLine(new Line(new Point(724,164), new Point(719,203)));
            this.addLine(new Line(new Point(719,203), new Point(706,227)));
            this.addLine(new Line(new Point(706,227), new Point(630,254)));
            this.addLine(new Line(new Point(630,254), new Point(585,265)));
            this.addLine(new Line(new Point(585,265), new Point(561,292)));
            this.addLine(new Line(new Point(561,292), new Point(555,325)));
            this.addLine(new Line(new Point(555,325), new Point(557,352)));
            this.addLine(new Line(new Point(557,352), new Point(567,391)));
            this.addLine(new Line(new Point(567,391), new Point(590,415)));
            this.addLine(new Line(new Point(590,415), new Point(615,425)));
            this.addLine(new Line(new Point(615,425), new Point(653,449)));
            this.addLine(new Line(new Point(653,449), new Point(679,464)));
            this.addLine(new Line(new Point(679,464), new Point(691,483)));
            this.addLine(new Line(new Point(691,483), new Point(697,504)));
            this.addLine(new Line(new Point(697,504), new Point(697,517)));
            this.addLine(new Line(new Point(697,517), new Point(689,522)));
            this.addLine(new Line(new Point(689,522), new Point(677,525)));
            this.addLine(new Line(new Point(677,525), new Point(663,523)));
            this.addLine(new Line(new Point(663,523), new Point(610,505)));
            this.addLine(new Line(new Point(610,505), new Point(574,488)));
            this.addLine(new Line(new Point(574,488), new Point(540,477)));
            this.addLine(new Line(new Point(540,477), new Point(498,475)));
            this.addLine(new Line(new Point(498,475), new Point(460,473)));
            this.addLine(new Line(new Point(460,473), new Point(425,469)));
            this.addLine(new Line(new Point(425,469), new Point(378,473)));
            this.addLine(new Line(new Point(378,473), new Point(343,481)));
            this.addLine(new Line(new Point(343,481), new Point(280,485)));
            this.addLine(new Line(new Point(280,485), new Point(244,486)));
            this.addLine(new Line(new Point(244,486), new Point(198,488)));
            this.addLine(new Line(new Point(198,488), new Point(172,482)));
            this.addLine(new Line(new Point(172,482), new Point(146,469)));
            this.addLine(new Line(new Point(146,469), new Point(132,447)));
            this.addLine(new Line(new Point(132,447), new Point(126,418)));
            this.addLine(new Line(new Point(126,418), new Point(135,394)));
            this.addLine(new Line(new Point(135,394), new Point(157,360)));
            this.addLine(new Line(new Point(157,360), new Point(181,334)));
            this.addLine(new Line(new Point(181,334), new Point(188,322)));
            this.addLine(new Line(new Point(188,322), new Point(189,289)));
            this.addLine(new Line(new Point(189,289), new Point(173,260)));
            this.addLine(new Line(new Point(173,260), new Point(153,228)));
            this.addLine(new Line(new Point(153,228), new Point(143,203)));
            this.addLine(new Line(new Point(143,203), new Point(133,160)));
            this.addLine(new Line(new Point(133,160), new Point(132,143)));

            this.checkpoints.add(new Line(new Point(48,176), new Point(113,161)));
            this.checkpoints.add(new Line(new Point(133,44), new Point(137,104)));
            this.checkpoints.add(new Line(new Point(251,49), new Point(244,104)));
            this.checkpoints.add(new Line(new Point(340,152), new Point(283,160)));
            this.checkpoints.add(new Line(new Point(388,187), new Point(382,238)));
            this.checkpoints.add(new Line(new Point(464,138), new Point(524,151)));
            this.checkpoints.add(new Line(new Point(572,34), new Point(572,88)));
            this.checkpoints.add(new Line(new Point(690,42), new Point(666,92)));
            this.checkpoints.add(new Line(new Point(731,164), new Point(779,162)));
            this.checkpoints.add(new Line(new Point(686,239), new Point(714,275)));
            this.checkpoints.add(new Line(new Point(640,335), new Point(576,340)));
            this.checkpoints.add(new Line(new Point(682,392), new Point(645,432)));
            this.checkpoints.add(new Line(new Point(699,495), new Point(763,468)));
            this.checkpoints.add(new Line(new Point(689,527), new Point(696,583)));
            this.checkpoints.add(new Line(new Point(584,500), new Point(548,562)));
            this.checkpoints.add(new Line(new Point(430,477), new Point(430,535)));
            this.checkpoints.add(new Line(new Point(272,489), new Point(277,555)));
            this.checkpoints.add(new Line(new Point(170,488), new Point(109,556)));
            this.checkpoints.add(new Line(new Point(125,434), new Point(30,434)));
            this.checkpoints.add(new Line(new Point(79,337), new Point(146,350)));
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
