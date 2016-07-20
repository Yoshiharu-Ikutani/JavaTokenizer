package sorting;

public class BinaryInsertion
{
    public static Integer[] sort(Integer[] a)
    {
        int n = a.length;
        for (int i = 1; i < n; i++)
        {
            Integer v = a[i];
            int lo = 0, hi = i;
            while (lo < hi)
            {
                int mid = lo + (hi - lo) / 2;
                if (v < a[mid])
                    hi = mid;
                else lo = mid + 1;
            }
            for (int j = i; j > lo; --j)
                a[j] = a[j - 1];
            a[lo] = v;
        }
        return (a);
    }
}
