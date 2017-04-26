package gui;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Created by ireneedriadr on 4/26/17.
 */
public class Load {
  private String[] name = new String[3];
  private int[] maxLv = new int[3];
  private int[] money = new int[3];
  private int[] truckLv = new int[3];

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

  public void LoadFile() {
    try(BufferedReader br = new BufferedReader(new FileReader("asset/player.txt"))) {
      String currentLine = null;
      int counter = 0;
      String pattern = "\\s*name\\s*:\\s*([^,]+)\\s*,\\s*maxLv\\s*:\\s*(\\d+)\\s*,\\s*money\\s*:\\s*(\\d+)\\s*,\\s*truckLv\\s*:\\s*(\\d+)\\s*";

      while((currentLine = br.readLine()) != null) {
         Pattern p = Pattern.compile(pattern);
         Matcher m = p.matcher(currentLine);

         if(m.find()) {
           name[counter] = m.group(1);
           maxLv[counter] = Integer.parseInt(m.group(2));
           money[counter] = Integer.parseInt(m.group(3));
           truckLv[counter] = Integer.parseInt(m.group(4));
         }

        counter++;
      }
    }
    catch(IOException e) {
      e.printStackTrace();
    }
  }
}
