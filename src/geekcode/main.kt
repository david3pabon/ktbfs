package geekcode

/**
 * Created by @david3pabon on 5/30/2017.
 */
// URL to labyrinth: https://docs.google.com/spreadsheets/d/14xyCmaQfX0nntJMLL9a3cJzJ-ZSmeqgPyAAzj2VYu2E/edit?usp=sharing
val URL = "https://api.myjson.com/bins/q2iwx"
val ORIGIN = 2
val DESTINY = 3

fun main (args: Array<String>) {
    val graph = Graph.build(requestJSON(URL))
    val path = graph.bfs(ORIGIN, DESTINY)
    System.out.println(path)
}