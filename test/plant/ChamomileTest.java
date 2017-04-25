package plant;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Ferdinandus Richard
 * Created on 25-Apr-2017.
 */
public class ChamomileTest {
  @Test
  public void testGetFlowerNameMethod() {
    Chamomile flower = new Chamomile();
    assertTrue((flower.getFlowerName()).equals("chamomile"));
    System.out.println("Chamomile getFlowerName method correct.");
  }

  @Test
  public void testGetSellingPrice() {
    Chamomile flower = new Chamomile();
    assertTrue(flower.getSellingPrice() == 0);
    flower.grow();
    assertTrue(flower.getSellingPrice() == 0);
    flower.grow();
    assertTrue(flower.getSellingPrice() == 15);
    flower.grow();
    assertTrue(flower.getSellingPrice() == 0);
    System.out.println("Chamomile getSellingPrice method correct.");
  }

  @Test
  public void testGetFlowerStateMethod() {
    Chamomile flower = new Chamomile();
    for (int i = 1; i < 4; i++) {
      assertTrue(flower.getFlowerState() == i);
      flower.grow();
    }
    assertTrue(flower.getFlowerState() == 4);
    System.out.println("Chamomile getFlowerState method correct.");
  }

  @Test
  public void testGetPriceMethod() {
    Chamomile flower = new Chamomile();
    assertTrue(flower.getPrice() == 10);
    System.out.println("Chamomile getPrice method correct.");
  }
}
