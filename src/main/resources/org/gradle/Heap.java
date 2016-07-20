package sorting;

public class Heap
{
    public static Integer[] sort(Integer[] pq)
    {
        int N = pq.length;
        for (int k = N / 2; k >= 1; k--)
            sink(pq, k, N);
        while (N > 1)
        {
            exch(pq, 1, N--);
            sink(pq, 1, N);
        }
        return (pq);
    }

    private static void sink(Integer[] pq, int k, int N)
    {
        while (2 * k <= N)
        {
            int j = 2 * k;
            if (j < N && (pq[j - 1] < pq[j]))
                j++;
            if (!(pq[k - 1] < pq[j - 1]))
                break;
            exch(pq, k, j);
            k = j;
        }
    }

    private static void exch(Object[] pq, int i, int j)
    {
        Object swap = pq[i - 1];
        pq[i - 1] = pq[j - 1];
        pq[j - 1] = swap;
    }

}
