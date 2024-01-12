package conversion.builtIn

import conversion.TestWithConversion
import org.scalatest.FunSuite

class NonLinearConversionTest extends FunSuite with TestWithConversion {

  def image3x3Path: String = "src/e2e/scala/images/nonLinear/3x3png.png"

  def image3x3Expect: String = "$B8\n" + "W#a\n" + "kdq\n" // TODO: create img etc. u know

  def conversionFlag: String = nonLinearTableFlag

  test("3x3") {
    convert(image3x3Path, conversionFlag)
  }

}
