package gui;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import player.Player;
import stage.StageController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

/**
 * Created by ireneedriadr on 4/22/17.
 */
public class Story extends JPanel {

  Story(JDesktopPane dep, int x, Player p) {
    final boolean f = false;
    String[] story = new String [500];
    int n = 0;
    try (BufferedReader br = new BufferedReader(new FileReader("asset/story.txt"))) {
      String sCurrentLine;

      while((sCurrentLine = br.readLine()) != null) {
        story[n] = sCurrentLine;
        n++;
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
    for(int i = 0 ; i < n; i++) {
      labelstory.setText("<html>"+labelstory.getText()+"<br>"+story[i]);
    }
    labelstory.setFont(new Font("Grinched 2.0", Font.BOLD,24));
    labelstory.setBounds(10,300,500,300);
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
                new Level(dep,p);

              }
            }
    );
  }
}
