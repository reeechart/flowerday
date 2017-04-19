package main;

import gui.DisplayMenu;

import javax.swing.*;

/**
 * Created by ireneedriadr on 4/19/17.
 */
public class Main {
  public static void main(String a[]) {

    DisplayMenu fr = new DisplayMenu();
    fr.setSize(1440,900);
    fr.setVisible(true);
    fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }
}
