package org.kagaka.graph;

import java.util.Set;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
// import org.junit.jupiter.api.TestInstance;
// import org.junit.jupiter.api.TestInstance.Lifecycle;


// @TestInstance(Lifecycle.PER_CLASS)
public class GraphTest {

    Graph<String> stringGraph = new GraphImpl<String>();

    @Test
    public void baseTest() {
        // fail("Not yet implemented");
        assertEquals(0, stringGraph.getVertices().size());
    }

    @Test
    public void cyclicStringGraphTest() {

        Vertex<String> va = new VertexImpl<String>("A");
        Vertex<String> vb = new VertexImpl<String>("B");
        Vertex<String> vc = new VertexImpl<String>("C");
        Vertex<String> vd = new VertexImpl<String>("D");

        stringGraph.addVertex(va);
        stringGraph.addVertex(vb);
        stringGraph.addVertex(vc);
        stringGraph.addVertex(vd);

        for (int i = 0; i < stringGraph.getVertices().size(); i++) {
            if (i != stringGraph.getVertices().size() - 1) {
                stringGraph.get(i).addMutualEdge(stringGraph.getVertices().get(i + 1));
            } else {
                stringGraph.getVertices().get(i).addMutualEdge(stringGraph.getVertices().get(0));
            }
        }

        Set<Vertex<String>> visitedD = stringGraph.depthFirstTraversal(stringGraph.get(0));

        String[] depthFirstExpected = {"A", "D", "C", "B"};
        Vertex<String>[] depthFirstResult = new Vertex[4];
        depthFirstResult = visitedD.toArray(depthFirstResult);

        assertEquals(depthFirstExpected.length, depthFirstResult.length);

//    for(Vertex<String> vs : visitedD) {
//          System.out.println("DEBUG visited " + vs.get());
//      }

        for (int i = 0; i < depthFirstResult.length; i++) {
            assertEquals(depthFirstExpected[i], depthFirstResult[i].get());
        }

        assertEquals(4, visitedD.size());

        Set<Vertex<String>> visitedB = stringGraph.breadthFirstTraversal(stringGraph.get(0));

        String[] breadthFirstExpected = {"A", "B", "D", "C"};
        Vertex<String>[] breadthFirstResult = new Vertex[4];
        breadthFirstResult = visitedB.toArray(breadthFirstResult);

        assertEquals(breadthFirstExpected.length, breadthFirstResult.length);

//        for(Vertex<String> vs : visitedB) {
//            System.out.println("DEBUG visited " + vs.get());
//        }

        for (int i = 0; i < breadthFirstResult.length; i++) {
            assertEquals(breadthFirstExpected[i], breadthFirstResult[i].get());
        }


//        for(String s : stringGraph.getContents()) {
//            System.out.println("DEBUG getContents " + s);
//        }

    }

}
