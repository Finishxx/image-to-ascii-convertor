package dataSource.imageColorCodeGrid.imageIo

import dataSource.imageColorCodeGrid.ImageColorCodeGridSource

import java.io.File
import javax.imageio.ImageIO

class ImageLoader(file: File) extends ImageColorCodeGridSource {
  protected def loadFromFile(file: File): Seq[Seq[Int]] = {

    val bufferedImage = ImageIO.read(file)

    bufferedImage
      .getRGB(0, 0, bufferedImage.getWidth, bufferedImage.getHeight, null, 0, 0)
      .toSeq
      .grouped(bufferedImage.getWidth())
      .toArray
      .toSeq

  }

  override def provide(): Seq[Seq[Int]] = loadFromFile(file)
}
