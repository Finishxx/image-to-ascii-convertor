package asciiArtApp.converters.color.toGreyscale

import asciiArtApp.model.color.greyscale.GreyscaleColor
import asciiArtApp.model.color.rgb.RgbColor
import converters.Converter

trait RgbToGreyscaleColorConverter[T <: RgbColor, V <: GreyscaleColor]
    extends Converter[T, V]
