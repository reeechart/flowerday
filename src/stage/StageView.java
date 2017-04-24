package stage;

import player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by ireneedriadr on 4/23/17.
 */
public class StageView {

  JButton[][] field = new JButton[3][3];

  public StageView(StageController sc, JDesktopPane dep, Player p, int l, ArrayList<ActionListener> actList) {

    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    int width = gd.getDisplayMode().getWidth();
    int height = gd.getDisplayMode().getHeight();

    ImageIcon image = new ImageIcon("asset/gameback.png");
    JLabel labelimage = new JLabel(image);
    labelimage.setBounds(0,0,1440,900);
    dep.add(labelimage, new Integer(150));

    ImageIcon level = new ImageIcon("asset/1small.png");
    JLabel labellevel = new JLabel(level);
    labellevel.setBounds(80,200,100,100);
    dep.add(labellevel, new Integer(1000));

    ImageIcon money = new ImageIcon("asset/money.png");
    JLabel labelmoney = new JLabel(money);
    labelmoney.setBounds(80, 270, 100, 100);
    dep.add(labelmoney, new Integer(1000));

    ImageIcon shop = new ImageIcon("asset/shop.png");
    JLabel labelshop = new JLabel(shop);
    labelshop.setBounds(1000, 50, 120,120);
    dep.add(labelshop,new Integer(1000));

    ImageIcon rose = new ImageIcon("asset/rose.png");
    JButton buttonrose = new JButton(rose);
    buttonrose.setBounds(1020, 180, 40, 40);
    buttonrose.setOpaque(false);
    buttonrose.setBorderPainted(false);
    buttonrose.setContentAreaFilled(false);
    buttonrose.addActionListener(actList.remove(0));
    dep.add(buttonrose, new Integer(1000));

    ImageIcon sunflower = new ImageIcon("asset/sunflower.png");
    JButton buttonsunflower = new JButton(sunflower);
    buttonsunflower.setBounds(1070, 180,40,40);
    buttonsunflower.setOpaque(false);
    buttonsunflower.setContentAreaFilled(false);
    buttonsunflower.setBorderPainted(false);
    buttonsunflower.addActionListener(actList.remove(0));
    dep.add(buttonsunflower, new Integer(1000));

    ImageIcon chamomile = new ImageIcon("asset/chamomile.png");
    JButton buttonchamomile = new JButton(chamomile);
    buttonchamomile.setBounds(1020,230,40,40);
    buttonchamomile.setOpaque(false);
    buttonchamomile.setBorderPainted(false);
    buttonchamomile.setContentAreaFilled(false);
    buttonchamomile.addActionListener(actList.remove(0));
    dep.add(buttonchamomile, new Integer(1000));

    ImageIcon orchid = new ImageIcon("asset/orchid.png");
    JButton buttonorchid = new JButton(orchid);
    buttonorchid.setBounds(1070,230,40,40);
    buttonorchid.setOpaque(false);
    buttonorchid.setContentAreaFilled(false);
    buttonorchid.setBorderPainted(false);
    buttonorchid.addActionListener(actList.remove(0));
    dep.add(buttonorchid, new Integer(1000));

    ImageIcon pot = new ImageIcon("asset/pot.png");
    JButton buttonpot = new JButton(pot);
    buttonpot.setBounds(1035,280,60,60);
    buttonpot.setOpaque(false);
    buttonpot.setContentAreaFilled(false);
    buttonpot.setBorderPainted(false);
    buttonpot.addActionListener(actList.remove(0));
    dep.add(buttonpot, new Integer(1000));

    ImageIcon potimage = new ImageIcon("asset/potempty.png");
    for(int i = 0 ; i < 1; i++) {
      for (int j = 0; j < 2; j++) {
        field[i][j] = new JButton(potimage);
        field[i][j].setBounds((j * 100) + 500, (i * 100) + 150, 100, 100);
        field[i][j].setBorderPainted(false);
        field[i][j].setContentAreaFilled(false);
        field[i][j].setOpaque(false);
        field[i][j].addActionListener(actList.get(0));
        dep.add(field[i][j],new Integer(1000));
      }
    }

    actList.remove(0);
    /*ImageIcon field = new ImageIcon("asset/field.png");
    JLabel labelfield = new JLabel(field);
    labelfield.setBounds(500,150,400,400);
    dep.add(labelfield, new Integer(1000));*/



    ImageIcon can = new ImageIcon("asset/wateringcan.png");
    JButton buttoncan = new JButton(can);
    buttoncan.setBounds(300,150,200,200);
    buttoncan.setOpaque(false);
    buttoncan.setContentAreaFilled(false);
    buttoncan.setBorderPainted(false);
    buttoncan.addActionListener(actList.remove(0));
    dep.add(buttoncan,new Integer(1000));

    ImageIcon scissors = new ImageIcon("asset/scissors.png");
    JButton buttonscissors = new JButton(scissors);
    buttonscissors.setBounds(300,300,200,200);
    buttonscissors.setOpaque(false);
    buttonscissors.setContentAreaFilled(false);
    buttonscissors.setBorderPainted(false);
    buttonscissors.addActionListener(actList.remove(0));
    dep.add(buttonscissors,new Integer(1000));

    JLabel trucklevel = new JLabel(Integer.toString(p.getTruckLevel()));
    trucklevel.setBounds(150,500,100,100);
    dep.add(trucklevel,new Integer(1000));

    ImageIcon truck = new ImageIcon("asset/truckmini.png");
    JButton buttontruck = new JButton(truck);
    buttontruck.setBounds(150, 650, 150,150);
    buttontruck.setOpaque(false);
    buttontruck.setBorderPainted(false);
    buttontruck.setContentAreaFilled(false);
    buttontruck.addActionListener(actList.remove(0));
    dep.add(buttontruck, new Integer(1000));
  }
}