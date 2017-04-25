package stage;

import gui.Level;
import plant.PlantController;
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
  public int i = 0;
  JButton[][] field = new JButton[3][3];
  JLabel labelmoney1;
  JLabel labelincome;
  JButton buttontruck;
  JButton buttonscissors;
  JButton buttoncan;
  JLabel labelgarden;
  JButton buttonpotp;
  JButton buttonpot;
  JButton buttonorchid;
  JButton buttonchamomile;
  JButton buttonsunflower;
  JButton buttonrose;
  JLabel labelmoney;
  JLabel labellevel;
  JLabel labelimage;
  JLabel labelshop;



  public void newPot(JDesktopPane dep, Stage stage, ActionListener a) {
    int n = stage.getPots() - 1;
    int x = n / 3;
    int y = n % 3;
    PlantController[][] pc = stage.getPlants();
    ImageIcon potimage = pc[x][y].getImage();
    buttonpot = new JButton(potimage);
    buttonpot.setBounds((y*150)+500,(x*150)+150,150,150);
    buttonpot.setOpaque(false);
    buttonpot.setBorderPainted(false);
    buttonpot.setContentAreaFilled(false);
    buttonpot.addActionListener(a);
    field[x][y] = buttonpot;
    updateMoney(dep, stage);
    dep.add(buttonpot, new Integer(1000));
  }


  public void updateIncome(JDesktopPane dep, Stage stage, ActionListener a) {
    updateIncome(dep,stage);
  }

  public void updatePot(JDesktopPane dep, Stage stage, int row, int col, ActionListener a) {
    PlantController[][] pc = stage.getPlants();
    ImageIcon bibitimage = pc[row][col].getImage();
    dep.remove(field[row][col]);
    JButton buttonpotbibit = new JButton(bibitimage);
    buttonpotbibit.setBounds((col * 150) + 500, (row * 150) + 150, 150, 150);
    buttonpotbibit.setOpaque(false);
    buttonpotbibit.setBorderPainted(false);
    buttonpotbibit.setContentAreaFilled(false);
    buttonpotbibit.addActionListener(a);
    field[row][col] = buttonpotbibit;
    updateMoney(dep, stage);
    i++;
    dep.add(buttonpotbibit, new Integer(1000+(i*150)));
  }

  public void updateMoney(JDesktopPane dep, Stage stage) {
    String gameMoney= new String(Integer.toString(stage.getInGameMoney()));
    dep.remove(labelmoney1);
    labelmoney1 = new JLabel(gameMoney);
    labelmoney1.setBounds(180,270,100,100);
    dep.add(labelmoney1, new Integer(1000));
  }

  public void updateIncome(JDesktopPane dep, Stage stage) {
    String income = new String(Integer.toString(stage.getIncome()));
    labelincome.setVisible(false);
    labelincome = new JLabel(income);
    labelincome.setBounds(180,370,100,100);
    dep.add(labelincome, new Integer(1000));
  }

  public StageView(Stage stage, StageController sc, JDesktopPane dep, Player p, int l, ArrayList<ActionListener> actList) {

    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    int width = gd.getDisplayMode().getWidth();
    int height = gd.getDisplayMode().getHeight();

    ImageIcon potimage = new ImageIcon("asset/potempty.png");

    ImageIcon image = new ImageIcon("asset/gameback.png");
    labelimage = new JLabel(image);
    labelimage.setBounds(0,0,1440,900);
    dep.add(labelimage, new Integer(150));

    ImageIcon level = new ImageIcon("asset/1small.png");
    labellevel = new JLabel(level);
    labellevel.setBounds(80,200,100,100);
    dep.add(labellevel, new Integer(1000));

    ImageIcon money = new ImageIcon("asset/money.png");
    labelmoney = new JLabel(money);
    labelmoney.setBounds(80, 270, 100, 100);
    dep.add(labelmoney, new Integer(1000));

    String income = new String(Integer.toString(stage.getIncome()));
    labelincome = new JLabel(income);
    labelincome.setBounds(180,370,100,100);
    dep.add(labelincome, new Integer(1000));

    String gameMoney= new String(Integer.toString(stage.getInGameMoney()));
    labelmoney1 = new JLabel(gameMoney);
    labelmoney1.setBounds(180,270,100,100);
    dep.add(labelmoney1, new Integer(1000));

    ImageIcon shop = new ImageIcon("asset/shop.png");
    labelshop = new JLabel(shop);
    labelshop.setBounds(1050, 30, 150,150);
    dep.add(labelshop, new Integer(1000));

    ImageIcon rose = new ImageIcon("asset/rose.png");
    buttonrose = new JButton(rose);
    buttonrose.setBounds(1020, 210, 100, 100);
    buttonrose.setOpaque(false);
    buttonrose.setBorderPainted(false);
    buttonrose.setContentAreaFilled(false);
    buttonrose.addActionListener(actList.remove(0));
    dep.add(buttonrose, new Integer(1000));

    ImageIcon sunflower = new ImageIcon("asset/sunflower.png");
    buttonsunflower = new JButton(sunflower);
    buttonsunflower.setBounds(1130, 210,100,100);
    buttonsunflower.setOpaque(false);
    buttonsunflower.setContentAreaFilled(false);
    buttonsunflower.setBorderPainted(false);
    buttonsunflower.addActionListener(actList.remove(0));
    dep.add(buttonsunflower, new Integer(1000));

    ImageIcon chamomile = new ImageIcon("asset/chamomile.png");
    buttonchamomile = new JButton(chamomile);
    buttonchamomile.setBounds(1020,320,100,100);
    buttonchamomile.setOpaque(false);
    buttonchamomile.setBorderPainted(false);
    buttonchamomile.setContentAreaFilled(false);
    buttonchamomile.addActionListener(actList.remove(0));
    dep.add(buttonchamomile, new Integer(1000));

    ImageIcon orchid = new ImageIcon("asset/orchid.png");
    buttonorchid = new JButton(orchid);
    buttonorchid.setBounds(1130,320,100,100);
    buttonorchid.setOpaque(false);
    buttonorchid.setContentAreaFilled(false);
    buttonorchid.setBorderPainted(false);
    buttonorchid.addActionListener(actList.remove(0));
    dep.add(buttonorchid, new Integer(1000));

    ImageIcon pot = new ImageIcon("asset/pot.png");
    buttonpotp = new JButton(pot);
    buttonpotp.setBounds(1080,430,100,100);
    buttonpotp.setOpaque(false);
    buttonpotp.setContentAreaFilled(false);
    buttonpotp.setBorderPainted(false);
    buttonpotp.addActionListener(actList.remove(0));
    dep.add(buttonpotp, new Integer(1000));

    ImageIcon garden = new ImageIcon("asset/garden.png");
    labelgarden = new JLabel(garden);
    labelgarden.setBounds(330, 30, 150,150);
    dep.add(labelgarden, new Integer(1000));

    for(int i = 0 ; i < 1; i++) {
      for (int j = 0; j < 2; j++) {
        field[i][j] = new JButton(potimage);
        field[i][j].setBounds((j * 150) + 500, (i * 150) + 150, 150, 150);
        field[i][j].setBorderPainted(false);
        field[i][j].setContentAreaFilled(false);
        field[i][j].setOpaque(false);
        field[i][j].addActionListener(actList.get(0));
        dep.add(field[i][j], new Integer(1000));
      }
    }

    actList.remove(0);

    ImageIcon can = new ImageIcon("asset/wateringcan.png");
    buttoncan = new JButton(can);
    buttoncan.setBounds(300,150,200,200);
    buttoncan.setOpaque(false);
    buttoncan.setContentAreaFilled(false);
    buttoncan.setBorderPainted(false);
    buttoncan.addActionListener(actList.remove(0));
    dep.add(buttoncan, new Integer(1000));

    ImageIcon scissors = new ImageIcon("asset/scissors.png");
    buttonscissors = new JButton(scissors);
    buttonscissors.setBounds(300,300,200,200);
    buttonscissors.setOpaque(false);
    buttonscissors.setContentAreaFilled(false);
    buttonscissors.setBorderPainted(false);
    buttonscissors.addActionListener(actList.remove(0));
    dep.add(buttonscissors, new Integer(1000));

    ImageIcon truck = new ImageIcon("asset/truckmini.png");
    buttontruck = new JButton(truck);
    buttontruck.setBounds(150, 650, 150,150);
    buttontruck.setOpaque(false);
    buttontruck.setBorderPainted(false);
    buttontruck.setContentAreaFilled(false);
    buttontruck.addActionListener(actList.remove(0));
    dep.add(buttontruck, new Integer(1000));
  }

  public void endStageView(Stage stage, JDesktopPane dep, int stat, Player p) {
    if(stat == 1) {
      ImageIcon quit = new ImageIcon("asset/quithappy.png");
      JFrame frame = new JFrame();
      JOptionPane.showMessageDialog(null, "Congratulations, you won!", "Message", JOptionPane.INFORMATION_MESSAGE, quit);
    }
    else {
      ImageIcon quit = new ImageIcon("asset/quit.png");
      JFrame frame = new JFrame();
      JOptionPane.showMessageDialog(null, "Sorry, you lose :(", "Message", JOptionPane.INFORMATION_MESSAGE, quit);
    }
    int n = stage.getPots();
    for (int pot = 0; pot < n; pot++) {
      int x = pot / 3;
      int y = pot % 3;
      dep.remove(field[x][y]);
    }
    dep.remove(labelmoney1);
    dep.remove(labelincome);
    dep.remove(buttontruck);
    dep.remove(buttonscissors);
    dep.remove(buttoncan);
    dep.remove(labelgarden);
    dep.remove(buttonpotp);
    dep.remove(buttonorchid);
    dep.remove(labelshop);
    dep.remove(buttonchamomile);
    dep.remove(buttonsunflower);
    dep.remove(buttonrose);
    dep.remove(labelmoney);
    dep.remove(labellevel);
    dep.remove(labelimage);
    new Level(dep, p);
  }
}