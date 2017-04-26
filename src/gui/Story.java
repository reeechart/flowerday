package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import player.Player;
import stage.StageController;

/**
 * Kelas untuk mengurus tampilan di layar saat menampilkan cerita.
 * Cerita diambil dari file eksternal, karena itu kelas ini juga mengurus
 * pembacaan cerita dari file eksternal.
 *
 * @author Irene Edria
 * @version 4/22/17
 */
class Story extends JPanel {

  /**
   * StageController yang akan dihidupkan setelah story selesai ditampilkan.
   */
  private StageController sc;

  /**
   * Konstruktor.
   *
   * @param dep Wadah untuk meletakkan item-item GUI pada layar
   * @param currentLevel level yang saat ini dimainkan
   * @param p <code>Player</code> yang sedang bermain
   */
  Story(JDesktopPane dep, int currentLevel, Player p) {
    final boolean f = false;
    String story = new String();
    int counter = 0;
    // Exception untuk pembacaan file eksternal
    try (BufferedReader br =
        new BufferedReader(new FileReader("asset/story.txt"))) {
      String strCurrentLine;
      // Deklarasi elemen yang ingin didekomposisi dari suatu line
      String findName = "<name>";
      String findNewline = "\\\\n";
      String replaceName = p.getName();
      String replaceNewline = "<br>";
      Pattern namePattern = Pattern.compile(findName);
      Pattern newlinePattern = Pattern.compile(findNewline);
      // Pembacaan file eksternal
      while ((strCurrentLine = br.readLine()) != null) {
        if (counter == currentLevel) {
          Matcher nameMatcher = namePattern.matcher(strCurrentLine);
          String nameReplaced = nameMatcher.replaceAll(replaceName);
          Matcher newlineMatcher = newlinePattern.matcher(nameReplaced);
          story = newlineMatcher.replaceAll(replaceNewline);
        }

        counter++;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    // Background
    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    int width = gd.getDisplayMode().getWidth();
    int height = gd.getDisplayMode().getHeight();
    ImageIcon image = new ImageIcon("asset/story2.png");
    JLabel labelimage = new JLabel(image);
    labelimage.setBounds(0, 0, 1440, 900);
    // Cerita yang ingin ditampilkan
    JLabel labelstory = new JLabel();
    labelstory.setText("<html>" + labelstory.getText() + "<br>" + story);
    labelstory.setFont(new Font("Grinched 2.0", Font.BOLD, 24));
    labelstory.setBounds(10, 250, 600, 500);
    labelstory.setBackground(new Color(255, 255, 255, 100));
    labelstory.setOpaque(true);
    dep.add(labelstory, new Integer(60));
    dep.add(labelimage, new Integer(50));
    // Button untuk melanjutkan ke aksi setelahnya
    ImageIcon sunflower = new ImageIcon("asset/truck.png");
    JButton truck = new JButton(sunflower);
    truck.setOpaque(false);
    truck.setContentAreaFilled(false);
    truck.setBorderPainted(false);
    truck.setBounds(1000, 410, 350, 350);
    dep.add(truck, new Integer(350));
    truck.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            dep.remove(truck);
            dep.remove(labelimage);
            dep.remove(labelstory);
            if (currentLevel == 1) {
              sc = new StageController(dep, 1, p.getTruckLevel(), p);
            } else if (currentLevel == 2) {
              sc = new StageController(dep, 2, p.getTruckLevel(), p);
            } else if (currentLevel == 3) {
              sc = new StageController(dep, 3, p.getTruckLevel(), p);
            } else if (currentLevel == 4) {
              sc = new StageController(dep, 4, p.getTruckLevel(), p);
            } else if (currentLevel == 5) {
              sc = new StageController(dep, 5, p.getTruckLevel(), p);
            } else if (currentLevel == 6) {
              sc = new StageController(dep, 6, p.getTruckLevel(), p);
            } else if (currentLevel == 7) {
              sc = new StageController(dep, 7, p.getTruckLevel(), p);
            } else if (currentLevel == 8) {
              sc = new StageController(dep, 8, p.getTruckLevel(), p);
            } else if (currentLevel == 9) {
              sc = new StageController(dep, 9, p.getTruckLevel(), p);
            } else {
              new Level(dep, p);
            }
          }
        }
    );
  }
}