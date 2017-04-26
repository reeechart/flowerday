package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import player.Player;

/**
 * Kelas untuk mengurus tampilan di layar untuk
 * pemilihan stage yang ingin dimainkan.
 * Di kelas ini akan ditampilkan button-button stage yang dapat dipilih.
 * Selain itu, ada juga opsi untuk melakukan upgrade pada truck pemain.
 *
 * @author Irene Edria
 * @version 4/25/17
 */
public class Level {

  JLabel upgradePrice;
  JLabel labelTruckLevel;
  JLabel labelmoneybag1;
  /**
   * Konstruktor.
   *
   * @param dep Wadah untuk meletakkan item-item GUI pada layar
   * @param p Keterangan mengenai player yang sedang bermain
   */
  public Level(JDesktopPane dep, Player p) {

    // Background
    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    int width = gd.getDisplayMode().getWidth();
    int height = gd.getDisplayMode().getHeight();
    ImageIcon image = new ImageIcon("asset/main2.png");
    JLabel labelimage = new JLabel(image);
    labelimage.setBounds(0, 0, 1440, 900);
    dep.add(labelimage, 150);
    // Button stage 1
    ImageIcon i1 = new ImageIcon("asset/1.png");
    JButton b1 = new JButton(i1);
    b1.setOpaque(false);
    b1.setContentAreaFilled(false);
    b1.setBorderPainted(false);
    b1.setBounds(200, 50, 200, 200);
    dep.add(b1, new Integer(700));
    // Button stage 2
    ImageIcon i2 = new ImageIcon("asset/2.png");
    JButton b2 = new JButton(i2);
    b2.setOpaque(false);
    b2.setContentAreaFilled(false);
    b2.setBorderPainted(false);
    b2.setBounds(400, 50, 200, 200);
    dep.add(b2, new Integer(700));
    // Button stage 3
    ImageIcon i3 = new ImageIcon("asset/3.png");
    JButton b3 = new JButton(i3);
    b3.setOpaque(false);
    b3.setContentAreaFilled(false);
    b3.setBorderPainted(false);
    b3.setBounds(600, 50, 200, 200);
    dep.add(b3, new Integer(700));
    // Button stage 4
    ImageIcon i4 = new ImageIcon("asset/4.png");
    JButton b4 = new JButton(i4);
    b4.setOpaque(false);
    b4.setContentAreaFilled(false);
    b4.setBorderPainted(false);
    b4.setBounds(200, 250, 200, 200);
    dep.add(b4, new Integer(700));
    // Button stage 5
    ImageIcon i5 = new ImageIcon("asset/5.png");
    JButton b5 = new JButton(i5);
    b5.setOpaque(false);
    b5.setContentAreaFilled(false);
    b5.setBorderPainted(false);
    b5.setBounds(400, 250, 200, 200);
    dep.add(b5, new Integer(700));
    // Button stage 6
    ImageIcon i6 = new ImageIcon("asset/6.png");
    JButton b6 = new JButton(i6);
    b6.setOpaque(false);
    b6.setContentAreaFilled(false);
    b6.setBorderPainted(false);
    b6.setBounds(600, 250, 200, 200);
    dep.add(b6, new Integer(700));
    // Button stage 7
    ImageIcon i7 = new ImageIcon("asset/7.png");
    JButton b7 = new JButton(i7);
    b7.setOpaque(false);
    b7.setBorderPainted(false);
    b7.setContentAreaFilled(false);
    b7.setBounds(200, 450, 200, 200);
    dep.add(b7, new Integer(700));
    // Button stage 8
    ImageIcon i8 = new ImageIcon("asset/8.png");
    JButton b8 = new JButton(i8);
    b8.setOpaque(false);
    b8.setBorderPainted(false);
    b8.setContentAreaFilled(false);
    b8.setBounds(400, 450, 200, 200);
    dep.add(b8, new Integer(700));
    // Button stage 9
    ImageIcon i9 = new ImageIcon("asset/9.png");
    JButton b9 = new JButton(i9);
    b9.setOpaque(false);
    b9.setBorderPainted(false);
    b9.setContentAreaFilled(false);
    b9.setBounds(600, 450, 200, 200);
    dep.add(b9, new Integer(700));
    // Icon Player Money
    ImageIcon moneybag = new ImageIcon("asset/bagmoney.png");
    JLabel labelmoneybag = new JLabel(moneybag);
    labelmoneybag.setBounds(1300, 10, 100, 100);
    dep.add(labelmoneybag, new Integer(1000));
    // Label Player Money
    String playerMoney = new String(Integer.toString(p.getMoney()));
    labelmoneybag1 = new JLabel(playerMoney);
    labelmoneybag1.setFont(new Font("Grinched 2.0", Font.BOLD,24));
    labelmoneybag1.setBounds(1400, 10, 50, 50);
    dep.add(labelmoneybag1, new Integer(1000));
    // Icon Player Level
    int level = p.getLastStageOpened();
    ImageIcon playerLevelIcon;
    JLabel labelLevel;
    if (level == 1) {
      playerLevelIcon = new ImageIcon("asset/1small.png");
      labelLevel = new JLabel(playerLevelIcon);
      labelLevel.setBounds(1325, 130, 50, 50);
      dep.add(labelLevel, new Integer(1000));
    } else if (level ==2) {
      playerLevelIcon = new ImageIcon("asset/2small.png");
      labelLevel = new JLabel(playerLevelIcon);
      labelLevel.setBounds(1325, 130, 50, 50);
      dep.add(labelLevel, new Integer(1000));
    } else if (level == 3) {
      playerLevelIcon = new ImageIcon("asset/3small.png");
      labelLevel = new JLabel(playerLevelIcon);
      labelLevel.setBounds(1325, 130, 50, 50);
      dep.add(labelLevel, new Integer(1000));
    } else if (level == 4) {
      playerLevelIcon = new ImageIcon("asset/4small.png");
      labelLevel = new JLabel(playerLevelIcon);
      labelLevel.setBounds(1325, 130, 50, 50);
      dep.add(labelLevel, new Integer(1000));
    } else if (level == 5) {
      playerLevelIcon = new ImageIcon("asset/5small.png");
      labelLevel = new JLabel(playerLevelIcon);
      labelLevel.setBounds(1325, 130, 50, 50);
      dep.add(labelLevel, new Integer(1000));
    } else if (level == 6) {
      playerLevelIcon = new ImageIcon("asset/6small.png");
      labelLevel = new JLabel(playerLevelIcon);
      labelLevel.setBounds(1325, 130, 50, 50);
      dep.add(labelLevel, new Integer(1000));
    } else if (level == 7) {
      playerLevelIcon = new ImageIcon("asset/7small.png");
      labelLevel = new JLabel(playerLevelIcon);
      labelLevel.setBounds(1325, 130, 50, 50);
      dep.add(labelLevel, new Integer(1000));
    } else if (level == 8) {
      playerLevelIcon = new ImageIcon("asset/8small.png");
      labelLevel = new JLabel(playerLevelIcon);
      labelLevel.setBounds(1325, 130, 50, 50);
      dep.add(labelLevel, new Integer(1000));
    } else {
      playerLevelIcon = new ImageIcon("asset/1small.png");
      labelLevel = new JLabel(playerLevelIcon);
      labelLevel.setBounds(1325, 130, 50, 50);
      dep.add(labelLevel, new Integer(1000));
    }
    // Button save
    JButton buttonSave = new JButton("Save");
    buttonSave.setBounds(1150, 130, 100, 50);
    buttonSave.setFont(new Font("Grinched 2.0", Font.BOLD,24));
    buttonSave.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {

                try {
                  PrintWriter writer = new PrintWriter("asset/player.txt","UTF-8");
                  int indeksPlayer = p.getIndeksPlayer();
                  for(int i=0;i<3;i++) {
                    String name;
                    int maxLv;
                    int money;
                    int truckLv;
                    if(i == indeksPlayer) {
                      name = p.getName();
                      maxLv = p.getLastStageOpened();
                      money = p.getMoney();
                      truckLv = p.getTruckLevel();
                    }
                    else {
                      name = p.getNameFromIndex(i);
                      maxLv = p.getLastStageOpenedFromIndex(i);
                      money = p.getMoneyFromIndex(i);
                      truckLv = p.getTruckLevelFromIndex(i);
                    }
                    if(i!=0) writer.println();
                    writer.print("name : " + name + ", maxLv : " + maxLv + ", money : " + money + ", truckLv : " + truckLv);
                    writer.close();
                  }
                }
                catch (FileNotFoundException a) {
                  System.exit(0);
                }
                catch (UnsupportedEncodingException a) {
                  System.exit(0);
                }
              }
            }
    );
    dep.add(buttonSave, new Integer(1000));
    // Icon Truck Level
    ImageIcon truck = new ImageIcon("asset/truckminimini.png");
    JLabel labelTruck = new JLabel(truck);
    labelTruck.setBounds(1300, 180, 100, 100);
    dep.add(labelTruck, new Integer(1000));
    // Label Truck Level
    String truckLevel = new String(Integer.toString(p.getTruckLevel()));
    labelTruckLevel = new JLabel(truckLevel);
    labelTruckLevel.setFont(new Font("Grinched 2.0", Font.BOLD,24));
    labelTruckLevel.setBounds(1400, 200, 50, 50);
    dep.add(labelTruckLevel, new Integer(1000));
    ImageIcon playerlevel = new ImageIcon();
    // Button Upgrade Truck
    JButton upgradeTruck = new JButton("Upgrade Truck");
    upgradeTruck.setFont(new Font("Grinched 2.0", Font.BOLD,24));
    upgradeTruck.setBounds(1150, 180, 150, 50);
    dep.add(upgradeTruck, new Integer(1000));
    // Label Upgrade Truck
    String price = new String(Integer.toString(3000*p.getTruckLevel()));
    upgradePrice = new JLabel(price);
    upgradePrice.setFont(new Font("Grinched 2.0", Font.BOLD,24));
    upgradePrice.setBounds(1200, 230, 100, 30);
    dep.add(upgradePrice, new Integer(1000));
    // Mengurus aksi yang dilakukan saat button diklik
    upgradeTruck.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                p.upgradeTruck();
                dep.remove(upgradePrice);
                dep.remove(labelTruckLevel);
                dep.remove(labelmoneybag1);
                String truckLevel = new String(Integer.toString(p.getTruckLevel()));
                labelTruckLevel = new JLabel(truckLevel);
                labelTruckLevel.setFont(new Font("Grinched 2.0", Font.BOLD,24));
                labelTruckLevel.setBounds(1400, 200, 50, 50);
                dep.add(labelTruckLevel, new Integer(1000));
                String price = new String(Integer.toString(3000*p.getTruckLevel()));
                upgradePrice = new JLabel(price);
                upgradePrice.setFont(new Font("Grinched 2.0", Font.BOLD,24));
                upgradePrice.setBounds(1200, 230, 100, 30);
                dep.add(upgradePrice, new Integer(1000));
                String playerMoney = new String(Integer.toString(p.getMoney()));
                labelmoneybag1 = new JLabel(playerMoney);
                labelmoneybag1.setFont(new Font("Grinched 2.0", Font.BOLD,24));
                labelmoneybag1.setBounds(1400, 10, 50, 50);
                dep.add(labelmoneybag1, new Integer(1000));
              }
            }
    );
    int playerLevel = p.getLastStageOpened();
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
                dep.remove(labelmoneybag);
                dep.remove(labelmoneybag1);
                dep.remove(labelTruckLevel);
                dep.remove(labelLevel);
                dep.remove(buttonSave);
                dep.remove(labelTruck);
                Story story = new Story(dep, 1, p);
                System.out.println(p.getName());
                System.out.println(p.getLastStageOpened());
                System.out.println(p.getMoney());
                System.out.println(p.getTruckLevel());
              }
            }
    );
    b2.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                if (playerLevel < 2) {
                  showRestrictionMessage();
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
                  dep.remove(labelmoneybag);
                  dep.remove(labelmoneybag1);
                  dep.remove(labelTruckLevel);
                  dep.remove(labelLevel);
                  dep.remove(buttonSave);
                  dep.remove(labelTruck);
                  Story story = new Story(dep, 2, p);
                }
              }
            }
    );
    b3.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                if (playerLevel < 3) {
                  showRestrictionMessage();
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
                  dep.remove(labelmoneybag);
                  dep.remove(labelmoneybag1);
                  dep.remove(labelTruckLevel);
                  dep.remove(labelLevel);
                  dep.remove(buttonSave);
                  dep.remove(labelTruck);
                  Story story = new Story(dep, 3, p);
                }
              }
            }
    );
    b4.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                if (playerLevel < 4) {
                  showRestrictionMessage();
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
                  dep.remove(labelmoneybag);
                  dep.remove(labelmoneybag1);
                  dep.remove(labelTruckLevel);
                  dep.remove(labelLevel);
                  dep.remove(buttonSave);
                  dep.remove(labelTruck);
                  Story story = new Story(dep, 4, p);
                }
              }
            }
    );
    b5.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                if (playerLevel < 5) {
                  showRestrictionMessage();
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
                  dep.remove(labelmoneybag);
                  dep.remove(labelmoneybag1);
                  dep.remove(labelTruckLevel);
                  dep.remove(labelLevel);
                  dep.remove(buttonSave);
                  dep.remove(labelTruck);
                  Story story = new Story(dep, 5, p);
                }
              }
            }
    );
    b6.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                if (playerLevel < 6) {
                  showRestrictionMessage();
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
                  dep.remove(labelmoneybag);
                  dep.remove(labelmoneybag1);
                  dep.remove(labelTruckLevel);
                  dep.remove(labelLevel);
                  dep.remove(buttonSave);
                  dep.remove(labelTruck);
                  Story story = new Story(dep, 6, p);
                }
              }
            }
    );
    b7.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                if (playerLevel < 7) {
                  showRestrictionMessage();
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
                  dep.remove(labelmoneybag);
                  dep.remove(labelmoneybag1);
                  dep.remove(labelTruckLevel);
                  dep.remove(labelLevel);
                  dep.remove(buttonSave);
                  dep.remove(labelTruck);
                  Story story = new Story(dep, 7, p);
                }
              }
            }
    );
    b8.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                if (playerLevel < 8) {
                  showRestrictionMessage();
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
                  dep.remove(labelmoneybag);
                  dep.remove(labelmoneybag1);
                  dep.remove(labelTruckLevel);
                  dep.remove(labelLevel);
                  dep.remove(buttonSave);
                  dep.remove(labelTruck);
                  Story story = new Story(dep, 8, p);
                }
              }
            }
    );
    b9.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                if (playerLevel < 9) {
                  showRestrictionMessage();
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
                  dep.remove(labelmoneybag);
                  dep.remove(labelmoneybag1);
                  dep.remove(labelTruckLevel);
                  dep.remove(labelLevel);
                  dep.remove(buttonSave);
                  dep.remove(labelTruck);
                  Story story = new Story(dep, 9, p);
                }
              }
            }
    );
  }

  /**
   * Prosedur yang menampilkan pesan bahwa level belum dapat dimainkan.
   */
  private void showRestrictionMessage() {
    ImageIcon quit = new ImageIcon("asset/quit.png");
    JFrame frame = new JFrame();
    JOptionPane.showMessageDialog(null, "You can not play this stage",
            "Message", JOptionPane.INFORMATION_MESSAGE, quit);
  }

  private void changeLabelPrice() {

  }
}