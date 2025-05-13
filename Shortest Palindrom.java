public class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;

        // Compute the KMP prefix table for the combined string
        int[] prefixTable = new int[combined.length()];
        int j = 0;

        // Build the KMP prefix table
        for (int i = 1; i < combined.length(); i++) {
            while (j > 0 && combined.charAt(i) != combined.charAt(j)) {
                j = prefixTable[j - 1];
            }
            if (combined.charAt(i) == combined.charAt(j)) {
                j++;
            }
            prefixTable[i] = j;
        }

        // The length of the longest palindromic prefix in the original string is stored in the last entry of the prefix table
        int palindromicPrefixLength = prefixTable[combined.length() - 1];

        // We need to add the remaining characters of the reverse string (from palindromicPrefixLength to the end)
        String toAdd = rev.substring(0, rev.length() - palindromicPrefixLength);

        return toAdd + s;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        String s1 = "aacecaaa";
        System.out.println(solution.shortestPalindrome(s1));  // Output: "aaacecaaa"

        // Test case 2
        String s2 = "abcd";
        System.out.println(solution.shortestPalindrome(s2));  // Output: "dcbabcd"
    }
}
