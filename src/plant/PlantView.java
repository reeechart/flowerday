package plant;

import javax.swing.ImageIcon;

/**
 * Kelas real yang mengurus tentang tampilan pot dan bunga pada layar.
 *
 * @author Gisela Supardi
 * @version 23/04/2017
 */
public class PlantView {

  /**
   * Image untuk ditampilkan.
   */
  private ImageIcon image;

  /**
   * Konstruktor untuk tampilan pot yang belum ditanami bunga.
   */
  PlantView() {
    image = new ImageIcon("asset/potempty.png");
  }

  /**
   * Konstruktor untuk tampilan pot berbunga.
   * Tampilan disesuaikan dengan <code>flowerState</code>
   * dan <code>flowerName</code> yang disimpan <code>flower</code>
   *
   * @param flower instans bunga yang ingin ditampilkan
   */
  PlantView(Flower flower) {
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
    image = new ImageIcon(filename);
  }

  /**
   * Getter dari gambar tanaman.
   *
   * @return gambar dari pot atau bunga.
   */
  ImageIcon getImage() {
    return image;
  }
}
