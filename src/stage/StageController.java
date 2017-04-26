package stage;

import player.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TimerTask;

/**
 * Kelas controller untuk mengatur model <code>Stage</code>.
 * Di sini akan diatur komunikasi antara input user, <code>Stage</code>,
 * dan <code>StageView</code>.
 *
 * @author Ferdinandus Richard
 * @author Irene Edria
 * @author Reinhard Benjamin
 * @version 22-Apr-2017
 */
public class StageController {

  /**
   * Model <code>Stage</code> yang diatur controller ini.
   */
  private Stage stage;
  /**
   * <code>StageView</code> yang diatur controller ini.
   */
  private StageView sview;
  /**
   * Dataa player yang sedang memainkan game ini.
   */
  private Player player;
  /**
   * Wadah untuk menampilkan pada layar.
   */
  private JDesktopPane dptemp;
  /**
   * Pengatur waktu untuk jalannya truk.
   */
  private Timer swingTimer;
  /**
   * Kumpulan <code>ActionListener</code> agar tombol dapat berkomunikasi.
   */
  private ArrayList<ActionListener> actionListenerList =
      new ArrayList<ActionListener>(9);
  /**
   * <code>ActionListener</code> untuk tombol pembelian mawar.
   */
  private ActionListener roseListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      stage.activeButton = new StringBuffer("rose");
    }
  };
  /**
   * <code>ActionListener</code> untuk tombol pembelian bunga matahari.
   */
  private ActionListener sunflowerListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      stage.activeButton = new StringBuffer("sunflower");
    }
  };
  /**
   * <code>ActionListener</code> untuk tombol pembelian kamomil.
   */
  private ActionListener chamomileListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      stage.activeButton = new StringBuffer("chamomile");
    }
  };
  /**
   * <code>ActionListener</code> untuk tombol pembelian anggrek.
   */
  private ActionListener orchidListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      stage.activeButton = new StringBuffer("orchid");
    }
  };
  /**
   * <code>ActionListener</code> untuk tombol penyiram bunga.
   */
  private ActionListener waterListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      stage.activeButton = new StringBuffer("water");

    }
  };
  /**
   * <code>ActionListener</code> untuk tombol gunting bunga.
   */
  private ActionListener harvestListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      stage.activeButton = new StringBuffer("harvest");
    }
  };

  private ActionListener sellListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      sendFlowersToTown(sellListener);
    }
  };
  /**
   * <code>ActionListener</code> untuk tombol pembelian pot.
   */
  private ActionListener potListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      buyPotInStage(plantListener);
    }
  };
  /**
   * <code>ActionListener</code> untuk tombol pot yang ada di taman.
   */
  private ActionListener plantListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      JButton source = (JButton) e.getSource();

      int potNumber = stage.getPots();
      int row;
      int col;
      int buttonRow = -1;
      int buttonCol = -1;

      for (int i = 0; i < potNumber; i++) {
        row = i / 3;
        col = i % 3;

        if (sview.field[row][col] == source) {
          buttonRow = row;
          buttonCol = col;
          break;
        }
      }
      if (stage.activeButton.toString().equals("rose")) {
        buyFlowerInStage("rose", buttonRow, buttonCol, plantListener);
      } else if (stage.activeButton.toString().equals("chamomile")) {
        buyFlowerInStage("chamomile", buttonRow, buttonCol, plantListener);
      } else if (stage.activeButton.toString().equals("orchid")) {
        buyFlowerInStage("orchid", buttonRow, buttonCol, plantListener);
      } else if (stage.activeButton.toString().equals("sunflower")) {
        buyFlowerInStage("sunflower", buttonRow, buttonCol, plantListener);
      } else if (stage.activeButton.toString().equals("water")) {
        waterFlowerInStage(buttonRow, buttonCol, plantListener);
      } else if (stage.activeButton.toString().equals("harvest")) {
        harvestFlowerInStage(buttonRow, buttonCol, plantListener);
      }
    }
  };

  /**
   * Konstruktor.
   *
   * @param dp Pane yang digunakan
   * @param stageLv level stage yang akan dibuat
   * @param truckLv level truck yang akan dipakai dalam stage
   * @param p <code>Player</code> yang sedang bermain
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
    sview = new StageView(stage, dptemp, player, stageLv, actionListenerList);
    sview.updatePlayerMoney(dptemp, stage, player);
    java.util.Timer timer = new java.util.Timer();
    TimerTask endGame = new TimerTask() {
      @Override
      public void run() {
        boolean f = true;
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime <= stage.getTimeLimit() * 1000) {
          // wait until delivery is finished
        }
        endGame();
        timer.cancel();
        timer.purge();
      }
    };
    timer.schedule(endGame, 30);
  }

  /**
   * Method untuk mengirim bunga ke kota. Akan dipanggil method penjualan
   * dari kelas <code>Stage</code>.
   * I.S.: Stage beserta atributnya terisi.
   * F.S.: Truk berangkat dan setelah waktu menjual truk habis, uang ditambah
   * serta truk akan berjalan kembali ke tempat semula.
   *
   * @param a <code>ActionListener</code> yang sedang aktif
   */
  public void sendFlowersToTown(ActionListener a) {
    if (stage.getIncome() > 0) {
      sview.moveTruckToCity(dptemp);
      stage.sellFlowers();
      int delay = 11000 - ((player.getTruckLevel() - 1) * 1500);
      sview.updateIncome(dptemp, stage, a);

      ActionListener task = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          sview.updateMoney(dptemp, stage);
          sview.moveTruckToWonderVillage(dptemp);
          swingTimer.stop();
        }
      };
      swingTimer = new Timer(delay, task);
      swingTimer.setRepeats(false);
      swingTimer.start();
    }
  }

  /**
   * Method untuk memanen bunga di stage yang diatur.
   * I.S. : Stage terdefinisi dengan ada flower di baris row dan kolom col.
   * F.S. : Flower di baris row dan kolom col dipanen dan income bertambah.
   *
   * @param row urutan baris bunga dalam stage yang diatur
   * @param col urutan kolom bunga dalam stage yang diatur
   * @param a <code>ActionListener</code> yang sedang aktif
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
   * @param flowerName nama flower yang ingin ditambahkan ke stage
   * @param row baris tempat flower akan ditambahkan
   * @param col kolom tempat flower akan ditambahkan
   * @param a <code>ActionListener</code> yang sedang aktif
   */
  public void buyFlowerInStage(String flowerName, int row, int col, ActionListener a) {
    int stageMoney = stage.getInGameMoney();
    int flowerPrice = stage.getPlants()[row][col].getFlowerPrice(flowerName);
    if (stageMoney >= flowerPrice) {
      stage.setInGameMoney(stageMoney - flowerPrice);
      stage.buyFlower(flowerName, row, col);
      sview.updatePot(dptemp, stage, row, col, a);
    }
  }

  /**
   * Method untuk membeli pot dalam stage yang diatur.
   * I.S. : Stage beserta atributnya terdefinisi.
   * F.S. : Pot ditambahkan berdasar kapasitas dari pot dalam stage.
   *
   * @param a <code>ActionListener</code> yang sedang aktif
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
   * @param a <code>ActionListener</code> yang sedang aktif
   */
  public void waterFlowerInStage(int row, int col, ActionListener a) {
    stage.waterFlower(row, col);
    int delay = 1400;
    ActionListener waterTask = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        sview.updatePot(dptemp, stage, row, col, a);
        swingTimer.stop();
      }
    };
    swingTimer = new Timer(delay, waterTask);
    swingTimer.setRepeats(false);
    swingTimer.start();
  }

  /**
   * Aksi yang akan dilakukan setelah timer habis.
   * I.S.: Timer habis.
   * F.S.: Ditampilkan windows baru yang menyatakan player menang atau kalah.
   */
  public void endGame() {
    int status;
    if (stage.getInGameMoney() >= stage.getTargetMoney()) {
      status = 1;
      int x = player.getLastStageOpened();
      x++;
      player.setLastStageOpened(x);
      player.addMoney(stage.getInGameMoney() * 50 / 100);
    } else {
      status = 0;
    }
    sview.endStageView(stage, dptemp, status, player);
  }

}