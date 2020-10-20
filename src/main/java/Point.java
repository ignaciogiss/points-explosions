import java.awt.*;

public class Point {
  private Speed speed;
  private int x, y;
  private Color color;
  private float alpha = 40;
  private int timer;

  Point(int theX, int theY, Speed theSpeed, Color theColor, int theTimer) {
    speed = theSpeed;
    x = theX;
    y = theY;
    color = theColor;
    timer = theTimer;
  }

  Point(int theX, int theY) {
    speed = null;
    x = theX;
    y = theY;
    color = null;
    timer = 0;
  }

  public void draw(Graphics2D g2d, int w, int h) {
    if (!ready()) {
      return;
    }
    g2d.setColor(color);
    AlphaComposite alcom = AlphaComposite.getInstance(
      AlphaComposite.SRC_OVER, alpha* 0.025f);
    g2d.setComposite(alcom);
    x = Math.abs(x) % w;
    y = Math.abs(y) % h;
    g2d.drawLine(x, y, x, y);
    speed.step();
    if (alpha > 0) alpha--;
    x += (int)speed.getStepX();
    y += (int)speed.getStepY();
  }

  private boolean ready() {
    if (timer > 0) {
      timer--;
      return false;
    }
    return true;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}
