package competitive;

/**
 * Given an array of strings, group anagrams together.
 * 
 * Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
 */
import java.util.*;

public class GroupAnagrams {
	public static void main(String[] args) {

		List<List<String>> t = groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });
		for (List<String> list : t) {
			for (String s : list) {
				System.out.print(s + " ");
			}
			System.out.println();
		}

	}

	public static List<List<String>> groupAnagramsOptimised(String[] strs) { // optimised & minimized version
		if (strs.length == 0)
			return new ArrayList();
		Map<String, List> map = new HashMap<>();
		for (String s : strs) {
			char[] ca = s.toCharArray();
			Arrays.sort(ca);
			String temp = String.valueOf(ca);
			if (!map.containsKey(temp))
				map.put(temp, new ArrayList());
			map.get(temp).add(s);
		}

		return new ArrayList(map.values());
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		boolean flags[] = new boolean[strs.length];
		List<List<String>> res = new ArrayList<>();
		for (int i = 0; i < flags.length; i++) {
			flags[i] = true;
		}
		for (int x = 0; x < strs.length; x++) {
			if (flags[x]) {
				int index = x;
				List<String> temp = new ArrayList<>();
//temp.add(strs[x]);
				while (index < strs.length) {
					if (isAnagram(strs[x], strs[index])) {
						temp.add(strs[index]);
						flags[index] = false;
					}
					index++;
				}
				// System.out.println(temp);
				res.add(temp);

			}
		}

		return res;
	}

	private static boolean isAnagram(String a, String b) {
		if (a.length() != b.length())
			return false;
		char[] ArrayS1 = a.toLowerCase().toCharArray();
		char[] ArrayS2 = b.toLowerCase().toCharArray();
		Arrays.sort(ArrayS1);
		Arrays.sort(ArrayS2);

		return Arrays.equals(ArrayS1, ArrayS2);
	}
}
