package asciiArtApp.converters.color.toGreyscale

import asciiArtApp.model.color.greyscale.GreyscaleColor
import asciiArtApp.model.color.rgb.RgbColor
import converters.Converter

/**
 * Converts RgbColors to GreyscaleColors
 * @tparam T Specific type of RgbColor
 * @tparam V Specific type of GreyscaelColor
 */
trait RgbToGreyscaleColorConverter[T <: RgbColor, V <: GreyscaleColor]
    extends Converter[T, V]
