import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort to handle duplicates and prune branches early
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int remain, int start, List<Integer> current, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Early stopping: numbers are sorted, so subsequent numbers will also be too large
            if (candidates[i] > remain) {
                break;
            }

            // Skip duplicate elements at the same decision level
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            current.add(candidates[i]);
            // Move to i + 1 since each number can only be used once
            backtrack(candidates, remain - candidates[i], i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}