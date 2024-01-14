package filters

import helpers.TestWithConsoleApplication

trait TestWithMultipleOutputs extends TestWithConsoleApplication {

  def getMultipleOutputs(
    importFlag: String,
    conversionFlag: String,
    flagsToFilenames: Seq[Seq[String]]): Seq[String] = {
    var flags: String = importFlag + conversionFlag
    for (nextFlags <- flagsToFilenames) {

    }
    ???
  }

}
