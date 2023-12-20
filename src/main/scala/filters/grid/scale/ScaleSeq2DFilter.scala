package filters.grid.scale

import filters.grid.Seq2DFilter

/**
 * Scales the Seq2D by factor of either 0.25, 1 or 4
 *
 * Example:
 * Original / Scale 1:
 * AB
 * CD
 *
 * Scale 0.25 (take one of those 4 symbols or calculate average):
 * A
 *
 * Scale 4:
 * AABB
 * AABB
 * CCDD
 * CCDD
 *
 * @param factor Factor by which the Seq2D is scaled by. In essence by how
 *               much should the number of elements be factored by after the scaling
 * @tparam T Type of elements stored in Seq2D
 */
class ScaleSeq2DFilter[T](factor: Double) extends Seq2DFilter[T] {
  require(
    Seq(1, 4, 0.25).contains(factor),
    "Please use factors of 1, 4 or 0.25 only!")

  private def quadruple(grid: Seq[Seq[T]]): Seq[Seq[T]] =
    grid.flatMap(line => Seq.fill(2)(line.flatMap(Seq.fill(2)(_))))

  private def quarter(grid: Seq[Seq[T]]): Seq[Seq[T]] =
    grid.grouped(2).map(_.head).toSeq.map(_.grouped(2).map(_.head).toSeq)

  override def filter(what: Seq[Seq[T]]): Seq[Seq[T]] = factor match {
    case 1    => what
    case 4    => quadruple(what)
    case 0.25 => quarter(what)
  }
}
