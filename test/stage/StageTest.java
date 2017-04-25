package stage;

import org.junit.Test;

/**
 * @author Ferdinandus Richard
 */

public class StageTest {
  @Test
  public void testGetLevelMethod() {
    Stage s;
    s = new Stage(1, 2);
    assert(s.getLevel() == 1);
    s = new Stage(2, 4);
    assert(s.getLevel() == 2);
    s = new Stage(3, 1);
    assert(s.getLevel() == 3);
    s = new Stage(4, 5);
    assert(s.getLevel() == 4);
    s = new Stage(5, 2);
    assert(s.getLevel() == 5);
    s = new Stage(6, 1);
    assert(s.getLevel() == 6);
    s = new Stage(7, 3);
    assert(s.getLevel() == 7);
    s = new Stage(8, 4);
    assert(s.getLevel() == 8);
    s = new Stage(9, 4);
    assert(s.getLevel() == 9);
    System.out.println("Stage getLevel method correct.");
  }

  @Test
  public void testGetInGameMoneyMethod() {
    Stage s;
    s = new Stage(1, 2);
    assert(s.getInGameMoney() == 35);
    s = new Stage(2, 2);
    assert(s.getInGameMoney() == 50);
    s = new Stage(3, 1);
    assert(s.getInGameMoney() == 65);
    s = new Stage(4, 3);
    assert(s.getInGameMoney() == 85);
    s = new Stage(5, 2);
    assert(s.getInGameMoney() == 120);
    s = new Stage(6, 3);
    assert(s.getInGameMoney() == 150);
    s = new Stage(7, 4);
    assert(s.getInGameMoney() == 170);
    s = new Stage(8, 4);
    assert(s.getInGameMoney() == 200);
    s = new Stage(9, 3);
    assert(s.getInGameMoney() == 200);
    System.out.println("Stage getInGameMoney method correct.");
  }

  @Test
  public void testGetTargetMoneyMethod() {
    Stage s;
    s = new Stage(1, 2);
    assert(s.getTargetMoney() == 150);
    s = new Stage(2, 2);
    assert(s.getTargetMoney() == 200);
    s = new Stage(3, 1);
    assert(s.getTargetMoney() == 500);
    s = new Stage(4, 3);
    assert(s.getTargetMoney() == 300);
    s = new Stage(5, 2);
    assert(s.getTargetMoney() == 500);
    s = new Stage(6, 3);
    assert(s.getTargetMoney() == 700);
    s = new Stage(7, 4);
    assert(s.getTargetMoney() == 600);
    s = new Stage(8, 4);
    assert(s.getTargetMoney() == 1000);
    s = new Stage(9, 3);
    assert(s.getTargetMoney() == 1500);
    System.out.println("Stage getTargetMoney method correct.");
  }

  @Test
  public void testGetTimeLimitMethod() {
    Stage s;
    s = new Stage(1, 2);
    assert(s.getTimeLimit() == 120);
    s = new Stage(2, 2);
    assert(s.getTimeLimit() == 120);
    s = new Stage(3, 1);
    assert(s.getTimeLimit() == 240);
    s = new Stage(4, 3);
    assert(s.getTimeLimit() == 150);
    s = new Stage(5, 2);
    assert(s.getTimeLimit() == 180);
    s = new Stage(6, 3);
    assert(s.getTimeLimit() == 180);
    s = new Stage(7, 4);
    assert(s.getTimeLimit() == 120);
    s = new Stage(8, 4);
    assert(s.getTimeLimit() == 180);
    s = new Stage(9, 3);
    assert(s.getTimeLimit() == 210);
    System.out.println("Stage getTimeLimit method correct.");
  }

  @Test
  public void testGetLevelOfTruckMethod() {
    Stage s;
    s = new Stage(1, 2);
    assert(s.getLevelOfTruck() == 2);
    s = new Stage(2, 4);
    assert(s.getLevelOfTruck() == 4);
    s = new Stage(3, 1);
    assert(s.getLevelOfTruck() == 1);
    s = new Stage(4, 5);
    assert(s.getLevelOfTruck() == 5);
    s = new Stage(5, 3);
    assert(s.getLevelOfTruck() == 3);
    s = new Stage(6, 6);
    assert(s.getLevel() == 6);
    System.out.println("Stage getLevelOfTruck method correct.");
  }

  @Test
  public void testGetIncomeMethod() {
    Stage s;
    s = new Stage(1,2);
    assert(s.getIncome() == 0);
    s = new Stage(2, 3);
    assert(s.getIncome() == 0);
    s = new Stage(9, 3);
    assert(s.getIncome() == 0);
    System.out.println("Stage getIncome method correct.");
  }

  @Test
  public void testGetPotsMethod() {
    Stage s;
    s = new Stage(1,2);
    assert(s.getPots() == 2);
    s = new Stage(7, 3);
    assert(s.getPots() == 2);
    s.buyPot();
    assert(s.getPots() == 3);
    s.buyPot();
    assert(s.getPots() == 4);
    s.buyPot();
    assert(s.getPots() == 5);
    s = new Stage(3, 4);
    s.buyPot();
    assert(s.getPots() == 3);
    s.buyPot();
    assert(s.getPots() == 4);
    System.out.println("Stage getPots method correct.");
  }

  @Test
  public void testSetInGameMoneyMethod() {
    Stage s;
    s = new Stage(7, 4);
    assert(s.getInGameMoney() == 170);
    s.setInGameMoney(400);
    assert(s.getInGameMoney() == 400);
    s.setInGameMoney(1020);
    assert(s.getInGameMoney() == 1020);
    s.setInGameMoney(395);
    assert(s.getInGameMoney() == 395);
    System.out.println("Stage setInGameMoney method correct.");
  }
}