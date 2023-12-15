package asciiArtApp.filters.image.grid.specific.flip

import asciiArtApp.filters.image.grid.GridImageFilter
import filters.grid.flip.Axis._
import asciiArtApp.model.image.grid.{GridImage, GridImageAs2DSeq}

class FlipGridImageFilter(axis: Axis) extends GridImageFilter[_] {
  override def filter(what: GridImage[_]): GridImage[_] = axis match {
    case X => new GridImageAs2DSeq(what.toGrid.reverse)
    case Y => new GridImageAs2DSeq(what.toGrid.map(_.reverse))
  }
}
