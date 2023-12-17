package asciiArtApp.filters.image.grid.specific

import asciiArtApp.filters.image.grid.GridImageFilter
import asciiArtApp.model.image.grid.{GridImage, GridImageAs2DSeq}
import filters.grid.GridAs2DSeqFilter

class GridToGridImageFilterAdapter[T](gridImageFilter: GridAs2DSeqFilter[T])
    extends GridImageFilter[T] {
  override def filter(what: GridImage[T]): GridImage[T] =
    new GridImageAs2DSeq(gridImageFilter.filter(what.toGrid))
}
