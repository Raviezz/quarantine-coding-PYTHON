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

Following Code relates to "Matrix Chain Of Multiplication"
1. https://www.youtube.com/watch?v=prx1psByp7U
2. https://www.youtube.com/watch?v=gwmitwgz87s

follow these , first you will understand what is matrix chain multi , why should we use it.



 *
 */
public class MinimunSplits {
	public static int memory[][];
	public static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		memory=new int[100][100];
		for(int i=0;i<memory.length;i++) {
			for(int j=0;j<memory[i].length;j++) {
				memory[i][j] = 0;
			}
		}
		
		System.out.print(new MinimunSplits().getMiniMumSplit("2352", 0, 3));
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
	
	public static int parseToInt(String s,int i,int j) {
		int temp = 0;
		for(int x=i;x<=j;x++) {
			temp = temp*10 + (s.charAt(x)-'0');
		}
		return temp;
	}
	
	public int getMiniMumSplit(String s,int i,int j) {
		int num = parseToInt(s,i,j);
		if(isPrime(num)) return 0;
		if(i==j && isPrime(num)) return 0;
		if(i==j && !isPrime(num)) return min;
		if(memory[i][j]!=0) return memory[i][j];
		
		int res = min;
		for(int k=i;k<j;k++) {
			int left = getMiniMumSplit(s, i, k);
			if(left == min) {
				continue;
			}
			
			int right = getMiniMumSplit(s, k+1, j);
			if(right == min) continue;
			
			res = Math.min(res, 1+left+right);
		}
		
		return memory[i][j] = res;
	}

}
