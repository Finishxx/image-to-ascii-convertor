package `import`

import helpers.TestWithConsoleApplication
import org.scalatest.FunSuite

class PngImportTest
    extends FunSuite
    with TestWithConsoleApplication
    with TestWithImport {

  def imagePath: String = "src/e2e/scala/images/formats/3x3png.png"

  test("No exceptions thrown") {
    tryAllTablesWithImage(imagePath)
  }
}
