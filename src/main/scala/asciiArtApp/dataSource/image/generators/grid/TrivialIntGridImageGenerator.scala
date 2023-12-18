package asciiArtApp.dataSource.image.generators.grid

import asciiArtApp.model.image.grid.{GridImage, GridImageAs2DSeq}
import dataSource.generators.number.IntGenerator

import scala.util.Random

class TrivialIntGridImageGenerator(
  width: Int,
  height: Int,
  intGenerator: IntGenerator)
    extends GridImageGenerator[Int](width, height) {
  require(width >= 0, "Negative width does not make sense for a grid!")
  require(height >= 0, "Negative height does not make sense for a grid!")
  override def generate(width: Int, height: Int): GridImage[Int] =
    new GridImageAs2DSeq(Seq.fill(width, height)(intGenerator.provide()))
}
