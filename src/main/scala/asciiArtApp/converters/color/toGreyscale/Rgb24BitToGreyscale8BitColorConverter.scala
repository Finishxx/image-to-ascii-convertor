package asciiArtApp.converters.color.toGreyscale

import asciiArtApp.model.color.greyscale.Greyscale8BitColor
import asciiArtApp.model.color.rgb.Rgb24BitColor
import converters.Converter

class Rgb24BitToGreyscale8BitColorConverter(
  redWeight: Double,
  greenWeight: Double,
  blueWeight: Double)
    extends Converter[Rgb24BitColor, Greyscale8BitColor] {
  require(
    Math.abs(redWeight + greenWeight + blueWeight - 1) < 1e-10,
    "Weights should add up to 1 to get reasonable results!")

  override def convert(what: Rgb24BitColor): Greyscale8BitColor =
    Greyscale8BitColor(
      ((what.red * redWeight) + (what.green * greenWeight) + (what.blue * blueWeight)).toInt)
}
