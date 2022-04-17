/**
 * Given a String of numbers N
 * Constraint is to change one digit from N at a time
 * Expected number of possible combinations divisible by 3
 * Example, 022 can have 9 such possible combinations, 
 * [012, 021, 222, 042, 024, 522, 072, 027, 822]
 */
import java.util.*;
import java.lang.*;

class DivisibleBy3Game {
    public static void main(String[] args) {
      int count = solution("022");
      //Tested for 23(7 results), 0081(11 results), 022(9 results)
      System.out.println("Count:: " + count);
    }

    public static int solution(String S) {
        int sum = 0;
        Set<Integer> resultSet = new HashSet<Integer>();
        char[] chars = S.toCharArray();
        for(char ch : chars) {
            sum+= Integer.parseInt(String.valueOf(ch));
        }
        Set<Integer> set = new HashSet<Integer>();
        set.add(3-sum);
        set.add(6-sum);
        set.add(9-sum);
        set.add(Math.abs(3-sum));
        set.add(Math.abs(6-sum));
        set.add(Math.abs(9-sum));
        set.add(Math.abs(sum - 3) + Math.abs(sum - 6) + Math.abs(sum - 9));
        for (int i = 0; i < chars.length; i++) {
            int val = Integer.parseInt(String.valueOf(chars[i]));
            char[] newChars = chars.clone();
            for (int delta: set) {
                int newVal = val + delta;
                if (newVal < 0 || newVal > 9) {
                  continue;
                }
                newChars[i] = (char)(newVal + '0');
                int x = Integer.parseInt(newStr);
                if (x % 3 == 0) {
                    resultSet.add(x);
                }
            }
        }
        return resultSet.size();
    }
}
