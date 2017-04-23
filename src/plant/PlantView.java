package plant;

import javax.swing.*;

/**
 * Kelas real yang mengurus tentang tampilan pot dan bunga pada layar.
 *
 * @author Gisela Supardi
 * @version 23/04/2017
 */
public class PlantView extends JPanel {
  /** Konstanta yang menyimpan lebar image untuk plant. */
  private final int WIDTH_SIZE = 100;
  /** Konstanta yang menyimpan tinggi image untuk plant */
  private final int HEIGHT_SIZE = 100;

  /**
   * Konstruktor untuk tampilan pot yang belum ditanami bunga.
   *
   * @param posX absis posisi peletakan gambar pada layar
   * @param posY absis posisi peletakan gambar pada layar
   */
  public PlantView(int posX, int posY) {
    ImageIcon potView = new ImageIcon("asset/potempty.png");
    JLabel potLabel = new JLabel(potView);
    potLabel.setBounds(posX, posY, WIDTH_SIZE, HEIGHT_SIZE);
  }

  /**
   * Konstruktor untuk tampilan pot berbunga.
   * Tampilan disesuaikan dengan <code>flowerState</code>
   * dan <code>flowerName</code> yang disimpan <code>flower</code>
   *
   * @param flower instans bunga yang ingin ditampilkan
   * @param posX absis posisi peletakan gambar pada layar
   * @param posY absis posisi peletakan gambar pada layar
   */
  public PlantView(Flower flower, int posX, int posY) {
    String filename;
    switch (flower.getFlowerState()) {
      case 1:
        filename = "asset/potbibit.png";
        break;
      case 2:
        filename = "asset/pottangkai.png";
        break;
      case 3:
        String flowerName = flower.getFlowerName();
        filename = "asset/pot" + flowerName + ".png";
        break;
      default:
        filename = "asset/potlayu.png";
    }
    ImageIcon flowerView = new ImageIcon(filename);
    JLabel flowerLabel = new JLabel(flowerView);
    flowerLabel.setBounds(posX, posY, WIDTH_SIZE, HEIGHT_SIZE);
  }
}
