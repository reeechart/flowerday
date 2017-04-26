package gui;

import player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * @author Irene Edria
 * @author  Reinhard Benjamin
 * @version 4/19/17
 */
public class Load {
  private String[] name = new String[3];
  private int[] maxLv = new int[3];
  private int[] money = new int[3];
  private int[] truckLv = new int[3];
  Player p;

  Load(JDesktopPane dp) {
    ImageIcon loadbackground = new ImageIcon("asset/gameback.png");
    JLabel labelload = new JLabel(loadbackground);
    labelload.setBounds(0, 0, 1440, 900);
    dp.add(labelload, new Integer(500));
    // Load File dari file eskternal
    LoadFile();
    ;
    // Button-button load file
    ImageIcon loadfile = new ImageIcon("asset/loadfile.png");
    JButton loadfile1 = new JButton(loadfile);
    loadfile1.setBounds(300, 200, 300, 300);
    loadfile1.setOpaque(false);
    loadfile1.setBorderPainted(false);
    loadfile1.setContentAreaFilled(false);

    dp.add(loadfile1, new Integer(550));
    JButton loadfile2 = new JButton(loadfile);
    loadfile2.setBounds(600, 200, 300, 300);
    loadfile2.setOpaque(false);
    loadfile2.setBorderPainted(false);
    loadfile2.setContentAreaFilled(false);

    dp.add(loadfile2, new Integer(550));
    JButton loadfile3 = new JButton(loadfile);
    loadfile3.setBounds(900, 200, 300, 300);
    loadfile3.setOpaque(false);
    loadfile3.setBorderPainted(false);
    loadfile3.setContentAreaFilled(false);

    dp.add(loadfile3, new Integer(550));
    // Label nama dan level loadfile
    JLabel label1 = new JLabel(name[0]);
    label1.setFont(new Font("Grinched 2.0", Font.BOLD, 24));
    label1.setBounds(430, 520, 100, 30);
    dp.add(label1, new Integer(550));
    JLabel label2 = new JLabel(name[1]);
    label2.setFont(new Font("Grinched 2.0", Font.BOLD, 24));
    label2.setBounds(740, 520, 100, 30);
    dp.add(label2, new Integer(550));
    JLabel label3 = new JLabel(name[2]);
    label3.setFont(new Font("Grinched 2.0", Font.BOLD, 24));
    label3.setBounds(1040, 520, 100, 30);
    dp.add(label3, new Integer(550));
    loadfile1.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                p = new Player(name, maxLv, truckLv, money, 0);
                new Level(dp, p);
                dp.remove(labelload);
                dp.remove(loadfile1);
                dp.remove(loadfile2);
                dp.remove(loadfile3);
                dp.remove(label1);
                dp.remove(label2);
                dp.remove(label3);
              }
            }
    );
    loadfile2.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                Player p = new Player(name, maxLv, truckLv, money, 1);
                new Level(dp, p);
                dp.remove(labelload);
                dp.remove(loadfile1);
                dp.remove(loadfile2);
                dp.remove(loadfile3);
                dp.remove(label1);
                dp.remove(label2);
                dp.remove(label3);
              }
            }
    );
    loadfile3.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                Player p = new Player(name, maxLv, truckLv, money, 2);
                new Level(dp, p);
                dp.remove(labelload);
                dp.remove(loadfile1);
                dp.remove(loadfile2);
                dp.remove(loadfile3);
                dp.remove(label1);
                dp.remove(label2);
                dp.remove(label3);

              }
            }
    );
  }

  public void LoadFile() {
    try(BufferedReader br = new BufferedReader(new FileReader("asset/player.txt"))) {
      String currentLine = null;
      int counter = 0;

      while((currentLine = br.readLine()) != null) {
        String pattern = "\\s*name\\s*:\\s*([^,]+)\\s*,\\s*maxLv\\s*:\\s*(\\d+)\\s*,\\s*money\\s*:\\s*(\\d+)\\s*,\\s*truckLv\\s*:\\s*(\\d+)\\s*";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(currentLine);

         if(m.find()) {
           name[counter] = m.group(1);
           maxLv[counter] = Integer.parseInt(m.group(2));
           money[counter] = Integer.parseInt(m.group(3));
           truckLv[counter] = Integer.parseInt(m.group(4));
         }

        counter++;
      }
    }
    catch(IOException e) {
      e.printStackTrace();
    }
  }

  Player getPlayer() {
    return p;
  }
}
