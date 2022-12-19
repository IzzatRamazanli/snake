package com.codenjoy.dojo.snake.client;

import com.codenjoy.dojo.services.Direction;
import com.codenjoy.dojo.services.Point;

import java.util.ArrayList;
import java.util.List;


public class SnakeSolution {
    private final List<Direction> directions = new ArrayList<>();

    public Direction solve(Board board) {
        Point head = board.getHead();
        if (head == null) return board.getSnakeDirection();
        Point apple = board.getApples().get(0);
        if (head.getX() < apple.getX()) return Direction.RIGHT;
        else if (head.getX() > apple.getX()) return Direction.LEFT;
        else if (head.getY() > apple.getY()) return Direction.DOWN;
        return Direction.UP;
    }

    public Direction solve2(Board board) {
        Point head = board.getHead();
        if (head == null) return board.getSnakeDirection();
        Point apple = board.getApples().get(0);
        Point stone = board.getStones().get(0);
        List<Point> walls = board.getWalls();


//       Graph graph = BoardGraph.boardGraph();
        List<GraphNode> graphNodes = new ArrayList<>();
        graphNodes.add(new GraphNode("A", 1));
        graphNodes.add(new GraphNode("B", 2));
        graphNodes.add(new GraphNode("C", 3));
        graphNodes.add(new GraphNode("D", 4));
        graphNodes.add(new GraphNode("E", 5));
        graphNodes.add(new GraphNode("F", 6));
        graphNodes.add(new GraphNode("G", 7));
        graphNodes.add(new GraphNode("H", 8));
        graphNodes.add(new GraphNode("J", 9));
        graphNodes.add(new GraphNode("K", 10));
        graphNodes.add(new GraphNode("L", 11));
        graphNodes.add(new GraphNode("M", 12));
        graphNodes.add(new GraphNode("N", 13));

        Graph graph = new Graph(graphNodes);
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("A", "D");

        graph.addEdge("B", "C");
        graph.addEdge("B", "D");
        graph.addEdge("B", "E");

        graph.addEdge("C", "D");
        graph.addEdge("C", "E");
        graph.addEdge("C", "F");

        graph.addEdge("D", "E");
        graph.addEdge("D", "F");
        graph.addEdge("D", "G");

        graph.addEdge("E", "F");
        graph.addEdge("E", "G");
        graph.addEdge("E", "H");

        graph.addEdge("F", "G");
        graph.addEdge("F", "H");
        graph.addEdge("F", "J");

        graph.addEdge("G", "H");
        graph.addEdge("G", "J");
        graph.addEdge("G", "K");

        graph.addEdge("H", "J");
        graph.addEdge("H", "K");
        graph.addEdge("H", "L");

        graph.addEdge("J", "K");
        graph.addEdge("J", "L");
        graph.addEdge("J", "M");

        graph.addEdge("K", "L");
        graph.addEdge("K", "M");
        graph.addEdge("K", "N");
        List<GraphNode> pathX = graph.BFSForPathFinding(head.getX(), apple.getX());
        List<GraphNode> pathY = graph.BFSForPathFinding(head.getY(), apple.getY());
        System.out.println(pathX);
        System.out.println(pathY);


        return Direction.UP;
    }


}
