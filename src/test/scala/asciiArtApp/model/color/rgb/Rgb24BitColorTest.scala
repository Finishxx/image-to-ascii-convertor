package asciiArtApp.model.color.rgb

import org.scalatest.FunSuite
import org.scalatest.Matchers.{an, be}

class Rgb24BitColorTest extends FunSuite {

  test("Test bounds") {
    an[IllegalArgumentException] should be thrownBy Rgb24BitColor(-1, 0, 0)
    an[IllegalArgumentException] should be thrownBy Rgb24BitColor(0, -1, 0)
    an[IllegalArgumentException] should be thrownBy Rgb24BitColor(0, 0, -1)

    Rgb24BitColor(0, 0, 0)
    Rgb24BitColor(255, 255, 255)

    an[IllegalArgumentException] should be thrownBy Rgb24BitColor(256, 0, 0)
    an[IllegalArgumentException] should be thrownBy Rgb24BitColor(0, 256, 0)
    an[IllegalArgumentException] should be thrownBy Rgb24BitColor(0, 0, 256)
  }
}
