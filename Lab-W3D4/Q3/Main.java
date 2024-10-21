package Q3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] adjMatrix = new int[][]
                {
                        { 0, 1, 1, 0, 0, 1, 0, 0, 0 },
                        { 1, 0, 0, 0, 0, 1, 0, 0, 0 },
                        { 1, 0, 0, 0, 0, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 1, 0, 0, 0, 1 },
                        { 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                        { 1, 1, 1, 0, 0, 0, 0, 1, 0 },
                        { 0, 0, 1, 0, 0, 0, 0, 1, 0 },
                        { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                        { 0, 0, 0, 1, 1, 0, 0, 0, 0 }
                };
        var vertices = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I' };
        var components = DFS(adjMatrix, vertices);

        for (Map.Entry<Character, Integer> entry : components.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();
            System.out.println("Key=" + key + ", Value=" + value);
        }
    }

    public static HashMap<Character, Integer> DFS(int[][] adjMatrix, char[] vertices) {
        var comNum = 0;
        var markedVertices = new HashMap<Character, Integer>();
        var visited = new HashSet<Character>();

        for (var v : vertices) {
            markedVertices.put(v, 0);
        }

        while (markedVertices.containsValue(0)) {
            comNum++;

            var vQueue = new PriorityQueue<Character>();
            char vertix = vertices[0];

            for(Map.Entry<Character, Integer> entry: markedVertices.entrySet()) {
                if (entry.getValue() == 0) {
                    vertix = entry.getKey();
                    break;
                }
            }

            markedVertices.put(vertix, comNum);
            vQueue.add(vertix);

            while (!vQueue.isEmpty()) {
                var vDequeue = vQueue.remove();

                if(visited.contains(vDequeue))
                {
                    visited.remove(vDequeue);
                    continue;
                }

                var vDequeueIndex = getIndexOfVertex(vertices, vDequeue);

                for (int i = 0; i < adjMatrix[vDequeueIndex].length; i++) {
                    if (adjMatrix[vDequeueIndex][i] == 1)
                    {
                        if ((markedVertices.get(vertices[i]) == 0))
                        {
                            var adjVertix = vertices[i];
                            markedVertices.put(adjVertix, comNum);
                            vQueue.add(adjVertix);
                        }
                    }
                }
                visited.add(vDequeue);
            }
        }

        return markedVertices;
    }

    public static int getIndexOfVertex(char[] vertices, char v) {
        var index = 0;
        for(var ver : vertices) {
            if(ver == v) {
                return index;
            }
            index++;
        }
        return -1;
    }
}
