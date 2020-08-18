package com.bellmanforde;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private static final int MAX_VERTEX = 10;
    private int[][] mas;
    private int curVertex;
    private Vertex[] vertexList;
    private FtStack stack;

    public Graph() {
        this.mas = new int[MAX_VERTEX][MAX_VERTEX];
        this.curVertex = 0;
        this.vertexList = new Vertex[MAX_VERTEX];
        this.stack = new FtStack();
    }

    public void addVertex(String name) {
        vertexList[curVertex++] = new Vertex(name);
    }

    public void addEdge(int start, int end, int val) {
        mas[start][end] = 1;
        mas[end][start] = 1;
    }

    public int check(int v) {
        for(int i = 0; i < curVertex; i++) {
            if(mas[v][i] == 1 && !vertexList[i].isVisited()) return i;
        }
        return -1;
    }

    public void Calc(int index) {
        System.out.println(vertexList[index].getName() + " is Visited");
        vertexList[index].setVisited(true);
        stack.push(index);

        while(!stack.isEmpty()) {
            int tmp = check(stack.pick());

            if(tmp == -1)
                tmp = stack.pop();
            else {
                System.out.println(vertexList[tmp].getName() + " is Visited");
                vertexList[tmp].setVisited(true);
                stack.push(tmp);
            }
        }

        for(int i = 0;i < curVertex; i ++) {
            vertexList[index].setVisited(false);
        }
    }
}
