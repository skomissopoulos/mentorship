// Function to determine if two strings are anagrams of each other.

import java.util.Map;
import java.util.HashMap;

class Main {
  public static Boolean isAnagram(String S, String T) {
    // Count the characters in S and T.
    // Again, note the use of Character (rather than char) and
    // Integer (rather than int).
    HashMap<Character, Integer> char_counts_in_S = countChars(S);
    HashMap<Character, Integer> char_counts_in_T = countChars(T);

    // If S and T don't contain the same number of distinct characters
    // (the number of keys in their respective char_counts), then they
    // can't be anagrams. hashmap.size() returns the number of keys
    // in the hashmap.
    if (char_counts_in_S.size() != char_counts_in_T.size()) {
        return false;
    }

    // Now check that for each character in S, that character appears
    // the same number of times in T.
    // This is a special kind of for loop; it loops over the
    // (key, value) pairs in the map rather than using i = 0; i < ...
    for (Map.Entry<Character, Integer> entry : char_counts_in_S.entrySet()) {
      Character c = entry.getKey();
      Integer char_count = entry.getValue();
      if (!char_counts_in_T.containsKey(c) ||
        char_counts_in_T.get(c) != char_count) {
        return false;
      }
    }

    // At this point we have checked that the counts of each character
    // in S are the same in T, and that S and T have the same number
    // of distinct characters. Together, these conditions mean that S and
    // T have exactly the same characters, and are anagrams of each other.
    return true;
  }

  // Returns a map from each character in `S` to the number of times
  // that character appears in S.
  public static HashMap<Character, Integer> countChars(String S) {
    HashMap<Character, Integer> char_counts = new HashMap<Character, Integer>();
    for (int i = 0; i < S.length(); ++i) {
      Character c = S.charAt(i);
      // If char is already in the map, increment it.
      // Otherwise, set its value to 1.
      if (char_counts.containsKey(c)) {
        Integer current_value_for_char = char_counts.get(c);
        char_counts.put(c, current_value_for_char + 1);
      } else {
        char_counts.put(c, 1);
      }
    }
    return char_counts;
  }

  public static void main(String[] args) {
    String s1 = "helloworld";
    String s2 = "hloolelwrd";
    String s3 = "notanagram";
    System.out.println(s1 + " is " + (isAnagram(s1, s2) ? "" : "not ") + "an anagram of " + s2);
    System.out.println(s1 + " is " + (isAnagram(s1, s3) ? "" : "not ") + "an anagram of " + s3);
    System.out.println(s2 + " is " + (isAnagram(s2, s3) ? "" : "not ") + "an anagram of " + s3);
  }
}
