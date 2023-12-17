package asciiArtApp.filters.image.grid.specific.flip

import asciiArtApp.filters.image.grid.specific.Seq2DToGridImageFilterAdapter
import filters.grid.flip.Axis.Axis
import filters.grid.flip.FlipSeq2DFilter

class FlipGridImageFilter(axis: Axis)
    extends Seq2DToGridImageFilterAdapter(new FlipSeq2DFilter(axis))
