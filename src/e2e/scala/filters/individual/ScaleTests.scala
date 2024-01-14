package filters.individual

import helpers.{TestWithBourkeImages, TestWithConsoleApplication}
import org.scalatest.FunSuite
import org.scalatest.Matchers.{an, be, convertToAnyShouldWrapper}

class ScaleTests
    extends FunSuite
    with TestWithConsoleApplication
    with TestWithBourkeImages {

  def image3x3Quartered: String = "$B\n" + "M*\n"
  def image3x3Quadrupled: String =
    "$$@@BB\n" + "$$@@BB\n" + "%%88WW\n" + "%%88WW\n" + "MM##**\n" + "MM##**\n"

  def image4x4Quartered: String = "$B\n" + "ad\n"

  def image4x4Quadrupled: String =
    "$$@@BB%%\n" + "$$@@BB%%\n" + "88WWMM**\n" + "88WWMM**\n" + "aahhddqq\n" + "aahhddqq\n" + "wwmmOO00\n" + "wwmmOO00\n"

  def scaleImage(imagePath: String, factor: String): String =
    runWithArgs(
      Seq(
        importImageFlag(imagePath),
        bourkeTableFlag,
        scaleFlag(factor),
        outputConsoleFlag))

  test("Scaling by 0.25 should work on 3x3 image") {
    scaleImage(image3x3Path, "0.25") should be(image3x3Quartered)
  }

  test("Scaling by 4 should work on 3x3 image") {
    scaleImage(image3x3Path, "4") should be(image3x3Quadrupled)
  }

  test("Scaling by 0.25 should work on 4x4 image") {
    scaleImage(image4x4Path, "0.25") should be(image4x4Quartered)
  }

  test("Scaling by 4 should work on 4x4 image") {
    scaleImage(image4x4Path, "4") should be(image4x4Quadrupled)
  }

  test("Scaling by 1 should be identity for image 3x3") {
    scaleImage(image3x3Path, "1") should be(image3x3Converted)
  }

  test("Scaling by 1 should be identity for image 4x4") {
    scaleImage(image4x4Path, "1") should be(image4x4Converted)
  }

  test("Invalid scaling factors should throw signal error") {
    an[Exception] should be thrownBy scaleImage(image3x3Path, "")
    an[Exception] should be thrownBy scaleImage(image3x3Path, "asd")
    an[Exception] should be thrownBy scaleImage(image3x3Path, "8")
    an[Exception] should be thrownBy scaleImage(image3x3Path, "0.125")
    an[Exception] should be thrownBy scaleImage(image3x3Path, "0")
  }

}
