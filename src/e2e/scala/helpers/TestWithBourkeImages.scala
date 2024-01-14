package helpers

trait TestWithBourkeImages {

  def image3x3Path: String = "src/e2e/scala/images/bourke/3x3.png"
  def image3x3Converted: String = "$@B\n" + "%8W\n" + "M#*\n"

  def image4x4Path: String = "src/e2e/scala/images/bourke/4x4.png"
  def image4x4Converted: String = "$@B%\n" + "8WM*\n" + "ahdq\n" + "wmO0\n"
}
