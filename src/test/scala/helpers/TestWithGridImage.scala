package helpers

import asciiArtApp.model.image.grid.GridImage
import org.scalatest.Matchers.{an, be, noException, thrownBy}

trait TestWithGridImage {
  def testGridImageDimensions(gridImage: GridImage[_]): Unit = {
    // check all allowed are ok
    for (x <- 0 until gridImage.width)
      for (y <- 0 until gridImage.height)
        noException should be thrownBy gridImage.at(x, y)

    // check all disallowed throw
    for (x <- -1 to gridImage.width) {
      // check below bounds
      an[IllegalArgumentException] should be thrownBy gridImage.at(
        x,
        gridImage.height)
      // check above bounds
      an[IllegalArgumentException] should be thrownBy gridImage.at(x, -1)
    }

    for (y <- -1 until gridImage.height) {
      // check left
      an[IllegalArgumentException] should be thrownBy gridImage.at(-1, y)
      // check right
      an[IllegalArgumentException] should be thrownBy gridImage.at(
        gridImage.width,
        y)
    }
  }

  def all[T](gridImage: GridImage[T], pred: T => Boolean): Unit =
    for (x <- 1 until gridImage.width)
      for (y <- 1 until gridImage.height)
        assert(pred(gridImage.at(x, y)))

}
