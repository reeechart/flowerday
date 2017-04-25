package gui;

import player.Player;
import stage.StageController;
import stage.StageView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

/**
 * Created by ireneedriadr on 4/23/17.
 */
public class Level {


  Story story;
  int playerLevel;

  public Level(JDesktopPane dep, Player p) {

    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    int width = gd.getDisplayMode().getWidth();
    int height = gd.getDisplayMode().getHeight();
    ImageIcon image = new ImageIcon("asset/main2.png");
    JLabel labelimage = new JLabel(image);
    labelimage.setBounds(0,0,1440,900);
    dep.add(labelimage, 150);

    ImageIcon i1 = new ImageIcon("asset/1.png");
    JButton b1 = new JButton(i1);
    b1.setOpaque(false);
    b1.setContentAreaFilled(false);
    b1.setBorderPainted(false);
    b1.setBounds(200,50,200,200);
    dep.add(b1, new Integer(700));

    ImageIcon i2 = new ImageIcon("asset/2.png");
    JButton b2 = new JButton(i2);
    b2.setOpaque(false);
    b2.setContentAreaFilled(false);
    b2.setBorderPainted(false);
    b2.setBounds(400, 50, 200, 200);
    dep.add(b2, new Integer(700));

    ImageIcon i3 = new ImageIcon("asset/3.png");
    JButton b3 = new JButton(i3);
    b3.setOpaque(false);
    b3.setContentAreaFilled(false);
    b3.setBorderPainted(false);
    b3.setBounds(600, 50, 200, 200);
    dep.add(b3, new Integer(700));

    ImageIcon i4 = new ImageIcon("asset/4.png");
    JButton b4 = new JButton(i4);
    b4.setOpaque(false);
    b4.setContentAreaFilled(false);
    b4.setBorderPainted(false);
    b4.setBounds(200, 250, 200, 200);
    dep.add(b4, new Integer(700));

    ImageIcon i5 = new ImageIcon("asset/5.png");
    JButton b5 = new JButton(i5);
    b5.setOpaque(false);
    b5.setContentAreaFilled(false);
    b5.setBorderPainted(false);
    b5.setBounds(400, 250, 200, 200);
    dep.add(b5, new Integer(700));

    ImageIcon i6 = new ImageIcon("asset/6.png");
    JButton b6 = new JButton(i6);
    b6.setOpaque(false);
    b6.setContentAreaFilled(false);
    b6.setBorderPainted(false);
    b6.setBounds(600,250,200,200);
    dep.add(b6,new Integer(700));

    ImageIcon i7 = new ImageIcon("asset/7.png");
    JButton b7 = new JButton(i7);
    b7.setOpaque(false);
    b7.setBorderPainted(false);
    b7.setContentAreaFilled(false);
    b7.setBounds(200,450,200,200);
    dep.add(b7, new Integer(700));

    ImageIcon i8 = new ImageIcon("asset/8.png");
    JButton b8 = new JButton(i8);
    b8.setOpaque(false);
    b8.setBorderPainted(false);
    b8.setContentAreaFilled(false);
    b8.setBounds(400,450,200,200);
    dep.add(b8, new Integer(700));

    ImageIcon i9 = new ImageIcon("asset/9.png");
    JButton b9 = new JButton(i9);
    b9.setOpaque(false);
    b9.setBorderPainted(false);
    b9.setContentAreaFilled(false);
    b9.setBounds(600, 450, 200, 200);
    dep.add(b9, new Integer(700));

    playerLevel = p.getLastStageOpened();

    b1.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                dep.remove(b1);
                dep.remove(b2);
                dep.remove(b3);
                dep.remove(b4);
                dep.remove(b5);
                dep.remove(b6);
                dep.remove(b7);
                dep.remove(b8);
                dep.remove(b9);
                dep.remove(labelimage);
                story = new Story(dep, 1, p);
              }
            }
    );
    b2.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                if (playerLevel < 2) {
                  ImageIcon quit = new ImageIcon("asset/quit.png");
                  JFrame frame = new JFrame();
                  JOptionPane.showMessageDialog(null, "You can not play this stage", "Message", JOptionPane.INFORMATION_MESSAGE, quit);

                } else {
                  story = new Story(dep, 2, p);
                  dep.remove(b1);
                  dep.remove(b2);
                  dep.remove(b3);
                  dep.remove(b4);
                  dep.remove(b5);
                  dep.remove(b6);
                  dep.remove(b7);
                  dep.remove(b8);
                  dep.remove(b9);
                  dep.remove(labelimage);
                }
              }
            }
    );
    b3.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                if (playerLevel < 3) {
                  ImageIcon quit = new ImageIcon("asset/quit.png");
                  JFrame frame = new JFrame();
                  JOptionPane.showMessageDialog(null, "You can not play this stage", "Message", JOptionPane.INFORMATION_MESSAGE, quit);
                }
                else {
                  dep.remove(b1);
                  dep.remove(b2);
                  dep.remove(b3);
                  dep.remove(b4);
                  dep.remove(b5);
                  dep.remove(b6);
                  dep.remove(b7);
                  dep.remove(b8);
                  dep.remove(b9);
                  dep.remove(labelimage);
                  story = new Story(dep, 3, p);
                }
              }
            }
    );
    b4.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                if (playerLevel < 4) {
                  ImageIcon quit = new ImageIcon("asset/quit.png");
                  JFrame frame = new JFrame();
                  JOptionPane.showMessageDialog(null, "You can not play this stage", "Message", JOptionPane.INFORMATION_MESSAGE, quit);
                } else {
                  dep.remove(b1);
                  dep.remove(b2);
                  dep.remove(b3);
                  dep.remove(b4);
                  dep.remove(b5);
                  dep.remove(b6);
                  dep.remove(b7);
                  dep.remove(b8);
                  dep.remove(b9);
                  dep.remove(labelimage);
                  story = new Story(dep, 4, p);
                }
              }
            }
    );
    b5.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                if (playerLevel < 5) {
                  ImageIcon quit = new ImageIcon("asset/quit.png");
                  JFrame frame = new JFrame();
                  JOptionPane.showMessageDialog(null, "You can not play this stage", "Message", JOptionPane.INFORMATION_MESSAGE, quit);
                } else {
                  dep.remove(b1);
                  dep.remove(b2);
                  dep.remove(b3);
                  dep.remove(b4);
                  dep.remove(b5);
                  dep.remove(b6);
                  dep.remove(b7);
                  dep.remove(b8);
                  dep.remove(b9);
                  dep.remove(labelimage);
                  story = new Story(dep, 5, p);
                }
              }
            }
    );
    b6.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                if (playerLevel < 6) {
                  ImageIcon quit = new ImageIcon("asset/quit.png");
                  JFrame frame = new JFrame();
                  JOptionPane.showMessageDialog(null, "You can not play this stage", "Message", JOptionPane.INFORMATION_MESSAGE, quit);
                } else {
                  dep.remove(b1);
                  dep.remove(b2);
                  dep.remove(b3);
                  dep.remove(b4);
                  dep.remove(b5);
                  dep.remove(b6);
                  dep.remove(b7);
                  dep.remove(b8);
                  dep.remove(b9);
                  dep.remove(labelimage);
                  story = new Story(dep, 6, p);
                }
              }
            }
    );
    b7.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                if (playerLevel < 7) {
                  ImageIcon quit = new ImageIcon("asset/quit.png");
                  JFrame frame = new JFrame();
                  JOptionPane.showMessageDialog(null, "You can not play this stage", "Message", JOptionPane.INFORMATION_MESSAGE, quit);
                } else {
                  dep.remove(b1);
                  dep.remove(b2);
                  dep.remove(b3);
                  dep.remove(b4);
                  dep.remove(b5);
                  dep.remove(b6);
                  dep.remove(b7);
                  dep.remove(b8);
                  dep.remove(b9);
                  dep.remove(labelimage);
                  story = new Story(dep, 7, p);
                }
              }
            }
    );
    b8.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                if (playerLevel < 8) {
                  ImageIcon quit = new ImageIcon("asset/quit.png");
                  JFrame frame = new JFrame();
                  JOptionPane.showMessageDialog(null, "You can not play this stage", "Message", JOptionPane.INFORMATION_MESSAGE, quit);
                } else {
                  dep.remove(b1);
                  dep.remove(b2);
                  dep.remove(b3);
                  dep.remove(b4);
                  dep.remove(b5);
                  dep.remove(b6);
                  dep.remove(b7);
                  dep.remove(b8);
                  dep.remove(b9);
                  dep.remove(labelimage);
                  story = new Story(dep, 8, p);
                }
              }
            }
    );
    b9.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                if (playerLevel < 9) {
                  ImageIcon quit = new ImageIcon("asset/quit.png");
                  JFrame frame = new JFrame();
                  JOptionPane.showMessageDialog(null, "You can not play this stage", "Message", JOptionPane.INFORMATION_MESSAGE, quit);
                } else {
                  dep.remove(b1);
                  dep.remove(b2);
                  dep.remove(b3);
                  dep.remove(b4);
                  dep.remove(b5);
                  dep.remove(b6);
                  dep.remove(b7);
                  dep.remove(b8);
                  dep.remove(b9);
                  dep.remove(labelimage);
                  story = new Story(dep, 9, p);
                }
              }
            }
    );
  }
}