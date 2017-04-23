package stage;

import java.util.Timer;
import java.util.TimerTask;
import plant.Flower;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Class Stage.
 *
 * @author Ferdinandus Richard
 * Created on 22-Apr-2017.
 */
public class Stage {
  /** Level stage yang akan dibentuk. */
  private final int level;
  /** Uang dalam stage yang bisa digunakan untuk membeli pot dan bunga. */
  private int inGameMoney;
  /** Target uang yang harus dipenuhi player untuk memenangkan stage. */
  private int targetMoney;
  /** Limit waktu dalam detik yang tersedia untuk memainkan stage. */
  private int timeLimit;
  /** Level truck yang dipakai dalam stage untuk melakukan penjualan. */
  private final int levelOfTruck;
  /** Banyaknya pendapatan yang akan didapat jika dilakukan penjualan. */
  private int income;
  /** Banyaknya pot yang ada di stage */
  private int pots;
  /** Array untuk menyimpan bunga yang ditanam oleh player */
  private Flower[][] flowers;
  /** Array boolean untuk menyatakan keberadaan pot dalam */
  private boolean[][] isPotAvailable;
  private final int DEFAULT_TARGET = 150;
  private final int DEFAULT_MONEY = 30;
  private final int DEFAULT_TIME_LIMIT = 120;
  private final int TARGET_GROWTH = 45;
  private final int DEFAULT_DELIVERY_TIME = 10000;

  /**
   * Constructor.
   * @param stageLevel level stage yang akan dibentuk
   * @param truckLv level dari truck yang akan dibentuk dalam stage
   */
  public Stage(int stageLevel, int truckLv) {
    level = stageLevel;
    inGameMoney = DEFAULT_MONEY + (15*(stageLevel-1));
    targetMoney = DEFAULT_TARGET + (70*(stageLevel)-1);
    if (stageLevel > 4) {
      targetMoney += TARGET_GROWTH;
    }
    timeLimit = DEFAULT_TIME_LIMIT;
    levelOfTruck = truckLv;
    income = 0;
    pots = 2;
    flowers = new Flower[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        isPotAvailable[i][j] = false;
      }
    }
    isPotAvailable[0][0] = true;
    isPotAvailable[0][1] = true;
  }

  /**
   * Getter untuk mendapatkan uang di dalam game
   * @return <code>inGameMoney</code>
   */
  public int getInGameMoney() {
    return inGameMoney;
  }

  /**
   * Getter untuk mendapatkan seluruh flower yang ada di stage
   * @return <code>flowers</code>
   */
  public Flower[][] getFlowers() {
    return flowers;
  }

  /**
   * Method untuk menjual bunga yang sudah dipanen.
   */
  public void sellFlower() {
    if (income != 0) {
     final int incomeToBeAdded = income;
      income = 0;
      long deliveryTime = DEFAULT_DELIVERY_TIME - ((levelOfTruck - 1) * 2000);
      Timer timer = new Timer();
      TimerTask deliveryTask = new TimerTask() {
        public void run() {
          long startTime = System.currentTimeMillis();
          // DISABLE SELL BUTTON, ANIMASI TRUCK JIKA PERLU
          while (System.currentTimeMillis() - startTime <= deliveryTime) {
            // wait until delivery is finished
          }
          inGameMoney += incomeToBeAdded;
          timer.cancel();
          return;
        }
      };
      timer.schedule(deliveryTask, 30);
    }
  }

  /**
   * Method untuk memanen bunga yang sudah ditanam di pot.
   * @param row baris tempat bunga akan dipanen
   * @param col kolom tempat bunga akan dipanen
   */
  public void harvestFlower(int row, int col) {
    // CEK KEBERADAAN POT DI CONTROLLER
    income += flowers[row][col].getPrice();
    flowers[row][col] = null;
    // HAPUS GAMBAR BUNGA DI LAYAR
  }

  /**
   * Method untuk menambahkan flower ke dalam stage.
   * @param flowerToBeAdded flower yang akan ditambahkan ke matrix flowers
   * @param row baris tempat bunga akan ditambahkan
   * @param col kolom tempat bunga akan ditambahkan
   */
  public void addFlower(Flower flowerToBeAdded, int row, int col) {
    flowers[row][col] = flowerToBeAdded;
    // TAMPILKAN BUNGA DI LAYAR DI pot[row][col]
  }

  /**
   * Method untuk menambahkan pot yang baru dibeli ke dalam stage.
   */
  public void addPot() {
    try {
      pots++;
      int row = (pots-1) / 3;
      int col = (pots-1) % 3;
      isPotAvailable[row][col] = true;
      // KELUARKAN GAMBAR POT DI MATRIX pot[row][col]
    } catch (ArrayIndexOutOfBoundsException e) {
      // DO NOTHING
    }
  }

  /**
   * Method untuk menyiram air ke bunga yang ada di baris row dan kolom col
   * @param row baris tempat bunga yang akan disiram
   * @param col kolom tempat bunga yang akan disiram
   */
  public void waterFlower(int row, int col) {
    flowers[row][col].grow();
    // UBAH GAMBAR FLOWER DI LAYAR JADI LEBIH BESAR
  }
}

