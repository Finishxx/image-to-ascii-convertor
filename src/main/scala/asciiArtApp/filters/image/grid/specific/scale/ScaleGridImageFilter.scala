package asciiArtApp.filters.image.grid.specific.scale

import asciiArtApp.filters.image.grid.specific.Seq2DToGridImageFilterAdapter
import filters.grid.scale.ScaleSeq2DFilter

class ScaleGridImageFilter[T](factor: Double)
    extends Seq2DToGridImageFilterAdapter[T](new ScaleSeq2DFilter(factor))
