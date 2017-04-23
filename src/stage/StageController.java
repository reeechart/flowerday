package stage;

/**
 * Class StageController.
 * Class controller untuk mengatur model <code>Stage</code>
 *
 * @author Ferdinandus Richard
 * Created on 22-Apr-2017.
 */
public class StageController {
  /**
   * Constructor.
   * @param stageLv level stage yang akan dibuat
   * @param truckLv level truck yang akan dipakai dalam stage
   */
  public StageController(int stageLv, int truckLv) {
    new Stage(stageLv, truckLv);
  }
}
