package Lesson7;

import java.util.*;

public class GraphImpl implements Graph {

    private final List<Vertex> vertexList;
    private final int[][] adjMatrix;
    private int maxWeight = 0;

    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new int[maxVertexCount][maxVertexCount];
    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, String...others) {
        boolean result = addEdge(startLabel, secondLabel);

        for (String other : others) {
            result &= addEdge(startLabel, other);
        }
        return result;
    }

    public boolean addEdge(String startLabel, String endLabel, int i) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMatrix[startIndex][endIndex] = i;
        adjMatrix[endIndex][startIndex] = i;
        maxWeight += i;

        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        for (int i = 0; i < getSize(); i++) {
            System.out.println(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j] > 0) {
                    System.out.println(" -> " + vertexList.get(j));
                }
            }
            System.out.println();
        }
    }

    @Override
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверный индекс: " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }
        this.unVisited();
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.println(vertex.getLabel());
        stack.push(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Queue<Vertex> stack, Vertex vertex) {
        System.out.println(vertex.getLabel());
        stack.add(vertex);
        vertex.setVisited(true);
    }

    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);
        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] > 0 && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    @Override
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверный индекс: " + startLabel);
        }

        Queue<Vertex> stack = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.remove();
            }
        }
        this.unVisited();
    }

    public void unVisited() {
        for (Vertex v : vertexList) {
            v.setVisited(false);
        }
    }

    public Map<String, Integer> minWeight(String start, String finish) {

        Map<String, Integer> map = new HashMap<>();

        int startIndex = indexOf(start);
        int finishIndex = indexOf(finish);

        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверный индекс: " + start);
        }

        for (Vertex v : vertexList) {
            map.put(v.getLabel(), maxWeight);

        }

        Queue<Vertex> stack = new LinkedList<>();
        Vertex vertex1 = vertexList.get(startIndex);

        visitVertex(stack, vertex1);
        while (!stack.isEmpty()) {
            Vertex vertex2 = getNearUnvisitedVertex(stack.peek());

            if (map.get(vertex2.getLabel()) > (map.get(vertex1.getLabel()) + adjMatrix[indexOf(vertex1.getLabel())][indexOf(vertex2.getLabel())])) {
                map.put(vertex2.getLabel(), map.get(vertex1.getLabel()) + adjMatrix[indexOf(vertex1.getLabel())][indexOf(vertex2.getLabel())]);
            }

            if (vertex2 != null || !vertex2.equals(vertexList.get(finishIndex))) {
                visitVertex(stack, vertex2);
            } else {
                stack.remove();
            }
        }
        this.unVisited();
        return map;
    }


}
