package gui;

import javax.swing.*;

/**
 * Created by ireneedriadr on 4/19/17.
 */
public class DisplayMenu extends JFrame {
  ImageIcon image = new ImageIcon("asset/main.png");
  JDesktopPane dp = new JDesktopPane();
  JLabel label = new JLabel(image);
  JPanel transPanel = new JPanel();

  public DisplayMenu() {
    label.setBounds(0,0,1440,900);


    transPanel.setOpaque(false);
    transPanel.setBounds(375,500,700,200);

    JButton buttonstart = new JButton("START");
    transPanel.add(buttonstart);

    JButton buttonload = new JButton("LOAD");
    transPanel.add(buttonload);


    dp.add(label, new Integer(50));
    dp.add(transPanel, new Integer(350));

    setLayeredPane(dp);

  }
}
