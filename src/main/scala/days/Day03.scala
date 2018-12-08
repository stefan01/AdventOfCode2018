package days

object Day03 extends Day {
  case class Claim(id: Int, x: Int, y: Int, width: Int, height: Int)

  override def part1(input: Iterator[String]): Unit = {
    val claims = input.map(l => {
      val claimParts = l.split(Array('#', ' ', '@', ',', ':', 'x'))
      Claim(
        claimParts(1).toInt,
        claimParts(4).toInt,
        claimParts(5).toInt,
        claimParts(7).toInt,
        claimParts(8).toInt
      )
    })

  }

  override def part2(input: Iterator[String]): Unit = ???
}
