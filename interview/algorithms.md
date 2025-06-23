Algorithms

❓ 100 Algorithms Interview Questions
🧪 Sorting & Searching (Q1–Q15)
Implement QuickSort and MergeSort.

Search in a rotated sorted array.

Find the first and last position of an element.

Find kth largest element in array.

Search a 2D matrix.

Implement binary search recursively and iteratively.

Find the median of two sorted arrays.

Top K frequent elements.

Missing number using XOR.

Find duplicate in O(1) space.

Sort colors (Dutch national flag).

Implement radix sort.

Find peak element.

Find majority element (Boyer-Moore).

Maximum frequency stack.

🔁 Recursion & Backtracking (Q16–Q30)
Generate all subsets of a set.

Generate all permutations.

N-Queens problem.

Sudoku solver.

Word search in a matrix.

Palindrome partitioning.

Restore IP addresses.

Combination sum.

Letter combinations of phone number.

Permutations with duplicates.

Generate parenthesis.

Rat in a maze.

Knight’s tour.

Word break problem.

All paths from source to target.

📉 Divide & Conquer (Q31–Q40)
Merge k sorted lists.

Count inversions in array.

Closest pair of points.

Maximum subarray (Kadane’s + Divide & Conquer).

Power function (fast exponentiation).

Median of two sorted arrays (log time).

Find kth smallest element in sorted matrix.

Majority element using divide and conquer.

Skyline problem.

Search in rotated array.

🧠 Dynamic Programming (Q41–Q60)
Fibonacci with memoization.

Climbing stairs.

House robber.

Longest increasing subsequence.

Edit distance.

Word break.

Longest common subsequence.

0/1 Knapsack.

Coin change.

Unique paths (with obstacles).

Partition equal subset sum.

Interleaving string.

Matrix chain multiplication.

Boolean expression evaluation.

Rod cutting problem.

Palindromic substring count.

Minimum cost to climb stairs.

Decode ways.

Jump game I & II.

Cherry pickup problem.

⚡ Greedy Algorithms (Q61–Q70)
Activity selection problem.

Fractional knapsack.

Jump game (greedy variant).

Minimum platforms required.

Gas station circuit.

Task scheduler.

Reorganize string.

Non-overlapping intervals.

Merge intervals.

Meeting rooms.

🌐 Graph Algorithms (Q71–Q85)
DFS and BFS traversals.

Topological sort.

Detect cycle in undirected graph.

Detect cycle in directed graph.

Number of islands.

Clone graph.

Course schedule.

Dijkstra's algorithm.

Bellman-Ford algorithm.

Prim’s and Kruskal’s MST.

Union-Find implementation.

Redundant connection.

Bipartite graph check.

Alien dictionary (topo sort).

Minimum spanning tree with edge list.

🌲 Trees & Binary Search Trees (Q86–Q90)
Inorder, preorder, postorder traversals.

Validate BST.

Lowest common ancestor.

Serialize and deserialize binary tree.

Diameter of binary tree.

🚀 Sliding Window & Two Pointers (Q91–Q95)
Longest substring without repeating characters.

Longest repeating character replacement.

Max sliding window.

Minimum window substring.

Move zeroes to end.

🔥 Bit Manipulation & Math (Q96–Q100)
Single number (XOR).

Counting bits.

Power of two / three.

GCD / LCM using Euclidean algorithm.

Fast exponentiation modulo large prime.

💡 Java Code Example – Longest Substring Without Repeating Characters
java
Copy
Edit
public int lengthOfLongestSubstring(String s) {
Set<Character> set = new HashSet<>();
int left = 0, right = 0, max = 0;

    while (right < s.length()) {
        if (!set.contains(s.charAt(right))) {
            set.add(s.charAt(right++));
            max = Math.max(max, set.size());
        } else {
            set.remove(s.charAt(left++));
        }
    }

    return max;

}
