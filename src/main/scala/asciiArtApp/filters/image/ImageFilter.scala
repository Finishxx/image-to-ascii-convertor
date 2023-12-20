package asciiArtApp.filters.image

import asciiArtApp.model.image.Image
import filters.Filter

/**
 * Filters Images
 * @tparam T Type of Image to filter
 */
trait ImageFilter[T <: Image] extends Filter[T]
