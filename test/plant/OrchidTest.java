package plant;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Ferdinandus Richard
 * Created on 25-Apr-2017.
 */
public class OrchidTest {
  @Test
  public void testGetFlowerNameMethod() {
    Orchid flower = new Orchid();
    assertTrue((flower.getFlowerName()).equals("orchid"));
    System.out.println("Orchid getFlowerName method correct.");
  }

  @Test
  public void testGetSellingPrice() {
    Orchid flower = new Orchid();
    assertTrue(flower.getSellingPrice() == 0);
    flower.grow();
    assertTrue(flower.getSellingPrice() == 0);
    flower.grow();
    assertTrue(flower.getSellingPrice() == 35);
    flower.grow();
    assertTrue(flower.getSellingPrice() == 0);
    System.out.println("Orchid getSellingPrice method correct.");
  }

  @Test
  public void testGetFlowerStateMethod() {
    Orchid flower = new Orchid();
    for (int i = 1; i < 4; i++) {
      assertTrue(flower.getFlowerState() == i);
      flower.grow();
    }
    assertTrue(flower.getFlowerState() == 4);
    System.out.println("Orchid getFlowerState method correct.");
  }

  @Test
  public void testGetPriceMethod() {
    Orchid flower = new Orchid();
    assertTrue(flower.getPrice() == 25);
    System.out.println("Orchid getPrice method correct.");
  }
}
