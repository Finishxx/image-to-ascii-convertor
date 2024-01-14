package conversion

import helpers.TestWithConsoleApplication

trait TestWithConversion extends TestWithConsoleApplication {

  def convert(imagePath: String, conversionFlag: String): String =
    runWithArgs(
      Seq(importImageFlag(imagePath), conversionFlag, outputConsoleFlag))

}
