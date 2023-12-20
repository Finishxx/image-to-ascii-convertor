package helpers

trait TestWithSeq2D {

  def gridSeq1x1: Seq[Seq[Int]] = Seq(Seq(1))

  def gridSeq2x2: Seq[Seq[Int]] = Seq(Seq(1, 2), Seq(3, 4))

  def gridSeq3x3: Seq[Seq[Int]] = Seq(Seq(1, 2, 3), Seq(4, 5, 6), Seq(7, 8, 9))

}
