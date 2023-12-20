package asciiArtApp.model.color.rgb

/**
 * Represents RGB color with range of values of 0 to 255 for each color
 *
 * @param red Represents red portion of the color
 * @param green Represents green portion of the color
 * @param blue Represents blue portion of the color
 */
case class Rgb24BitColor(red: Int, green: Int, blue: Int) extends RgbColor {
  require(
    (0 to 255).contains(red),
    "Please use values between 0 and 255 for representing red color")
  require(
    (0 to 255).contains(green),
    "Please use values between 0 and 255 for representing green color")
  require(
    (0 to 255).contains(blue),
    "Please use values between 0 and 255 for representing blue color")
}
