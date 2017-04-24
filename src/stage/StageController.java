package stage;

import player.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringBuffer;
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
  private ArrayList<ActionListener> actionListenerList;

  ActionListener roseListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      stage.activeButton = new StringBuffer("rose");
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

  ActionListener sunflowerListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      stage.activeButton = new StringBuffer("sunflower");
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
      sendFlowersToTown();
    }
  };

  ActionListener potListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      buyPotInStage();
    }
  };

  ActionListener plantListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      JButton source = (JButton)e.getSource();

      int potNumber = stage.getPots();
      int row,col;
      int buttonRow,buttonCol;

      for(int i=0;i<potNumber;i++) {
        row = i/3;
        col = i%3;

        if(sview.field[row][col] == source) {
          buttonRow = row;
          buttonCol = col;
          break;
        }
      }

      if(stage.activeButton.equals("rose")) { buyFlowerInStage("rose", buttonRow, buttonCol); }
      else if(stage.activeButton.equals("chamomile")_ { buyFlowerInStage("chamomile", buttonRow, buttonCol); }
      else if(stage.activeButton.equals("orchid"))  { buyFlowerInStage("orchid", buttonRow, buttonCol); }
      else if(stage.activeButton.equals("sunflower"))  { buyFlowerInStage("sunflower", buttonRow, buttonCol); }
      else if(stage.activeButton.equals("water"))  { waterFlowerInStage(buttonRow, buttonCol);}
      else if(stage.activeButton.equals("harvest"))  { harvestFlowerInStage(buttonRow, buttonCol); }

      activeButton = new StringBuffer("null");
    }
  };

  actionListenerList.add(roseListener);
  actionListenerList.add(sunflowerListener);
  actionListenerList.add(chamomileListener);
  actionListenerList.add(orchidListener);
  actionListenerList.add(potListener);
  actionListenerList.add(plantListener);
  actionListenerList.add(waterListener);
  actionListenerList.add(harvestListener);
  actionListenerList.add(sellListener);

  /**
   * Constructor.
   * @param stageLv level stage yang akan dibuat
   * @param truckLv level truck yang akan dipakai dalam stage
   */
  public StageController(JDesktopPane dp, int stageLv, int truckLv, Player p) {
    player = p;
    stage = new Stage(stageLv, truckLv);
    sview = new StageView(this, dp, player, stageLv, actionListenerList);
  }

  public void sendFlowersToTown() {
    if (stage.getIncome() > 0) {
      stage.sellFlowers();
    }
  }

  /**
   * Method untuk memanen bunga di stage yang diatur.
   * @param row urutan baris bunga dalam stage yang diatur
   * @param col urutan kolom bunga dalam stage yang diatur
   */
  public void harvestFlowerInStage(int row, int col) {
    stage.harvestFlower(row, col);
  }

  /**
   * Method untuk membeli bunga tertentu yang tersedia di panel stage.
   * @param _flowerName nama flower yang ingin ditambahkan ke stage
   * @param row baris tempat flower akan ditambahkan
   * @param col kolom tempat flower akan ditambahkan
   */
  public void buyFlowerInStage(String _flowerName, int row, int col) {
    int stageMoney = stage.getInGameMoney();
    int flowerPrice = stage.getPlants()[row][col].getFlowerPrice(_flowerName);
    if (stageMoney >= flowerPrice) {
      stage.setInGameMoney(stageMoney - flowerPrice);
      stage.buyFlower(_flowerName, row, col);
    }
  }

  /**
   * Method untuk membeli pot dalam stage yang diatur.
   */
  public void buyPotInStage() {
    int stageMoney = stage.getInGameMoney();
    int potPrice = stage.getPlants()[0][0].getPotPrice();
    if ((stageMoney >= potPrice) && (stage.getPots() < 9)) {
      stage.setInGameMoney(stageMoney - potPrice);
      stage.buyPot();
      //sview.addPot();
    }
  }

  /**
   * Method untuk menyiram bunga dalam stage yang diatur.
   * @param row urutan baris bunga yang disiram
   * @param col urutan kolom bunga yang disiram
   */
  public void waterFlowerInStage(int row, int col) {
    stage.waterFlower(row, col);
  }
}