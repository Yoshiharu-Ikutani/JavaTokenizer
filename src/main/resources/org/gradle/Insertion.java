package sorting;

public class Insertion
{
    public static Integer[] sort(Integer[] a)
    {
        int n = a.length;
        for (int i = 0; i < n; i++)
        {
            for (int j = i; j > 0 && (a[j] < a[j - 1]); j--)
            {
                int swap = a[j];
                a[j] = a[j - 1];
                a[j - 1] = swap;
            }
        }
        return a;
    }

}
