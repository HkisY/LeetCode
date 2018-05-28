import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        /*---------------------------------------------*/
        int[] nums = new int[4];
        nums[0] = 2;
        nums[1] = 7;
        nums[2] = 11;
        nums[3] = 15;

        int[] ints = twoSum(nums, 9);
        for (int i : ints) {
            System.out.println(ints[i]);
        }
        /*---------------------------------------------*/
        String[] words ={"gin", "zen", "gig", "msg"};
        int i = uniqueMorseRepresentations(words);
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
     * @since 2018-5-28
     */
    public static int uniqueMorseRepresentations(String[] words) {
        String[] str = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..", "--", "-.",
                "---", ".--.", "--.-", ".-.", "...", "-",
                "..-", "...-", ".--", "-..-", "-.--", "--.."};
        String[] word = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        Map<String,String> map = new HashMap<>();
        for (int i =0;i<str.length;i++){
            map.put(str[i],word[i]);
        }
        List<StringBuilder> list = new ArrayList<>();
        for (String i : words) {
            StringBuilder sb = new StringBuilder();
            char[] chars = i.toCharArray();
            for (char c : chars) {
                for (String s:str){
                    //比较两个char 是否相等
                    if (map.get(s).equals(c)){
                        sb.append(s);
                    }
                }
            }
            list.add(sb);
        }
        int number = 0;
        for (StringBuilder sb:list){
            list.contains(sb);
            number++;
        }
        return number-list.size();
    }
}
