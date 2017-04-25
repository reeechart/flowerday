package stage;

import player.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TimerTask;

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
  private JDesktopPane dptemp;
  private Timer swing_timer;
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
    sview.updatePlayerMoney(dptemp, stage, player);
    java.util.Timer timer = new java.util.Timer();
    TimerTask endGame = new TimerTask() {
      @Override
      public void run() {
        boolean f = true;
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime <= stage.getTimeLimit()*1000) {
          // wait until delivery is finished
        }
        endGame();
        timer.cancel();
        timer.purge();
      }
    };
    timer.schedule(endGame, 30);
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
          swing_timer.stop();
        }
      };
      swing_timer = new Timer(delay, task);
      swing_timer.setRepeats(false);
      swing_timer.start();
    }
  }

  /**
   * Method untuk memanen bunga di stage yang diatur.
   * I.S. : Stage terdefinisi dengan ada flower di baris row dan kolom col.
   * F.S. : Flower di baris row dan kolom col dipanen dan income bertambah.
   *
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
   * I.S. : Stage beserta atributnya terdefinisi.
   * F.S. : Flower dengan nama <code>_flowerPot</code> berhasil ditambahkan.
   *
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
   * I.S. : Stage beserta atributnya terdefinisi.
   * F.S. : Pot ditambahkan berdasar kapasitas dari pot dalam stage.
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
   * I.S. : Stage beserta atributnya terdefinisi.
   * F.S. : Flower di baris row dan kolom col berhasil disiram.
   *
   * @param row urutan baris bunga yang disiram
   * @param col urutan kolom bunga yang disiram
   */
  public void waterFlowerInStage(int row, int col, ActionListener a) {
    stage.waterFlower(row, col);
    int delay = 3400;
    ActionListener waterTask = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        sview.updatePot(dptemp, stage, row, col, a);
        swing_timer.stop();
      }
    };
    swing_timer = new Timer(delay, waterTask);
    swing_timer.setRepeats(false);
    swing_timer.start();
  }

  public void endGame() {
    int status;
    if (stage.getInGameMoney() >= stage.getTargetMoney()) {
      status = 1;
      int x = player.getLastStageOpened();
      x++;
      player.setLastStageOpened(x);
      player.addMoney(stage.getInGameMoney()*50/100);
    }
    else {
      status = 0;
    }
    sview.endStageView(stage, dptemp, status, player);
  }
}