package Car;


import java.awt.Graphics;
import java.awt.geom.Line2D;

/**
 * Created by root on 3/21/17.
 */
public class Line {
    private Point p1;
    private Point p2;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public static boolean doesLineIntersect(Line l1, Line l2) {
        Line2D line1 = new Line2D.Double(l1.getP1().X(), l1.getP1().Y(), l1.getP2().X(), l1.getP2().Y());
        Line2D line2 = new Line2D.Double(l2.getP1().X(), l2.getP1().Y(), l2.getP2().X(), l2.getP2().Y());
        return line2.intersectsLine(line1);
    }

    public void drawLine(Graphics g){
        g.drawLine((int)p1.X(), (int)p1.Y(), (int)p2.X(), (int)p2.Y());
    }

    // calculate point of intersection
    public static Point pointOfIntersection(Line l1, Line l2) {

        double x1 = l1.getP1().X();
        double y1 = l1.getP1().Y();
        double x2 = l1.getP2().X();
        double y2 = l1.getP2().Y();
        double x3 = l2.getP1().X();
        double y3 = l2.getP1().Y();
        double x4 = l2.getP2().X();
        double y4 = l2.getP2().Y();

        // Math magic
        double d = (x1-x2)*(y3-y4) - (y1-y2)*(x3-x4);

        double xi = ((x3-x4)*(x1*y2-y1*x2)-(x1-x2)*(x3*y4-y3*x4))/d;
        double yi = ((y3-y4)*(x1*y2-y1*x2)-(y1-y2)*(x3*y4-y3*x4))/d;

        return new Point((int)xi, (int)yi);
    }

    // absolute length of the line
    public double lineLength() {
        return Math.sqrt((Math.pow(p1.X() - p2.X(),2) + Math.pow(p1.Y() - p2.Y(),2)));
    }

    // getters, setter
    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }
}
