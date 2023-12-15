package asciiArtApp.model.image.grid

import asciiArtApp.model.image.Image

import scala.annotation.unused

// GridImage provides interface for working with
// images using a grid for representation of an image
trait GridImage[T] extends Image {

  def width: Int

  def height: Int

  def at(x: Int, y: Int): T

  def map[V](fun: T => V): GridImage[V] =
    mapWithIndex((element: T, _) => fun(element))

  def mapWithIndex[V](fun: (T, (Int, Int)) => V): GridImage[V]

  def toGrid: Seq[Seq[T]] = {
    import scala.collection.mutable.ArrayBuffer
    ArrayBuffer
      .tabulate(height)(x => ArrayBuffer.tabulate(width)(y => at(x, y)))
      .map(_.toSeq)
      .toSeq
  }
}
