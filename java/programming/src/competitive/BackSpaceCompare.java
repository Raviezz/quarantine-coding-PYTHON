package competitive;
import java.util.*;
/*
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?
 */
public class BackSpaceCompare {
	public static void main(String[] args) {
		System.out.print(backspaceCompare("ab#c", "ad#c"));
	}
	 public static boolean backspaceCompare(String S, String T) {
	        char guess = '#';
	        int index = S.indexOf(guess);
	        
	        while (index >= 0) {  
	            if(index == 0){
	                 S = S.substring(index+1,S.length());
	            }else{
	                 S = S.substring(0,index-1)+""+S.substring(index+1,S.length());
	            }
	            index = index-2;
	            index = S.indexOf(guess, index + 1);
	        }
	        index = T.indexOf(guess);
	        
	        while (index >= 0) {  
	            if(index == 0){
	                 T = T.substring(index+1,T.length());
	            }else{
	                 T = T.substring(0,index-1)+""+T.substring(index+1,T.length());
	            }
	            index = index-2;
	            index = T.indexOf(guess, index + 1);
	        }
	        if(S.equals(T)) return true;
	        
	        return false;
	    }
}
