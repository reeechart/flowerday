package plant;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Ferdinandus Richard
 * Created on 25-Apr-2017.
 */
public class RoseTest {
  @Test
  public void testGetFlowerNameMethod() {
    Rose flower = new Rose();
    assertTrue((flower.getFlowerName()).equals("rose"));
    System.out.println("Rose getFlowerName method correct.");
  }

  @Test
  public void testGetSellingPrice() {
    Rose flower = new Rose();
    assertTrue(flower.getSellingPrice() == 0);
    flower.grow();
    assertTrue(flower.getSellingPrice() == 0);
    flower.grow();
    assertTrue(flower.getSellingPrice() == 70);
    flower.grow();
    assertTrue(flower.getSellingPrice() == 0);
    System.out.println("Rose getSellingPrice method correct.");
  }

  @Test
  public void testGetFlowerStateMethod() {
    Rose flower = new Rose();
    for (int i = 1; i < 4; i++) {
      assertTrue(flower.getFlowerState() == i);
      flower.grow();
    }
    assertTrue(flower.getFlowerState() == 4);
    System.out.println("Rose getFlowerState method correct.");
  }

  @Test
  public void testGetPriceMethod() {
    Rose flower = new Rose();
    assertTrue(flower.getPrice() == 40);
    System.out.println("Rose getPrice method correct.");
  }
}
