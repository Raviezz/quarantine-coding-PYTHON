package competitive;
import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author Raviteja
 Given an array of Integers, return indices of the two numbers such that they add up to a specific target.
You may assume tha each input would have exactly one solution , and ay not use the same element twice.

Example:
 Given inputs  = [2,7,11,15], target = 9;

output = [0,1] 
 */
public class TwoSum {

	public static void main(String[] args) {
		int input[] = new int[] {2,7,11,15};
		int res[] = getTwoSum(input,9);
		for(int x:res) System.out.print(x);

	}

	private static int[] getTwoSum(int[] input,int target) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<input.length;i++) {
			if(!map.containsKey(target-input[i])) {
				map.put(input[i],i);
			}else {
				return new int[] {map.get(target-input[i]),i};
			}
		}
		return null;
	}

}
