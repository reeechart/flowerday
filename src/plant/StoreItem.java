package plant;

/**
 * Kelas abstrak yang merepresentasikan barang-barang yang dapat dibeli
 * pada shop saat bermain dalam stage.
 *
 * @author Gisela Supardi
 * @version 22/04/2017
 */
public abstract class StoreItem {
  /** Harga yang harus dibayar untuk membeli item ini. */
  private int price;

  /**
   * Konstruktor
   *
   * @param c harga yang diinginkan untuk item ini.
   */
  public StoreItem(int c) {
    price = c;
  }

  /**
   * Getter untuk harga item.
   *
   * @return <code>price</code>
   */
  public int getPrice() {
    return price;
  }
}
