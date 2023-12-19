package asciiArtApp.converters.color.toRgb

import asciiArtApp.model.color.rgb.Rgb24BitColor
import helpers.TestWithIntColor
import org.scalatest.FunSuite

class IntAsColorToRgb24BitColorConverterTest
    extends FunSuite
    with TestWithIntColor {

  val converter = new IntAsColorToRgb24BitColorConverter

  test("All 24 bit colors") {
    def sameColor(rgb24BitColor: Rgb24BitColor, intColor: Int): Boolean =
      rgb24BitColor.blue == getBlue(intColor) &&
        rgb24BitColor.red == getRed(intColor) &&
        rgb24BitColor.green == getGreen(intColor)

    for (i <- 0 to 0x00FFFFFF) {
      val convertedColor = converter.convert(i)

      assert(sameColor(convertedColor, i))
    }
  }

}
