package asciiArtApp.model.grid

trait Grid[T] {
  def width: Int

  def height: Int

  def at(x: Int, y: Int): T

  def map[V](fun: T => V): Grid[V]

  def toGrid: Seq[Seq[T]] = {
    import scala.collection.mutable.ArrayBuffer
    ArrayBuffer
      .tabulate(height)(x => ArrayBuffer.tabulate(width)(y => at(x, y)))
      .map(_.toSeq)
      .toSeq
  }
}
