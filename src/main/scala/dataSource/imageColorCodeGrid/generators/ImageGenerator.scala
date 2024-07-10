package dataSource.imageColorCodeGrid.generators

import dataSource.imageColorCodeGrid.ImageColorCodeGridSource

abstract class ImageGenerator(width: Int, height: Int)
    extends ImageColorCodeGridSource {
  def generate(width: Int, height: Int): Seq[Seq[Int]]

  override final def provide(): Seq[Seq[Int]] = generate(width, height)
}
