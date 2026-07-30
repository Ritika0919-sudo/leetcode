class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        int hottest = 0;

        for (int i = n - 1; i >= 0; i--) {
            int currentTemp = temperatures[i];

            if (currentTemp >= hottest) {
                hottest = currentTemp;
                continue;
            }

            int days = 1;
            while (temperatures[i + days] <= currentTemp) {
                days += result[i + days];
            }
            result[i] = days;
        }

        return result;
    }
}