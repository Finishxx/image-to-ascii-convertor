package asciiArtApp.converters.color.toRgb

import asciiArtApp.model.color.rgb.RgbColor
import converters.Converter

/**
 * Converts Ints packed with rgb color information int RgbColors
 *
 * @tparam V Specific type of RgbColor
 */
trait IntAsColorToRgbColorConverter[V <: RgbColor]
    extends Converter[Int, V]
