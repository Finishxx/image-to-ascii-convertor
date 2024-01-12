package `import`

import helpers.TestWithConsoleApplication
import org.scalatest.FunSuite

class PngImportTest
    extends FunSuite
    with TestWithConsoleApplication
    with TestWithImport {

  test("No exceptions thrown") {
    tryAllTablesWithImage(image3x3PathPng)
  }
}
