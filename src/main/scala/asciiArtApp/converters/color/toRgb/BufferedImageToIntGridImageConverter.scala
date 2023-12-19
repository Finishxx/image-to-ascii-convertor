package asciiArtApp.converters.color.toRgb

import asciiArtApp.model.image.grid.{GridImage, GridImageAs2DSeq}
import converters.Converter

import java.awt.image.BufferedImage

class BufferedImageToIntGridImageConverter
    extends Converter[BufferedImage, GridImage[Int]] {
  override def convert(what: BufferedImage): GridImage[Int] =
    new GridImageAs2DSeq(
      what
        .getRGB(0, 0, what.getWidth, what.getHeight, null, 0, what.getWidth)
        .toSeq
        .grouped(what.getWidth())
        .toSeq
    )
}
