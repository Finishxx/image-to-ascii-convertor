package asciiArtApp.filters.image.grid

import asciiArtApp.filters.image.ImageFilter
import asciiArtApp.model.image.grid.GridImage

trait GridImageFilter[T] extends ImageFilter[GridImage[T]]
