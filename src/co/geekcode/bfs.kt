package co.geekcode

import com.google.gson.Gson

/**
 * Created by @david3pabon on 6/1/2017.
 */

class Node(val neighbors: MutableSet<Int> = mutableSetOf(), var parent: Int = -1)

class Graph {

    val edges:MutableList<Int> = mutableListOf()
    val vertices:MutableList<Pair<Int, Int>> = mutableListOf()
    var nodes: MutableMap<Int, Node> = mutableMapOf()

    fun findPath(root: Int, destiny: Int) : MutableList<Int> {
        val queue:MutableList<Int> = mutableListOf()
        var current = -1
        queue.add(root)
        while (!queue.isEmpty()) {
            current = queue.removeAt(0)
            if (current == destiny) break
            val node = nodes[current]
            node?.neighbors?.forEach { neighbor ->
                if (nodes[neighbor]?.parent == -1 && neighbor != root) {
                    nodes[neighbor]?.parent = current
                }
                queue.add(neighbor)
            }
        }
        return makePath(current)
    }

    private fun makePath(initial: Int) : MutableList<Int> {
        val path: MutableList<Int> = mutableListOf()
        var index = initial
        while (index != -1) {
            path.add(index)
            index = if (nodes[index] != null) nodes[index]!!.parent else -1
        }
        path.reverse()
        return path
    }

    private fun makeAdjacencyList() : MutableMap<Int, Node> {
        nodes = mutableMapOf()
        edges.forEach({ value ->
            val node = Node()
            vertices.forEach({ (first, second) ->
                if (first == value) node.neighbors.add(second)
                else if (second == value) node.neighbors.add(first)
            })
            nodes[value] = node
        })
        return nodes
    }

    companion object Builder {
        fun build(json: String) :Graph {
            val g = Gson().fromJson(json, Graph::class.java)
            g.makeAdjacencyList()
            return g
        }
    }
}

