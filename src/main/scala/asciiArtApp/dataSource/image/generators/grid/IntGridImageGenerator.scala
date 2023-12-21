package asciiArtApp.dataSource.image.generators.grid

import asciiArtApp.model.image.grid.{GridImage, GridImageAs2DSeq}
import dataSource.generators.number.IntGenerator

import scala.util.Random

/**
 * Generates an Int GridImage using provided intGenerator
 *
 * @param width Desired width of the generated GridImage
 * @param height Desired height of the generated GridImage
 * @param intGenerator Generates individual ints contained in produced GridImage
 */
class IntGridImageGenerator(
  width: Int,
  height: Int,
  intGenerator: IntGenerator)
    extends GridImageGenerator[Int](width, height) with IntAsColorGridImageGenerator {
  require(width > 0, "Non-positive width does not make sense for a grid!")
  require(height > 0, "Non-positive height does not make sense for a grid!")
  override def generate(width: Int, height: Int): GridImage[Int] =
    new GridImageAs2DSeq(Seq.fill(width, height)(intGenerator.provide()))
}
