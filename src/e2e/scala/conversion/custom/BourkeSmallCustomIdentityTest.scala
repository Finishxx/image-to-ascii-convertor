package conversion.custom

import helpers.TestWithBourkeSmallImages
import org.scalatest.FunSuite

class BourkeSmallCustomIdentityTest
    extends FunSuite
    with TestIdentity
    with TestWithBourkeSmallImages {

  def bourkeSmallChars: String = " .:-=+*#%@"
  def conversionFlag: String = bourkeSmallTableFlag

  test("3x3 image should convert the same as with custom") {
    testIdentity(
      importImageFlag(image3x3Path),
      conversionFlag,
      customTableFlag(bourkeSmallChars))
  }

  test("4x4 image should convert the same as with custom") {
    testIdentity(
      importImageFlag(image4x4Path),
      conversionFlag,
      customTableFlag(bourkeSmallChars))
  }
}
