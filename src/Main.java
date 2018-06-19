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
//        int i = hammingDistance(1, 4);
//        System.out.println(i);
        /*---------------------------------------------*/
//        String s = "UDUDUDUDUDUDLLLLLLRRRRRR";
//        boolean b = judgeCircle(s);
//        System.out.println(b);
//        String move = "LL";
//        boolean flag = judgeCircle(move);
//        System.out.println(flag);
        /*---------------------------------------------*/
//        TreeNode a = new TreeNode(5);
//        TreeNode b = new TreeNode(3, a, null);
//        TreeNode f = new TreeNode(2);
//        //主节点
//        TreeNode c = new TreeNode(1, b, f);
//
//        TreeNode l = new TreeNode(4);
//        TreeNode m = new TreeNode(1, null, l);
//        TreeNode n = new TreeNode(7);
//        TreeNode o = new TreeNode(3, null, n);
//        //主节点
//        TreeNode p = new TreeNode(2, m, o);
//        TreeNode resultTree = mergeTrees(c, p);
//        System.out.println(resultTree);
        /*---------------------------------------------*/
//        List<Integer> number = getNumber(10);
//        System.out.println(number);
//        List<Integer> list = selfDividingNumbers(1, 22);
//        System.out.println(list);
        /*---------------------------------------------*/
//        int[] num = {1,3,4,2,8};
//        quickSort(num);
//        int resualt = arrayPairSum(num);
        /*---------------------------------------------*/
//        int[] widths = {4,7,6,4,10,5,3,10,10,7,4,4,6,7,10,10,8,7,2,6,3,3,4,7,2,4};
//        String S = "kjvswlxlss";
//        int[] ints = numberOfLines(widths, S);
//        System.out.println(Arrays.toString(ints));
        /*---------------------------------------------*/
//        String[] s = {"900 jiuxian.guangdong.com","12 hxin.com"};
//        List<String> list = subdomainVisits(s);
//        for (String s1:list){
//            System.out.println(s1);
//        }
        /*---------------------------------------------*/
        String S = "baaa";
        char C = 'b';
        int[] ints = shortestToChar(S, C);
        System.out.println(Arrays.toString(ints));

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
    public int[][] flipAndInvertImageSolution(int[][] A) {
        int C = A[0].length;
        for (int[] row : A)
            for (int i = 0; i < (C + 1) / 2; ++i) {
                int tmp = row[i] ^ 1;
                row[i] = row[C - 1 - i] ^ 1;
                row[C - 1 - i] = tmp;
            }

        return A;
    }

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
     *
     * @since 2018-05-31
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
        int index = two.length - 1;
        for (int i = 0; i < one.length; i++) {
            if (i < two.length) {
                if (one[one.length - i - 1] != two[index]) {
                    num++;
                }
                index--;
            } else {
                if (one[one.length - i - 1] == 49) {
                    num++;
                }
            }
        }
        return num;
    }


    /**
     * one-line java solution
     * \
     */
    public int hammingDistanceSolution(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    /**
     * Initially, there is a Robot at position (0, 0). Given a sequence of its moves,
     * judge if this robot makes a circle, which means it moves back to the original place.
     * <p>
     * The move sequence is represented by a string. And each move is represent by a character.
     * The valid robot moves are R (Right), L (Left), U (Up) and D (down).
     * The output should be true or false representing whether the robot makes a circle.
     * <p>
     * Example 1:
     * Input: "UD"
     * Output: true
     * Example 2:
     * Input: "LL"
     * Output: false
     *
     * @since 2018-05-31
     */
    public static boolean judgeCircle(String moves) {
        char[] chars = moves.toCharArray();
        int up = 0;
        int down = 0;
        int left = 0;
        int right = 0;
        for (char c : chars) {
            switch (c) {
                case 'U':
                    up++;
                    break;
                case 'D':
                    down++;
                    break;
                case 'L':
                    left++;
                    break;
                case 'R':
                    right++;
                    break;
            }
        }
        if (up == down && left == right) {
            return true;
        }
        return false;
    }

    /**
     * Given two binary trees and imagine that when you put one of them to cover the other,
     * some nodes of the two trees are overlapped while the others are not.
     * <p>
     * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
     * then sum node values up as the new value of the merged node. Otherwise,
     * the NOT null node will be used as the node of new tree.
     * <p>
     * Example 1:
     * Input:
     * Tree 1                     Tree 2
     *     1                         2
     *    / \                       / \
     *   3   2                     1   3
     *  /                           \   \
     * 5                             4   7
     * Output:
     * Merged tree:
     *     3
     *    / \
     *   4   5
     *  / \   \
     * 5   4   7
     * Note: The merging process must start from the root nodes of both trees.
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right)
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    /**
     * A self-dividing number is a number that is divisible by every digit it contains.

     For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
     Also, a self-dividing number is not allowed to contain the digit zero.

     Given a lower and upper number bound, output a list of every possible self dividing number,
     including the bounds if possible.

     Example 1:
     Input:
     left = 1, right = 22
     Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
     Note:

     The boundaries of each input argument are 1 <= left <= right <= 10000.
     */
    public static List<Integer> selfDividingNumbers(int left, int right) {
        if (left > right) {
            int temp = left;
            left = right;
            right = temp;
        }
        //存放符合结果的数字集
        List<Integer> result = new ArrayList<>();
        for (; left <= right; left++) {
            List<Integer> list = getNumber(left);
            if (list.contains(0)) {
                continue;
            }
            boolean flag = true;
            for (Integer integer : list) {
                if (left % integer != 0) {
                    flag = false;
                }
            }
            if (flag) {
                result.add(left);
            }

        }
        //存放将数字按十位 百位 切分后的数字集
        return result;
    }

    private static List<Integer> getNumber(int source) {
        List<Integer> list = new ArrayList<>();
        for (int num = 10; source % num <= source; num = num * 10) {
            int front = source % num;
            int middlenum = num / 10;
            int target = (front - front % middlenum) / middlenum;
            list.add(target);

            if (front == source) {
                break;
            }
        }
        return list;
    }

    /**
     * better solution
     * @param left
     * @param right
     * @return
     */
    public List<Integer> selfDividingNumber(int left, int right) {
        List<Integer> ans = new ArrayList();
        for (int n = left; n <= right; ++n) {
            if (selfDividing(n)) ans.add(n);
        }
        return ans;
    }

    public boolean selfDividing(int n) {
        for (char c : String.valueOf(n).toCharArray()) {
            if (c == '0' || (n % (c - '0') > 0))
                return false;
        }
        return true;
    }

    //Alternate implementation of selfDividing:

    //another method
    public boolean selfDividin(int n) {
        int x = n;
        while (x > 0) {
            int d = x % 10;
            x /= 10;
            if (d == 0 || (n % d) > 0) return false;
        }
        return true;
    }

    /**
     * Given an array of 2n integers, your task is to group these integers into n pairs of integer,
     * say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

     Example 1:
     Input: [1,4,3,2]

     Output: 4
     Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
     Note:
     n is a positive integer, which is in the range of [1, 10000].
     All the integers in the array will be in the range of [-10000, 10000].
     */
    public static int arrayPairSum(int[] nums) {
        //数组无序 故需要排序
        //自写快排
        //API中的排序算法        Arrays.sort(nums);
        quickSort(nums);
        int resualt = 0;
        for (int i =0;i<nums.length;i++){
            if (i%2!=0){
                resualt+=nums[i-1];
            }
        }
        return resualt;
    }

    /**
     * 快排
     */
    public static void quickSort(int[] array){
        _quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array) + " quickSort");
    }
    private static int getMiddle(int[] list, int low, int high) {
        int tmp = list[low];    //数组的第一个作为中轴
        while (low < high) {
            while (low < high && list[high] >= tmp) {
                high--;
            }
            list[low] = list[high];   //比中轴小的记录移到低端
            while (low < high && list[low] <= tmp) {
                low++;
            }
            list[high] = list[low];   //比中轴大的记录移到高端
        }
        list[low] = tmp;              //中轴记录到尾
        return low;                  //返回中轴的位置
    }
    private static void _quickSort(int[] list,int low, int high){
        if(low<high){
            int middle = getMiddle(list,low,high);
            _quickSort(list,low,middle - 1);
            _quickSort(list,middle + 1,high);
        }
    }

    /**
     * We are to write the letters of a given string S, from left to right into lines.
     * Each line has maximum width 100 units, and if writing a letter would cause the
     * width of the line to exceed 100 units, it is written on the next line.
     * We are given an array widths, an array where widths[0] is the width of 'a',
     * widths[1] is the width of 'b', ..., and widths[25] is the width of 'z'.

     Now answer two questions: how many lines have at least one character from S,
     and what is the width used by the last such line? Return your answer as an integer list of length 2.



     Example :
     Input:
     widths = [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
     S = "abcdefghijklmnopqrstuvwxyz"
     Output: [3, 60]
     Explanation:
     All letters have the same length of 10. To write all 26 letters,
     we need two full lines and one line with 60 units.
     Example :
     Input:
     widths = [4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
     S = "bbbcccdddaaa"
     Output: [2, 4]
     Explanation:
     All letters except 'a' have the same length of 10, and
     "bbbcccdddaa" will cover 9 * 10 + 2 * 4 = 98 units.
     For the last 'a', it is written on the second line because
     there is only 2 units left in the first line.
     So the answer is 2 lines, plus 4 units in the second line.


     Note:

     The length of S will be in the range [1, 1000].
     S will only contain lowercase letters.
     widths is an array of length 26.
     widths[i] will be in the range of [2, 10].
     *
     *
     *
     * 草稿代码
     */
    public static int[] numberOfLines(int[] widths, String S) {
        char[] chars = S.toCharArray();
        //行数初始化即为第一行
        int line = 1, units = 0;
        for (int i = 0; i < chars.length; i++) {
            //不需要进行强转
            int index = chars[i] - 97;
            units = units + widths[index];
            while (units > 100) {
                int minusUnits = units - widths[index];
                //考虑到字符所占units不可能比100大这种不合理情况 故此处循环只要进来就只执行一次
                if (minusUnits <= 100) {
                    line++;
                    units = units - minusUnits;
                    System.out.println(line + ":" + units);
                    //此循环只执行一次
                    break;

                }
            }
        }
        return new int[]{line, units};
    }

    /**
     * 上面方法优化
     * @param widths
     * @param S
     * @return
     */
    public int[] solutionNumberOfLines(int[] widths, String S) {
        int lines = 1, width = 0;
        for (char c: S.toCharArray()) {
            int w = widths[c - 'a'];
            width += w;
            if (width > 100) {
                lines++;
                width = w;
            }
        }

        return new int[]{lines, width};
    }

    /**
     * 此种方法 只试用于S中相同字符相连的情况
     * @param widths
     * @param S
     * @return
     */
    public int[] wrongNumberOfLines(int[] widths, String S) {
        char[] chars = S.toCharArray();
        //统计相同字符出现的次数
        //将字符加入set集合 可判断是否重复
        Map<Character, Integer> middle = new HashMap<>();
        Set<Character> key = new HashSet<>();
        for (char word : chars) {
            if (!key.contains(word)) {
                key.add(word);
                middle.put(word, 1);
            } else {
                int i = middle.get(word);
                middle.put(word, ++i);
            }
        }
        //行数初始化即为第一行
        int line = 1, units = 0;
        for (int i = 0; i < chars.length; i++) {
            //此字符为 chars【i】 数量为 middle.get(chars[i])
            Integer integer = middle.get(chars[i]);
            i += integer - 1;
            //不需要进行强转
            int index = chars[i] - 97;
            units = units + widths[index] * integer;
            while (units > 100) {
                for (int j = 1; j <= integer; j++) {
                    int minusUnits = units - widths[index] * j;
                    //考虑到字符所占units不可能比100大这种不合理情况 故此处循环只要进来就只执行一次
                    if (minusUnits <= 100) {
                        int changeLine = ((integer - j) * widths[index]) / 100;
                        if (changeLine == 0) {
                            line++;
                            units = units - minusUnits;
                            //此循环只执行一次
                            break;
                        } else {
                            line += changeLine;
                            units = units - minusUnits;
                            break;
                        }
                    }
                }
            }

        }
        return new int[]{line, units};
    }

    /**
     * A website domain like "discuss.leetcode.com" consists of various subdomains.
     * At the top level, we have "com", at the next level, we have "leetcode.com",
     * and at the lowest level, "discuss.leetcode.com". When we visit a domain like "discuss.leetcode.com",
     * we will also visit the parent domains "leetcode.com" and "com" implicitly.

     Now, call a "count-paired domain" to be a count (representing the number of visits this domain received),
     followed by a space, followed by the address.
     An example of a count-paired domain might be "9001 discuss.leetcode.com".

     We are given a list cpdomains of count-paired domains.
     We would like a list of count-paired domains,
     (in the same format as the input, and in any order),
     that explicitly counts the number of visits to each subdomain.

     Example 1:
     Input:
     ["9001 discuss.leetcode.com"]
     Output:
     ["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
     Explanation:
     We only have one website domain: "discuss.leetcode.com".
     As discussed above, the subdomain "leetcode.com" and "com" will also be visited.
     So they will all be visited 9001 times.

     Example 2:
     Input:
     ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
     Output:
     ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
     Explanation:
     We will visit "google.mail.com" 900 times, "yahoo.com" 50 times,
     "intel.mail.com" once and "wiki.org" 5 times. For the subdomains,
     we will visit "mail.com" 900 + 1 = 901 times, "com" 900 + 50 + 1 = 951 times, and "org" 5 times.

     Notes:

     The length of cpdomains will not exceed 100.
     The length of each domain name will not exceed 100.
     Each address will have either 1 or 2 "." characters.
     The input count in any count-paired domain will not exceed 10000.
     The answer output can be returned in any order.
     */
    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> middle = new HashMap();
        for (String domain : cpdomains) {
            String[] cpinfo = domain.split("\\s+");
            String[] word = cpinfo[1].split("\\.");
            int count = Integer.valueOf(cpinfo[0]);
            String str = "";
            for (int i = word.length - 1; i >= 0; --i) {
                str = word[i] + (i < word.length - 1 ? "." : "") + str;
                //jdk 1.8 中新增方法  不需要像以前一样 增加set 判断是否存在
                middle.put(str, middle.getOrDefault(str, 0) + count);
            }
        }

        List<String> list = new ArrayList();
        for (String s : middle.keySet())
            list.add(middle.get(s) + " " + s);
        return list;
    }

    /**
     * Given a string S and a character C,
     * return an array of integers representing the shortest distance from the character C in the string.

     Example 1:

     Input: S = "loveleetcode", C = 'e'
     Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]


     Note:

     S string length is in [1, 10000].
     C is a single character, and guaranteed to be in string S.
     All letters in S and C are lowercase.
     * @since 2018-06-19
     */
    public static int[] shortestToChar(String S, char C) {
        char[] chars = S.toCharArray();
        int[] array = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == C) {
                array[i] = 0;
                continue;
            }
            Integer left = 1000000;
            Integer right = 1000000;
            //向右判断距离
            for (int j = i; j < chars.length; j++) {
                if (chars[j] == C) {
                    right = j - i;
                    break;
                }
            }
            //向左判断
            for (int k = i; k >= 0; k--) {
                if (chars[k] == C) {
                    left = i - k;
                    break;
                }
            }
            if (right > left) {
                array[i] = left;
            } else {
                array[i] = right;
            }
        }
        return array;
    }
    /**
     * solution
     */
    public int[] shortestToCharSolution(String S, char C) {
        int N = S.length();
        int[] ans = new int[N];
        int prev = Integer.MIN_VALUE / 2;

        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = i - prev;
        }

        prev = Integer.MAX_VALUE / 2;
        for (int i = N-1; i >= 0; --i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = Math.min(ans[i], prev - i);
        }

        return ans;
    }
}
