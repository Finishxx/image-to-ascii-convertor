package helpers

import asciiArtApp.model.color.greyscale.Greyscale8BitColor
import asciiArtApp.model.color.rgb.Rgb24BitColor

import scala.util.Random

trait TestWithColor {

  // After much thought, this is too much, deprecated in favor of testing 1000 random values
  def getAllRgb24BitColors: Iterable[Rgb24BitColor] = {
    val colorIterable: Iterable[Rgb24BitColor] = for {
      r <- 0 to 255
      g <- 0 to 255
      b <- 0 to 255
    } yield Rgb24BitColor(r, g, b)
    colorIterable
  }

  def get1000RandomRgb24BitColors: Iterable[Rgb24BitColor] = {
    val random: Random = new Random()
    val colorIterable: Iterable[Rgb24BitColor] = for (r <- 0 to 1000)
      yield
        Rgb24BitColor(
          random.between(1, 256),
          random.between(1, 256),
          random.between(1, 256))
    colorIterable
  }

  def getAllGreyscale8BitColors: Iterable[Greyscale8BitColor] = {
    val colorIterable: Iterable[Greyscale8BitColor] =
      for (intensity <- 0 to 255)
        yield Greyscale8BitColor(intensity)
    colorIterable
  }

  def greyscale8BitColorSatisfy(
    what: Greyscale8BitColor => Boolean): Boolean = {
    for (intensity <- 0 to 255)
      if (!what(Greyscale8BitColor(intensity)))
        return false
    true
  }

}
