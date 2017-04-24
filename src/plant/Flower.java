package plant;

/**
 * Kelas abstrak yang merepresentasikan bunga yang ditanam.
 * <p>Bunga hanya dapat hidup dalam pot.
 * Hidup bunga akan dibagi menjadi 4 state yang disimpan sebagai
 * atribut <code>flowerState</code>. Pada state 1 dan 2,
 * bunga perlu disiram agar dapat tumbuh ke state selanjutnya.
 * Sedangkan pada state 3, bunga perlu segera dipanen
 * agar tidak busuk (state 4).
 * Bunga yang busuk tidak akan menghasilkan uang ketika dijual.
 * </p>
 * <p>Setiap jenis bunga memiliki harga beli dan harga jual masing-masing.
 * Uang stage akan dikurangi seharga <code>price</code> saat membeli bunga
 * dan akan ditambah sebanyak <code>sellingPrice</code> saat bunga dijual.
 * </p>
 *
 * @author Gisela Supardi
 * @version 22/04/2017
 */
public abstract class Flower extends StoreItem {
  /** Nama jenis bunga. */
  private String flowerName;

  /** Banyak Wonders yang bisa didapatkan ketika menjual bunga. */
  private int sellingPrice;

  /**
   * Status pertumbuhan bunga. Memiliki range dari 1-4.
   * State 1: tunas.
   * State 2: bakal bunga.
   * State 3: bunga yang siap dipanen.
   * State 4: bunga yang busuk; menghasilkan 0 Wonder.
   */
  private int flowerState;

  /**
   * Konstruktor.
   *
   * @param name nama jenis bunga yang diinginkan.
   * @param price harga beli sebuah bunga yang diinginkan.
   * @param sellingPrice harga jual sebuah bunga yang diinginkan.
   */
  public Flower(String name, int price, int sellingPrice) {
    super(price);
    flowerName = name;
    this.sellingPrice = sellingPrice;
    flowerState = 1;
  }

  /**
   * Getter dari nama jenis bunga.
   *
   * @return <code>flowerName</code>
   */
  public final String getFlowerName() {
    return flowerName;
  }

  /**
   * Getter dari harga jual bunga.
   *
   * @return harga jual bunga. Untuk bunga yang siap panen
   *         dihargai sebanyak <code>sellingPrice</code>,
   *         sedangkan selain itu dihargai 0 Wonder.
   */
  public final int getSellingPrice() {
    if (flowerState == 3) {
      return sellingPrice;
    }
    else {
      return 0;
    }
  }

  /**
   * Getter status pertumbuhan bunga.
   *
   * @return <code>flowerState</code>
   */
  public final int getFlowerState() {
    return flowerState;
  }

  /**
   * Menumbuhkan bunga dengan cara menaikkan state dari bunga.
   * I.S. : Flower terdefinisi dengan <code>flowerState</code> tertentu.
   * F.S. : <code>flowerState</code> dari <code>Flower</code> bertambah satu.
   */
  public void grow() {
    flowerState++;
  }
}