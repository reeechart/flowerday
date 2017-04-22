package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ireneedriadr on 4/22/17.
 */
public class Story extends JPanel {
  public
  Story(JDesktopPane dep, int x) {
    ImageIcon image = new ImageIcon("asset/story1.png");
    JLabel labelimage = new JLabel(image);
    labelimage.setBounds(0,0,1440,900);

    JLabel labelstory = new JLabel("Yayyayayay");
    labelstory.setFont(new Font("Grinched 2.0", Font.BOLD,24));
    labelstory.setBounds(10,0,1440,900);

    dep.add(labelstory, new Integer(350));
    dep.add(labelimage, new Integer(50));
  }
}
