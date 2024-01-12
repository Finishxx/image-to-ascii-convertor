package `import`

import helpers.TestWithConsoleApplication
import org.scalatest.FunSuite

class JpgImportTests
    extends FunSuite
    with TestWithConsoleApplication
    with TestWithImport {

  test("No exceptions thrown") {
    tryAllTablesWithImage(image3x3PathJpg)
  }

}
