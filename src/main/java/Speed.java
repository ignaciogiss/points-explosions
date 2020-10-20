import java.util.Random;

public class Speed {
  private int dirX, dirY;
  private float speed;
  private float dspeed = 0f;

  public Speed(int x, int y) {
    dirX = x;
    dirY = y;
    Random r = new Random();
    speed = 1 + 2*r.nextFloat();
  }

  public void step() {
    dspeed += 0.2f;
    if (speed > 0.02f) {
      speed -= 0.02f;
    }
  }

  public double getStepX() {
    return speed*dirX;
  }

  public double getStepY() {
    if (dirY == 0) {
      return dspeed;
    }
    return (speed + dspeed*sign(dirY))*dirY;
  }

  private float sign(float v) {
    return v > 0f ? 1f : -1f;
  }

  private int getRandomSign() {
    Random r = new Random();
    return r.nextInt(4) -1;
  }
}
