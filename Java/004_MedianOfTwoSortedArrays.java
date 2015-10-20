public class Solution {
    private double findKthSortedArrays(int A[], int astart, int aend,
                                       int B[], int bstart, int bend, int k) {
        int m = aend - astart, n = bend - bstart;
        if (m < n) {//保证长的只是在A
            return findKthSortedArrays(B, bstart, bend, A, astart, aend, k);
        }
        if (n == 0)
            return A[astart + k - 1];
        if (k == 1)
            return Math.min(A[astart], B[bstart]);
        //对于B而言，先比较k／2和b的长度，由于a的长度可能过长，造成b并没有那么多数据，所以比较k/2（a,b均淘汰k/2）和b
        //对A而言，用k减去pb即可
        int pb = Math.min(k / 2, n), pa = k - pb;
        if (A[astart + pa - 1] > B[bstart + pb - 1])
            //淘汰pb长度的数据
            return findKthSortedArrays(A, astart, aend, B, bstart + pb, bend, k - pb);
        else if (A[astart + pa - 1] < B[bstart + pb - 1])
            return findKthSortedArrays(A, astart + pa, aend, B, bstart, bend, k - pa);
        else
            return A[astart + pa - 1];
    }

    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length, n = B.length;
        if ((n + m) % 2 == 1)
            return findKthSortedArrays(A, 0, m, B, 0, n, (n + m) / 2 + 1);
        else
            return (findKthSortedArrays(A, 0, m, B, 0, n, (n + m) / 2 + 1) +
                    findKthSortedArrays(A, 0, m, B, 0, n, (n + m) / 2)) / 2.0;
    }
}

