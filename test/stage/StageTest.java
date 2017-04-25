package stage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Ferdinandus Richard
 * Created on 25-Apr-2017.
 */

public class StageTest {
  @Test
  public void testGetLevelMethod() {
    Stage s;
    s = new Stage(1, 2);
    assertTrue(s.getLevel() == 1);
    s = new Stage(2, 4);
    assertTrue(s.getLevel() == 2);
    s = new Stage(3, 1);
    assertTrue(s.getLevel() == 3);
    s = new Stage(4, 5);
    assertTrue(s.getLevel() == 4);
    s = new Stage(5, 2);
    assertTrue(s.getLevel() == 5);
    s = new Stage(6, 1);
    assertTrue(s.getLevel() == 6);
    s = new Stage(7, 3);
    assertTrue(s.getLevel() == 7);
    s = new Stage(8, 4);
    assertTrue(s.getLevel() == 8);
    s = new Stage(9, 4);
    assertTrue(s.getLevel() == 9);
    System.out.println("Stage getLevel method correct.");
  }

  @Test
  public void testGetInGameMoneyMethod() {
    Stage s;
    s = new Stage(1, 2);
    assertTrue(s.getInGameMoney() == 35);
    s = new Stage(2, 2);
    assertTrue(s.getInGameMoney() == 50);
    s = new Stage(3, 1);
    assertTrue(s.getInGameMoney() == 65);
    s = new Stage(4, 3);
    assertTrue(s.getInGameMoney() == 85);
    s = new Stage(5, 2);
    assertTrue(s.getInGameMoney() == 120);
    s = new Stage(6, 3);
    assertTrue(s.getInGameMoney() == 150);
    s = new Stage(7, 4);
    assertTrue(s.getInGameMoney() == 170);
    s = new Stage(8, 4);
    assertTrue(s.getInGameMoney() == 200);
    s = new Stage(9, 3);
    assertTrue(s.getInGameMoney() == 200);
    System.out.println("Stage getInGameMoney method correct.");
  }

  @Test
  public void testGetTargetMoneyMethod() {
    Stage s;
    s = new Stage(1, 2);
    assertTrue(s.getTargetMoney() == 150);
    s = new Stage(2, 2);
    assertTrue(s.getTargetMoney() == 200);
    s = new Stage(3, 1);
    assertTrue(s.getTargetMoney() == 500);
    s = new Stage(4, 3);
    assertTrue(s.getTargetMoney() == 300);
    s = new Stage(5, 2);
    assertTrue(s.getTargetMoney() == 500);
    s = new Stage(6, 3);
    assertTrue(s.getTargetMoney() == 700);
    s = new Stage(7, 4);
    assertTrue(s.getTargetMoney() == 600);
    s = new Stage(8, 4);
    assertTrue(s.getTargetMoney() == 1000);
    s = new Stage(9, 3);
    assertTrue(s.getTargetMoney() == 1500);
    System.out.println("Stage getTargetMoney method correct.");
  }

  @Test
  public void testGetTimeLimitMethod() {
    Stage s;
    s = new Stage(1, 2);
    assertTrue(s.getTimeLimit() == 120);
    s = new Stage(2, 2);
    assertTrue(s.getTimeLimit() == 120);
    s = new Stage(3, 1);
    assertTrue(s.getTimeLimit() == 240);
    s = new Stage(4, 3);
    assertTrue(s.getTimeLimit() == 150);
    s = new Stage(5, 2);
    assertTrue(s.getTimeLimit() == 180);
    s = new Stage(6, 3);
    assertTrue(s.getTimeLimit() == 180);
    s = new Stage(7, 4);
    assertTrue(s.getTimeLimit() == 120);
    s = new Stage(8, 4);
    assertTrue(s.getTimeLimit() == 180);
    s = new Stage(9, 3);
    assertTrue(s.getTimeLimit() == 210);
    System.out.println("Stage getTimeLimit method correct.");
  }

  @Test
  public void testGetLevelOfTruckMethod() {
    Stage s;
    s = new Stage(1, 2);
    assertTrue(s.getLevelOfTruck() == 2);
    s = new Stage(2, 4);
    assertTrue(s.getLevelOfTruck() == 4);
    s = new Stage(3, 1);
    assertTrue(s.getLevelOfTruck() == 1);
    s = new Stage(4, 5);
    assertTrue(s.getLevelOfTruck() == 5);
    s = new Stage(5, 3);
    assertTrue(s.getLevelOfTruck() == 3);
    s = new Stage(6, 6);
    assertTrue(s.getLevel() == 6);
    System.out.println("Stage getLevelOfTruck method correct.");
  }

  @Test
  public void testGetIncomeMethod() {
    Stage s;
    s = new Stage(1,2);
    assertTrue(s.getIncome() == 0);
    s = new Stage(2, 3);
    assertTrue(s.getIncome() == 0);
    s = new Stage(9, 3);
    assertTrue(s.getIncome() == 0);
    System.out.println("Stage getIncome method correct.");
  }

  @Test
  public void testGetPotsMethod() {
    Stage s;
    s = new Stage(1,2);
    assertTrue(s.getPots() == 2);
    s = new Stage(7, 3);
    assertTrue(s.getPots() == 2);
    s.buyPot();
    assertTrue(s.getPots() == 3);
    s.buyPot();
    assertTrue(s.getPots() == 4);
    s.buyPot();
    assertTrue(s.getPots() == 5);
    s = new Stage(3, 4);
    s.buyPot();
    assertTrue(s.getPots() == 3);
    s.buyPot();
    assertTrue(s.getPots() == 4);
    System.out.println("Stage getPots method correct.");
  }

  @Test
  public void testSetInGameMoneyMethod() {
    Stage s;
    s = new Stage(7, 4);
    assertTrue(s.getInGameMoney() == 170);
    s.setInGameMoney(400);
    assertTrue(s.getInGameMoney() == 400);
    s.setInGameMoney(1020);
    assertTrue(s.getInGameMoney() == 1020);
    s.setInGameMoney(395);
    assertTrue(s.getInGameMoney() == 395);
    System.out.println("Stage setInGameMoney method correct.");
  }
}