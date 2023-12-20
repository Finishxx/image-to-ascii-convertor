package asciiArtApp.converters.color.toGreyscale

import asciiArtApp.model.color.rgb.Rgb24BitColor
import helpers.TestWithColor
import org.scalatest.FunSuite
import org.scalatest.Matchers.{
  an,
  be,
  convertToAnyShouldWrapper,
  equal,
  thrownBy
}

class Rgb24BitToGreyscale8BitColorConverterTest
    extends FunSuite
    with TestWithColor {

  // Also checks for maximum and minimum while at it values (edge cases)
  def testWeightsOver1000Rgb24BitColors(
    redWeight: Double,
    greenWeight: Double,
    blueWeight: Double): Unit = {
    val converter = new Rgb24BitToGreyscale8BitColorConverter(
      redWeight,
      greenWeight,
      blueWeight)

    for (rgbColor <- get1000RandomRgb24BitColors ++ Seq(
           Rgb24BitColor(0, 0, 0),
           Rgb24BitColor(255, 255, 255))) {
      val converted = converter.convert(rgbColor)
      converted.intensity should equal(
        (rgbColor.red * redWeight + rgbColor.green * greenWeight + rgbColor.blue * blueWeight).toInt)
    }
  }

  test("Red only") {
    testWeightsOver1000Rgb24BitColors(1, 0, 0)
  }

  test("Green only") {
    testWeightsOver1000Rgb24BitColors(0, 1, 0)
  }

  test("Blue only") {
    testWeightsOver1000Rgb24BitColors(0, 0, 1)
  }

  test("Equal spread") {
    testWeightsOver1000Rgb24BitColors(1.0 / 3, 1.0 / 3, 1.0 / 3)
  }

  test("0.3 Red, 0.59 Green, 0.11 Blue") {
    testWeightsOver1000Rgb24BitColors(0.3, 0.59, 0.11)
  }

  test("Invalid weights throw") {
    def shouldThrowOn(r: Double, g: Double, b: Double) =
      an[IllegalArgumentException] should be thrownBy
        new Rgb24BitToGreyscale8BitColorConverter(r, g, b)

    shouldThrowOn(0, 0, 0)
    shouldThrowOn(-1, 1, 0)
    shouldThrowOn(1, 1, 0)
    shouldThrowOn(0, 1.01, -0.01)
    shouldThrowOn(0.02, 0.99, -0.01)
    shouldThrowOn(2, -2, 1)
    shouldThrowOn(1.0 / 4, 1.0 / 4, 1.0 / 4)
  }

}
