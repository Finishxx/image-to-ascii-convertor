package asciiArtApp.filters.image.specific

import asciiArtApp.filters.image.specific.FlipFilter.FlipAxis._
import asciiArtApp.model.image.grid.GridImage
import filters.Filter

import scala.math.ceil

class FlipFilter[T](axis: Axis) extends Filter[GridImage[T]] {

  private def flipOnNumberAxis(num: Int, middle: Int): Int =
    if (num < middle) middle + (middle - num) else middle - (num - middle)

  private def flipAroundMiddle(num: Int, size: Int): Int =
    flipOnNumberAxis(num, )

  private def flipPointOnXAxis(point: (Int, Int), axis: Int): (Int, Int) =
    point match {
      case (x, y) => (flipOnNumberAxis(x, axis), y)
    }

  private def flipPointOnYAxis(point: (Int, Int), axis: Int): (Int, Int) =
    point match {
      case (x, y) => (x, flipOnNumberAxis(y, axis))
    }

  override def filter(what: GridImage[T]): GridImage[T] =
    what.mapWithIndex((_, coordinates: (Int, Int)) =>
      coordinates match {
        case (x: Int, y: Int) =>
          axis match {
            case X => what.at(flipOnNumberAxis(x, ceil(x / 2).toInt), y)
            case Y => what.at(x, flipOnNumberAxis(y, ceil(x / 2).toInt))
          }
    })
}

object FlipFilter {
  object FlipAxis extends Enumeration {
    type Axis = Value
    val X, Y = Value
  }
}
