## Problem Statement:

You are given an integer array `nums` sorted in ascending order, but rotated at an **unknown pivot**, and an integer `target`.

Return the **index** of `target` if it is in the array. If not, return `-1`.

You must solve it in **O(log n)** time.

Input:

- An integer array `nums` (**rotated**)
- An integer `target`

Output:

- Integer index of target if found, otherwise `-1`

Constraints:

- `1 <= nums.length <= 10^4`
- `-10^4 <= nums[i], target <= 10^4`
- All values in nums are **unique**

Example 1:

```makefile
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
```

Example 2:

```makefile
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
```

Example 3:

```makefile
Input: nums = [1], target = 0
Output: -1
```
