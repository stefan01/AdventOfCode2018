package days

object Day02 extends Day {
  implicit def booleanToInt(b: Boolean) = if (b) 1 else 0

  override def part1(input: Iterator[String]): Unit = {
    val lines = input.toList

    val doubles = charTimesCount(lines)
      .map(
        _.keySet.contains(2): Int
      ).sum
    val triples = charTimesCount(lines)
      .map(
        _.keySet.contains(3): Int
      ).sum
    println(s"Result is $doubles*$triples = ${doubles * triples}")
  }

  def charTimesCount(input: Seq[String]) = {
    input.map { s =>
      s.groupBy(c => s.count(c == _))
    }
  }

  override def part2(input: Iterator[String]): Unit = {
    val lines = input.toList

    val lineCombinations = for(a <- lines; b <- lines) yield (a, b)
    val oneDifferStrings = lineCombinations
      .filter {
        case (a, b) => sameChars(a, b).size == Math.max(a.size, b.size)-1
      }

    println(s"Result is ${sameChars(oneDifferStrings(0)._1, oneDifferStrings(0)._2).mkString}")
  }

  def sameChars(a: String, b: String) = {
    (a zip b).filter {
      case (a, b) => a == b
    }.map(_._1)
  }
}
