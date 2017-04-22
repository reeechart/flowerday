package gui;

import javax.swing.*;

/**
 * Created by ireneedriadr on 4/22/17.
 */
public class DisplayStory extends JPanel {
  DisplayStory(JDesktopPane dp) {
    JLabel labelstory = new JLabel("Yayyayayay");
    labelstory.setBounds(0,0,1440,900);
    dp.add(labelstory,new Integer(350));
  }
}
