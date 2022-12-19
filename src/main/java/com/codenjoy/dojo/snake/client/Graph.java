package com.codenjoy.dojo.snake.client;

import com.codenjoy.dojo.services.Point;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    public List<GraphNode> graphNodes;
    private final List<GraphNode> path;

    public Graph(List<GraphNode> graphNodes) {
        this.graphNodes = graphNodes;
        path = new ArrayList<>();
    }

    public void addEdge(String i, String j) {
        GraphNode first = graphNodes.stream()
                .filter(x -> x.name.equals(i))
                .findFirst()
                .orElse(null);
        GraphNode second = graphNodes.stream()
                .filter(z -> z.name.equals(j))
                .findFirst()
                .orElse(null);

        first.neighbours.add(second);
        second.neighbours.add(first);
    }

    public List<GraphNode> pathPrint(GraphNode node) {
        if (node.parent != null) {
            pathPrint(node.parent);
            path.add(node);
        }
        System.out.print(node.name + " ");
        return path;
    }


    public List<GraphNode> BFSForPathFinding(int nodeFrom, int nodeTo) {
        LinkedList<GraphNode> queue = new LinkedList<>();
        List<GraphNode> path = null;
        queue.add(graphNodes.get(nodeFrom - 1));
        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.remove(0);
            currentNode.isVisited = true;
            if (currentNode.equals(graphNodes.get(nodeTo - 1))) {
                path = pathPrint(currentNode);
            }
            currentNode.neighbours.forEach(x -> {
                if (!x.isVisited) {
                    x.parent = currentNode;
                    x.isVisited = true;
                    queue.add(x);
                }
            });
        }
        return path;
    }

    public List<GraphNode> BFSForPathFindingX(Point head, Point apple) {
        LinkedList<GraphNode> queue = new LinkedList<>();
        List<GraphNode> path = null;
        queue.add(graphNodes.get(head.getX() - 1));
        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.remove(0);
            currentNode.isVisited = true;
            if (currentNode.equals(graphNodes.get(apple.getX()))) {
                path = pathPrint(currentNode);
            }
            currentNode.neighbours.forEach(x -> {
                if (!x.isVisited) {
                    x.parent = currentNode;
                    x.isVisited = true;
                    queue.add(x);
                }
            });
        }
        return path;
    }

    public List<GraphNode> BFSForPathFindingY(Point head, Point apple) {
        LinkedList<GraphNode> queue = new LinkedList<>();
        List<GraphNode> path = null;
        queue.add(graphNodes.get(head.getY() - 1));
        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.remove(0);
            currentNode.isVisited = true;
            if (currentNode.equals(graphNodes.get(apple.getY()))) {
                path = pathPrint(currentNode);
            }
            currentNode.neighbours.forEach(x -> {
                if (!x.isVisited) {
                    x.parent = currentNode;
                    x.isVisited = true;
                    queue.add(x);
                }
            });
        }
        return path;
    }

    @Override
    public String toString() {
        StringBuilder graph = new StringBuilder();
        for (int i = 0; i < graphNodes.size(); i++) {
            graph.append(graphNodes.get(i).name).append(": ");
            for (int j = 0; j < graphNodes.get(i).neighbours.size(); j++) {
                if (j == graphNodes.get(i).neighbours.size() - 1)
                    graph.append(graphNodes.get(i).neighbours.get(j).name);
                else
                    graph.append(graphNodes.get(i).neighbours.get(j).name)
                            .append(" -> ");
            }
            graph.append("\n");
        }
        return graph.toString();
    }
}
