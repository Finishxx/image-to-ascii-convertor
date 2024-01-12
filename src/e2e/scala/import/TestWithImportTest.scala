package `import`

import helpers.TestWithConsoleApplication

trait TestWithImportTest extends TestWithConsoleApplication {

  def tryAllTablesWithImage(imagePath: String): Unit =
    for (table <- Seq(
           bourkeTableFlag,
           bourkeSmallTableFlag,
           nonLinearTableFlag))
      println(runWithArgs(Seq(importImageFlag(imagePath), table)))
}
