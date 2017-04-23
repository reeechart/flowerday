package plant;

/**
 * Kelas real yang merepresentasikan pot untuk menanam bunga.
 * Pada pot inilah bunga dapat hidup, jika tidak ada pot kosong,
 * bunga tidak dapat ditanam.
 * <p>Pot memiliki harga tetap di setiap stage, yaitu 100 Wonders</p>
 *
 * @author Gisela Supardi
 * @version 22/04/2017
 */
public class Pot extends StoreItem {
  /** Konstruktor. */
  public Pot() {
    super(100);
  }
}
