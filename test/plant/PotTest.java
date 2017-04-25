package plant;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Ferdinandus Richard
 * Created on 25-Apr-2017.
 */
public class PotTest {
  @Test
  public void testGetPriceMethod() {
    Pot pot = new Pot();
    assertTrue(pot.getPrice() == 100);
    System.out.println("Pot getPrice method correct.");
  }
}
