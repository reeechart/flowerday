package stage;

import gui.Level;
import plant.PlantController;
import player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Kelas view untuk mengatur menampilkan model <code>Stage</code> ke layar.
 *
 * @author Ferdinandus Richard
 * @author Irene Edria
 * @author Reinhard Benjamin
 * @version 23-Apr-2017
 */
public class StageView {

  /**
   * Pengatur urutan layer. Digunakan untuk menimpa layer sebelumnya.
   */
  public int layerIterator = 0;
  /**
   * Button untuk pot-pot yang ada atau akan ada di taman.
   */
  JButton[][] field = new JButton[3][3];
  /**
   * Tampilan untuk truk yang akan menjual bunga.
   */
  private JButton buttonTruck;
  /**
   * Button untuk gunting pemanen bunga.
   */
  private JButton buttonScissors;
  /**
   * Button untuk alat penyiram bunga.
   */
  private JButton buttonWateringCan;
  /**
   * Tampilan gambar untuk penanda taman.
   */
  private JLabel labelGarden;
  /**
   * Button untuk membeli pot.
   */
  private JButton buttonPotInStore;
  /**
   * Button untuk pot-pot yang diletakkan di taman.
   */
  private JButton buttonPot;
  /**
   * Button untuk membeli bunga anggrek.
   */
  private JButton buttonOrchid;
  /**
   * Button untuk membeli bunga kamomil.
   */
  private JButton buttonChamomile;
  /**
   * Button untuk membeli bunga matahari.
   */
  private JButton buttonSunflower;
  /**
   * Button untuk membeli bunga mawar.
   */
  private JButton buttonRose;
  /**
   * Button untuk menjual hasil panen.
   */
  private JButton sell;
  /**
   * Tampilan gambar koin di sebelah jumlah uang sebagai penanda uang.
   */
  private JLabel labelWonderCoin;
  /**
   * Tampilan untuk gambar uang.
   */
  private JLabel labelMoney;
  /**
   * Tampilan untuk memberitahu berapa Wonder(s) yang akan didapat
   * saat dilakukan penjualan dari bunga yang telah dipanen.
   */
  private JLabel labelIncome;
  /**
   * Tampilan penanda level berapa yang sedang dimainkan.
   */
  private JLabel labelLevel;
  /**
   * Tampilan untuk background saat bermain dalam stage.
   */
  private JLabel labelBackground;
  /**
   * Tampilan gambar penanda shop.
   */
  private JLabel labelShop;
  /**
   * Tampilan gambar kantong uang untuk menandakan game money.
   */
  private JLabel labelMoneyBag;
  /**
   * Tampilan untuk game money.
   */
  private JLabel labelGameMoney;
  /**
   * Tampilan gambar penanda Wonder Village, tempat penanaman bunga.
   */
  private JLabel labelVillage;
  /**
   * Tampilan gambar penanda Wonder Town, tempat menjual bunga.
   */
  private JLabel labelTown;
  /**
   * Thread agar truk dapat bergerak saat menjual dan kembali.
   */
  private Thread animation;

  /**
   * Menjalankan animasi truk yang sedang menjual bunga ke kota.
   * I.S.: Dipanggil fungsi menjual bunga oleh <code>StageController</code>.
   * F.S.: Truk akan menjalankan animasinya yaitu berpindah dari kiri ke kanan.
   *
   * @param dep <code>JDesktopPane</code> yang menjadi wadah
   */
  void moveTruckToCity(JDesktopPane dep) {
    buttonTruck.setVisible(false);
    ImageIcon truck = new ImageIcon("asset/truckmini.png");
    buttonTruck = new JButton(truck);
    animation = new Thread(new Runnable() {
      @Override
      public void run() {
        int x = 200;
        while (x < 920) {
          buttonTruck.setBounds(x, 650, 150, 150);
          buttonTruck.setOpaque(false);
          buttonTruck.setBorderPainted(false);
          buttonTruck.setContentAreaFilled(false);
          dep.add(buttonTruck, new Integer(1000));
          x += 10;
          try {
            animation.sleep(16);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    });
    animation.start();
  }

  /**
   * Menjalankan animasi truk yang sedang kembali dari kota.
   * I.S.: Truk berada di kota.
   * F.S.: Truk akan menjalankan animasinya yaitu berpindah dari kanan ke kiri.
   *
   * @param dep <code>JDesktopPane</code> yang menjadi wadah
   */
  void moveTruckToWonderVillage(JDesktopPane dep) {
    buttonTruck.setVisible(false);
    ImageIcon truck = new ImageIcon("asset/truckmini.png");
    buttonTruck = new JButton(truck);
    animation = new Thread(new Runnable() {
      @Override
      public void run() {
        int x = 920;
        while (x > 200) {
          buttonTruck.setBounds(x, 650, 150, 150);
          buttonTruck.setOpaque(false);
          buttonTruck.setBorderPainted(false);
          buttonTruck.setContentAreaFilled(false);
          dep.add(buttonTruck, new Integer(1000));
          x -= 10;
          try {
            animation.sleep(16);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    });
    animation.start();
  }

  /**
   * Menambahkan pot sebagai koleksi button.
   * I.S.: Dipilih tombol untuk membeli pot.
   * F.S.: Muncul pot baru pada layar.
   *
   * @param dep Wadah untuk menampilkan pada layar
   * @param stage <code>Stage</code> yang sedang dimainkan
   * @param a <code>ActionListener</code> yang sedang aktif
   */
  void newPot(JDesktopPane dep, Stage stage, ActionListener a) {
    int n = stage.getPots() - 1;
    int x = n / 3;
    int y = n % 3;
    PlantController[][] pc = stage.getPlants();
    ImageIcon potimage = pc[x][y].getImage();
    buttonPot = new JButton(potimage);
    buttonPot.setBounds((y * 150) + 500, (x * 150) + 150, 150, 150);
    buttonPot.setOpaque(false);
    buttonPot.setBorderPainted(false);
    buttonPot.setContentAreaFilled(false);
    buttonPot.addActionListener(a);
    field[x][y] = buttonPot;
    updateMoney(dep, stage);
    dep.add(buttonPot, new Integer(1000));
  }

  /**
   * Memperbaharui tampilan total calon pendapatan pada layar.
   * I.S.: Bunga yang siap panen dipanen.
   * F.S.: Tampilan calon pendapatan berubah pada layar.
   *
   * @param dep Wadah untuk menampilkan pada layar
   * @param stage <code>Stage</code> yang sedang dimainkan
   */
  private void updateIncome(JDesktopPane dep, Stage stage) {
    String income = Integer.toString(stage.getIncome());
    labelIncome.setVisible(false);
    labelIncome = new JLabel(income);
    labelIncome.setFont(new Font("Grinched 2.0", Font.BOLD, 24));
    labelIncome.setBounds(180, 600, 100, 100);
    dep.add(labelIncome, new Integer(1000));
  }

  /**
   * Memperbaharui tampilan total calon pendapatan pada layar.
   * Persiapan untuk pengembangan yang mungkin akan dilakukan di kemudian hari.
   * I.S.: Bunga yang siap panen dipanen.
   * F.S.: Tampilan calon pendapatan berubah pada layar.
   *
   * @param dep Wadah untuk menampilkan pada layar
   * @param stage <code>Stage</code> yang sedang dimainkan
   * @param a <code>ActionListener</code> yang sedang aktif
   */
  void updateIncome(JDesktopPane dep, Stage stage, ActionListener a) {
    updateIncome(dep, stage);
  }

  /**
   * Memperbaharui tampilan pot karena pot ditanami atau bunga bertumbuh.
   *
   * @param dep Wadah untuk menampilkan pada layar
   * @param stage <code>Stage</code> yang sedang dimainkan
   * @param row Absis letak pot
   * @param col Ordinat letak pot
   * @param a <code>ActionListener</code> yang sedang aktif
   */
  void updatePot(JDesktopPane dep, Stage stage, int row, int col, ActionListener a) {
    PlantController[][] pc = stage.getPlants();
    ImageIcon bibitimage = pc[row][col].getImage();
    dep.remove(field[row][col]);
    JButton buttonpotbibit = new JButton(bibitimage);
    buttonpotbibit.setBounds((col * 150) + 500, (row * 150) + 150, 150, 150);
    buttonpotbibit.setOpaque(false);
    buttonpotbibit.setBorderPainted(false);
    buttonpotbibit.setContentAreaFilled(false);
    buttonpotbibit.addActionListener(a);
    field[row][col] = buttonpotbibit;
    updateMoney(dep, stage);
    layerIterator++;
    dep.add(buttonpotbibit, new Integer(1000 + (layerIterator * 150)));
  }

  /**
   * Memperbaharui jumlah uang yang dimiliki dalam <code>stage</code>.
   * I.S.: Bunga yang siap panen dipanen.
   * F.S.: Tampilan calon pendapatan berubah pada layar.
   *
   * @param dep Wadah untuk menampilkan pada layar
   * @param stage <code>Stage</code> yang sedang dimainkan
   */
  void updateMoney(JDesktopPane dep, Stage stage) {
    String gameMoney = Integer.toString(stage.getInGameMoney());
    dep.remove(labelMoney);
    labelMoney = new JLabel(gameMoney);
    labelMoney.setFont(new Font("Grinched 2.0", Font.BOLD, 24));
    labelMoney.setBounds(180, 270, 100, 100);
    dep.add(labelMoney, new Integer(1000));
  }

  /**
   * Memperbaharui game money yang dimiliki <code>p</code>.
   * I.S.: Uang <code>p</code> sembarang.
   * F.S.: Tampilan uang <code>p</code> berubah pada layar.
   *
   * @param dep Wadah untuk menampilkan pada layar
   * @param stage <code>Stage</code> yang sedang dimainkan
   * @param p Pemain yang sedang memainkan game
   */
  void updatePlayerMoney(JDesktopPane dep, Stage stage, Player p) {
    String playerMoney = Integer.toString(p.getMoney());
    labelGameMoney.setVisible(false);
    labelGameMoney = new JLabel(playerMoney);
    labelGameMoney.setFont(new Font("Grinched 2.0", Font.BOLD, 24));
    labelGameMoney.setBounds(1400, 10, 50, 50);
    dep.add(labelGameMoney, new Integer(1000));
  }

  /**
   * Konstruktor.
   *
   * @param stage <code>Stage</code> yang sedang dimainkan
   * @param dep Wadah untuk menampilkan pada layar
   * @param p Pemain yang sedang memainkan game
   * @param stgLevel Level yang sedang dimainkan saat ini
   * @param actList <code>ActionListener</code> yang sedang aktif
   */
  StageView(Stage stage, JDesktopPane dep, Player p, int stgLevel,
      ArrayList<ActionListener> actList) {
    // Pot kosong
    ImageIcon potimage = new ImageIcon("asset/potempty.png");
    // Background saat bermain di stage
    ImageIcon image = new ImageIcon("asset/gameback.png");
    labelBackground = new JLabel(image);
    labelBackground.setBounds(0, 0, 1440, 900);
    dep.add(labelBackground, new Integer(150));
    // Tampilan game money
    ImageIcon moneybag = new ImageIcon("asset/bagmoney.png");
    labelMoneyBag = new JLabel(moneybag);
    labelMoneyBag.setBounds(1300, 10, 100, 100);
    dep.add(labelMoneyBag, new Integer(1000));
    String playerMoney = Integer.toString(p.getMoney());
    labelGameMoney = new JLabel(playerMoney);
    labelGameMoney.setFont(new Font("Grinched 2.0", Font.BOLD, 24));
    labelGameMoney.setBounds(1400, 10, 50, 50);
    dep.add(labelGameMoney, new Integer(1000));
    // Tampilan game money
    ImageIcon level = new ImageIcon("asset/" + stgLevel + "small.png");
    labelLevel = new JLabel(level);
    labelLevel.setBounds(1300, 110, 100, 100);
    dep.add(labelLevel, new Integer(1000));
    ImageIcon money = new ImageIcon("asset/money.png");
    labelWonderCoin = new JLabel(money);
    labelWonderCoin.setBounds(80, 270, 100, 100);
    dep.add(labelWonderCoin, new Integer(1000));
    // Tampilan calon pendapatan
    String income = Integer.toString(stage.getIncome());
    labelIncome = new JLabel(income);
    labelIncome.setFont(new Font("Grinched 2.0", Font.BOLD, 24));
    labelIncome.setBounds(180, 600, 100, 100);
    dep.add(labelIncome, new Integer(1000));
    String gameMoney = Integer.toString(stage.getInGameMoney());
    labelMoney = new JLabel(gameMoney);
    labelMoney.setBounds(180, 270, 100, 100);
    labelMoney.setFont(new Font("Grinched 2.0", Font.BOLD, 24));
    dep.add(labelMoney, new Integer(1000));
    // Tampilan store
    ImageIcon shop = new ImageIcon("asset/shop.png");
    labelShop = new JLabel(shop);
    labelShop.setBounds(1050, 30, 150, 150);
    dep.add(labelShop, new Integer(1000));
    ImageIcon rose = new ImageIcon("asset/rose.png");
    buttonRose = new JButton(rose);
    buttonRose.setBounds(1020, 210, 100, 100);
    buttonRose.setOpaque(false);
    buttonRose.setBorderPainted(false);
    buttonRose.setContentAreaFilled(false);
    buttonRose.addActionListener(actList.remove(0));
    dep.add(buttonRose, new Integer(1000));
    ImageIcon sunflower = new ImageIcon("asset/sunflower.png");
    buttonSunflower = new JButton(sunflower);
    buttonSunflower.setBounds(1130, 210, 100, 100);
    buttonSunflower.setOpaque(false);
    buttonSunflower.setContentAreaFilled(false);
    buttonSunflower.setBorderPainted(false);
    buttonSunflower.addActionListener(actList.remove(0));
    dep.add(buttonSunflower, new Integer(1000));
    ImageIcon chamomile = new ImageIcon("asset/chamomile.png");
    buttonChamomile = new JButton(chamomile);
    buttonChamomile.setBounds(1020, 320, 100, 100);
    buttonChamomile.setOpaque(false);
    buttonChamomile.setBorderPainted(false);
    buttonChamomile.setContentAreaFilled(false);
    buttonChamomile.addActionListener(actList.remove(0));
    dep.add(buttonChamomile, new Integer(1000));
    ImageIcon orchid = new ImageIcon("asset/orchid.png");
    buttonOrchid = new JButton(orchid);
    buttonOrchid.setBounds(1130, 320, 100, 100);
    buttonOrchid.setOpaque(false);
    buttonOrchid.setContentAreaFilled(false);
    buttonOrchid.setBorderPainted(false);
    buttonOrchid.addActionListener(actList.remove(0));
    dep.add(buttonOrchid, new Integer(1000));
    ImageIcon pot = new ImageIcon("asset/pot.png");
    buttonPotInStore = new JButton(pot);
    buttonPotInStore.setBounds(1080, 430, 100, 100);
    buttonPotInStore.setOpaque(false);
    buttonPotInStore.setContentAreaFilled(false);
    buttonPotInStore.setBorderPainted(false);
    buttonPotInStore.addActionListener(actList.remove(0));
    dep.add(buttonPotInStore, new Integer(1000));
    // Tampilan taman
    ImageIcon garden = new ImageIcon("asset/garden.png");
    labelGarden = new JLabel(garden);
    labelGarden.setBounds(330, 30, 150, 150);
    dep.add(labelGarden, new Integer(1000));
    for (int i = 0; i < 1; i++) {
      for (int j = 0; j < 2; j++) {
        field[i][j] = new JButton(potimage);
        field[i][j].setBounds((j * 150) + 500, (i * 150) + 150, 150, 150);
        field[i][j].setBorderPainted(false);
        field[i][j].setContentAreaFilled(false);
        field[i][j].setOpaque(false);
        field[i][j].addActionListener(actList.get(0));
        dep.add(field[i][j], new Integer(1000));
      }
    }
    actList.remove(0);
    // Tampilan gardening tool
    ImageIcon can = new ImageIcon("asset/wateringcan.png");
    buttonWateringCan = new JButton(can);
    buttonWateringCan.setBounds(300, 150, 200, 200);
    buttonWateringCan.setOpaque(false);
    buttonWateringCan.setContentAreaFilled(false);
    buttonWateringCan.setBorderPainted(false);
    buttonWateringCan.addActionListener(actList.remove(0));
    dep.add(buttonWateringCan, new Integer(1000));
    ImageIcon scissors = new ImageIcon("asset/scissors.png");
    buttonScissors = new JButton(scissors);
    buttonScissors.setBounds(300, 300, 200, 200);
    buttonScissors.setOpaque(false);
    buttonScissors.setContentAreaFilled(false);
    buttonScissors.setBorderPainted(false);
    buttonScissors.addActionListener(actList.remove(0));
    dep.add(buttonScissors, new Integer(1000));
    // Tampilan penjualan
    ImageIcon village = new ImageIcon("asset/land.png");
    labelVillage = new JLabel(village);
    labelVillage.setBounds(50, 650, 150, 150);
    dep.add(labelVillage, new Integer(1000));
    sell = new JButton("Sell");
    sell.setBounds(100, 600, 80, 30);
    sell.addActionListener(actList.remove(0));
    dep.add(sell, new Integer(1000));
    ImageIcon truck = new ImageIcon("asset/truckmini.png");
    buttonTruck = new JButton(truck);
    buttonTruck.setBounds(200, 650, 150, 150);
    buttonTruck.setOpaque(false);
    buttonTruck.setBorderPainted(false);
    buttonTruck.setContentAreaFilled(false);
    dep.add(buttonTruck, new Integer(1000));
    ImageIcon city = new ImageIcon("asset/city.png");
    labelTown = new JLabel(city);
    labelTown.setBounds(1100, 590, 200, 200);
    dep.add(labelTown, new Integer(1000));
  }

  /**
   * Menampilkan box berisi keterangan menang atau kalah.
   * I.S.: Timer sudah habis.
   * F.S.: Ditampilkan box keterangan hasil permainan.
   *
   * @param stage <code>Stage</code> yang sedang dimainkan
   * @param dep Wadah untuk menampilkan pada layar
   * @param stat Status kemenangan player; 1 untuk menang dan lainnya untuk kalah
   * @param p Pemain yang sedang memainkan game
   */
  void endStageView(Stage stage, JDesktopPane dep, int stat, Player p) {
    if (stat == 1) {
      ImageIcon quit = new ImageIcon("asset/quithappy.png");
      JFrame frame = new JFrame();
      JOptionPane.showMessageDialog(null,
          "Congratulations, you won!", "Message",
          JOptionPane.INFORMATION_MESSAGE, quit);
    } else {
      ImageIcon quit = new ImageIcon("asset/quit.png");
      JFrame frame = new JFrame();
      JOptionPane.showMessageDialog(null,
          "Sorry, you lose :(", "Message",
          JOptionPane.INFORMATION_MESSAGE, quit);
    }
    if (animation.isAlive()) {
      animation.interrupt();
    }
    int n = stage.getPots();
    for (int pot = 0; pot < n; pot++) {
      int x = pot / 3;
      int y = pot % 3;
      dep.remove(field[x][y]);
    }
    dep.remove(labelMoney);
    dep.remove(labelIncome);
    dep.remove(buttonTruck);
    dep.remove(sell);
    dep.remove(buttonScissors);
    dep.remove(buttonWateringCan);
    dep.remove(labelGarden);
    dep.remove(buttonPotInStore);
    dep.remove(buttonOrchid);
    dep.remove(labelShop);
    dep.remove(buttonChamomile);
    dep.remove(buttonSunflower);
    dep.remove(buttonRose);
    dep.remove(labelWonderCoin);
    dep.remove(labelLevel);
    dep.remove(labelBackground);
    dep.remove(labelMoneyBag);
    dep.remove(labelGameMoney);
    dep.remove(labelVillage);
    dep.remove(labelTown);
    new Level(dep, p);
  }
}