package asciiArtApp.model.color.rgb

import asciiArtApp.model.color.Color

trait RgbColor[T] extends Color {

  def red: T

  def green: T

  def blue: T
}
