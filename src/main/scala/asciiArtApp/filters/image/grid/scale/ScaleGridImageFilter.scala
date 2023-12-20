package asciiArtApp.filters.image.grid.scale

import asciiArtApp.filters.image.grid.Seq2DToGridImageFilterAdapter
import filters.grid.scale.ScaleSeq2DFilter

/**
 * Scales the GridImage by factor of either 0.25, 1 or 4
 *
 * Example:
 * Original / Scale 1:
 * AB
 * CD
 *
 * Scale 0.25 (take one of those 4 symbols or calculate average):
 * A
 *
 * Scale 4:
 * AABB
 * AABB
 * CCDD
 * CCDD
 *
 * @param factor Factor by which the GridImage is scaled by. In essence by how
 *               much should the area of the image be factored by after the scaling
 * @tparam T Type of elements contained in scaled GridImage
 */
class ScaleGridImageFilter[T](factor: Double)
    extends Seq2DToGridImageFilterAdapter[T](new ScaleSeq2DFilter[T](factor))
