import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class PointsEx extends JFrame {

  public PointsEx() {

    initUI();
  }

  private void initUI() {

    final Surface surface = new Surface();

    add(surface);
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        Timer timer = surface.getTimer();
        timer.stop();
      }
    });

    setTitle("Points explosions");
    setSize(800, 600);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main(String[] args) {

    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        PointsEx ex = new PointsEx();
        ex.setVisible(true);
      }
    });
  }
}