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
            this.startY = 100;
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

            int xmiddleL = 300;
            int xmiddleR = 500;

            this.addLine(new Line(new Point(x1, y1), new Point(x2, y2)));
            this.addLine(new Line(new Point(x2, y2), new Point(x3, y3)));
            this.addLine(new Line(new Point(x4, y4), new Point(x1, y1)));

            this.addLine(new Line(new Point(xmiddleL, 250), new Point(xmiddleR, 250)));
            this.addLine(new Line(new Point(xmiddleL, 250), new Point(xmiddleL, 550)));
            this.addLine(new Line(new Point(xmiddleR, 250), new Point(xmiddleR, 550)));

            this.addLine(new Line(new Point(50, 550), new Point(xmiddleL, 550)));
            this.addLine(new Line(new Point(xmiddleR, 550), new Point(750, 550)));

            this.addLine(new Line(new Point(x5, y5), new Point(x6, y6)));
            this.addLine(new Line(new Point(x6, y6), new Point(x7, y7)));
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

        } else if (testMapNr == 4) {

            this.startX = 460;
            this.startY = 375;
            this.startDegree = 180;

            this.addLine(new Line(new Point(145,7), new Point(132,7)));
            this.addLine(new Line(new Point(132,7), new Point(112,7)));
            this.addLine(new Line(new Point(112,7), new Point(82,8)));
            this.addLine(new Line(new Point(82,8), new Point(59,13)));
            this.addLine(new Line(new Point(59,13), new Point(41,21)));
            this.addLine(new Line(new Point(41,21), new Point(33,33)));
            this.addLine(new Line(new Point(33,33), new Point(19,54)));
            this.addLine(new Line(new Point(19,54), new Point(11,71)));
            this.addLine(new Line(new Point(11,71), new Point(9,97)));
            this.addLine(new Line(new Point(9,97), new Point(7,126)));
            this.addLine(new Line(new Point(7,126), new Point(8,143)));
            this.addLine(new Line(new Point(8,143), new Point(9,162)));
            this.addLine(new Line(new Point(9,162), new Point(11,178)));
            this.addLine(new Line(new Point(11,178), new Point(16,199)));
            this.addLine(new Line(new Point(16,199), new Point(17,212)));
            this.addLine(new Line(new Point(17,212), new Point(18,239)));
            this.addLine(new Line(new Point(18,239), new Point(16,267)));
            this.addLine(new Line(new Point(16,267), new Point(12,289)));
            this.addLine(new Line(new Point(12,289), new Point(9,304)));
            this.addLine(new Line(new Point(9,304), new Point(10,322)));
            this.addLine(new Line(new Point(10,322), new Point(9,354)));
            this.addLine(new Line(new Point(9,354), new Point(11,378)));
            this.addLine(new Line(new Point(11,378), new Point(14,404)));
            this.addLine(new Line(new Point(14,404), new Point(14,427)));
            this.addLine(new Line(new Point(14,427), new Point(14,447)));
            this.addLine(new Line(new Point(14,447), new Point(11,476)));
            this.addLine(new Line(new Point(11,476), new Point(12,494)));
            this.addLine(new Line(new Point(12,494), new Point(15,518)));
            this.addLine(new Line(new Point(15,518), new Point(26,534)));
            this.addLine(new Line(new Point(26,534), new Point(34,541)));
            this.addLine(new Line(new Point(34,541), new Point(49,554)));
            this.addLine(new Line(new Point(49,554), new Point(61,564)));
            this.addLine(new Line(new Point(61,564), new Point(75,574)));
            this.addLine(new Line(new Point(75,574), new Point(97,581)));
            this.addLine(new Line(new Point(97,581), new Point(121,584)));
            this.addLine(new Line(new Point(121,584), new Point(141,583)));
            this.addLine(new Line(new Point(141,583), new Point(179,585)));
            this.addLine(new Line(new Point(179,585), new Point(211,585)));
            this.addLine(new Line(new Point(211,585), new Point(237,586)));
            this.addLine(new Line(new Point(237,586), new Point(269,581)));
            this.addLine(new Line(new Point(269,581), new Point(306,574)));
            this.addLine(new Line(new Point(306,574), new Point(328,573)));
            this.addLine(new Line(new Point(328,573), new Point(361,573)));
            this.addLine(new Line(new Point(361,573), new Point(398,577)));
            this.addLine(new Line(new Point(398,577), new Point(444,579)));
            this.addLine(new Line(new Point(444,579), new Point(486,577)));
            this.addLine(new Line(new Point(486,577), new Point(523,576)));
            this.addLine(new Line(new Point(523,576), new Point(564,576)));
            this.addLine(new Line(new Point(564,576), new Point(600,579)));
            this.addLine(new Line(new Point(600,579), new Point(651,582)));
            this.addLine(new Line(new Point(651,582), new Point(684,579)));
            this.addLine(new Line(new Point(684,579), new Point(726,573)));
            this.addLine(new Line(new Point(726,573), new Point(744,562)));
            this.addLine(new Line(new Point(744,562), new Point(757,541)));
            this.addLine(new Line(new Point(757,541), new Point(768,523)));
            this.addLine(new Line(new Point(768,523), new Point(773,496)));
            this.addLine(new Line(new Point(773,496), new Point(777,467)));
            this.addLine(new Line(new Point(777,467), new Point(776,434)));
            this.addLine(new Line(new Point(776,434), new Point(773,401)));
            this.addLine(new Line(new Point(773,401), new Point(769,381)));
            this.addLine(new Line(new Point(769,381), new Point(756,361)));
            this.addLine(new Line(new Point(756,361), new Point(723,341)));
            this.addLine(new Line(new Point(723,341), new Point(690,329)));
            this.addLine(new Line(new Point(690,329), new Point(651,321)));
            this.addLine(new Line(new Point(651,321), new Point(614,318)));
            this.addLine(new Line(new Point(614,318), new Point(572,318)));
            this.addLine(new Line(new Point(572,318), new Point(535,318)));
            this.addLine(new Line(new Point(535,318), new Point(504,319)));
            this.addLine(new Line(new Point(504,319), new Point(472,321)));
            this.addLine(new Line(new Point(472,321), new Point(440,321)));
            this.addLine(new Line(new Point(440,321), new Point(393,322)));
            this.addLine(new Line(new Point(393,322), new Point(365,329)));
            this.addLine(new Line(new Point(365,329), new Point(328,337)));
            this.addLine(new Line(new Point(328,337), new Point(310,336)));
            this.addLine(new Line(new Point(310,336), new Point(295,323)));
            this.addLine(new Line(new Point(295,323), new Point(285,303)));
            this.addLine(new Line(new Point(285,303), new Point(285,281)));
            this.addLine(new Line(new Point(285,281), new Point(293,265)));
            this.addLine(new Line(new Point(293,265), new Point(310,248)));
            this.addLine(new Line(new Point(310,248), new Point(332,241)));
            this.addLine(new Line(new Point(332,241), new Point(371,236)));
            this.addLine(new Line(new Point(371,236), new Point(408,235)));
            this.addLine(new Line(new Point(408,235), new Point(437,236)));
            this.addLine(new Line(new Point(437,236), new Point(463,236)));
            this.addLine(new Line(new Point(463,236), new Point(498,242)));
            this.addLine(new Line(new Point(498,242), new Point(533,247)));
            this.addLine(new Line(new Point(533,247), new Point(570,250)));
            this.addLine(new Line(new Point(570,250), new Point(604,249)));
            this.addLine(new Line(new Point(604,249), new Point(680,229)));
            this.addLine(new Line(new Point(680,229), new Point(727,213)));
            this.addLine(new Line(new Point(727,213), new Point(750,197)));
            this.addLine(new Line(new Point(750,197), new Point(762,180)));
            this.addLine(new Line(new Point(762,180), new Point(777,149)));
            this.addLine(new Line(new Point(777,149), new Point(785,120)));
            this.addLine(new Line(new Point(785,120), new Point(785,96)));
            this.addLine(new Line(new Point(785,96), new Point(777,68)));
            this.addLine(new Line(new Point(777,68), new Point(770,57)));
            this.addLine(new Line(new Point(770,57), new Point(750,36)));
            this.addLine(new Line(new Point(750,36), new Point(720,18)));
            this.addLine(new Line(new Point(720,18), new Point(682,9)));
            this.addLine(new Line(new Point(682,9), new Point(646,5)));
            this.addLine(new Line(new Point(646,5), new Point(611,6)));
            this.addLine(new Line(new Point(611,6), new Point(576,6)));
            this.addLine(new Line(new Point(576,6), new Point(550,6)));
            this.addLine(new Line(new Point(550,6), new Point(504,6)));
            this.addLine(new Line(new Point(504,6), new Point(453,6)));
            this.addLine(new Line(new Point(453,6), new Point(425,12)));
            this.addLine(new Line(new Point(425,12), new Point(382,19)));
            this.addLine(new Line(new Point(382,19), new Point(341,15)));
            this.addLine(new Line(new Point(341,15), new Point(299,10)));
            this.addLine(new Line(new Point(299,10), new Point(244,4)));
            this.addLine(new Line(new Point(244,4), new Point(197,5)));
            this.addLine(new Line(new Point(197,5), new Point(168,5)));
            this.addLine(new Line(new Point(168,5), new Point(144,7)));
            //this.addLine(new Line(new Point(144,7), new Point(149,166)));
            this.addLine(new Line(new Point(149,166), new Point(134,251)));
            this.addLine(new Line(new Point(134,251), new Point(130,279)));
            this.addLine(new Line(new Point(130,279), new Point(124,314)));
            this.addLine(new Line(new Point(124,314), new Point(123,341)));
            this.addLine(new Line(new Point(123,341), new Point(126,362)));
            this.addLine(new Line(new Point(126,362), new Point(125,388)));
            this.addLine(new Line(new Point(125,388), new Point(121,412)));
            this.addLine(new Line(new Point(121,412), new Point(121,436)));
            this.addLine(new Line(new Point(121,436), new Point(127,451)));
            this.addLine(new Line(new Point(127,451), new Point(139,465)));
            this.addLine(new Line(new Point(139,465), new Point(154,480)));
            this.addLine(new Line(new Point(154,480), new Point(210,484)));
            this.addLine(new Line(new Point(210,484), new Point(257,478)));
            this.addLine(new Line(new Point(257,478), new Point(298,475)));
            this.addLine(new Line(new Point(298,475), new Point(337,472)));
            this.addLine(new Line(new Point(337,472), new Point(376,474)));
            this.addLine(new Line(new Point(376,474), new Point(439,475)));
            this.addLine(new Line(new Point(439,475), new Point(471,477)));
            this.addLine(new Line(new Point(471,477), new Point(490,480)));
            this.addLine(new Line(new Point(490,480), new Point(523,484)));
            this.addLine(new Line(new Point(523,484), new Point(565,485)));
            this.addLine(new Line(new Point(565,485), new Point(606,484)));
            this.addLine(new Line(new Point(606,484), new Point(636,479)));
            this.addLine(new Line(new Point(636,479), new Point(658,473)));
            this.addLine(new Line(new Point(658,473), new Point(677,462)));
            this.addLine(new Line(new Point(677,462), new Point(680,453)));
            this.addLine(new Line(new Point(680,453), new Point(682,445)));
            this.addLine(new Line(new Point(682,445), new Point(680,432)));
            this.addLine(new Line(new Point(680,432), new Point(675,420)));
            this.addLine(new Line(new Point(675,420), new Point(660,414)));
            this.addLine(new Line(new Point(660,414), new Point(633,413)));
            this.addLine(new Line(new Point(633,413), new Point(589,408)));
            this.addLine(new Line(new Point(589,408), new Point(550,410)));
            this.addLine(new Line(new Point(550,410), new Point(512,412)));
            this.addLine(new Line(new Point(512,412), new Point(449,418)));
            this.addLine(new Line(new Point(449,418), new Point(405,426)));
            this.addLine(new Line(new Point(405,426), new Point(350,437)));
            this.addLine(new Line(new Point(350,437), new Point(294,445)));
            this.addLine(new Line(new Point(294,445), new Point(253,437)));
            this.addLine(new Line(new Point(253,437), new Point(217,426)));
            this.addLine(new Line(new Point(217,426), new Point(191,398)));
            this.addLine(new Line(new Point(191,398), new Point(180,363)));
            this.addLine(new Line(new Point(180,363), new Point(167,305)));
            this.addLine(new Line(new Point(167,305), new Point(166,254)));
            this.addLine(new Line(new Point(166,254), new Point(187,219)));
            this.addLine(new Line(new Point(187,219), new Point(216,189)));
            this.addLine(new Line(new Point(216,189), new Point(255,170)));
            this.addLine(new Line(new Point(255,170), new Point(286,165)));
            this.addLine(new Line(new Point(286,165), new Point(327,170)));
            this.addLine(new Line(new Point(327,170), new Point(412,162)));
            this.addLine(new Line(new Point(412,162), new Point(485,163)));
            this.addLine(new Line(new Point(485,163), new Point(525,168)));
            this.addLine(new Line(new Point(525,168), new Point(562,173)));
            this.addLine(new Line(new Point(562,173), new Point(598,172)));
            this.addLine(new Line(new Point(598,172), new Point(642,166)));
            this.addLine(new Line(new Point(642,166), new Point(665,151)));
            this.addLine(new Line(new Point(665,151), new Point(681,135)));
            this.addLine(new Line(new Point(681,135), new Point(681,118)));
            this.addLine(new Line(new Point(681,118), new Point(673,105)));
            this.addLine(new Line(new Point(673,105), new Point(653,99)));
            this.addLine(new Line(new Point(653,99), new Point(625,97)));
            this.addLine(new Line(new Point(625,97), new Point(587,96)));
            this.addLine(new Line(new Point(587,96), new Point(542,96)));
            this.addLine(new Line(new Point(542,96), new Point(484,98)));
            this.addLine(new Line(new Point(484,98), new Point(432,100)));
            this.addLine(new Line(new Point(432,100), new Point(367,98)));
            this.addLine(new Line(new Point(367,98), new Point(313,98)));
            this.addLine(new Line(new Point(313,98), new Point(262,106)));
            this.addLine(new Line(new Point(262,106), new Point(218,119)));
            this.addLine(new Line(new Point(218,119), new Point(169,137)));
            this.addLine(new Line(new Point(169,137), new Point(149,175)));
            this.addLine(new Line(new Point(149,175), new Point(146,188)));

            this.checkpoints.add(new Line(new Point(29,139), new Point(118,143)));
            this.checkpoints.add(new Line(new Point(104,278), new Point(34,269)));
            this.checkpoints.add(new Line(new Point(102,418), new Point(24,431)));
            this.checkpoints.add(new Line(new Point(170,492), new Point(165,559)));
            this.checkpoints.add(new Line(new Point(333,488), new Point(326,550)));
            this.checkpoints.add(new Line(new Point(498,497), new Point(498,553)));
            this.checkpoints.add(new Line(new Point(635,494), new Point(637,563)));
            this.checkpoints.add(new Line(new Point(692,444), new Point(757,445)));
            this.checkpoints.add(new Line(new Point(633,337), new Point(622,391)));
            this.checkpoints.add(new Line(new Point(381,342), new Point(381,406)));
            this.checkpoints.add(new Line(new Point(184,299), new Point(267,299)));
            this.checkpoints.add(new Line(new Point(333,183), new Point(334,220)));
            this.checkpoints.add(new Line(new Point(559,184), new Point(560,230)));
            this.checkpoints.add(new Line(new Point(688,140), new Point(747,164)));
            this.checkpoints.add(new Line(new Point(573,24), new Point(571,78)));
            this.checkpoints.add(new Line(new Point(379,33), new Point(372,80)));
            this.checkpoints.add(new Line(new Point(153,21), new Point(186,101)));
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
