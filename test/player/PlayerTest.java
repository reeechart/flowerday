package player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Ferdinandus Richard
 * Created on 25-Apr-2017.
 */
public class PlayerTest {
  @Test
  public void testGetNameMethod() {
    Player player;
    player = new Player("James");
    assertTrue(player.getName().equals("James"));
    player = new Player("Richard", 3, 2, 500);
    assertTrue(player.getName().equals("Richard"));
    player = new Player("Irene", 4, 3, 700);
    assertTrue(player.getName().equals("Irene"));
    player = new Player("Reinhard", 6, 2, 900);
    assertTrue(player.getName().equals("Reinhard"));
    player = new Player("Gisela", 5, 1, 1020);
    assertTrue(player.getName().equals("Gisela"));
    System.out.println("Player getName method correct.");
  }

  @Test
  public void testGetLastStageOpenedMethod() {
    Player player;
    player = new Player("James");
    assertTrue(player.getLastStageOpened() == 1);
    player = new Player("Richard", 3, 2, 500);
    assertTrue(player.getLastStageOpened() == 3);
    player = new Player("Irene", 4, 3, 700);
    assertTrue(player.getLastStageOpened() == 4);
    player = new Player("Reinhard", 6, 2, 900);
    assertTrue(player.getLastStageOpened() == 6);
    player = new Player("Gisela", 5, 1, 1020);
    assertTrue(player.getLastStageOpened() == 5);
    System.out.println("Player getLastStageOpened method correct.");
  }

  @Test
  public void testGetTruckLevelMethod() {
    Player player;
    player = new Player("James");
    assertTrue(player.getTruckLevel() == 1);
    player = new Player("Richard", 3, 2, 500);
    assertTrue(player.getTruckLevel() == 2);
    player = new Player("Irene", 4, 3, 700);
    assertTrue(player.getTruckLevel() == 3);
    player = new Player("Reinhard", 6, 2,  900);
    assertTrue(player.getTruckLevel() == 2);
    player = new Player("Gisela", 5, 1,  1020);
    assertTrue(player.getTruckLevel() == 1);
    System.out.println("Player getTruckLevel method correct.");
  }

  @Test
  public void testGetMoney() {
    Player player;
    player = new Player("James");
    assertTrue(player.getMoney() == 0);
    player = new Player("Richard", 3, 2, 500);
    assertTrue(player.getMoney() == 500);
    player = new Player("Irene", 4, 3, 700);
    assertTrue(player.getMoney() == 700);
    player = new Player("Reinhard", 6, 2, 900);
    assertTrue(player.getMoney() == 900);
    player = new Player("Gisela", 5, 1, 1020);
    assertTrue(player.getMoney() == 1020);
    System.out.println("Player getMoney method correct.");
  }

  @Test
  public void testSetLastStageOpenedMethod() {
    Player player;
    player = new Player("James");
    assertTrue(player.getLastStageOpened() == 1);
    player.setLastStageOpened(3);
    assertTrue(player.getLastStageOpened() == 3);
    player = new Player("Richard", 2, 5, 500);
    assertTrue(player.getLastStageOpened() == 2);
    player.setLastStageOpened(4);
    assertTrue(player.getLastStageOpened() == 4);
    player = new Player("Irene", 4, 3, 700);
    assertTrue(player.getLastStageOpened() == 4);
    player.setLastStageOpened(1);
    assertTrue(player.getLastStageOpened() == 1);
    player = new Player ("Reinhard", 1, 3, 900);
    assertTrue(player.getLastStageOpened() == 1);
    player.setLastStageOpened(7);
    assertTrue(player.getLastStageOpened() == 7);
    player = new Player("Gisela", 3, 5, 1020);
    assertTrue(player.getLastStageOpened() == 3);
    player.setLastStageOpened(5);
    assertTrue(player.getLastStageOpened() == 5);
    System.out.println("Player setLastStageOpened method correct.");
  }

  @Test
  public void testUpgradeTruckMethod() {
    Player player;
    player = new Player("James");
    assertTrue(player.getTruckLevel() == 1);
    player.addMoney(100000);
    player.upgradeTruck();
    assertTrue(player.getTruckLevel() == 2);
    player.upgradeTruck();
    assertTrue(player.getTruckLevel() == 3);
    player = new Player("Ferdi", 4, 3, 200);
    assertTrue(player.getTruckLevel() == 3);
    player.upgradeTruck();
    assertTrue(player.getTruckLevel() == 3);
    System.out.println("Player upgradeTruck method correct.");
  }

  @Test
  public void testAddMoneyMethod() {
    Player player;
    player = new Player("James");
    assertTrue(player.getMoney() == 0);
    player.addMoney(300);
    assertTrue(player.getMoney() == 300);
    player.addMoney(121);
    assertTrue(player.getMoney() == 421);
    player.addMoney(406);
    assertTrue(player.getMoney() == 827);
    player = new Player("Edria", 5, 2, 1000);
    assertTrue(player.getMoney() == 1000);
    player.addMoney(193);
    assertTrue(player.getMoney() == 1193);
    player.addMoney(79);
    assertTrue(player.getMoney() == 1272);
    System.out.println("Player addMoney method correct.");
  }
}