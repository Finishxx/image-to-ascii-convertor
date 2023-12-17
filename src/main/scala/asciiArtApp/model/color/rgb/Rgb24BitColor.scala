package asciiArtApp.model.color.rgb

case class Rgb24BitColor(red: Int, green: Int, blue: Int) extends RgbColor {
  require(
    red >= 0 && red <= 255,
    "Please use values between 0 and 255 for representing red color")
  require(
    green >= 0 && green <= 255,
    "Please use values between 0 and 255 for representing green color")
  require(
    blue >= 0 && blue <= 255,
    "Please use values between 0 and 255 for representing blue color")
}
