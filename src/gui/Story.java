package gui;

import player.Player;
import stage.StageController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

/**
 * Created by ireneedriadr on 4/22/17.
 */
public class Story extends JPanel {

  Story(JDesktopPane dep, int x, Player p) {
    final boolean f = false;
    String story = new String();
    int counter = 0;

    try (BufferedReader br = new BufferedReader(new FileReader("asset/story.txt"))) {
      String sCurrentLine;

      String findName = "<name>";
      String findNewline = "\\\\n";
      String replaceName = p.getName();
      String replaceNewline = "<br>";

      Pattern namePattern = Pattern.compile(findName);
      Pattern newlinePattern = Pattern.compile(findNewline);

      while((sCurrentLine = br.readLine()) != null) {
        if(counter == x) {
          Matcher nameMatcher = namePattern.matcher(sCurrentLine);
          String nameReplaced = nameMatcher.replaceAll(replaceName);
          Matcher newlineMatcher = newlinePattern.matcher(nameReplaced);
          story = newlineMatcher.replaceAll(replaceNewline);
        }

        counter++;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    int width = gd.getDisplayMode().getWidth();
    int height = gd.getDisplayMode().getHeight();
    ImageIcon image = new ImageIcon("asset/story2.png");
    JLabel labelimage = new JLabel(image);
    labelimage.setBounds(0,0,1440,900);

    JLabel labelstory = new JLabel();
    labelstory.setText("<html>"+labelstory.getText()+"<br>"+story);
    labelstory.setFont(new Font("Grinched 2.0", Font.BOLD,24));
    labelstory.setBounds(10,250,600,500);
    labelstory.setBackground(new Color(255,255,255,100));
    labelstory.setOpaque(true);
    dep.add(labelstory, new Integer(50));

    dep.add(labelimage, new Integer(50));

    ImageIcon sunflower = new ImageIcon("asset/truck.png");
    JButton truck = new JButton(sunflower);
    truck.setOpaque(false);
    truck.setContentAreaFilled(false);
    truck.setBorderPainted(false);

    truck.setBounds(1000,410,350,350);
    dep.add(truck, new Integer(350));

    truck.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                dep.remove(truck);
                dep.remove(labelimage);
                dep.remove(labelstory);
                if (x == 1) {
                  StageController sc = new StageController(dep, 1, p.getTruckLevel(), p);
                } else if (x == 2) {
                  StageController sc = new StageController(dep, 2, p.getTruckLevel(), p);
                } else if (x == 3) {
                  StageController sc = new StageController(dep, 3, p.getTruckLevel(), p);
                } else if( x == 4) {
                  StageController sc = new StageController(dep, 4, p.getTruckLevel(), p);
                } else if (x == 5) {
                  StageController sc = new StageController(dep, 5, p.getTruckLevel(), p);
                } else if (x == 6) {
                  StageController sc = new StageController(dep, 6, p.getTruckLevel(), p);
                } else if (x == 7) {
                  StageController sc = new StageController(dep, 7, p.getTruckLevel(), p);
                } else if (x == 8) {
                  StageController sc = new StageController(dep, 8, p.getTruckLevel(), p);
                } else if (x == 9) {
                  StageController sc = new StageController(dep, 9, p.getTruckLevel(), p);
                }
                else {
                  new Level(dep, p);
                }
              }
            }
    );
  }
}