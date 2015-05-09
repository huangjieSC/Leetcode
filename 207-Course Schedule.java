public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //construct graph matrix
        int[][] matGraph = new int[numCourses][numCourses];
        for (int i = 0; i< prerequisites.length; i++) {
            matGraph[prerequisites[i][1]][prerequisites[i][0]] = 1;
        }
        int[] visited = new int[numCourses]; // -1: visited; 1: unvisited
         for(int j=0; j<visited.length;j++)
            visited[j]=0;
        
        //detect cycle in each connected component
        for (int node = 0; node < numCourses; node++) {
                if (DFS(node, matGraph, visited)) {
                    continue;
                }
                return false;
        }
        return true;
    }
    
    public boolean DFS(int node, int[][] matGraph, int[] visited) {
        if(visited[node]==-1) return false;
        if(visited[node] == 1) return true;
        
        visited[node] = -1;
        for (int otherNode = 0; otherNode < matGraph.length; otherNode++) {
            if (matGraph[node][otherNode] == 1) {
                if (!DFS(otherNode, matGraph, visited)) {
                    return false;
                }
            }
        }
        visited[node] = 1; //backstracking
        
        return true;
    }
}
