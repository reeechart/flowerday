package stage;

import plant.Flower;

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

  /**
   * Constructor.
   * @param stageLevel level stage yang akan dibentuk
   * @param truckLv level dari truck yang akan dibentuk dalam stage
   */
  public Stage(int stageLevel, int truckLv) {
    level = stageLevel;
    inGameMoney = 30 + (15*(stageLevel-1));
    targetMoney = 500 + (70*(stageLevel)-1);
    if (stageLevel > 4) {
      targetMoney += 45;
    }
    timeLimit = 120;
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
   * Method untuk menjual bunga yang sudah dipanen.
   */
  public void sellFlower() {
    if (income != 0) {
      // DISABLE SELL BUTTON, ANIMASI TRUCK JIKA PERLU
      // BUAT THREAD UNTUK HITUNG WAKTU SELAMA 3 DETIK
      int duration = 3000 - ((levelOfTruck-1)*1000);
      // SLEEP THREAD SELAMA DURATION
      inGameMoney += income;
      income = 0;
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
}

