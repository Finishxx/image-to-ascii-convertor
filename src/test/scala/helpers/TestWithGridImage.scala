package helpers

import asciiArtApp.model.image.grid.GridImage
import org.scalatest.Matchers.{an, be, noException, thrownBy}

trait TestWithGridImage {
  def testGridImageDimensions(gridImage: GridImage[_]): Unit = {
    // check all allowed are ok
    for (x <- 1 to gridImage.width)
      for (y <- 1 to gridImage.height)
        noException should be thrownBy gridImage.at(x, y)

    // check all disallowed throw
    for (x <- 0 to gridImage.width + 1) {
      // check below bounds
      an[IllegalArgumentException] should be thrownBy gridImage.at(
        x,
        gridImage.height + 1)
      // check above bounds
      an[IllegalArgumentException] should be thrownBy gridImage.at(x, 0)
    }

    for (y <- 0 to gridImage.height + 1) {
      // check left
      an[IllegalArgumentException] should be thrownBy gridImage.at(0, y)
      // check right
      an[IllegalArgumentException] should be thrownBy gridImage.at(
        gridImage.width + 1,
        y)
    }
  }

}
