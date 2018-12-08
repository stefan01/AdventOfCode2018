import days._

import scala.io.Source

object Main {
  def main(args: Array[String]): Unit = {
    //Day01.part1(getInput("01"))
    //Day01.part2(getInput("01"))

    //Day02.part1(getInput("02"))
    //Day02.part2(getInput("02"))

    Day03.part1(getInput("03"))
  }

  def getInput(day: String): Iterator[String] = {
    val fileStream = getClass.getResourceAsStream("days/Day" + day + ".txt")
    Source.fromInputStream(fileStream).getLines()
  }
}
