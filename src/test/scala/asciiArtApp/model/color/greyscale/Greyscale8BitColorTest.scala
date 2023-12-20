package asciiArtApp.model.color.greyscale

import org.scalatest.FunSuite
import org.scalatest.Matchers.{an, be}
class Greyscale8BitColorTest extends FunSuite {

  test("Test bounds") {
    an[IllegalArgumentException] should be thrownBy Greyscale8BitColor(-1)
    Greyscale8BitColor(0)
    Greyscale8BitColor(255)
    an[IllegalArgumentException] should be thrownBy Greyscale8BitColor(256)
  }
}
