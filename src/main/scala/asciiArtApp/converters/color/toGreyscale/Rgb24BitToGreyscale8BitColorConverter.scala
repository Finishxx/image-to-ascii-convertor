package asciiArtApp.converters.color.toGreyscale

import asciiArtApp.model.color.greyscale.Greyscale8BitColor
import asciiArtApp.model.color.rgb.Rgb24BitColor
import converters.Converter

class Rgb24BitToGreyscale8BitColorConverter(
  redWeight: Double,
  greenWeight: Double,
  blueWeight: Double)
    extends Converter[Rgb24BitColor, Greyscale8BitColor] {

  override def convert(what: Rgb24BitColor): Greyscale8BitColor =
    Greyscale8BitColor(
      ((what.red * redWeight) + (what.green * greenWeight) + (what.blue * blueWeight)).toInt)
}
