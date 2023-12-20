package asciiArtApp.converters.color.toRgb

import asciiArtApp.model.color.rgb.Rgb24BitColor
import converters.Converter

/**
 * Converts an Int representing color into Rgb24BitColor case class.
 *
 * The Int has to pack the color information in this exact manner:
 *
 * Red: bits 16 to 23
 * Green: bits 8 to 15
 * Blue: bits 0 to 7
 */
class IntAsColorToRgb24BitColorConverter extends Converter[Int, Rgb24BitColor] {
  override def convert(what: Int): Rgb24BitColor =
    Rgb24BitColor((what >> 16) & 0xFF, (what >> 8) & 0xFF, what & 0xFF)
}
