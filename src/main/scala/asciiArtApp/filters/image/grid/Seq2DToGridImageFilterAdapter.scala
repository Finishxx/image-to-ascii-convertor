package asciiArtApp.filters.image.grid

import asciiArtApp.model.image.grid.{GridImage, GridImageAs2DSeq}
import filters.grid.Seq2DFilter

/**
 * Adapts Seq2DFilters to work on the inner grid of GridImage
 *
 * @param seq2DFilter Filter to be adapted to work with GridImages
 * @tparam T Type of elements stored in filtered GridImage
 */
class Seq2DToGridImageFilterAdapter[T](seq2DFilter: Seq2DFilter[T])
    extends GridImageFilter[T] {
  override def filter(what: GridImage[T]): GridImage[T] =
    new GridImageAs2DSeq(seq2DFilter.filter(what.toGrid))
}
