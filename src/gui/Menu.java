package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import player.Player;

/**
 * Kelas untuk mengurus tampilan di layar untuk menu utama.
 * Di kelas ini akan ditampilkan button start yang jika diklik akan menanyakan
 * nama kemudian memulai permainan.
 *
 * @author Irene Edria
 * @version 4/19/17
 */
public class Menu extends JPanel {

  /**
   * Data resolusi tampilan layar terhadap device yang spesifik.
   * Digunakan untuk menyesuaikan tampilan.
   */
  private static GraphicsDevice device =
      GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];

  /**
   * Konstruktor.
   */
  public Menu() {
    JDesktopPane dp = new JDesktopPane();
    // Tampilan logo WonderProject
    GraphicsDevice gd =
        GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    int width = gd.getDisplayMode().getWidth();
    int height = gd.getDisplayMode().getHeight();
    ImageIcon imagel = new ImageIcon("asset/logo.png");
    JLabel logoimage = new JLabel(imagel);
    logoimage.setBounds(0, 0, width, height);
    dp.add(logoimage, new Integer(700));
    int delay = 5000;
    ActionListener task = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        logoimage.setVisible(false);
      }
    };
    new Timer(delay, task).start();
    // Background
    ImageIcon image = new ImageIcon("asset/main3.png");
    JLabel labelimage = new JLabel(image);
    labelimage.setBounds(0, 0, 1440, 900);
    dp.add(labelimage, new Integer(50));
    // Button start
    ImageIcon start = new ImageIcon("asset/water.png");
    JButton buttonstart = new JButton(start);
    buttonstart.setOpaque(false);
    buttonstart.setContentAreaFilled(false);
    buttonstart.setBorderPainted(false);
    buttonstart.setBounds(640, 550, 200, 200);
    dp.add(buttonstart, new Integer(350));
    // Button exit
    ImageIcon exit = new ImageIcon("asset/sun.png");
    JButton buttonclose = new JButton(exit);
    buttonclose.setOpaque(false);
    buttonclose.setContentAreaFilled(false);
    buttonclose.setBorderPainted(false);
    buttonclose.setBounds(10, 10, 150, 150);
    dp.add(buttonclose, new Integer(500));
    // Action Listener untuk button-button yang ada
    buttonclose.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            confirm();
          }
        }
    );
    buttonstart.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            JLabel namePlayer = new JLabel("  Your name?");
            namePlayer.setFont(new Font("Grinched 2.0", Font.BOLD, 24));
            namePlayer.setBounds(540, 300, 400, 200);
            namePlayer.setBackground(new Color(255, 255, 255, 100));
            namePlayer.setOpaque(true);
            dp.add(namePlayer, new Integer(300));
            JTextField name = new JTextField("");
            name.setBounds(670, 380, 200, 30);
            JButton buttonok = new JButton("ok");
            buttonok.setBounds(750, 430, 50, 50);
            dp.add(name, new Integer(350));
            dp.add(buttonok, new Integer(350));
            buttonok.addActionListener(
                new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                    Player p = new Player(name.getText());
                    new Story(dp, 0, p);
                    dp.remove(name);
                    dp.remove(buttonok);
                    dp.remove(buttonstart);
                    dp.remove(labelimage);
                    dp.remove(namePlayer);
                  }
                }
            );
          }
        }
    );
    JFrame fr = new JFrame();
    fr.setLayeredPane(dp);
    fr.setExtendedState(JFrame.MAXIMIZED_BOTH);
    fr.setVisible(true);
    fr.setUndecorated(true);
    fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }

  /**
   * Dialog box untuk konfirmasi exit.
   */
  private static void confirm() {
    ImageIcon quit = new ImageIcon("asset/quit.png");
    JFrame frame = new JFrame();
    int dialogButton = JOptionPane.YES_NO_OPTION;
    int confirmquest = JOptionPane.showConfirmDialog(null,
        "Are you sure want to quit ?", "FlowerDay", dialogButton,
        JOptionPane.QUESTION_MESSAGE, quit);
    if (confirmquest == JOptionPane.YES_OPTION) {
      System.exit(0);
    }
  }
}