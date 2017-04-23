package stage;

import plant.Flower;

/**
 * Class StageController.
 * Class controller untuk mengatur model <code>Stage</code>
 *
 * @author Ferdinandus Richard
 * Created on 22-Apr-2017.
 */
public class StageController {
  private Stage stage;
  /**
   * Constructor.
   * @param stageLv level stage yang akan dibuat
   * @param truckLv level truck yang akan dipakai dalam stage
   */
  public StageController(int stageLv, int truckLv) {
    stage = new Stage(stageLv, truckLv);
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
   * Method untuk menyiram bunga dalam stage yang diatur.
   * @param row urutan baris bunga yang disiram
   * @param col urutan kolom bunga yang disiram
   */
  public void waterFlowerInStage(int row, int col) {
    stage.waterFlower(row, col);
  }

  /**
   * Method untuk membeli pot dalam stage yang diatur.
   */
  public void buyPotInStage() {
    stage.buyPot();
  }

  /**
   * Method untuk membeli bunga tertentu yang tersedia di panel stage.
   * @param _flowerToBeAdded flower yang ingin ditambahkan ke stage
   * @param row baris tempat flower akan ditambahkan
   * @param col kolom tempat flower akan ditambahkan
   */
  public void buyFlowerInStage(Flower _flowerToBeAdded, int row, int col) {
    stage.buyFlower();
  }
}

