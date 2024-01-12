package conversion.builtIn

import conversion.TestWithConversion
import org.scalatest.FunSuite
import org.scalatest.Matchers.{be, convertToAnyShouldWrapper}

class BourkeConversionTest extends FunSuite with TestWithConversion {

  def image3x3Path: String = "src/e2e/scala/images/bourke/3x3png.png"
  def image3x3Expect: String = "$B8\n" + "W#a\n" + "kdq\n"
  def conversionFlag: String = bourkeTableFlag

  test("3x3") {
    convert(image3x3Path, conversionFlag) should be(image3x3Expect)
  }

}
