package Lesson7;

public interface Graph {

    void addVertex(String label);

    boolean addEdge(String startLabel, String secondLabel, String... others);

    boolean addEdge(String startLabel, String secondLabel, int i);

    int getSize();

    void display();

    /**
     * англ. Depth-first search, DFS
     */
    void dfs(String startLabel);

    /**
     * англ. breadth-first search, BFS
     */
    void bfs(String startLabel);

//    Stack<String> findShortPathViaBfs(String startLabel, String finishLabel);

}
