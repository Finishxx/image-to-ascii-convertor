package asciiArtApp.filters.image.grid.rotate

import asciiArtApp.filters.image.grid.Seq2DToGridImageFilterAdapter
import filters.grid.rotate.RotateSeq2DFilter

/**
 * Rotates GridImage by multiples of 90 degrees
 *
 * @param degrees By how many degrees should the GridImage be rotated by.
 *                Only multiples of 90 are allowed
 * @tparam T Type of elements the GridImage stores
 */
class RotateGridImageFilter[T](degrees: Int)
    extends Seq2DToGridImageFilterAdapter[T](new RotateSeq2DFilter[T](degrees))
