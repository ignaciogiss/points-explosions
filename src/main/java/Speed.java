import java.util.Random;

public class Speed {
  private int dirX, dirY;
  private float speed;

  public Speed(int x, int y) {
    dirX = x;
    dirY = y;
    Random r = new Random();
    speed = 1 + 2*r.nextFloat();
  }

  public void step() {
    if (speed > 0.02f) {
      speed -= 0.02f;
    }
  }

  public double getStepX() {
    return speed*dirX;// + getRandomSign();
  }

  public double getStepY() {
    return speed*dirY;// + getRandomSign();
  }

  private int getRandomSign() {
    Random r = new Random();
    return r.nextInt(4) -1;
  }
}
