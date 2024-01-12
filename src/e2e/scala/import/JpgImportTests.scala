package `import`

import helpers.TestWithConsoleApplication
import org.scalatest.FunSuite

class JpgImportTests
    extends FunSuite
    with TestWithConsoleApplication
    with TestWithImport {

  def jpgImagePath: String = "src/e2e/scala/images/formats/3x3jpg.jpg"

  test("No exceptions thrown") {
    tryAllTablesWithImage(jpgImagePath)
  }

}
