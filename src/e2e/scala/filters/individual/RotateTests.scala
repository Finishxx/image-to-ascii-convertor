package filters.individual

import helpers.{TestWithBourkeImages, TestWithConsoleApplication}
import org.scalatest.FunSuite
import org.scalatest.Matchers.{an, be, convertToAnyShouldWrapper, thrownBy}

class RotateTests
    extends FunSuite
    with TestWithConsoleApplication
    with TestWithBourkeImages {

  // 90
  def image3x3RotatedCWBy90: String = "BW*\n" + "@8#\n" + "$%M\n"
  //-90
  def image3x3RotatedCCWBy90: String = "M%$\n" + "#8@\n" + "*WB\n"
  def image3x3RotatedBy180: String = "*#M\n" + "W8%\n" + "B@$\n"
  // 90
  def image4x4RotatedCWBy90: String = "%*q0\n" + "BMdO\n" + "@Whm\n" + "$8aw\n"
  // -90
  def image4x4RotatedCCWBy90: String = "wa8$\n" + "mhW@\n" + "OdMB\n" + "0q*%\n"
  def image4x4RotatedBy180: String = "0Omw\n" + "qdha\n" + "*MW8\n" + "%B@$\n"

  def rotateByDegrees(imagePath: String, degrees: String): String =
    runWithArgs(
      Seq(
        importImageFlag(imagePath),
        bourkeTableFlag,
        rotate(degrees), // order matters
        outputConsoleFlag))

  test("Rotate by 0 is identity on 3x3 image") {
    rotateByDegrees(image3x3Path, "0") should be(image3x3Converted)
  }

  test("Rotate by 0 is identity on 4x4 image") {
    rotateByDegrees(image4x4Path, "0") should be(image4x4Converted)
  }

  test("Rotate by 90 degrees works on 3x3 image") {
    rotateByDegrees(image3x3Path, "90") should be(image3x3RotatedCWBy90)
  }

  test("Rotate by 90 degrees works on 4x4 image") {
    rotateByDegrees(image4x4Path, "90") should be(image4x4RotatedCWBy90)
  }

  test("Rotated by 180 degrees works on 3x3 image") {
    rotateByDegrees(image3x3Path, "180") should be(image3x3RotatedBy180)
  }

  test("Rotated by 180 degrees works on 4x4 image") {
    rotateByDegrees(image4x4Path, "180") should be(image4x4RotatedBy180)
  }

  test("Rotated by -90 degrees works on 3x3 image") {
    rotateByDegrees(image3x3Path, "-90") should be(image3x3RotatedCCWBy90)
  }

  test("Rotated by -90 degrees works on 4x4 image") {
    rotateByDegrees(image4x4Path, "-90") should be(image4x4RotatedCCWBy90)
  }

  def testIdentity(
    degrees1: String,
    degrees2: String,
    imagePath: String): Unit = {
    val first: String = rotateByDegrees(imagePath, degrees1)
    val second: String = rotateByDegrees(imagePath, degrees2)

    assert(first == second)
  }

  def testIdentityInSuccession(degrees: Int, imagePath: String): Unit =
    for (i <- -3 to 3)
      testIdentity(degrees.toString, (degrees + i * 360).toString, imagePath)

  test("Rotation by 90 degrees is identical to full rotations with same offset") {
    testIdentityInSuccession(90, image3x3Path)
    testIdentityInSuccession(90, image4x4Path)
  }

  test("Rotation by 0 degrees is identical to full rotations with same offset") {
    testIdentityInSuccession(0, image3x3Path)
    testIdentityInSuccession(0, image4x4Path)
  }

  test(
    "Rotation by 180 degrees is identical to full rotations with same offset") {
    testIdentityInSuccession(180, image3x3Path)
    testIdentityInSuccession(180, image4x4Path)
  }

  test(
    "Rotation by -90 degrees is identical to full rotations with same offset") {
    testIdentityInSuccession(-90, image3x3Path)
    testIdentityInSuccession(-90, image4x4Path)
  }

  test("Rotation by non multiples of 90 results in an error") {
    an[Exception] should be thrownBy rotateByDegrees(image3x3Path, "-1")
    an[Exception] should be thrownBy rotateByDegrees(image3x3Path, "1")
    an[Exception] should be thrownBy rotateByDegrees(image3x3Path, "110")
    an[Exception] should be thrownBy rotateByDegrees(image3x3Path, "-110")
  }

  test("Rotation by non-integers should result in an error") {
    an[Exception] should be thrownBy rotateByDegrees(image3x3Path, "")
    an[Exception] should be thrownBy rotateByDegrees(image3x3Path, "asd")
    an[Exception] should be thrownBy rotateByDegrees(image3x3Path, "0.0")
  }
}
