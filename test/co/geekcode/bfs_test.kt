package co.geekcode

import org.junit.Test

/**
 * Created by @david3pabon on 6/1/2017.
 */
class BFSTest {
    val JSON = "{\"edges\":[0,1,2,3,4,5,6,7,8],\"vertices\":[{\"first\":0,\"second\":3},{\"first\":1,\"second\":4},{\"first\":1,\"second\":2},{\"first\":2,\"second\":5},{\"first\":3,\"second\":4},{\"first\":3,\"second\":6},{\"first\":5,\"second\":8},{\"first\":6,\"second\":7}]}"

    @Test
    fun testPathFinding() {
        val graph = Graph.build(JSON)
        val path = graph.findPath(2, 3)
        assert("[2, 1, 4, 3]".equals(path.toString()))
    }

    @Test
    fun testSameOriginAndDestiny() {
        val graph = Graph.build(JSON)
        val path = graph.findPath(0, 0)
        assert(path.size == 1)
        assert("[0]".equals(path.toString()))
    }
}