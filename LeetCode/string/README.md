Problems:

| No.  | Problem                                                      | Difficulty | Date       | Time Spent | Note |
| ---- | ------------------------------------------------------------ | ---------- | ---------- | ---------- | ---- |
| 0006 | [ZigZag Conversion](https://leetcode.com/problems/zigzag-conversion/) | Medium     | 2020-11-9  |            |      |
| 0008 | [String to Integer (atoi)](https://leetcode.com/problems/string-to-integer-atoi/) | Medium     | 2020-11-10 |            |      |
| 0007 | [Revser Integer](https://leetcode.com/problems/reverse-integer/) | Easy       | 2020-11-12 |            |      |
| 0013 | [Roman to Integer](https://leetcode.com/problems/roman-to-integer/) | Easy       | 2020-11-13 |            |      |
| 0014 | [Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/) | Easy       | 2020-11-14 | 30mins.    |      |
| 0028 | [Implement strStr()](https://leetcode.com/problems/implement-strstr/) | Easy       | 2020-11-14 | 15mins.    |      |
| 0031 | [Next Permutation](https://leetcode.com/problems/next-permutation/) | Medium     | 2020-11-15 | 2 hrs      |      |
| 0058 | [Length of Last word](https://leetcode.com/problems/length-of-last-word/) | Easy       | 2020-11-16 | 10mins.    |      |
|      |                                                              |            |            |            |      |
|      |                                                              |            |            |            |      |
|      |                                                              |            |            |            |      |
|      |                                                              |            |            |            |      |
|      |                                                              |            |            |            |      |
|      |                                                              |            |            |            |      |
|      |                                                              |            |            |            |      |
|      |                                                              |            |            |            |      |
|      |                                                              |            |            |            |      |
|      |                                                              |            |            |            |      |
|      |                                                              |            |            |            |      |
|      |                                                              |            |            |            |      |

**String** related LeetCode Problems: 

https://github.com/liweiwei1419/LeetCode-Solutions-in-Good-Style/tree/master/string/Java

------

# Java String Take away

- Java String is Immutable; 
  - e.g.  `test = test.replace("a", "b");`  //assign value back to `test`
- The **java.lang.Math.floor()** returns the double value that is less than or equal to the argument and is equal to the nearest mathematical integer.
- 





# Problem Solutions/Tips



**00031-Next Permutation [Solution](https://leetcode.com/problems/next-permutation/solution/)**:

First, we observe that for any given sequence that is in descending order, no next larger permutation is possible. 

We need to find the first pair of two successive numbers a[i]*a*[*i*] and a[i-1]*a*[*i*−1], from the right, which satisfy a[i] > a[i-1]*a*[*i*]>*a*[*i*−1].

![ Next Permutation ](https://leetcode.com/media/original_images/31_nums_graph.png)

E.g. 158476531 -- Steps 

1. Start from right, find the first decreasing element --> 4 
2. start from element 4 to the right, find the number just large (closest) to 4 ---> 5
3. Swap 4 & 5 --> 158**5**76**4**31
4. Resort/Reverse everything from the right side of 5 --> 158513467 

![Next Permutation](https://leetcode.com/media/original_images/31_Next_Permutation.gif)

