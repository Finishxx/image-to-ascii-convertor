package asciiArtApp.filters.image.grid.specific.flip

import asciiArtApp.filters.image.grid.specific.Seq2DToGridImageFilterAdapter
import filters.grid.flip.FlipSeq2DFilter

class FlipGridImageFilter[T](axis: Axis)
    extends Seq2DToGridImageFilterAdapter[T](new FlipSeq2DFilter(axis))
