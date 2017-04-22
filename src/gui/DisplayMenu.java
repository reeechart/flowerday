package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ireneedriadr on 4/19/17.
 */



public class DisplayMenu extends JPanel {

  static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
  JFrame fr = new JFrame();
  ImageIcon image = new ImageIcon("asset/main2.png");
  public JDesktopPane dp = new JDesktopPane();
  JDesktopPane dp1 = new JDesktopPane();
  JLabel labelimage = new JLabel(image);
  JPanel panelmain = new JPanel();
  JPanel panel = new JPanel();

  public static void confirm() {
    JFrame frame = new JFrame();
    int dialogButton = JOptionPane.YES_NO_OPTION;
    int confirmquest = JOptionPane.showConfirmDialog(null, "Are you sure want to quit ?", "FlowerDay", dialogButton );
    if(confirmquest == JOptionPane.YES_OPTION) {
      System.exit(0);
    }

  }

  public DisplayMenu() {

    //Main Menu
    labelimage.setBounds(0,0,1440,900);

    JButton buttonstart = new JButton("START");
    buttonstart.setBounds(700, 700, 100, 30);
    panelmain.add(buttonstart);


    dp.add(labelimage, new Integer(50));
    dp.add(buttonstart, new Integer(350));


    //Story Page


    //Main
    JButton buttonclose = new JButton("EXIT");
    buttonclose.setBounds(0,0,50,50);
    panel.add(buttonclose);


    dp.add(buttonclose, new Integer(500));

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
                dp.remove(buttonstart);
                dp.remove(labelimage);
                new DisplayStory(dp);

              }
            }
    );

    fr.setLayeredPane(dp);
    fr.setExtendedState(JFrame.MAXIMIZED_BOTH);
    fr.setVisible(true);
    fr.setUndecorated(true);
    fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

  }
}

