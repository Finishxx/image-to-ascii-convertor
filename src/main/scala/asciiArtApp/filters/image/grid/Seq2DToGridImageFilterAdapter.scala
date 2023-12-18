package asciiArtApp.filters.image.grid

import asciiArtApp.model.image.grid.{GridImage, GridImageAs2DSeq}
import filters.grid.Seq2DFilter

class Seq2DToGridImageFilterAdapter[T](gridImageFilter: Seq2DFilter[T])
    extends GridImageFilter[T] {
  override def filter(what: GridImage[T]): GridImage[T] =
    new GridImageAs2DSeq(gridImageFilter.filter(what.toGrid))
}
