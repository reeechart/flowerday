package stage;

import player.Player;

/**
 * Class StageController.
 * Class controller untuk mengatur model <code>Stage</code>
 *
 * @author Ferdinandus Richard
 * Created on 22-Apr-2017.
 */
public class StageController {
  private Stage stage;
  private Player player;
  /**
   * Constructor.
   * @param stageLv level stage yang akan dibuat
   * @param truckLv level truck yang akan dipakai dalam stage
   */
  public StageController(int stageLv, int truckLv, Player player) {
    stage = new Stage(stageLv, truckLv);
    this.player = player;
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

  /**
   * Method untuk menambahkan uang ke player yang bermain dalam game
   * @param amount jumlah uang yang ingin ditambahkan ke player
   */
  public void addMoneyToPlayer(int amount) {
    player.addMoney(amount);
  }
}

