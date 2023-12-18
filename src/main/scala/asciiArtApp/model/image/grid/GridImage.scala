package asciiArtApp.model.image.grid

import asciiArtApp.model.grid.Grid
import asciiArtApp.model.image.Image

import scala.annotation.unused

// GridImage provides interface for working with
// images using a grid for representation of an image
trait GridImage[T] extends Image with Grid[T] {
  def map[V](fun: T => V): GridImage[V]

}
