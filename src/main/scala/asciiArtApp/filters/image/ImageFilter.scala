package asciiArtApp.filters.image

import asciiArtApp.model.image.Image
import filters.Filter

trait ImageFilter[T <: Image] extends Filter[T]
