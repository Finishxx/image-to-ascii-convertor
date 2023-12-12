package asciiArtApp.converters.image.specific

import converters.Converter

class ColorCodeImageToRasterImageConverter(converter: Converter[Int, RgbPixel]) extends Converter[Seq[Seq[Int]], Rgb24BitColorImage] {
  override def convert(what: Seq[Seq[Int]]): Rgb24BitColorImage = new Rgb24BitColorImage(what.map(_.map(converter.convert)))
}
