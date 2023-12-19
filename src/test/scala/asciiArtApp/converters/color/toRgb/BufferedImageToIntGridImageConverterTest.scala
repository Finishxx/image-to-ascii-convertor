package asciiArtApp.converters.color.toRgb

import helpers.{TestWithGridImage, TestWithImages, TestWithIntColor}
import org.scalatest.FunSuite
import org.scalatest.Matchers.{convertToAnyShouldWrapper, equal}

class BufferedImageToIntGridImageConverterTest
    extends FunSuite
    with TestWithIntColor
    with TestWithImages
    with TestWithGridImage {

  val converter = new BufferedImageToIntGridImageConverter

  def testConversion(path: String, allSatisfy: Int => Boolean): Unit = {
    val bufferedImage = loadBufferedImage(path)

    val intGrid = converter.convert(bufferedImage)

    intGrid.width should equal(bufferedImage.getWidth)
    intGrid.height should equal(bufferedImage.getHeight)

    all(intGrid, allSatisfy)
  }

  test("4x4 white") {
    testConversion(white4x4Png, int => hasRgb(int, 255, 255, 255))
  }

  test("4x4 black") {
    testConversion(black4x4Png, int => hasRgb(int, 0, 0, 0))
  }

  test("4x4 red") {
    testConversion(red4x4Png, int => hasRgb(int, 255, 0, 0))
  }
}
