package Car;

import DNA.Population;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by root on 3/21/17.
 */
public class GUI extends Applet implements Runnable, KeyListener, MouseListener{
    private static final long serialVersionUID = 1L;
    private static int FPS = 60;
    private static long lastUpdate = System.currentTimeMillis();
    private static long millisPerFrame = 1000 / FPS;
    private static long timeSinceLastUpdate;

    public static int windowWidth = 800;
    public static int windowHeight = 600;

    private Image image;
    private Graphics second;

    private boolean paint = false;          // hotkey 'P' - paint visuals or not
    private boolean playInRealtime = true;  // hotkey 'R' - display the learning in real time or dont care for visuals

    // test map
    //private Map map = new Map(2);

    // test car
    //private Car car = new Car(130, 400, 260).addCheckpoints(map.getCheckpoints());

    private Population population = new Population(20,0.02,2);

    @Override
    public void init() {

        setSize(windowWidth, windowHeight);
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
        addMouseListener(this);
        Frame frame = (Frame) this.getParent().getParent();
        frame.setTitle("Genetic Cars");

    }

    @Override
    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub
        super.stop();
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        super.destroy();
    }

    @Override
    public void run() {

        while (true) {


            this.population.doMoves();

            if (this.paint) {
                repaint();
            }

            if (this.playInRealtime) {
                timeSinceLastUpdate = System.currentTimeMillis() - lastUpdate;
                if (timeSinceLastUpdate < millisPerFrame) {
                    long timeToSlepp = millisPerFrame - timeSinceLastUpdate;
                    try {
                        Thread.sleep(timeToSlepp);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lastUpdate = System.currentTimeMillis();
            }
        }
    }

    @Override
    public void update(Graphics g) {

        if (image == null) {
            image = createImage(this.getWidth(), this.getHeight());
            second = image.getGraphics();
        }

        second.setColor(Color.WHITE);
        second.fillRect(0, 0, getWidth(), getHeight());
        second.setColor(getForeground());

        paint(second);

        g.drawImage(image, 0, 0, this);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);

        population.getMap().drawMap(g);

        GeneticCar fittestCar = population.getPopulation().get(0);
        for (GeneticCar geneticCar : population.getPopulation()) {
            if (geneticCar.getFitness() > fittestCar.getFitness()) {
                fittestCar = geneticCar;
            }
            geneticCar.drawCar(g);
        }

        // Draw FOV and checkpoints of fittest car
        fittestCar.drawVisualField(g);
        fittestCar.drawCheckpoints(g);


        g.setColor(Color.BLACK);
        g.drawString("Generation : " + population.getGeneration(), 10, 580);
        g.drawString("Population Size : " + population.getPopulation().size(), 10, 560);
        g.drawString("Best fitness : " + (int)fittestCar.getFitness(), 10, 540);
        g.drawString("Iteration : " + population.getIteration(), 10, 520);


		/*
		 * for (Line l : createLines) { l.drawLine(g); }
		 */

		/*
        map.drawMap(g);
        car.checkWallIntersection(map.getLines());
        car.checkCheckpointIntersection(map.getCheckpoints());
        car.drawCar(g);
        car.drawVisualField(g);
        car.drawCheckpoints(g);

        g.setColor(Color.BLACK);
        g.drawString("X: " + car.getX(), 10, 15);
        g.drawString("Y:" + car.getY(), 10, 35);
        g.drawString("degree:" + car.getDegree(), 10, 55);
        g.drawString("fitness: " + car.getFitness(), 10, 75);
        */

    }

    private boolean left, right;

    @Override
    public void keyPressed(KeyEvent arg0) {
        switch (arg0.getKeyCode()) {

            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;

            case KeyEvent.VK_P:
                this.paint = !this.paint;
                break;

            case KeyEvent.VK_R:
                this.playInRealtime = !playInRealtime;
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        switch (arg0.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                right = false;
                break;

            case KeyEvent.VK_LEFT:
                left = false;
                break;
        }

    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

	/*
	 * int lastX; int lastY; boolean initialized = false; ArrayList<Line>
	 * createLines = new ArrayList<Line>();
	 */

    @Override
    public void mouseClicked(MouseEvent arg0) {

		/*
		 * if (initialized == false) { initialized = true; lastX = arg0.getX();
		 * lastY = arg0.getY(); } else { int x = arg0.getX(); int y =
		 * arg0.getY();
		 *
		 * Line l = new Line(new Point(lastX, lastY), new Point(x,y));
		 * createLines.add(l);
		 *
		 * String o =
		 * "this.addLine(new Line(new Point("+lastX+","+lastY+"), new Point("+x+
		 * ","+y+")));"; System.out.println(o);
		 *
		 * lastX = x; lastY = y; initialized = false; }
		 */
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }
}
