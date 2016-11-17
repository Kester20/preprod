package utility;

import java.util.Arrays;

/**
 * @author Arsalan
 */
public class FindLongestRepeated {


    private static String longestCommonPrefix(String s, String t) {
        int n = Math.min(s.length(), t.length());
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i))
                return s.substring(0, i);
        }
        return s.substring(0, n);
    }


    public static String longestRepeated(String s) {
        int n = s.length();
        String[] suffixes = new String[n];
        for (int i = 0; i < n; i++) {
            suffixes[i] = s.substring(i, n);
        }

        Arrays.sort(suffixes);

        String lrs = "";
        for (int i = 0; i < n - 1; i++) {
            String x = longestCommonPrefix(suffixes[i], suffixes[i + 1]);
            if (x.length() > lrs.length())
                lrs = x;
        }
        return lrs;
    }
}