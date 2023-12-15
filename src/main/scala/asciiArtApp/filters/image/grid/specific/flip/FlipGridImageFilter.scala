package asciiArtApp.filters.image.grid.specific.flip

import asciiArtApp.filters.image.grid.specific.GridToGridImageFilterAdapter
import filters.grid.flip.Axis.Axis
import filters.grid.flip.FlipGridFilter

class FlipGridImageFilter(axis: Axis)
    extends GridToGridImageFilterAdapter(new FlipGridFilter(axis))
