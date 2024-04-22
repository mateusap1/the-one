file://<WORKSPACE>/src/main/scala/Main.scala
### java.lang.StringIndexOutOfBoundsException: Range [1113, 1113 + -7) out of bounds for length 1538

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 2.13.12
Classpath:
<WORKSPACE>/.bloop/the-one/bloop-bsp-clients-classes/classes-Metals-eit3KUzcTfqIGBg3Bdhcqg== [exists ], <HOME>/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/com/sourcegraph/semanticdb-javac/0.9.9/semanticdb-javac-0.9.9.jar [exists ], <HOME>/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ], <HOME>/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/modules/scala-parser-combinators_2.13/2.3.0/scala-parser-combinators_2.13-2.3.0.jar [exists ]
Options:
-Yrangepos -Xplugin-require:semanticdb


action parameters:
offset: 1093
uri: file://<WORKSPACE>/src/main/scala/Main.scala
text:
```scala
package org.unb.theone

import scala.io.Source
import scala.collection.immutable.{Set, Map}

object TheOne {
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
    inputString.split(" ")
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

  def sortInsert(currentFrequency: List[(String, Int)], num: Int, word: String, frequency: Int) = {
    // Insert word / frequency in the right place
    
    currentFrequency.foldRight(currentFrequency)(((@@), x :: xs))
  }

  def sortCommon(frequencyWords: Map[String, Int], num: Int) = {
    frequencyWords.foldRight(frequencyWords)(((word, freq), acc) => acc.)
  }
}

object Main extends App {
  // val path =
  //   "<WORKSPACE>"
  // val content = TheOne.readFile("./test.txt")
  // printf("File content: %s", content)
  println(TheOne.addToMap("a", Map("a" -> 1, "b" -> 2)))

}

```



#### Error stacktrace:

```
java.base/jdk.internal.util.Preconditions$1.apply(Preconditions.java:55)
	java.base/jdk.internal.util.Preconditions$1.apply(Preconditions.java:52)
	java.base/jdk.internal.util.Preconditions$4.apply(Preconditions.java:213)
	java.base/jdk.internal.util.Preconditions$4.apply(Preconditions.java:210)
	java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:98)
	java.base/jdk.internal.util.Preconditions.outOfBoundsCheckFromIndexSize(Preconditions.java:118)
	java.base/jdk.internal.util.Preconditions.checkFromIndexSize(Preconditions.java:397)
	java.base/java.lang.String.checkBoundsOffCount(String.java:4853)
	java.base/java.lang.String.rangeCheck(String.java:307)
	java.base/java.lang.String.<init>(String.java:303)
	scala.tools.nsc.interactive.Global.typeCompletions$1(Global.scala:1245)
	scala.tools.nsc.interactive.Global.completionsAt(Global.scala:1283)
	scala.meta.internal.pc.SignatureHelpProvider.$anonfun$treeSymbol$1(SignatureHelpProvider.scala:390)
	scala.Option.map(Option.scala:242)
	scala.meta.internal.pc.SignatureHelpProvider.treeSymbol(SignatureHelpProvider.scala:388)
	scala.meta.internal.pc.SignatureHelpProvider$MethodCall$.unapply(SignatureHelpProvider.scala:205)
	scala.meta.internal.pc.SignatureHelpProvider$MethodCallTraverser.visit(SignatureHelpProvider.scala:316)
	scala.meta.internal.pc.SignatureHelpProvider$MethodCallTraverser.traverse(SignatureHelpProvider.scala:310)
	scala.meta.internal.pc.SignatureHelpProvider$MethodCallTraverser.traverse(SignatureHelpProvider.scala:275)
	scala.reflect.api.Trees$Traverser.traverseTrees(Trees.scala:2506)
	scala.reflect.internal.Trees$Apply.traverse(Trees.scala:791)
	scala.reflect.internal.Trees.itraverse(Trees.scala:1605)
	scala.reflect.internal.Trees.itraverse$(Trees.scala:1604)
	scala.reflect.internal.SymbolTable.itraverse(SymbolTable.scala:28)
	scala.reflect.internal.SymbolTable.itraverse(SymbolTable.scala:28)
	scala.reflect.api.Trees$Traverser.traverse(Trees.scala:2497)
	scala.meta.internal.pc.SignatureHelpProvider$MethodCallTraverser.visit(SignatureHelpProvider.scala:350)
	scala.meta.internal.pc.SignatureHelpProvider$MethodCallTraverser.traverse(SignatureHelpProvider.scala:310)
	scala.meta.internal.pc.SignatureHelpProvider$MethodCallTraverser.$anonfun$visit$5(SignatureHelpProvider.scala:346)
	scala.meta.internal.pc.SignatureHelpProvider$MethodCallTraverser.$anonfun$visit$5$adapted(SignatureHelpProvider.scala:323)
	scala.collection.IterableOnceOps.foreach(IterableOnce.scala:576)
	scala.collection.IterableOnceOps.foreach$(IterableOnce.scala:574)
	scala.collection.AbstractIterable.foreach(Iterable.scala:933)
	scala.collection.IterableOps$WithFilter.foreach(Iterable.scala:903)
	scala.meta.internal.pc.SignatureHelpProvider$MethodCallTraverser.$anonfun$visit$3(SignatureHelpProvider.scala:323)
	scala.meta.internal.pc.SignatureHelpProvider$MethodCallTraverser.$anonfun$visit$3$adapted(SignatureHelpProvider.scala:322)
	scala.collection.IterableOnceOps.foreach(IterableOnce.scala:576)
	scala.collection.IterableOnceOps.foreach$(IterableOnce.scala:574)
	scala.collection.AbstractIterable.foreach(Iterable.scala:933)
	scala.collection.IterableOps$WithFilter.foreach(Iterable.scala:903)
	scala.meta.internal.pc.SignatureHelpProvider$MethodCallTraverser.visit(SignatureHelpProvider.scala:322)
	scala.meta.internal.pc.SignatureHelpProvider$MethodCallTraverser.traverse(SignatureHelpProvider.scala:310)
	scala.meta.internal.pc.SignatureHelpProvider$MethodCallTraverser.fromTree(SignatureHelpProvider.scala:279)
	scala.meta.internal.pc.SignatureHelpProvider.signatureHelp(SignatureHelpProvider.scala:27)
	scala.meta.internal.pc.ScalaPresentationCompiler.$anonfun$signatureHelp$1(ScalaPresentationCompiler.scala:311)
```
#### Short summary: 

java.lang.StringIndexOutOfBoundsException: Range [1113, 1113 + -7) out of bounds for length 1538