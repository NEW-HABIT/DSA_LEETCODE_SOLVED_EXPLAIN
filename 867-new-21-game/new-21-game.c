#include <stdio.h>

double new21Game(int n, int k, int maxPts) {
    if (k == 0 || n >= k + maxPts - 1) return 1.0;

    double dp[n + 1];
    for (int i = 0; i <= n; i++) dp[i] = 0.0;

    dp[0] = 1.0;
    double windowSum = 1.0;   // sliding window ka sum
    double result = 0.0;

    for (int i = 1; i <= n; i++) {
        dp[i] = windowSum / maxPts;  // probability ka average
        if (i < k) {
            windowSum += dp[i];  // abhi tak draw kar rahi hai
        } else {
            result += dp[i];     // yaha stop hoga
        }

        if (i - maxPts >= 0) {
            windowSum -= dp[i - maxPts];  // window slide karo
        }
    }

    return result;
}


