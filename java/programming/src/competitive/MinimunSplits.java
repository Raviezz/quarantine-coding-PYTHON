package competitive;
/**
 * 
 * @author Raviteja
 * Minimum splits required to convert a number into prime segments.

Given a number in the form of a string s, the task is to calculate and display 
minimum splits required such that the segments formed are Prime or print Not Possible otherwise.

Input: s = “2351”
Output : 0
Explanation: Given number is already prime.

Input: s = “2352”
Output: 2
Explanation: Resultant prime segments are 23,5,2

Input: s = “2375672”
Output : 2
Explanation: Resultant prime segments are 2,37567,2



 *
 */
public class MinimunSplits {

	public static void main(String[] args) {
		
	}
	public static boolean isPrime(int num) {
		int count=1;
		if(num ==3 || num == 2) return true;
		for(int x = 1;x<=Math.ceil(Math.sqrt(num));x++) {
			if(num%x==0 ) count++;
		}
		if(count == 2) return true;
		return false;
	}

}
