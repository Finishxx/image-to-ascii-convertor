package asciiArtApp.filters.image.grid.flip

import asciiArtApp.filters.image.grid.Seq2DToGridImageFilterAdapter
import filters.grid.flip.Axis.Axis
import filters.grid.flip.FlipSeq2DFilter

/**
 * Flips given GridImage around given axis
 *
 * @param axis Axis which the GridImage will be around on, either X or Y
 * @tparam T Type contained in the GridImage we desire to flip
 */
class FlipGridImageFilter[T](axis: Axis)
    extends Seq2DToGridImageFilterAdapter[T](new FlipSeq2DFilter[T](axis))
