package helpers

// ((what >> 16) & 0xFF).toByte,
//      ((what >> 8) & 0xFF).toByte,
//      (what & 0xFF).toByte)

trait TestWithIntColor {
  def getRed(int: Int): Int = (int >> 16) & 0xFF

  def getGreen(int: Int): Int = (int >> 8) & 0xFF

  def getBlue(int: Int): Int = int & 0xFF

  def hasRgb(int: Int, r: Int, g: Int, b: Int): Boolean =
    //print( s"Expected: ($r, $g, $b), got: (${getRed(int)}, ${getGreen(int)}, ${getBlue(int)})")
    getRed(int) == r && getGreen(int) == g && getBlue(int) == b

  def rgbToInt(r: Int, g: Int, b: Int): Int = { // TODO: Delete if not neccessary
    require(
      r >= 0,
      "Please provide positive number for representing red color!")
    require(
      g >= 0,
      "Please provide positive number for representing green color!")
    require(
      b >= 0,
      "Please provide positive number for representing blue color!")

    (r & 0xFF) << 16 | (g & 0xFF) << 8 | (b & 0xFF)
  }

}
