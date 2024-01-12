package conversion.builtIn

import conversion.TestWithConversion
import org.scalatest.FunSuite

class BourkeConversionTest extends FunSuite with TestWithConversion {

  def image3x3Path: String = "src/e2e/scala/images/bourke/3x3png.png"
  def image3x3Expect: String = "$?#\n" + ".?:\n" + "asd\n" // TODO: Change
  def conversionFlag: String = bourkeTableFlag

  test("3x3") {
    assert(checkConversionExpect(image3x3Path, conversionFlag, image3x3Expect))
  }

}
