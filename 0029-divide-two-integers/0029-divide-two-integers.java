class Solution {
    public int divide(int dividend, int divisor) {
        // Handle 32-bit integer overflow: Integer.MIN_VALUE / -1 = 2^31 (overflows to Integer.MAX_VALUE)
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Convert to long and take absolute values to prevent overflow during bit shifts
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        int quotient = 0;

        // Subtract divisor * 2^shift from dividend
        while (a >= b) {
            short shift = 0;
            while (a >= (b << (shift + 1))) {
                shift++;
            }
            a -= b << shift;
            quotient += 1 << shift;
        }

        return isNegative ? -quotient : quotient;
    }
}