package helpers

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

trait TestWithImages {

  def white4x4Gif: String = "src/test/scala/testFiles/4x4white.gif"
  def white4x4Jpg: String = "src/test/scala/testFiles/4x4white.jpg"
  def white4x4Png: String = "src/test/scala/testFiles/4x4white.png"
  def black4x4Png: String = "src/test/scala/testFiles/4x4black.png"
  def red4x4Png: String = "src/test/scala/testFiles/4x4red.png"

  def loadBufferedImage(path: String): BufferedImage =
    ImageIO.read(new File(path))

}
