## Problem Statement:

Given an `m x n` matrix, if an element is `0`, set its entire row and column to `0`.
You must do it `in-place`.

Input:

- A 2D integer array matrix` [m]``[n] `

Output:

- Modify the matrix in-place such that any row or column containing a `0` is entirely set to `0`.

Constraints:

- `m == matrix.length`
- `n == matrix[0].length`
- `1 <= m, n <= 200`
- `-2³¹ <= matrix[i][j] <= 2³¹ - 1`

Example 1:

```makefile
Input:
[
    [1,1,1],
    [1,0,1],
    [1,1,1]
]

Output:
[
    [1,0,1],
    [0,0,0],
    [1,0,1]
]
```

Example 2:

```makefile
Input:
[
    [0,1,2,0],
    [3,4,5,2],
    [1,3,1,5]
]

Output:
[
    [0,0,0,0],
    [0,4,5,0],
    [0,3,1,0]
]
```
