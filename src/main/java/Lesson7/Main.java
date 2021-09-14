package Lesson7;

public class Main {
    public static void main(String[] args) {

        Graph graph = new GraphImpl (10);

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");
        graph.addVertex("I");
        graph.addVertex("J");

        graph.addEdge("A", "B", 200);
        graph.addEdge("A", "F", 500);
        graph.addEdge("B", "C", 300);
        graph.addEdge("C", "D", 100);
        graph.addEdge("B", "E", 150);
        graph.addEdge("D", "I", 400);
        graph.addEdge("E", "I", 250);
        graph.addEdge("I", "J", 100);
        graph.addEdge("F", "G", 200);
        graph.addEdge("G", "H", 150);
        graph.addEdge("H", "J", 200);

//        graph.display();
//        System.out.println("BFS");
//        graph.bfs("A");
//        System.out.println("DFS");
//        graph.dfs("A");

    }
}
