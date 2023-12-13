package asciiArtApp.dataSource.image.generators

import dataSource.imageColorCodeGrid.ImageColorCodeGridSource

abstract class ImageGenerator(width: Int, height: Int)
    extends ImageColorCodeGridSource {
  protected def generate(width: Int, height: Int): Seq[Seq[Int]]

  override final def provide(): Seq[Seq[Int]] = generate(width, height)
}
