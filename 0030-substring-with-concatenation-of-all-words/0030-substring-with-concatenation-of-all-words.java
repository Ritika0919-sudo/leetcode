import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        if (s.length() < totalLen) {
            return result;
        }

        // Count frequency of each word in the words array
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String w : words) {
            wordFreq.put(w, wordFreq.getOrDefault(w, 0) + 1);
        }

        // Run sliding window for each remainder offset
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int right = i;
            Map<String, Integer> seen = new HashMap<>();
            int count = 0;

            while (right + wordLen <= s.length()) {
                String sub = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordFreq.containsKey(sub)) {
                    seen.put(sub, seen.getOrDefault(sub, 0) + 1);
                    count++;

                    // Shrink the window if a word appears more times than allowed
                    while (seen.get(sub) > wordFreq.get(sub)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    // If all words are matched exactly
                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    // Reset the window
                    seen.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}