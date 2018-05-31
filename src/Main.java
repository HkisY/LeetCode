import java.util.*;

public class Main {

    public static void main(String[] args) {
        /*---------------------------------------------*/
//        int[] nums = new int[4];
//        nums[0] = 2;
//        nums[1] = 7;
//        nums[2] = 11;
//        nums[3] = 15;
//
//        int[] ints = twoSum(nums, 9);
//        for (int i : ints) {
//            System.out.println(ints[i]);
//        }
//        /*---------------------------------------------*/
//        String[] words ={"gin", "zen", "gig", "msg"};
//        int i = uniqueMorseRepresentations(words);
//        System.out.println(i);
        /*---------------------------------------------*/
//        int[][] A = new int[][]{{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
//        int[][] ints1 = flipAndInvertImage(A);
//        for (int i = 0; i < ints1.length; i++) {
//            for (int j = 0; j < ints1.length; j++) {
//                System.out.print(ints1[i][j] + ",");
//            }
//            System.out.println(" ");
//        }
//
//        int[][] B = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
//        int[][] ints2 = flipAndInvertImage(B);
//        for (int i = 0; i < ints2.length; i++) {
//            for (int j = 0; j < ints2.length; j++) {
//                System.out.print(ints2[i][j] + ",");
//            }
//            System.out.println(" ");
//        }
        /*---------------------------------------------*/
        int i = hammingDistance(1, 4);
        System.out.println(i);

    }

    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * Example:
     * <p>
     * Given nums = [2, 7, 11, 15], target = 9,
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1]
     *
     * @since 2018-5-28
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (target == sum) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes,
     * as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
     * For convenience, the full table for the 26 letters of the English alphabet is given below:
     * <p>
     * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
     * "...","-","..-","...-",".--","-..-","-.--","--.."]
     * <p>
     * Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter.
     * For example, "cab" can be written as "-.-.-....-", (which is the concatenation "-.-." + "-..." + ".-").
     * We'll call such a concatenation, the transformation of a word.
     * Return the number of different transformations among all words we have.
     * <p>
     * Example:
     * Input: words = ["gin", "zen", "gig", "msg"]
     * Output: 2
     * Explanation:
     * The transformation of each word is:
     * "gin" -> "--...-."
     * "zen" -> "--...-."
     * "gig" -> "--...--."
     * "msg" -> "--...--."
     * <p>
     * There are 2 different transformations, "--...-." and "--...--.".
     * <p>
     * Note:
     * <p>
     * The length of words will be at most 100.
     * Each words[i] will have length in range [1, 12].
     * words[i] will only consist of lowercase letters.
     *
     * @since 2018-5-28
     */
    public static int uniqueMorseRepresentations(String[] words) {
        String[] str = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..", "--", "-.",
                "---", ".--.", "--.-", ".-.", "...", "-",
                "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> list = new HashSet<>();
        for (String i : words) {
            StringBuilder sb = new StringBuilder();
            char[] chars = i.toCharArray();
            for (char c : chars) {
                sb.append(str[c - 'a']);
            }
            list.add(sb.toString());
        }

        return list.size();
    }

    /**
     * Given a binary matrix A, we want to flip the image horizontally, then invert it,
     * and return the resulting image.
     * <p>
     * To flip an image horizontally means that each row of the image is reversed.  For example,
     * flipping [1, 1, 0] horizontally results in [0, 1, 1].
     * <p>
     * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example,
     * inverting [0, 1, 1] results in [1, 0, 0].
     * <p>
     * Example 1:
     * <p>
     * Input: [[1,1,0],[1,0,1],[0,0,0]]
     * Output: [[1,0,0],[0,1,0],[1,1,1]]
     * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
     * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
     * Example 2:
     * <p>
     * Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
     * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
     * Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
     * Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
     * <p>
     * Notes:
     * 1 <= A.length = A[0].length <= 20
     * 0 <= A[i][j] <= 1
     *
     * @since 2018-5-30
     */
    public static int[][] flipAndInvertImage(int[][] A) {
        if (A.length % 2 == 0) {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < (A[i].length / 2); j++) {
                    int temp = A[i][j];
                    A[i][j] = A[i][A[i].length - j - 1];
                    A[i][A[i].length - j - 1] = temp;
                    if (A[i][j] == 0) {
                        A[i][j] = 1;
                    } else if (A[i][j] == 1) {
                        A[i][j] = 0;
                    }
                    if (A[i][A[i].length - j - 1] == 0) {
                        A[i][A[i].length - j - 1] = 1;
                    } else if (A[i][A[i].length - j - 1] == 1) {
                        A[i][A[i].length - j - 1] = 0;
                    }

                }
            }
        } else {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < (A[i].length - 1) / 2; j++) {
                    int temp = A[i][j];
                    A[i][j] = A[i][A[i].length - j - 1];
                    A[i][A[i].length - j - 1] = temp;
                    if (A[i][j] == 0) {
                        A[i][j] = 1;
                    } else if (A[i][j] == 1) {
                        A[i][j] = 0;
                    }
                    if (A[i][A[i].length - j - 1] == 0) {
                        A[i][A[i].length - j - 1] = 1;
                    } else if (A[i][A[i].length - j - 1] == 1) {
                        A[i][A[i].length - j - 1] = 0;
                    }
                }
                if (A[i][(A[i].length - 1) / 2] == 0) {
                    A[i][(A[i].length - 1) / 2] = 1;
                } else {
                    A[i][(A[i].length - 1) / 2] = 0;
                }
            }
        }

        return A;
    }

    /**
     * 按位异或直接赋值并转换
     */
//    public int[][] flipAndInvertImage(int[][] A) {
//        int C = A[0].length;
//        for (int[] row: A)
//            for (int i = 0; i < (C + 1) / 2; ++i) {
//                int tmp = row[i] ^ 1;
//                row[i] = row[C - 1 - i] ^ 1;
//                row[C - 1 - i] = tmp;
//            }
//
//        return A;
//    }

    /**
     * The Hamming distance between two integers is the number of positions
     * at which the corresponding bits are different.
     * <p>
     * Given two integers x and y, calculate the Hamming distance.
     * <p>
     * Note:
     * 0 ≤ x, y < 231.
     * <p>
     * Example:
     * <p>
     * Input: x = 1, y = 4
     * <p>
     * Output: 2
     * <p>
     * Explanation:
     * 1   (0 0 0 1)
     * 4   (0 1 0 0)
     * ↑   ↑
     * <p>
     * The above arrows point to positions where the corresponding bits are different.
     */
    public static int hammingDistance(int x, int y) {
        if (x < y) {
            int temp = y;
            y = x;
            x = temp;
        }
        //大数
        char[] one = Integer.toBinaryString(x).toCharArray();

        char[] two = Integer.toBinaryString(y).toCharArray();
        int num = 0;
        int index = two.length-1;
        for (int i = 0; i < one.length; i++) {
            if (i < two.length) {
                if (one[one.length-i-1]!=two[index]){
                    num++;
                }
                index--;
            }else {
                if (one[one.length-i-1] == 49){
                    num++;
                }
            }
        }
        return num;
    }


    /*one-line java solution*/
    public int hammingDistanceSolution(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
