package asciiArtApp.converters.color.toRgb

import asciiArtApp.model.color.rgb.RgbColor
import converters.Converter

trait IntAsColorToRgbColorConverter[V <: RgbColor] extends Converter[Int, RgbColor]
