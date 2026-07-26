class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {

        int[][] engineers = new int[n][2];

        for (int i = 0; i < n; i++) {
            engineers[i][0] = efficiency[i];
            engineers[i][1] = speed[i];
        }

        Arrays.sort(engineers, (a, b) -> b[0] - a[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        long speedSum = 0;
        long maxPerformance = 0;
        int MOD = 1000000007;

        for (int[] engineer : engineers) {

            int currEfficiency = engineer[0];
            int currSpeed = engineer[1];

            minHeap.offer(currSpeed);
            speedSum += currSpeed;

            if (minHeap.size() > k) {
                speedSum -= minHeap.poll();
            }

            maxPerformance = Math.max(maxPerformance,
                    speedSum * currEfficiency);
        }

        return (int)(maxPerformance % MOD);
    }
}