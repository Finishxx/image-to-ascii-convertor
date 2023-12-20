package asciiArtApp.model.color.greyscale

/**
 * Represents greyscale with intensity ranging from 0 to 255
 *
 * @param intensity Intensity of the greyscale color
 */
case class Greyscale8BitColor(intensity: Int) extends GreyscaleColor {
  require(
    (0 to 255).contains(intensity),
    "Please use values between 0 and 255 for representing red color")
}
