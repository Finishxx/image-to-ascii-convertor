package asciiArtApp.filters.image.grid.specific.rotate

import asciiArtApp.filters.image.grid.GridImageFilter
import asciiArtApp.model.image.grid.{GridImage, GridImageAs2DSeq}

class RotateGridImageFilter(degrees: Int) extends GridImageFilter[_] {

  private def rotate90(grid: Seq[Seq[_]]): Seq[Seq[_]] = grid.transpose

  private def rotateMinus90(grid: Seq[Seq[_]]): Seq[Seq[_]] =
    grid.transpose.map(_.reverse)

  override def filter(what: GridImage[_]): GridImage[_] =
    degrees % 360 match {
      case 0 => what
      case 180 | -180 =>
        new GridImageAs2DSeq(what.toGrid.map(_.reverse).reverse)
      case 90 | -270 => new GridImageAs2DSeq(rotate90(what.toGrid))
      case -90 | 270 => new GridImageAs2DSeq(rotateMinus90(what.toGrid))
      case _         => throw new IllegalArgumentException("Invalid rotation angle")
    }
}
