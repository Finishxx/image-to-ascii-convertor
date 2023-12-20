package asciiArtApp.model.image.grid

import asciiArtApp.model.grid.Grid
import asciiArtApp.model.image.Image

import scala.annotation.unused

/**
 * Provides interface for working with images
 * using, which use a grid for storing image information
 *
 * @tparam T Type of elements contained in the grid
 */
trait GridImage[T] extends Image with Grid[T] {
  def map[V](fun: T => V): GridImage[V]

}
