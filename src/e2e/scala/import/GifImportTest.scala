package `import`

import helpers.TestWithConsoleApplication
import org.scalatest.FunSuite

class GifImportTest
    extends FunSuite
    with TestWithConsoleApplication
    with TestWithImport {

  def gifImagePath: String = "src/e2e/scala/images/formats/3x3gif.gif"

  test("No exceptions thrown") {
    tryAllTablesWithImage(gifImagePath)
  }
}
