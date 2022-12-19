package com.codenjoy.dojo.snake.client;


import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    public int index;
    public String name;

    public boolean isVisited = false;
    public GraphNode parent;
    public List<GraphNode> neighbours;

    public GraphNode(String name, int index) {
        this.index = index;
        this.name = name;
        neighbours = new ArrayList<>();
    }

    @Override
    public String toString() {
        return name;
    }
}
