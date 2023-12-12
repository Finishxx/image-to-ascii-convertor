package asciiArtApp.converters.image.specific.toRgb

import asciiArtApp.model.image.grid.GridImageAs2DSeq
import converters.Converter

import java.awt.image.BufferedImage

class BufferedImageToIntGridImageConverter
    extends Converter[BufferedImage, GridImageAs2DSeq[Int]] {
  override def convert(what: BufferedImage): GridImageAs2DSeq[Int] =
    new GridImageAs2DSeq(
      what
        .getRGB(0, 0, what.getWidth, what.getHeight, null, 0, 0)
        .toSeq
        .grouped(what.getWidth())
        .toSeq
    )
}
