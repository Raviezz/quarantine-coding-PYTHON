package competitive;

public class Test {
public static int nums[] = {2,6,9,3,5,1,7};
	public static void main(String[] args) {
		for(int i=0;i<nums.length;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(nums[i]<nums[j]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
					printArray();
					System.out.print("\n");
				}
			}
		}
		
	}
	private static void printArray() {
		for(int x: nums) System.out.print(x+" ");
	}

}
