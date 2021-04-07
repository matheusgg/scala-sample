package innerclasses

object Main extends App {
  /**
   * Inner classes
   */
  class Graph {
    class Node {
      var connectedNodes: List[Node] = Nil

      // # operator make Node class to be path-independent, so we can use any reference of Graph
      var connectedNodes2: List[Graph#Node] = Nil

      def connectTo(node: Node): Unit = {
        if (!connectedNodes.exists(node.equals)) {
          connectedNodes = node :: connectedNodes
        }
      }

      def connectTo2(node: Graph#Node): Unit = {
        if (!connectedNodes.exists(node.equals)) {
          connectedNodes = node :: connectedNodes
        }
      }
    }

    var nodes: List[Node] = Nil

    def newNode: Node = {
      val res = new Node
      nodes = res :: nodes
      res
    }
  }

  val graph1: Graph = new Graph

  // Inner class Node is path-dependent, so we need a reference of Graph (graph1) to create a node
  val node1: graph1.Node = graph1.newNode
  val node2: graph1.Node = graph1.newNode
  val node3: graph1.Node = graph1.newNode
  //  val node4: Node = new Node // Does not compile, to create a Node we need a Graph reference

  node1.connectTo(node2)
  node3.connectTo(node1)

  val graph2: Graph = new Graph
  val node5: graph2.Node = graph2.newNode
  //  node1.connectTo(node5) // Does not compile, because connectTo of node1 expects a graph1.Node
  node1.connectTo2(node5) // connectTo2 receives Graph#Node, so we can use a node created by any graph reference

}
