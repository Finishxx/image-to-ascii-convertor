package asciiArtApp.model.color.greyscale

import asciiArtApp.model.color.Color

case class Greyscale8BitColor(intensity: Int) extends Color {
  require(
    intensity >= 0 && intensity <= 255,
    "Please use values between 0 and 255 for representing red color")
}
