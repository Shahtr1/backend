package ds.arrays_strings.missing_number_1_to_n;

public class MissingNumber1_to_N {
    public static void main(String[] args) {
        int[] nums = { 0, 1 };

        int sum = ((nums.length) * (nums.length + 1)) / 2;

        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }

        System.out.println("Missing number is: " + sum);
    }
}
