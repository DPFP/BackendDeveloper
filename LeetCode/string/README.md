**Problems**:

| No.  | Problem                                                      | Difficulty | Date       | Time Spent | Note                         |
| ---- | ------------------------------------------------------------ | ---------- | ---------- | ---------- | ---------------------------- |
| 0006 | [ZigZag Conversion](https://leetcode.com/problems/zigzag-conversion/) | Medium     | 2020-11-9  |            |                              |
| 0008 | [String to Integer (atoi)](https://leetcode.com/problems/string-to-integer-atoi/) | Medium     | 2020-11-10 |            |                              |
| 0007 | [Revser Integer](https://leetcode.com/problems/reverse-integer/) | Easy       | 2020-11-12 |            |                              |
| 0013 | [Roman to Integer](https://leetcode.com/problems/roman-to-integer/) | Easy       | 2020-11-13 |            |                              |
| 0014 | [Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/) | Easy       | 2020-11-14 | 30mins.    |                              |
| 0028 | [Implement strStr()](https://leetcode.com/problems/implement-strstr/) | Easy       | 2020-11-14 | 15mins.    |                              |
| 0031 | [Next Permutation](https://leetcode.com/problems/next-permutation/) | Medium     | 2020-11-15 | 2 hrs      |                              |
| 0058 | [Length of Last word](https://leetcode.com/problems/length-of-last-word/) | Easy       | 2020-11-16 | 10mins.    |                              |
| 0067 | [Add Binary](https://leetcode.com/problems/add-binary/)      | Easy       | 2020-11-16 | 2 hrs      | Refer. solution              |
| 0125 | [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/) | Easy       | 2020-11-19 | 15mins     |                              |
| 0151 | [Reverse words in a String](https://leetcode.com/problems/reverse-words-in-a-string/) | Medium     | 2020-11-20 | 43mins     |                              |
| 0165 | [Compare Version numbers](https://leetcode.com/problems/compare-version-numbers/) | Medium     | 2020-11-21 | 62mins     |                              |
| 0344 | [Reverse String](https://leetcode.com/problems/reverse-string/) | Easy       | 2020-11-21 | 12mins     | in-place O(1)                |
| 0345 | [Reverse Vowels of a String](https://leetcode.com/problems/reverse-vowels-of-a-string/) | Easy       | 2020-11-22 | 32mins     |                              |
| 0387 | [First Unique character in a string](https://leetcode.com/problems/first-unique-character-in-a-string/submissions/) | Easy       | 2020-11-23 | 36mins     | Refer.solution               |
| 0415 | [Add Strings](https://leetcode.com/problems/add-strings/)    | Easy       | 2020-11-24 | 30mins     | (similar to 0067 add binary) |
| 0443 | String Compression                                           | Medium     | 2020-11-25 |            |                              |
|      |                                                              |            |            |            |                              |
|      |                                                              |            |            |            |                              |
|      |                                                              |            |            |            |                              |

**String** related LeetCode Problems: 

https://github.com/liweiwei1419/LeetCode-Solutions-in-Good-Style/tree/master/string/Java



# Take away



## Primitive Data Types

| Data Type | Size    | Description                                                  |
| :-------- | :------ | :----------------------------------------------------------- |
| byte      | 1 byte  | Stores whole numbers from -128 to 127                        |
| short     | 2 bytes | Stores whole numbers from -32,768 to 32,767                  |
| int       | 4 bytes | Stores whole numbers from -2,147,483,648 to 2,147,483,647    |
| long      | 8 bytes | Stores whole numbers from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 |
| float     | 4 bytes | Stores fractional numbers. Sufficient for storing 6 to 7 decimal digits |
| double    | 8 bytes | Stores fractional numbers. Sufficient for storing 15 decimal digits |
| boolean   | 1 bit   | Stores true or false values                                  |
| char      | 2 bytes | Stores a single character/letter or ASCII values             |

- Java String is Immutable; 

  - e.g.  `test = test.replace("a", "b");`  //assign value back to `test`

- The **java.lang.Math.floor()** returns the double value that is less than or equal to the argument and is equal to the nearest mathematical integer.

- You can parse any number string to Int/long with difference radix ` Integer.parseInt(x, radix)`

  - e.g. `Integer.parseInt("1011", 2)` will parse the string as binary input value; 
  - Note: For Integer It only able to handle Positive numbers;

-  For parse super long string to number, try the two following methods: [ref](https://stackoverflow.com/questions/11860311/how-to-convert-binary-number-to-double-in-java)

  - #1 

    ```java
    public static double toDouble(byte[] bytes) {
         return ByteBuffer.wrap(bytes).getDouble();
    }
    ```

  - #2

    ```java
    String text = "1100000110011101010111011000101011011000011111111111111111111110";
    double doubleVal = Double.longBitsToDouble(new BigInteger(text, 2).longValue());
    System.out.println(doubleVal);
    ```

- How to Convert ASCII to String conversion Using Java ?

  - int a = 65;
  - Character.toString(a);
  - [bitwise operation](https://www.vojtechruzicka.com/bit-manipulation-java-bitwise-bit-shift-operations/);

- How to clean StringBuilder ? [Answer](https://www.javacodeexamples.com/java-stringbuilder-clear-example-how-to-empty-stringbuilder-stringbuffer/1535)

  - `new StringBuilder()` object creation is costly -- not recommened, especially not in the loop.
  - `sb.delete(0,sb.length)` internally allocate new buffer, which is costly. 
  - `sb.setLength(0)` consider the best choice* 

- How to check if a characer is Alphanumeric ?

  - ```java
    Character.isLetter(c) ||Character.isDigit(c)
    ```

- What's the different between **StringBuilder** and **StringBuffer** ? 

  - [`StringBuffer`](http://docs.oracle.com/javase/8/docs/api/java/lang/StringBuffer.html) is synchronized, [`StringBuilder`](http://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html) is not. (Similar to `Vector` and `ArrayList`)

- What's the different between `strip()` and `trim()`?

  - `strip()` is "Unicode-aware" evolution of `trim()`.

- How to increament HashMap<Character,Interger> count ? 

  - `map.put(key, map.getOrDefault(key,0) + 1);`

- How to get Numeric(int) value out of Char ? 

  - `Character.getNumericValue('1')` ==>  1 (int)

  - or Numeric(int) to char 

  - ```java
    int a=1;    
    char c=(char)(a+'0');
    ```

- How to remove element from Array ? 

  - #1, Using Two arrays;
  - #2, ArraysUtils.remove() from Apache Commons pacakge;
  - #3, Using for loop to shift element from the index that need be removed; 



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



