package `import`

import helpers.TestWithConsoleApplication
import org.scalatest.FunSuite

class PngImportTest
    extends FunSuite
    with TestWithConsoleApplication
    with TestWithImportTest {

  test("No exceptions thrown") {
    tryAllTablesWithImage(image3x3PathPng)
  }
}
