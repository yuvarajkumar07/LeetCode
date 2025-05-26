class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int[][] colorCount = new int[n][26];
        List<Integer>[] graph = new ArrayList[n];
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            graph[from].add(to);
            indegree[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0, result = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited++;

            int colorIdx = colors.charAt(node) - 'a';
            colorCount[node][colorIdx]++;
            result = Math.max(result, colorCount[node][colorIdx]);

            for (int neighbor : graph[node]) {
                for (int c = 0; c < 26; c++) {
                    colorCount[neighbor][c] = Math.max(
                        colorCount[neighbor][c],
                        colorCount[node][c]
                    );
                }

                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return visited == n ? result : -1;
    }
}
