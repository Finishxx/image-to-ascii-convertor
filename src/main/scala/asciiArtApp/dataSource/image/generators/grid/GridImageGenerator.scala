package asciiArtApp.dataSource.image.generators.grid

import asciiArtApp.dataSource.image.generators.ImageGenerator
import asciiArtApp.model.image.grid.GridImage

/**
 * Generates a GridImage[T] with given width and height
 *
 * @param width Desired width of the generated GridImage
 * @param height Desired height of the generated GridImage
 * @tparam T Type contained in individual pixels of GridImage
 */
abstract class GridImageGenerator[T](width: Int, height: Int)
    extends ImageGenerator[GridImage[T]] {
  protected def generate(width: Int, height: Int): GridImage[T]

  final override def provide(): GridImage[T] = generate(width, height)
}
