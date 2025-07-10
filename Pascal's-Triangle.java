class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int row = 0; row < numRows; row++) {
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1); 
            for (int col = 1; col < row; col++) {
                int value = triangle.get(row - 1).get(col - 1) + triangle.get(row - 1).get(col);
                currentRow.add(value);
            }
            if (row > 0) {
                currentRow.add(1); 
            }
            triangle.add(currentRow);
        }
        return triangle;
    }
}
