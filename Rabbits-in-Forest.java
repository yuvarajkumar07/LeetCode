class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int totalRabbits = 0;

        for (int answer : answers) {
            countMap.put(answer, countMap.getOrDefault(answer, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int k = entry.getKey();
            int count = entry.getValue();
            int groupSize = k + 1;
            int groups = (int) Math.ceil((double) count / groupSize);
            totalRabbits += groups * groupSize;
        }

        return totalRabbits;
    }
}
