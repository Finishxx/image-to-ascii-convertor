package asciiArtApp.dataSource.image.imageIo

import dataSource.fileSystem.FromFileImporter

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

/**
 * Imports BufferedImage using ImageIO library
 * @param file File pointing to image we want to import
 */
class ImageIoBufferedImageImporter(file: File)
    extends FromFileImporter[BufferedImage](file)
    with BufferedImageImporter {
  require(file.exists(), "Please provide a path to a file, which exists!")
  override protected def importFromFile(file: File): BufferedImage =
    ImageIO.read(file)
}
