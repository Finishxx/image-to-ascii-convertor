package `import`

import helpers.TestWithConsoleApplication
import org.scalatest.FunSuite

class GifImportTest
    extends FunSuite
    with TestWithConsoleApplication
    with TestWithImportTest {

  test("No exceptions thrown") {
    tryAllTablesWithImage(image3x3PathGif)
  }
}
