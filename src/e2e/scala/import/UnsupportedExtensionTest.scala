package `import`

import helpers.TestWithConsoleApplication
import org.scalatest.FunSuite
import org.scalatest.Matchers.{an, be}

class UnsupportedExtensionTest
    extends FunSuite
    with TestWithConsoleApplication
    with TestWithImport {

  def bmpImagePath: String = "src/e2e/scala/images/formats/3x3bmp.bmp"

  test("Error is thrown when using BMP file") {
    an[Exception] should be thrownBy
      runWithArgs(
        Seq(
          importImageFlag(bmpImagePath),
          outputConsoleFlag,
          bourkeTableFlag))
  }
}
