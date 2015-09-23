/*************************************************************************
    > File Name: 043_MultiplyStrings.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/multiply-strings/
    > Created Time: 三  9/23 10:59:10 2015
 ************************************************************************/
/*
直接乘会溢出，所以每次都要两个single digit相乘，最大81，不会溢出。
比如385 * 97, 就是个位=5 * 7，十位=8 * 7 + 5 * 9 ，百位=3 * 7 + 8 * 9 …
可以每一位用一个Int表示，存在一个int[]里面。
这个数组最大长度是num1.len + num2.len，比如99 * 99，最大不会超过10000，所以4位就够了。
这种个位在后面的，不好做（10的0次方，可惜对应位的数组index不是0而是n-1），
所以干脆先把string reverse了代码就清晰好多。
最后结果前面的0要清掉。
*/
public class Solution {
    public String multiply(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        
        StringBuilder sb = new StringBuilder();
        
        int[] array = new int[num1.length() + num2.length()];
        
        for (int i = 0; i < num1.length(); i ++) {
            int a = num1.charAt(i) - '0';
            for (int j = 0; j < num2.length(); j ++) {
                int b = num2.charAt(j) - '0';
                array[i + j] += a * b;
            }
        }
        
        for (int i = 0; i < array.length; i ++) {
            int digit = array[i] % 10;
            int carry = array[i] / 10;
            //digit是当前位的值， carry是进位
            //每次将当前位的值插入到sb的最后
            sb.insert(0, digit);
            //前一位纪录进位
            if (i < array.length - 1) {
                array[i + 1] += carry;
            }
           
        }
        
         //trim starting zeros
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
        
    }
}
