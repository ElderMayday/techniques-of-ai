package Car;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by root on 3/21/17.
 */
public class Car {
    public static final double speed = 3.0;
    public static final double turningSpeed = 1.5;
    public static final int length = 30;
    public static final int visionRange = 200;

    public static int carLength = 20;
    public static int carWidth = 10;

    private double x;
    private double y;
    private double degree;
    private double currSpeed;

    // vars useful for the NN and GA
    private boolean crashed;
    private double distanceTraveled;

    private Point posCar;

    // List of the degrees of the visual field
    public static ArrayList<Integer> degrees = new ArrayList<Integer>(Arrays.asList(-90, -45, 0, 45, 90));
    // List of the lines of the visual field
    private ArrayList<Line> FOVLines;

    // vars needed for the checkpoints
    private int crossedCheckpoints;
    private ArrayList<Line> checkpoints;

    public Car(double x, double y, double degree) {
        this.x = x;
        this.y = y;
        this.degree = degree;
        this.currSpeed = 0;
        this.crashed = false;
        this.distanceTraveled = 0;
        this.FOVLines = new ArrayList<Line>();
    }

    // Optional constructor parameter for checkpoints
    public Car addCheckpoints(ArrayList<Line> checkpoints) {
        this.checkpoints = new ArrayList<Line>(checkpoints);
        this.crossedCheckpoints = 0;
        return this;
    }

    // update position of the car - dependence on degree and speed
    public void update(Map map) {
        if (this.crashed) {
            return;
        }
        double xPlus = Math.cos(Math.toRadians(this.degree)) * Car.speed;
        double yPlus = Math.sin(Math.toRadians(this.degree)) * Car.speed;

        this.x += xPlus;
        this.y += yPlus;

        this.distanceTraveled += Math.sqrt(Math.pow(xPlus, 2) + Math.pow(yPlus, 2));

        posCar = new Point((int) x, (int) y);

        // check if car is crashed - collided with the map
        for (Line wall : map.getLines()) {
            if (doesCarCollideWithLine(wall)) {
                this.crashed = true;
            }
        }

        this.FOVLines.clear();

        // Create visual field lines specified by the degrees list
        for (Integer currDegree : degrees) {
            Point tmpPoint = new Point((int) (x + Math.cos(Math.toRadians(this.degree + currDegree)) * Car.visionRange),
                    (int) (y + Math.sin(Math.toRadians(this.degree + currDegree)) * Car.visionRange));
            Line tmpLine = new Line(posCar, tmpPoint);
            this.FOVLines.add(tmpLine);
        }

    }

    public void goRight() {
        if (!this.crashed) {
            this.degree = (this.degree + turningSpeed) % 360;
        }
    }

    public void goLeft() {
        if (!this.crashed) {
            this.degree -= turningSpeed;
            if (this.degree < 0) {
                this.degree = 360;
            }
        }
    }

    public void accelerate() {
        this.currSpeed += 0.1;
        if (this.currSpeed >= Car.speed) {
            this.currSpeed = Car.speed;
        }
    }

    public void breaking() {
        this.currSpeed -= 0.2;
        if (this.currSpeed <= 0) {
            this.currSpeed = 0;
        }
    }

    // Calculating the 4 corners of a car
    private ArrayList<Point> getCarCorners() {
        ArrayList<Point> points = new ArrayList<Point>();

        int xLength = (int) (carLength * Math.cos(Math.toRadians(degree)));
        int yLength = (int) (carLength * Math.sin(Math.toRadians(degree)));

        int xWidth = (int) (carWidth * Math.cos(Math.toRadians(degree + 90)));
        int yWidth = (int) (carWidth * Math.sin(Math.toRadians(degree + 90)));

        points.add(new Point((int) (x + xLength + xWidth), (int) (y + yLength + yWidth)));
        points.add(new Point((int) (x + xLength - xWidth), (int) (y + yLength - yWidth)));
        points.add(new Point((int) (x - xLength - xWidth), (int) (y - yLength - yWidth)));
        points.add(new Point((int) (x - xLength + xWidth), (int) (y - yLength + yWidth)));

        return points;
    }

    // method to check if car lines collide with a given line
    private boolean doesCarCollideWithLine(Line l) {
        ArrayList<Point> points = this.getCarCorners();

        boolean intersects = false;

        intersects = intersects | Line.doesLineIntersect(l, new Line(points.get(0), points.get(1)));
        intersects = intersects | Line.doesLineIntersect(l, new Line(points.get(1), points.get(2)));
        intersects = intersects | Line.doesLineIntersect(l, new Line(points.get(2), points.get(3)));
        intersects = intersects | Line.doesLineIntersect(l, new Line(points.get(3), points.get(0)));

        return intersects;
    }

    // Check for visual line intersection with wall lines
    public void checkWallIntersection(ArrayList<Line> wall, Graphics g) {
        for (int i = 0; i < this.FOVLines.size(); i++) {
            Line visualLine = this.FOVLines.get(i);

            for (Line wallLine : wall) {
                if (Line.doesLineIntersect(visualLine, wallLine)) {
                    Point intersec = Line.pointOfIntersection(wallLine, visualLine);
                    visualLine.setP2(intersec);
                    this.FOVLines.set(i, visualLine);
                }
            }
        }
    }

    // Checking if car crossed a checkpoint
    public void checkCheckpointIntersection(ArrayList<Line> allCheckpoints) {
        // Store intersected checkpoints in a list to not cause exceptions
        ArrayList<Line> crossedThisCheckpoint = new ArrayList<Line>();
        for (Line l : this.checkpoints) {
            if (this.doesCarCollideWithLine(l)) {
                crossedThisCheckpoint.add(l);
            }
        }

        // Delete all crossed checkpoints from the checkpoint list
        for (Line l : crossedThisCheckpoint) {
            this.checkpoints.remove(l);
            this.crossedCheckpoints++;
        }

        // No more checkpoints available -> reset
        if (this.checkpoints.size() == 0) {
            this.checkpoints = new ArrayList<Line>(allCheckpoints);
        }
    }

    // distance to wall data for NN input
    public ArrayList<Integer> getFOVdata() {
        ArrayList<Integer> distances = new ArrayList<Integer>();

        for (Line line : this.FOVLines) {
            distances.add((int) line.lineLength());
        }

        return distances;
    }

    public void drawCar(Graphics g) {
        ArrayList<Point> points = this.getCarCorners();

        // outline of car
        g.setColor(Color.BLACK);
        g.drawLine((int) (points.get(0).X()), (int) points.get(0).Y(), (int) points.get(1).X(),
                (int) points.get(1).Y());
        g.drawLine((int) (points.get(1).X()), (int) points.get(1).Y(), (int) points.get(2).X(),
                (int) points.get(2).Y());
        g.drawLine((int) (points.get(2).X()), (int) points.get(2).Y(), (int) points.get(3).X(),
                (int) points.get(3).Y());
        g.drawLine((int) (points.get(3).X()), (int) points.get(3).Y(), (int) points.get(0).X(),
                (int) points.get(0).Y());

    }

    // Draws visual line and oval to signal intersection
    public void drawVisualField(Graphics g) {
        g.setColor(Color.BLACK);
        for (Line l : this.FOVLines) {
            l.drawLine(g);
            if (l.lineLength() < Car.visionRange - 2) {
                g.drawOval((int) l.getP2().X() - 5, (int) l.getP2().Y() - 5, 10, 10);
            }
        }
    }

    public void drawCheckpoints(Graphics g) {
        g.setColor(Color.BLUE);
        for (Line l : this.checkpoints) {
            l.drawLine(g);
        }
    }

    // Fitness function for genetic algorithm
    public double getFitness() {
        return this.crossedCheckpoints * 100 + (this.distanceTraveled / 10);
    }

    public Point getPoint() {
        return new Point((int) this.x, (int) this.y);
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getDegree() {
        return degree;
    }

    public double getDistanceTraveled() {
        return this.distanceTraveled;
    }
}
