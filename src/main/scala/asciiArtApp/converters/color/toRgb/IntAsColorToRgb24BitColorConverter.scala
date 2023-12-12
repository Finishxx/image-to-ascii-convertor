package asciiArtApp.converters.color.toRgb

import asciiArtApp.model.color.rgb.Rgb24BitColor
import converters.Converter

class IntAsColorToRgb24BitColorConverter extends Converter[Int, Rgb24BitColor] {
  override def convert(what: Int): Rgb24BitColor =
    Rgb24BitColor(
      ((what >> 16) & 0xFF).toByte,
      ((what >> 8) & 0xFF).toByte,
      (what & 0xFF).toByte)

}
