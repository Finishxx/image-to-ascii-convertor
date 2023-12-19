package asciiArtApp.converters.color.toGreyscale

import asciiArtApp.model.color.greyscale.Greyscale8BitColor
import asciiArtApp.model.color.rgb.Rgb24BitColor
import converters.Converter

import scala.math.Fractional.Implicits.infixFractionalOps

class Rgb24BitToGreyscale8BitColorConverter(
  redWeight: Double,
  greenWeight: Double,
  blueWeight: Double)
    extends Converter[Rgb24BitColor, Greyscale8BitColor] {
  require(
    Math.abs(redWeight + greenWeight + blueWeight - 1) < 1e-10,
    "Weights should add up to 1 to get reasonable results!")
  require(
    (0 to 1).contains(redWeight),
    "Red weight should be non-negative and not greater than one!")
  require(
    (0 to 1).contains(greenWeight),
    "Green weight should be non-negative and not greater than one!")
  require(
    (0 to 1).contains(blueWeight),
    "Blue weight should be non-negative and not greater than one!")

  override def convert(what: Rgb24BitColor): Greyscale8BitColor =
    Greyscale8BitColor(
      ((what.red * redWeight) + (what.green * greenWeight) + (what.blue * blueWeight)).toInt)
}
