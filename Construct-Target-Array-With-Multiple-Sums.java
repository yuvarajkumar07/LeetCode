class Solution {
    public boolean isPossible(int[] target) {
        long total = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : target) {
            total += num;
            pq.add(num);
        }

        while (true) {
            int max = pq.poll();
            long rest = total - max;
            if (max == 1 || rest == 1) return true;
            if (rest == 0 || max < rest) return false;
            int previous = (int)(max % rest);
            if (previous == 0) return false;
            pq.add(previous);
            total = rest + previous;
        }
    }
}
