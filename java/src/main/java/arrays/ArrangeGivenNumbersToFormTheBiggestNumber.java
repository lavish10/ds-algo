//Arrange given numbers to form the biggest number
package arrays;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrangeGivenNumbersToFormTheBiggestNumber {

    static String largestNumber(List<Integer> lis) {
        //finding number of digits in maximum element present in array
        int n = Collections.max(lis).toString().length();

        ArrayList<ExtendedNum> en = new ArrayList<ExtendedNum>();

        for (Integer li : lis) {
            en.add(new ExtendedNum(li, n));
        }
        en.sort((p1, p2) -> (int) (p2.modifiedValue - p1.modifiedValue));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < en.size(); i++) {
            sb.append(Long.toString(en.get(i).originalValue));
        }

        BigInteger bi = new BigInteger(sb.toString());

        return bi.toString();
    }

    public static void main(String[] args) {
        Integer arr[] = {1, 34, 3, 98, 9, 76, 45, 4, 12, 121};
        List<Integer> lis = Arrays.asList(arr);
        System.out.println(largestNumber(lis));
    }
}

class ExtendedNum {
    int originalValue;
    long modifiedValue;

    ExtendedNum(int originalValue, int n) {
        this.originalValue = originalValue;
        String s = Integer.toString(originalValue);
        StringBuilder sb = new StringBuilder(s);
        StringBuilder ans = new StringBuilder();
        while (ans.length() <= n + 1) {
            ans.append(sb);
        }
        s = ans.toString().substring(0, n + 1);
        modifiedValue = Long.parseLong(s);
    }
}
