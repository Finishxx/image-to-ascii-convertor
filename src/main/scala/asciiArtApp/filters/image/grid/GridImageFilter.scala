package asciiArtApp.filters.image.grid

import asciiArtApp.filters.image.ImageFilter
import asciiArtApp.model.image.grid.GridImage

/**
 * Applies to filter to given GridImage
 * @tparam T Type of elements stored in filtered GridImage
 */
trait GridImageFilter[T] extends ImageFilter[GridImage[T]]
