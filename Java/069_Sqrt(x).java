public class Solution {
    public int mySqrt(int x) {
        double error = 0.0000001f;
        double high = x;
        double low = 0;
        
        while (high - low > error) {
            double mid = (high + low) / 2;
            
            if (mid * mid > x) {
                high = mid;
            } else {
                low = mid;
            }
        }
        
        return (int) Math.floor(high);
    }
}
