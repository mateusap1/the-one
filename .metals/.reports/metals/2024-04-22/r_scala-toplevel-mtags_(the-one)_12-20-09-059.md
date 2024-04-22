error id: file://<WORKSPACE>/src/main/scala/Main.scala:[125..126) in Input.VirtualFile("file://<WORKSPACE>/src/main/scala/Main.scala", "package org.unb.theone

import scala.io.Source
import scala.collection.immutable.{Set, Map}

class TheOne(value: T) {
  def 
}

object WordCounter {
  def readFile(path: String): String = {
    Source.fromFile(path).mkString
  }

  def filterChars(inputString: String): String = {
    inputString.replaceAll("""[\W_]+""", " ")
  }

  def normalize(inputString: String): String = {
    inputString.toLowerCase()
  }

  def scan(inputString: String): List[String] = {
    inputString.split(" ").toList
  }

  def removeStopWords(inputWords: List[String], stopWords: Set[String]) = {
    inputWords.filter((s: String) => !stopWords.contains(s))
  }

  def addToMap(s: String, acc: Map[String, Int]) = {
    if (acc.contains(s)) {
      acc + (s -> (acc(s) + 1))
    } else {
      acc + (s -> 1)
    }
  }

  def frequencies(inputWords: List[String]): Map[String, Int] = {
    inputWords.foldRight(Map.empty[String, Int])(addToMap)
  }

  def sortFreq(frequencyWords: Map[String, Int]): List[(String, Int)] = {
    frequencyWords.toList.sortBy[Int]((wordFreq: (String, Int)) => -wordFreq._2)
  }

  def topFreqs(ordFreqWords: List[(String, Int)], num: Int) = {
    ordFreqWords
      .slice(0, num)
      .foldRight("")((wordFreq: (String, Int), acc: String) =>
        wordFreq._1 + " - " + wordFreq._2.toString + "\n" + acc
      )
  }
}

object Main extends App {
  // val path =
  //   "<WORKSPACE>"
  // val content = TheOne.readFile("./test.txt")
  // printf("File content: %s", content)
  println(WordCounter.addToMap("a", Map("a" -> 1, "b" -> 2)))

}
")
file://<WORKSPACE>/src/main/scala/Main.scala
file://<WORKSPACE>/src/main/scala/Main.scala:8: error: expected identifier; obtained rbrace
}
^
#### Short summary: 

expected identifier; obtained rbrace