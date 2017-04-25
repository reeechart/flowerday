package stage;

import java.util.Timer;
import java.util.TimerTask;
import java.lang.StringBuffer;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import plant.PlantController;

/**
 * Class Stage.
 *
 * @author Ferdinandus Richard
 * Created on 22-Apr-2017.
 */
public class Stage {
  private final int DEFAULT_DELIVERY_TIME = 10000;

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
  /** Matrix untuk menyimpan tanaman yang ditanam oleh player */
  private PlantController[][] plants;
  /** String untuk menandakan button yang sedang diklik oleh user */
  public StringBuffer activeButton;

  /**
   * Constructor.
   * @param stageLevel level stage yang akan dibentuk
   * @param truckLv level dari truck yang akan dibentuk dalam stage
   */
  public Stage(int stageLevel, int truckLv) {
    level = stageLevel;
    levelOfTruck = truckLv;
    income = 0;
    pots = 2;

    plants = new PlantController[3][3];

    plants[0][0] = new PlantController();
    plants[0][1] = new PlantController();

    activeButton = new StringBuffer("null");

    String filename = "asset/stageconf.txt";
    String line = null;

    try
    {
      int cnt = 0;

      FileReader fileReader = new FileReader(filename);
      BufferedReader bufferedReader = new BufferedReader(fileReader);

      while ((line = bufferedReader.readLine()) != null) {
        cnt++;
        String pattern = "^\\s*startMoney\\s*:\\s*(\\d+)\\s*,\\s*targetMoney\\s*:\\s*(\\d+)\\s*,\\s*timeLimit\\s*:\\s*(\\d+)\\s*$";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(line);

        if(m.find() && cnt == stageLevel) {
         inGameMoney = Integer.parseInt(m.group(1));
         targetMoney = Integer.parseInt(m.group(2));
         timeLimit = Integer.parseInt(m.group(3));
        }
      }

      bufferedReader.close();
    }
    catch(FileNotFoundException e) {
      // do something here
    }
    catch(IOException e) {
      // do something here
    }
  }

  public int getLevel() {
    return level;
  }

  /**
   * Getter untuk mendapatkan uang di dalam stage.
   * @return <code>inGameMoney</code>
   */
  public int getInGameMoney() {
    return inGameMoney;
  }

  /**
   * Getter untuk mendapatkan target uang untuk memenangkan stage.
   * @return <code>targetMoney</code>
   */
  public int getTargetMoney() {
    return targetMoney;
  }

  /**
   * Getter untuk mendapatkan batas waktu untuk memainkan stage.
   * @return <code>timeLimit</code>
   */
  public int getTimeLimit() {
    return timeLimit;
  }

  /**
   * Getter untuk mendapatkan level dari truck yang dipakai dalam stage.
   * @return <code>levelOfTruck</code>
   */
  public final int getLevelOfTruck() {
    return levelOfTruck;
  }

  /**
   * Getter untuk mendapatkan income yang bisa didapat dengan menjual bunga.
   * @return <code>income</code>
   */
  public int getIncome() {
    return income;
  }

  /**
   * Getter untuk mendapatkan banyaknya pot yang ada di dalam stage.
   * @return <code>pots</code>
   */
  public int getPots() {
    return pots;
  }

  /**
   * Getter untuk mendapatkan matrix of PlantController.
   * @return <code>plants</code>
   */
  public PlantController[][] getPlants() {
    return plants;
  }

  public void setInGameMoney(int _inGameMoney) {
    inGameMoney = _inGameMoney;
  }

  /**
   * Method untuk menjual bunga yang sudah dipanen.
   */
  public void sellFlowers() {
    final int incomeToBeAdded = income;
    income = 0;
    long deliveryTime = DEFAULT_DELIVERY_TIME - ((levelOfTruck - 1) * 1500);
    Timer timer = new Timer();
    TimerTask deliveryTask = new TimerTask() {
      @Override
      public void run() {
        long startTime = System.currentTimeMillis();
        // DISABLE SELL BUTTON, ANIMASI TRUCK JIKA PERLU
        while (System.currentTimeMillis() - startTime <= deliveryTime) {
          // wait until delivery is finished
        }
        inGameMoney += incomeToBeAdded;
        timer.cancel();
      }
    };
    timer.schedule(deliveryTask, 30);
  }


  /**
   * Method untuk memanen bunga yang sudah ditanam di pot.
   * @param row baris tempat bunga akan dipanen
   * @param col kolom tempat bunga akan dipanen
   */
  public void harvestFlower(int row, int col) {
    // CEK KEBERADAAN POT DI CONTROLLER
    income += plants[row][col].harvest();
    plants[row][col] = new PlantController();
    // HAPUS GAMBAR BUNGA DI LAYAR
  }

  /**
   * Method untuk menambahkan flower ke dalam stage.
   * @param flowerName flower yang akan ditambahkan ke matrix flowers
   * @param row baris tempat bunga akan ditambahkan
   * @param col kolom tempat bunga akan ditambahkan
   */
  public void buyFlower(String flowerName, int row, int col) {
    plants[row][col].addFlowerToPot(flowerName);
    // TAMPILKAN BUNGA DI LAYAR DI pot[row][col]
  }

  /**
   * Method untuk menambahkan pot yang baru dibeli ke dalam stage.
   */
  public void buyPot() {
    pots++;
    int row = (pots - 1) / 3;
    int col = (pots - 1) % 3;
    plants[row][col] = new PlantController();
    // KELUARKAN GAMBAR POT DI MATRIX pot[row][col]
  }

  /**
   * Method untuk menyiram air ke bunga yang ada di baris row dan kolom col
   * @param row baris tempat bunga yang akan disiram
   * @param col kolom tempat bunga yang akan disiram
   */
  public void waterFlower(int row, int col) {
    plants[row][col].growTheFlower();

    // UBAH GAMBAR FLOWER DI LAYAR JADI LEBIH BESAR
  }
}