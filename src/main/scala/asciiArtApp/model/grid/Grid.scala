package asciiArtApp.model.grid

/**
 * Represents grid containing elements with certain width and height
 * @tparam T Type of elements contained in the grid
 */
trait Grid[T] {

  /**
   * Width of the grid
   */
  def width: Int

  /**
   * Height of the grid
   */
  def height: Int

  /**
   * Accesses element in the grid at given x and y coordinates
   *
   * Coordinates have [0, 0] in top left corner
   *
   * @param x X coordinate of the element we desire to access
   * @param y Y coordinate of the element we desire to access
   */
  def at(x: Int, y: Int): T

  /**
   * Creates a new Grid by applying fun to each element of the grid
   */
  def map[V](fun: T => V): Grid[V]

  /**
   * Using accessor at(x, y) and width and height
   * creates a 2DSeq representation of the grid
   */
  def toGrid: Seq[Seq[T]] = {
    import scala.collection.mutable.ArrayBuffer
    ArrayBuffer
      .tabulate(height)(x => ArrayBuffer.tabulate(width)(y => at(x, y)))
      .map(_.toSeq)
      .toSeq
  }
}
