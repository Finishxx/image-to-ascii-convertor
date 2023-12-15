package asciiArtApp.filters.image.grid.specific

import asciiArtApp.filters.image.grid.GridImageFilter
import asciiArtApp.model.image.grid.{GridImage, GridImageAs2DSeq}
import filters.grid.GridAs2DSeqFilter

class GridToGridImageFilterAdapter(gridImageFilter: GridAs2DSeqFilter)
    extends GridImageFilter[_] {
  override def filter(what: GridImage[_]): GridImage[_] =
    new GridImageAs2DSeq(gridImageFilter.filter(what.toGrid))
}
