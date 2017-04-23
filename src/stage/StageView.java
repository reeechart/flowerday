package stage;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ireneedriadr on 4/23/17.
 */
public class StageView {

  public StageView(JDesktopPane dep, int x) {
    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    int width = gd.getDisplayMode().getWidth();
    int height = gd.getDisplayMode().getHeight();
    ImageIcon image = new ImageIcon("asset/main2.png");
    JLabel labelimage = new JLabel(image);
    labelimage.setBounds(0,0,1440,900);
    dep.add(labelimage, 150);
  }

}
