package stage;

import plant.PlantController;
import player.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.StringBuffer;
import java.util.ArrayList;

/**
 * Class StageController.
 * Class controller untuk mengatur model <code>Stage</code>
 *
 * @author Ferdinandus Richard
 * Created on 22-Apr-2017.
 */
public class StageController {
  private Stage stage;
  private StageView sview;
  private Player player;
  JDesktopPane dptemp = new JDesktopPane();
  private ArrayList<ActionListener> actionListenerList = new ArrayList<ActionListener>(9);

  ActionListener roseListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      stage.activeButton = new StringBuffer("rose");
    }
  };

  ActionListener sunflowerListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      stage.activeButton = new StringBuffer("sunflower");
    }
  };

  ActionListener chamomileListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      stage.activeButton = new StringBuffer("chamomile");
    }
  };

  ActionListener orchidListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      stage.activeButton = new StringBuffer("orchid");
    }
  };



  ActionListener waterListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      stage.activeButton = new StringBuffer("water");

    }
  };

  ActionListener harvestListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      stage.activeButton = new StringBuffer("harvest");
    }
  };

  ActionListener sellListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      sendFlowersToTown(sellListener);
    }
  };

  ActionListener potListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      buyPotInStage(plantListener);
    }
  };

  ActionListener plantListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      JButton source = (JButton)e.getSource();

      int potNumber = stage.getPots();
      int row,col;
      int buttonRow = -1;
      int buttonCol = -1;

      for(int i=0;i<potNumber;i++) {
        row = i/3;
        col = i%3;

        if(sview.field[row][col] == source) {
          buttonRow = row;
          buttonCol = col;
          break;
        }
      }


      if(stage.activeButton.toString().equals("rose")) { buyFlowerInStage("rose", buttonRow, buttonCol, plantListener); }
      else if(stage.activeButton.toString().equals("chamomile")) { buyFlowerInStage("chamomile", buttonRow, buttonCol, plantListener); }
      else if(stage.activeButton.toString().equals("orchid"))  { buyFlowerInStage("orchid", buttonRow, buttonCol, plantListener); }
      else if(stage.activeButton.toString().equals("sunflower"))  { buyFlowerInStage("sunflower", buttonRow, buttonCol, plantListener); }
      else if(stage.activeButton.toString().equals("water"))  { waterFlowerInStage(buttonRow, buttonCol, plantListener);}
      else if(stage.activeButton.toString().equals("harvest"))  { harvestFlowerInStage(buttonRow, buttonCol, plantListener); }

      stage.activeButton = new StringBuffer("null");
    }
  };

  /**
   * Constructor.
   * @param stageLv level stage yang akan dibuat
   * @param truckLv level truck yang akan dipakai dalam stage
   */
  public StageController(JDesktopPane dp, int stageLv, int truckLv, Player p) {
    actionListenerList.add(roseListener);
    actionListenerList.add(sunflowerListener);
    actionListenerList.add(chamomileListener);
    actionListenerList.add(orchidListener);
    actionListenerList.add(potListener);
    actionListenerList.add(plantListener);
    actionListenerList.add(waterListener);
    actionListenerList.add(harvestListener);
    actionListenerList.add(sellListener);
    player = p;
    dptemp = dp;
    stage = new Stage(stageLv, truckLv);
    sview = new StageView(stage, this, dptemp, player, stageLv, actionListenerList);
  }

  public void sendFlowersToTown(ActionListener a) {
    if (stage.getIncome() > 0) {
      stage.sellFlowers();
      int delay = 11000;
      sview.updateIncome(dptemp, stage, a);
      ActionListener task = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          sview.updateMoney(dptemp, stage);
        }
      };
      new Timer(delay, task).start();

    }
  }

  /**
   * Method untuk memanen bunga di stage yang diatur.
   * @param row urutan baris bunga dalam stage yang diatur
   * @param col urutan kolom bunga dalam stage yang diatur
   */
  public void harvestFlowerInStage(int row, int col, ActionListener a) {
    stage.harvestFlower(row, col);
    sview.updatePot(dptemp, stage, row, col, a);
    sview.updateIncome(dptemp, stage, a);
  }

  /**
   * Method untuk membeli bunga tertentu yang tersedia di panel stage.
   * @param _flowerName nama flower yang ingin ditambahkan ke stage
   * @param row baris tempat flower akan ditambahkan
   * @param col kolom tempat flower akan ditambahkan
   */
  public void buyFlowerInStage(String _flowerName, int row, int col, ActionListener a) {
    int stageMoney = stage.getInGameMoney();
    int flowerPrice = stage.getPlants()[row][col].getFlowerPrice(_flowerName);
    if (stageMoney >= flowerPrice) {
      stage.setInGameMoney(stageMoney - flowerPrice);
      stage.buyFlower(_flowerName, row, col);
      sview.updatePot(dptemp, stage, row, col, a);
    }
  }

  /**
   * Method untuk membeli pot dalam stage yang diatur.
   */
  public void buyPotInStage(ActionListener a) {
    int stageMoney = stage.getInGameMoney();
    int potPrice = stage.getPlants()[0][0].getPotPrice();
    if ((stageMoney >= potPrice) && (stage.getPots() < 9)) {
      stage.setInGameMoney(stageMoney - potPrice);
      stage.buyPot();
      sview.newPot(dptemp, stage, a);
    }
  }

  /**
   * Method untuk menyiram bunga dalam stage yang diatur.
   * @param row urutan baris bunga yang disiram
   * @param col urutan kolom bunga yang disiram
   */
  public void waterFlowerInStage(int row, int col, ActionListener a) {
    stage.waterFlower(row, col);
    sview.updatePot(dptemp, stage, row, col, a);
  }
}