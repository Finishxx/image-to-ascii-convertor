package asciiArtApp.converters.image.specific

import asciiArtApp.model.color.rgb.RgbColor
import asciiArtApp.model.image.grid.raster.{Rgb24BitColorImage, RgbColorImage}
import converters.Converter
import converters.specific.StructuralConverter

import java.awt.image.BufferedImage


class ColorAsNumberGridToRgbImageConverter[T, V](
  colorAsIntToRgbColorConverter: Converter[Int, RgbColor[T]])
    extends StructuralConverter[Seq[Seq[_]], T, Seq[Seq[RgbColor[V]]]] {
  override def convert(what: BufferedImage): RgbColorImage[T] = ???
}
