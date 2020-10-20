import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

class Surface extends JPanel implements ActionListener {

  private final int DELAY = 80;
  private Timer timer;
  private int timeout = 50;
  private int originElement = 0;
  private List<Point> points;
  private List<Point> origins;
  private List<Color> colors = Arrays.asList(Color.blue, Color.red, Color.magenta, Color.cyan, Color.green, Color.yellow);

  public Surface() {
    points = new ArrayList<>();
    origins = Arrays.asList(new Point(400, 300), new Point(150, 150), new Point(300, 350), new Point(600, 150), new Point(150, 350), new Point(300, 150), new Point(600, 350));
    initSurface();
    initTimer();
  }

  public void initSurface() {
    points = new ArrayList<>();
    Random r = new Random();
    int xIni = origins.get(originElement).getX();
    int yIni = origins.get(originElement).getY();
    originElement = cycle(originElement);
    for (int i = 0; i < 350; i++) {
      Color color = colors.get(r.nextInt(colors.size()));
      Speed speed = new Speed(getRandomSign(r), getRandomSign(r));
      Point point = new Point(xIni + getRandomSign(r)*3, yIni + getRandomSign(r)*3, speed, color, r.nextInt(10));
      points.add(point);
    }
  }

  private int cycle(int index) {
    if (index + 1 >= origins.size()) {
      return 0;
    }
    return index + 1;
  }

  private int getRandomSign(Random r) {
    return  r.nextInt(5) -2;
  }

  private void initTimer() {

    timer = new Timer(DELAY, this);
    timer.start();
  }

  public Timer getTimer() {

    return timer;
  }

  private void doDrawing(Graphics g) {
    if (timeout < 1) {
      initSurface();
      timeout = 50;
    }
    else
      timeout--;


    Graphics2D g2d = (Graphics2D) g;

    int w = getWidth();
    int h = getHeight();

    for (Point point : points) {
      point.draw(g2d, w, h);
      // int x = Math.abs(r.nextInt()) % w;
      // int y = Math.abs(r.nextInt()) % h;
      // g2d.drawLine(x, y, x, y);
    }
  }

  @Override
  public void paintComponent(Graphics g) {

    super.paintComponent(g);
    setBackground(Color.black);
    doDrawing(g);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    repaint();
  }
}