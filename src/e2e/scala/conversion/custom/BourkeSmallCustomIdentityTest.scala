package conversion.custom

import org.scalatest.FunSuite

class BourkeSmallCustomIdentityTest extends FunSuite with TestIdentity {

  def bourkeSmallChars: String = " .:-=+*#%@"

  def image3x3Path: String = "src/e2e/scala/images/bourkeSmall/3x3png.png"

  test("3x3 image should convert the same as with custom") {
    testIdentity(
      importImageFlag(image3x3Path),
      bourkeSmallTableFlag,
      customTableFlag(bourkeSmallChars))
  }

  test("Random image should convert the same as with custom") {
    testIdentity(
      randomImageFlag,
      bourkeSmallTableFlag,
      customTableFlag(bourkeSmallChars))
  }

}
