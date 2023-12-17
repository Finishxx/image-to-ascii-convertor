package asciiArtApp.dataSource.image.generators.grid

import asciiArtApp.model.image.grid.{GridImage, GridImageAs2DSeq}
import dataSource.generators.number.IntGenerator

import scala.util.Random

class TrivialIntGridImageGenerator(
  width: Int,
  height: Int,
  intGenerator: IntGenerator)
    extends GridImageGenerator[Int](width, height) {
  override def generate(width: Int, height: Int): GridImage[Int] = {
    val random: Random = new Random
    new GridImageAs2DSeq(Seq.fill(width, height)(intGenerator.provide()))
  }
}
