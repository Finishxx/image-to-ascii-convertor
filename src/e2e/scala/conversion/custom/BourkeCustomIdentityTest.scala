package conversion.custom

import org.scalatest.FunSuite

class BourkeCustomIdentityTest extends FunSuite with TestIdentity {

  def bourkeChars: String =
    "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. "

  def image3x3Path: String = "src/e2e/scala/images/bourke/3x3png.png"

  test("3x3 image should convert the same as with custom") {
    testIdentity(
      importImageFlag(image3x3Path),
      bourkeSmallTableFlag,
      customTableFlag(bourkeChars))
  }

  test("Random image should convert the same as with custom") {
    testIdentity(
      randomImageFlag,
      bourkeSmallTableFlag,
      customTableFlag(bourkeChars))
  }
}
