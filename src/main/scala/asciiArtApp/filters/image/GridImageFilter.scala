package asciiArtApp.filters.image

import asciiArtApp.model.image.grid.GridImage
import filters.Filter

class GridImageFilter[T](filter: Filter[T]) extends Filter[GridImage[T]] {
  override def filter(what: GridImage[T]): GridImage[T] =
    what.map(filter.filter)
}
