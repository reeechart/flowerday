package plant;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Ferdinandus Richard
 * Created on 25-Apr-2017.
 */
public class SunflowerTest {
  @Test
  public void testGetFlowerNameMethod() {
    Sunflower flower = new Sunflower();
    assertTrue((flower.getFlowerName()).equals("sunflower"));
    System.out.println("Sunflower getFlowerName method correct.");
  }

  @Test
  public void testGetSellingPrice() {
    Sunflower flower = new Sunflower();
    assertTrue(flower.getSellingPrice() == 0);
    flower.grow();
    assertTrue(flower.getSellingPrice() == 0);
    flower.grow();
    assertTrue(flower.getSellingPrice() == 100);
    flower.grow();
    assertTrue(flower.getSellingPrice() == 0);
    System.out.println("Sunflower getSellingPrice method correct.");
  }

  @Test
  public void testGetFlowerStateMethod() {
    Sunflower flower = new Sunflower();
    for (int i = 1; i < 4; i++) {
      assertTrue(flower.getFlowerState() == i);
      flower.grow();
    }
    assertTrue(flower.getFlowerState() == 4);
    System.out.println("Sunflower getFlowerState method correct.");
  }

  @Test
  public void testGetPriceMethod() {
    Sunflower flower = new Sunflower();
    assertTrue(flower.getPrice() == 50);
    System.out.println("Sunflower getPrice method correct.");
  }
}
