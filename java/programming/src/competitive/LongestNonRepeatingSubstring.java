package competitive;
/**
 * 
 * @author Raviteja
 
 Longest Substring Without Repeating Characters:

Given a substring , find the length of the longest substring without repeating characters:

Examples:
 input: "abcabcbb"
 ouput: "abc" 
 return: 3

2. input: "bbbbbb"
   output: "b"
   return 1

3. input : "pwwkew"
   outputs: "wke" / "kew"
   return 3
 
 */
public class LongestNonRepeatingSubstring {

	public static void main(String[] args) {
		System.out.print(getLongestSubstring("abcabcd"));

	}
	private static int getLongestSubstring(String s) { // Fuck its O(n^n) // needs to optimised
		int max = 1;
		OUTER:for(int x=0;x<s.length();x++) {
			char ch = s.charAt(x);
			String temp = ch+"";
			INNER:for(int y=1;y<s.length();y++) {
				if(temp.contains(s.charAt(y)+"")) {
					break INNER;
				}else {
					temp +=s.charAt(y)+"";
					ch = s.charAt(y);
					if(max < temp.length()) {
						max = temp.length();
					}
				}
			}
		}
		return max;
	}

}
