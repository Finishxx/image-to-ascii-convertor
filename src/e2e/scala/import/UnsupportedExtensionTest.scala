package `import`

import helpers.TestWithConsoleApplication
import org.scalatest.FunSuite
import org.scalatest.Matchers.{an, be}

class UnsupportedExtensionTest
    extends FunSuite
    with TestWithConsoleApplication
    with TestWithImportTest {

  test("Error is thrown when using BMP file") {
    an[Exception] should be thrownBy
      runWithArgs(
        Seq(
          importImageFlag(image3x3PathBmp),
          outputConsoleFlag,
          bourkeTableFlag))
  }
}
