package asciiArtApp.filters.image

import asciiArtApp.model.image.grid.GridImage
import filters.Filter

trait GridImageFilter[T] extends Filter[GridImage[T]]
