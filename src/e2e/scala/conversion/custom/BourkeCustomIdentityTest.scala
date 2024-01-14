package conversion.custom

import helpers.TestWithBourkeImages
import org.scalatest.FunSuite

class BourkeCustomIdentityTest
    extends FunSuite
    with TestIdentity
    with TestWithBourkeImages {

  def bourkeChars: String =
    "'$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i:,\\\"^`'\"'. \""

  def conversionFlag: String = bourkeTableFlag

  test("3x3 image should convert the same as with custom") {
    testIdentity(
      importImageFlag(image3x3Path),
      conversionFlag,
      customTableFlagNoEscape(bourkeChars))
  }

  test("4x4 image should convert the same as with custom") {
    testIdentity(
      importImageFlag(image4x4Path),
      conversionFlag,
      customTableFlagNoEscape(bourkeChars))
  }
}
