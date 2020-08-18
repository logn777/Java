package com.bellmanforde;

public class Vertex {
    private String name;
    private boolean isVisited;

    public void setName(String name) {
        this.name = name;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public String getName() {
        return name;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public Vertex(String name) {
        this.name = name;
        this.isVisited = isVisited;
    }
}
