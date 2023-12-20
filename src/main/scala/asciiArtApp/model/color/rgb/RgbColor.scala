package asciiArtApp.model.color.rgb

import asciiArtApp.model.color.Color

/**
 * Represents color made out of 3 colors red, green and blue
 */
trait RgbColor extends Color {

  def red: Int

  def green: Int

  def blue: Int

}
