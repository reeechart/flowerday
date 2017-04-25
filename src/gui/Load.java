package gui;

import javax.swing.*;

/**
 * Created by ireneedriadr on 4/26/17.
 */
public class Load {

  public Load(JDesktopPane dp) {
    ImageIcon loadbackground = new ImageIcon("asset/gameback.png");
    JLabel labelload = new JLabel(loadbackground);
    labelload.setBounds(0, 0, 1440, 900);
    dp.add(labelload, new Integer(500));

    ImageIcon loadfile = new ImageIcon("asset/loadfile.png");
    JButton loadfile1 = new JButton(loadfile);
    JButton loadfile2 = new JButton(loadfile);
    JButton loadfile3 = new JButton(loadfile);

    loadfile1.setBounds(300, 200, 300, 300);
    loadfile1.setOpaque(false);
    loadfile1.setBorderPainted(false);
    loadfile1.setContentAreaFilled(false);
    dp.add(loadfile1, new Integer(550));

    loadfile2.setBounds(600, 200, 300, 300);
    loadfile2.setOpaque(false);
    loadfile2.setBorderPainted(false);
    loadfile2.setContentAreaFilled(false);
    dp.add(loadfile2, new Integer(550));

    loadfile3.setBounds(900, 200, 300, 300);
    loadfile3.setOpaque(false);
    loadfile3.setBorderPainted(false);
    loadfile3.setContentAreaFilled(false);
    dp.add(loadfile3, new Integer(550));
  }
}
