package stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.StringBuffer;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import plant.PlantController;

/**
 * Kelas real untuk menyimpan atribut-atribut dan behaviour pada stage.
 *
 * @author Ferdinandus Richard
 * @author Irene Edria
 * @author Reinhard Linardi
 * @version 22-Apr-2017
 */
class Stage {

  /**
   * Konstanta untuk default waktu menjual bunga.
   */
  private final int defaultDeliveryTime = 10000;

  /**
   * Level stage yang akan dibentuk.
   */
  private final int level;
  /**
   * Uang dalam stage yang bisa digunakan untuk membeli pot dan bunga.
   */
  private int inGameMoney;
  /**
   * Target uang yang harus dipenuhi player untuk memenangkan stage.
   */
  private int targetMoney;
  /**
   * Limit waktu dalam detik yang tersedia untuk memainkan stage.
   */
  private int timeLimit;
  /**
   * Level truck yang dipakai dalam stage untuk melakukan penjualan.
   */
  private final int levelOfTruck;
  /**
   * Banyaknya pendapatan yang akan didapat jika dilakukan penjualan.
   */
  private int income;
  /**
   * Banyaknya pot yang ada di stage.
   */
  private int pots;
  /**
   * Matrix untuk menyimpan tanaman yang ditanam oleh player.
   */
  private PlantController[][] plants;
  /**
   * String untuk menandakan button yang sedang diklik oleh user.
   */
  private StringBuffer activeButton;

  /**
   * Konstruktor.
   *
   * @param stageLevel level stage yang akan dibentuk
   * @param truckLv level dari truck yang akan dibentuk dalam stage
   */
  Stage(int stageLevel, int truckLv) {
    // Inisiasi atribut-atribut yang dimiliki stage
    level = stageLevel;
    levelOfTruck = truckLv;
    income = 0;
    pots = 2;
    plants = new PlantController[3][3];
    // Menambahkan 2 pot pada awal permainan
    plants[0][0] = new PlantController();
    plants[0][1] = new PlantController();
    // Membaca file eksternal untuk data stage
    activeButton = new StringBuffer("null");
    String filename = "asset/stageconf.txt";
    String line = null;
    // Penanganan exception
    try {
      int cnt = 0;
      FileReader fileReader = new FileReader(filename);
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      while ((line = bufferedReader.readLine()) != null) {
        cnt++;
        String pattern = "^\\s*startMoney\\s*:\\s*(\\d+)\\s*,"
            + "\\s*targetMoney\\s*:\\s*(\\d+)\\s*,"
            + "\\s*timeLimit\\s*:\\s*(\\d+)\\s*$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(line);
        if (m.find() && cnt == stageLevel) {
          inGameMoney = Integer.parseInt(m.group(1));
          targetMoney = Integer.parseInt(m.group(2));
          timeLimit = Integer.parseInt(m.group(3));
        }
      }
      bufferedReader.close();
    } catch (FileNotFoundException e) {
      System.exit(0);
    } catch (IOException e) {
      System.exit(0);
    }
  }

  /**
   * Getter dari level yang sedang dimainkan.
   *
   * @return <code>level</code>
   */
  int getLevel() {
    return level;
  }

  /**
   * Getter untuk mendapatkan uang di dalam stage.
   *
   * @return <code>inGameMoney</code>
   */
  int getInGameMoney() {
    return inGameMoney;
  }

  /**
   * Getter untuk mendapatkan target uang untuk memenangkan stage.
   *
   * @return <code>targetMoney</code>
   */
  int getTargetMoney() {
    return targetMoney;
  }

  /**
   * Getter untuk mendapatkan batas waktu untuk memainkan stage.
   *
   * @return <code>timeLimit</code>
   */
  int getTimeLimit() {
    return timeLimit;
  }

  /**
   * Getter untuk mendapatkan level dari truck yang dipakai dalam stage.
   *
   * @return <code>levelOfTruck</code>
   */
  final int getLevelOfTruck() {
    return levelOfTruck;
  }

  /**
   * Getter untuk mendapatkan income yang bisa didapat dengan menjual bunga.
   *
   * @return <code>income</code>
   */
  int getIncome() {
    return income;
  }

  /**
   * Getter untuk mendapatkan banyaknya pot yang ada di dalam stage.
   *
   * @return <code>pots</code>
   */
  int getPots() {
    return pots;
  }

  /**
   * Getter untuk mendapatkan matrix of PlantController.
   *
   * @return <code>plants</code>
   */
  PlantController[][] getPlants() {
    return plants;
  }

  /**
   * Setter untuk uang stage.
   *
   * @param inGameMoney uang stage yang ingin dimasukkan
   */
  void setInGameMoney(int inGameMoney) {
    this.inGameMoney = inGameMoney;
  }

  /**
   * Method untuk menjual bunga yang sudah dipanen.
   */
  void sellFlowers() {
    final int incomeToBeAdded = income;
    income = 0;
    long deliveryTime = defaultDeliveryTime - ((levelOfTruck - 1) * 1500);
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
        timer.purge();
      }
    };
    timer.schedule(deliveryTask, 30);
  }


  /**
   * Method untuk memanen bunga yang sudah ditanam di pot.
   *
   * @param row baris tempat bunga akan dipanen
   * @param col kolom tempat bunga akan dipanen
   */
  void harvestFlower(int row, int col) {
    income += plants[row][col].harvest();
    plants[row][col] = new PlantController();
  }

  /**
   * Method untuk menambahkan flower ke dalam stage.
   *
   * @param flowerName flower yang akan ditambahkan ke matrix flowers
   * @param row baris tempat bunga akan ditambahkan
   * @param col kolom tempat bunga akan ditambahkan
   */
  void buyFlower(String flowerName, int row, int col) {
    plants[row][col].addFlowerToPot(flowerName);
  }

  /**
   * Method untuk menambahkan pot yang baru dibeli ke dalam stage.
   */
  public void buyPot() {
    pots++;
    int row = (pots - 1) / 3;
    int col = (pots - 1) % 3;
    plants[row][col] = new PlantController();
  }

  /**
   * Method untuk menyiram air ke bunga yang ada di baris row dan kolom col.
   *
   * @param row baris tempat bunga yang akan disiram
   * @param col kolom tempat bunga yang akan disiram
   */
  void waterFlower(int row, int col) {
    plants[row][col].growTheFlower();
  }
}