package filters.individual

import helpers.{TestWithBourkeImages, TestWithConsoleApplication}
import org.scalatest.FunSuite
import org.scalatest.Matchers.{an, be, convertToAnyShouldWrapper}

class FlipTests
    extends FunSuite
    with TestWithConsoleApplication
    with TestWithBourkeImages {

  def image3x3FlippedX: String = "M#*\n" + "%8W\n" + "$@B\n"
  def image3x3FlippedY: String = "B@$\n" + "W8%\n" + "*#M\n"

  def image4x4FlippedX: String = "wmO0\n" + "ahdq\n" + "8WM*\n" + "$@B%\n"
  def image4x4FlippedY: String = "%B@$\n" + "*MW8\n" + "qdha\n" + "0Omw\n"

  def flipImage(imagePath: String, axis: String): String =
    runWithArgs(
      Seq(
        importImageFlag(imagePath),
        bourkeTableFlag,
        flipFlag(axis),
        outputConsoleFlag))

  test("Flipping by X works on image 3x3") {
    flipImage(image3x3Path, "x") should be(image3x3FlippedX)
  }

  test("Flipping by X works on image 4x4") {
    flipImage(image4x4Path, "x") should be(image4x4FlippedX)
  }

  test("Flipping by Y works on image 3x3") {
    flipImage(image3x3Path, "y") should be(image3x3FlippedY)
  }

  test("Flipping by Y works on image 4x4") {
    flipImage(image4x4Path, "Y") should be(image4x4FlippedY)
  }

  test("Invalid input values signal error") {
    an[Exception] should be thrownBy flipImage(image3x3Path, "asd")
    an[Exception] should be thrownBy flipImage(image3x3Path, "")
    an[Exception] should be thrownBy flipImage(image3x3Path, "1")
  }

}
