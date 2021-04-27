package JavaProgs;

import java.util.ArrayList;
import java.util.List;

class courseSchedule {
    public static void main(String[] args) {
        int numCourses = 5;
        int pre[][] = {{1,0},{2,1},{3,2},{4,3},{4,2}};
        System.out.println(canFinish(numCourses, pre));
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = buildGraph(numCourses, prerequisites);
        int[] color = new int[numCourses];
        for (int i = 0; i < adjList.size(); i++) {
            if (color[i] == 0) {
                if (hasCycleFromVertex(adjList, color, i)) {
                    return false;
                }
            }
        }
        return true;
    }
    //Creating Graph
    private static List<List<Integer>> buildGraph(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] i: prerequisites) {
            adjList.get(i[1]).add(i[0]);
        }
        return adjList;
    }
    
    private static boolean hasCycleFromVertex(List<List<Integer>> adjList, int[] color, int vertex) {
        if(color[vertex] == 1) {
            return true;
        }
        color[vertex] = 1;
        for (int v: adjList.get(vertex)) {
            if (color[v] != 2) {
                if (hasCycleFromVertex(adjList, color, v))  {
                    return true;
                }
            }
        }
        color[vertex] = 2;
        return false;
    }
}
