package dataSource.imageColorCodeGrid.generators.specific

import dataSource.imageColorCodeGrid.generators.ImageGenerator

import scala.util.Random

class TrivialGenerator(width: Int, height: Int)
    extends ImageGenerator(width, height) {
  override def generate(width: Int, height: Int): Seq[Seq[Int]] = {
    val random: Random = new Random
    Seq.fill(width, height)(random.nextInt())
  }
}
