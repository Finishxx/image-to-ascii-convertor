package asciiArtApp.dataSource.image.imageIo

import dataSource.fileSystem.FromFileImporter

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

class ImageIoImporter(file: File)
    extends FromFileImporter[BufferedImage](file) {
  override protected def importFromFile(file: File): BufferedImage =
    ImageIO.read(file)
}
