package gui;

import org.w3c.dom.css.Counter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by ireneedriadr on 4/19/17.
 */

public class Menu extends JPanel {

  static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
  JFrame fr = new JFrame();
  ImageIcon image = new ImageIcon("asset/main3.png");
  public JDesktopPane dp = new JDesktopPane();
  JLabel labelimage = new JLabel(image);
  JPanel panel = new JPanel();



  public static void confirm(){
    ImageIcon quit = new ImageIcon("asset/quit.png");
    JFrame frame = new JFrame();
    int dialogButton = JOptionPane.YES_NO_OPTION;
    int confirmquest = JOptionPane.showConfirmDialog(null, "Are you sure want to quit ?", "FlowerDay", dialogButton, JOptionPane.QUESTION_MESSAGE, quit);
    if(confirmquest == JOptionPane.YES_OPTION) {
      System.exit(0);
    }
  }

  public Menu() {

    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    int width = gd.getDisplayMode().getWidth();
    int height = gd.getDisplayMode().getHeight();
    ImageIcon imagel = new ImageIcon("asset/logo.png");
    JLabel logoimage = new JLabel(imagel);
    logoimage.setBounds(0,0,width,height);

    dp.add(logoimage, new Integer(700));

    int delay = 5000;
    ActionListener task = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        logoimage.setVisible(false);
      }
    };
    new Timer(delay, task).start();


    //Main Menu

    labelimage.setBounds(0,0,1440,900);

    ImageIcon start = new ImageIcon("asset/water.png");
    JButton buttonstart = new JButton(start);
    buttonstart.setOpaque(false);
    buttonstart.setContentAreaFilled(false);
    buttonstart.setBorderPainted(false);
    buttonstart.setBounds(640, 550, 200, 200);

    dp.add(labelimage, new Integer(50));
    dp.add(buttonstart, new Integer(350));


    //Main
    ImageIcon exit = new ImageIcon("asset/sun.png");
    JButton buttonclose = new JButton(exit);
    buttonclose.setOpaque(false);
    buttonclose.setContentAreaFilled(false);
    buttonclose.setBorderPainted(false);
    buttonclose.setBounds(10,10,150,150);

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
                new Story(dp,0);

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