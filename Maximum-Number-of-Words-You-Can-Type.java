class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> broken = new HashSet<>();
        for (char ch : brokenLetters.toCharArray()) {
            broken.add(ch);
        }

        String[] words = text.split(" ");
        int count = 0;

        for (String word : words) {
            boolean canType = true;
            for (char ch : word.toCharArray()) {
                if (broken.contains(ch)) {
                    canType = false;
                    break;
                }
            }
            if (canType) count++;
        }

        return count;
    }
}
