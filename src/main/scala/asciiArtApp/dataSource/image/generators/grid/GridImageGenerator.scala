package asciiArtApp.dataSource.image.generators.grid

import asciiArtApp.dataSource.image.generators.ImageGenerator
import asciiArtApp.model.image.grid.GridImage

abstract class GridImageGenerator[T](width: Int, height: Int)
    extends ImageGenerator[GridImage[T]] {
  protected def generate(width: Int, height: Int): GridImage[T]

  final override def provide(): GridImage[T] = generate(width, height)
}
