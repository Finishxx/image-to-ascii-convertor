package asciiArtApp.filters.image.grid.specific.scale

import asciiArtApp.filters.image.grid.GridImageFilter
import asciiArtApp.model.image.grid.{GridImage, GridImageAs2DSeq}

class ScaleGridImageFilter(factor: Double) extends GridImageFilter[_] {

  private def quadruple(grid: Seq[Seq[_]]): Seq[Seq[_]] =
    grid.map(_.flatMap(Seq.fill(4)(_)))

  private def quarter(grid: Seq[Seq[_]]): Seq[Seq[_]] =
    grid.map(_.grouped(4).map(_.head).toSeq)

  override def filter(what: GridImage[_]): GridImage[_] = factor match {
    case 1    => what
    case 4    => new GridImageAs2DSeq(quadruple(what.toGrid))
    case 0.25 => new GridImageAs2DSeq(quarter(what.toGrid))
    case _    => throw new IllegalArgumentException("Invalid rotation angle")
  }
}
