package asciiArtApp.converters.image.specific

import converters.Converter

import java.awt.image.BufferedImage

class BufferedImageToColorAsIntGridConverter
    extends Converter[BufferedImage, Seq[Seq[Int]]] {
  override def convert(what: BufferedImage): Seq[Seq[Int]] =
    what
      .getRGB(0, 0, what.getWidth, what.getHeight, null, 0, 0)
      .toSeq
      .grouped(what.getWidth())
      .toSeq
}
