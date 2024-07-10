package asciiArtApp.model.image.grid

import asciiArtApp.model.image.Image

// GridImage provides interface for working with
// images using a grid for representation of an image
trait GridImage[T] extends Image {

  def width: Int

  def height: Int

  def at(x: Int, y: Int): T

  def map[V](fun: T => V): GridImage[V]

}
