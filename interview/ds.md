## Data Structures

❓ 100 Data Structures Interview Questions
📁 Arrays & Strings (Q1–Q20)
Find the duplicate number in an array without modifying the array.

Rotate an array by k steps.

Merge two sorted arrays.

Kadane’s algorithm (Maximum Subarray).

Product of array except self.

Two Sum / Three Sum / Four Sum.

Sliding window maximum.

Longest substring without repeating characters.

Palindrome check (and longest palindromic substring).

Find missing number from 1 to n.

Set Matrix Zeroes (in-place).

Search in a rotated sorted array.

Group anagrams.

Longest common prefix.

Valid parentheses.

Trapping rain water.

Move all zeroes to the end.

Count number of islands (as a matrix problem).

Word search in matrix.

Matrix spiral traversal.

🔗 Linked Lists (Q21–Q35)
Reverse a linked list.

Detect cycle in a linked list (Floyd’s Cycle Detection).

Merge two sorted linked lists.

Remove nth node from end.

Find intersection of two linked lists.

Check if linked list is a palindrome.

Add two numbers represented by linked lists.

Flatten a multilevel linked list.

Copy list with random pointer.

Sort a linked list.

Detect and remove loop.

Find middle node.

Rotate list right.

Delete node without head pointer.

Partition linked list around a value.

🥞 Stacks & Queues (Q36–Q50)
Implement stack using queue and vice versa.

Min stack.

Evaluate reverse Polish notation.

Next greater element.

Daily temperatures.

Balanced parentheses.

Sliding window maximum (with deque).

Implement circular queue.

Design LRU cache.

Decode string (e.g., 3[a2[c]]).

Basic calculator (I, II).

Largest rectangle in histogram.

Remove k digits to get smallest number.

Implement queue using two stacks.

Celebrity problem.

🧠 Hash Tables & Sets (Q51–Q65)
Two sum (hash map approach).

Longest consecutive sequence.

Subarray sum equals K.

Isomorphic strings.

Top K frequent elements.

Group anagrams.

Find all duplicates in array.

Minimum window substring.

Valid Sudoku.

Word pattern.

Intersection of two arrays.

Count distinct elements in every window.

Implement phone directory.

Find common elements in 3 sorted arrays.

First non-repeating character.

🌲 Trees (Q66–Q80)
Inorder, preorder, postorder traversals.

Level order traversal (BFS).

Validate BST.

Lowest common ancestor.

Diameter of binary tree.

Check if tree is symmetric.

Construct binary tree from inorder & preorder.

Path sum in a binary tree.

Flatten binary tree to linked list.

Vertical order traversal.

Serialize and deserialize binary tree.

Zigzag level order traversal.

BST to sorted doubly linked list.

Count number of nodes in complete binary tree.

Binary tree right side view.

🔗 Tries, Heaps, Disjoint Sets (Q81–Q90)
Implement Trie.

Word search with Trie.

Longest word in dictionary.

Top K frequent words (min-heap).

Median from data stream.

Merge K sorted lists.

K closest points to origin.

Find peak in a 2D matrix.

Union-Find (DSU) – detect cycle in graph.

Number of connected components.

🌐 Graphs (Q91–Q100)
DFS / BFS traversal.

Clone graph.

Detect cycle in undirected graph.

Detect cycle in directed graph.

Topological sort.

Number of islands (DFS / BFS / Union Find).

Shortest path in binary matrix.

Course schedule I & II.

Alien dictionary (order of characters).

Dijkstra’s algorithm for shortest path.

💡 Java Code Example – Min Stack
java
Copy
Edit
class MinStack {
Stack<Integer> stack = new Stack<>();
Stack<Integer> minStack = new Stack<>();

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
