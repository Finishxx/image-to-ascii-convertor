package conversion.builtIn

import conversion.TestWithConversion
import helpers.TestWithBourkeImages
import org.scalatest.FunSuite
import org.scalatest.Matchers.{be, convertToAnyShouldWrapper}

class BourkeConversionTest
    extends FunSuite
    with TestWithConversion
    with TestWithBourkeImages {
  def conversionFlag: String = bourkeTableFlag

  test("3x3") {
    convert(image3x3Path, conversionFlag) should be(image3x3Converted)
  }

  test("4x4") {
    convert(image4x4Path, conversionFlag) should be(image4x4Converted)
  }
}
