package asciiArtApp.model.image.grid

class GridImageAs2DSeq[T](grid: Seq[Seq[T]]) extends GridImage[T] {
  require(
    grid.forall(_.size == grid.head.size),
    "Malformed grid! Please provide grid with equally sized rows.")

  override def width: Int = grid.size

  override def height: Int = grid.head.size

  override def at(x: Int, y: Int): T = grid(x)(y)

  override def map[V](fun: T => V): GridImage[V] =
    new GridImageAs2DSeq(grid.map(_.map(fun)))
}
