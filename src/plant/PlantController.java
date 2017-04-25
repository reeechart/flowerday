package plant;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;

/**
 * Kelas real yang mengurus tentang kelakuan pot dan bunga semasa hidupnya.
 *
 * @author Gisela Supardi
 * @version 23/04/2017
 */
public class PlantController {

  /**
   * Pot yang diurus oleh controller ini.
   */
  private Pot potInControl;
  /**
   * Bunga yang diurus oleh controller ini.
   */
  private Flower flowerInControl;
  /**
   * Representasi tanaman yang diurus controller ini pada layar.
   */
  private PlantView viewInControl;
  /**
   * Default waktu perpindahan state pertumbuhan dalam ms.
   */
  private final int growthTime = 3000;
  /**
   * Default batas waktu dalam ms untuk memanen bunga sebelum membusuk.
   */
  private final int harvestTime = 4000;

  /**
   * Konstruktor.
   */
  public PlantController() {
    potInControl = new Pot();
    viewInControl = new PlantView();
  }

  /**
   * Getter untuk harga beli bunga.
   *
   * @param name nama bunga yang ingin diketahui namanya
   * @return harga dari bunga berjenis <code>name</code>
   */
  public int getFlowerPrice(String name) {
    Flower dummy;
    switch (name) {
      case "sunflower":
        dummy = new Sunflower();
        break;
      case "rose":
        dummy = new Rose();
        break;
      case "orchid":
        dummy = new Orchid();
        break;
      default:
        dummy = new Chamomile();
    }
    return dummy.getPrice();
  }

  /**
   * Fungsi untuk mendapatkan nilai beli pot.
   *
   * @return harga beli pot
   */
  public int getPotPrice() {
    return potInControl.getPrice();
  }

  /**
   * Getter untuk gambar yang ingin dirender.
   *
   * @return <code>ImageIcon</code> untuk plant ini
   */
  public ImageIcon getImage() {
    return viewInControl.getImage();
  }

  /**
   * Fungsi untuk mendapatkan nilai jual bunga saat dipanen.
   * Pot kosong juga akan menghasilkan 0 Wonder.
   *
   * @return harga jual bunga atau 0 jika pot kosong
   */
  public int harvest() {
    if (flowerInControl == null) {
      return 0;
    } else {
      return flowerInControl.getSellingPrice();
    }
  }

  /**
   * Menginisialisasi <code>Flower</code> yang ada pada controller ini.
   * I.S.: Pot kosong.
   * F.S.: Bunga state 1 tertanam pada pot.
   *
   * @param flowerName nama bunga yang ingin dimasukkan
   */
  public void addFlowerToPot(String flowerName) {
    switch (flowerName) {
      case "sunflower":
        flowerInControl = new Sunflower();
        break;
      case "rose":
        flowerInControl = new Rose();
        break;
      case "orchid":
        flowerInControl = new Orchid();
        break;
      case "chamomile":
        flowerInControl = new Chamomile();
        break;
      default:
        // do nothing
    }
    viewInControl = new PlantView(flowerInControl);
  }

  /**
   * Prosedur untuk mengurus kehidupan bunga yang telah ditanam.
   * I.S.: Bunga disiram.
   * F.S.: Bunga tumbuh ke stage selanjutnya.
   */
  public void growTheFlower() {
    switch (flowerInControl.getFlowerState()) {
      case 1:
        waitToGrow(growthTime);
        break;
      case 2:
        waitToGrow(growthTime);
        // fall through agar bunga busuk jika tidak di harvest
      case 3:
        waitToGrow(harvestTime);
        break;
      default:
        // bunga busuk; do nothing
    }
    viewInControl = new PlantView(flowerInControl);
  }

  /**
   * Prosedur untuk menjalankan waktu tumbuh bunga.
   *
   * @param time berapa lama waktu tunggunya
   */
  private void waitToGrow(int time) {
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
      @Override
      public void run() {
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime <= time) {
          // wait for growing delay
        }
        flowerInControl.grow();
        viewInControl = new PlantView(flowerInControl);
        timer.cancel();
        timer.purge();
      }
    };
    if (time == harvestTime) {
      timer.schedule(task, 3000);
    } else {
      timer.schedule(task, 30);
    }
  }
}
