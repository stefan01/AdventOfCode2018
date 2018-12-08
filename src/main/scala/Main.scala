import days.{Day01, Day02}

import scala.io.Source

object Main {
  def main(args: Array[String]): Unit = {
    //Day01.part1(getInput("01_P1"))
    //Day01.part2(getInput("01_P2"))
    Day02.part1(getInput("02_P1"))
  }

  def getInput(day: String): Iterator[String] = {
    val fileStream = getClass.getResourceAsStream("days/Day" + day + ".txt")
    Source.fromInputStream(fileStream).getLines()
  }
}
