package player;

/**
 * Class real Player yang merepresentasikan pemain dalam game FlowerDay.
 * Player memiliki nama, stage terakhir yang sudah terbuka, dan level truck.
 *
 * @author Ferdinandus Richard
 * Created on 22-Apr-2017.
 */
public class Player {
  /** Nama player. */
  private final String name;
  /** Stage terakhir dalam game yang bisa dimainkan. */
  private int lastStageOpened;
  /** Level truck yang menentukan waktu yang diperlukan untuk penjualan. */
  private int truckLevel;
  /**
   * Uang player dalam game dalam satuan Wonder.
   * Uang dipakai untuk melakukan <code>upgradeTruck</code>.
   */
  private int money;

  /**
   * Constructor default.
   * @param playerName nama player yang akan dibuat
   */
  public Player(String playerName) {
    name = playerName;
    lastStageOpened = 0;
    truckLevel = 1;
  }

  /**
   * Constructor dengan parameter.
   * Constructor ini digunakan untuk pembentukan player yang sudah ada datanya.
   * @param playerName nama player yang akan dibuat
   * @param lastStage stage terakhir yang bisa dimainkan dalam game
   * @param truckLv level truck player yang akan dibentuk
   */
  public Player(String playerName, int lastStage, int truckLv) {
    name = playerName;
    lastStageOpened = lastStage;
    truckLevel = truckLv;
  }

  /**
   * Getter untuk nama player dalam game.
   * @return <code>name</code>
   */
  public String getName() {
    return name;
  }

  /**
   * Getter untuk mendapatkan stage terakhir yang bisa dimainkan dalam game.
   * @return <code>lastStageOpened</code>
   */
  public int getLastStageOpened() {
    return lastStageOpened;
  }

  /**
   * Setter untuk mengubah stage terakhir yang bisa dimainkan dalam game.
   * @param lastStage stage terakhir yang bisa dimainkan <code>Player</code>
   */
  public void setLastStageOpened(int lastStage) {
    lastStageOpened = lastStage;
  }

  /**
   * Method untuk melakukan upgrade truck menjadi lebih cepat.
   * Meningkatkan nilai dari <code>truckLevel</code>
   */
  public void upgradeTruck() {
    truckLevel++;
  }

  /**
   * Getter untuk level truck yang dipakai dalam game.
   * @return <code>truckLevel</code>
   */
  public int getTruckLevel() {
    return truckLevel;
  }

  /**
   * Method untuk menambahkan uang player setelah memenangkan sebuah stage.
   * @param amount jumlah uang yang ingin ditambahkan ke player dalam Wonders
   */
  public void addMoney(int amount) {
    money += amount;
  }

  /**
   * Getter untuk uang player dalam game.
   * @return <code>money</code>
   */
  public int getMoney() {
    return money;
  }
}
