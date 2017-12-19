package random.problems;


public class AddOneToArray {
	
	public static void main(String[] args) {
		int[] arr = {9, 9, 9};
		int[] output = addOne(arr);
		for (int i = 0; i < output.length; i++) {
			System.out.print(output[i]);
		}
	}

	private static int[] addOne(int[] arr) {
		int carry = 1;
		int total = 0;
		int[] output = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			total = arr[i] + carry;
			if (total == 10) carry = 1;
			else carry = 0;
			output[i] = total % 10;
		}
		if (carry == 1) {
			output =  new int[arr.length + 1];
			output[0] = 1;
		}
		return output;
	}

}
