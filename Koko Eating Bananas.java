public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMax(piles);
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, h, mid)) {
                result = mid;
                right = mid - 1;  // Try to find a smaller k
            } else {
                left = mid + 1;  // Need a larger k
            }
        }
        return result;
    }

    // Helper to find maximum in piles
    private int getMax(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }

    // Helper to check if Koko can finish at speed k
    private boolean canFinish(int[] piles, int h, int k) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k;  // same as Math.ceil(pile / k)
        }
        return hours <= h;
    }

    // For testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] piles1 = {3, 6, 7, 11};
        int h1 = 8;
        System.out.println(sol.minEatingSpeed(piles1, h1)); // Output: 4

        int[] piles2 = {30, 11, 23, 4, 20};
        int h2 = 5;
        System.out.println(sol.minEatingSpeed(piles2, h2)); // Output: 30

        int[] piles3 = {30, 11, 23, 4, 20};
        int h3 = 6;
        System.out.println(sol.minEatingSpeed(piles3, h3)); // Output: 23
    }
}
