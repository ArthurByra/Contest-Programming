import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Created by byraa on 3/27/2017.
 */
public class BigEats {

    public static void main(String[] args)
    {
        BigEats b = new BigEats();

        Scanner sc = new Scanner(System.in);

        int first = sc.nextInt();
        int second = sc.nextInt();
        long money = sc.nextInt();

        long[] firstCategory = new long[first];
        long[] secondCategory = new long[second];

        for (int i = 0; i < first; i++)
        {
            firstCategory[i] = sc.nextInt();
        }

        for (int i = 0; i < second; i++)
        {
            secondCategory[i] = sc.nextInt();
        }

        b.mergeSort(firstCategory, 0, firstCategory.length - 1);
        b.mergeSort(secondCategory, 0, secondCategory.length - 1);

        long best = Integer.MAX_VALUE;
        long currentTotal;

        long retVal = 0;

        int i = 0;
        int j = secondCategory.length - 1;

        while(i < firstCategory.length && j >= 0)
        {
            currentTotal = firstCategory[i] + secondCategory[j];

            if (Math.abs(money - currentTotal) <= best)
            {
                retVal = currentTotal;
                best = Math.abs(money - currentTotal);
            }

            if(currentTotal == money)
            {
                System.out.println(currentTotal);
                System.exit(0);
            }
            else if (currentTotal > money)
            {
                j--;
            }
            else if (currentTotal < money)
            {
                i++;
            }
        }

        System.out.println(retVal);
    }

    public void mergeSort(long[] array, int low, int high)
    {
        if (low < high)
        {
            int middle = (low + high) / 2;

            mergeSort(array, low, middle);
            mergeSort(array, middle + 1, high);
            long[] s = array;

            merge(s, low, middle, high);
        }
    }

    public long[] merge(long[] array, int low, int middle, int high)
    {
        ArrayDeque<Long> buffer1 = new ArrayDeque<>();
        ArrayDeque<Long> buffer2 = new ArrayDeque<>();

        long[] s = array;

        for (int i = low; i <= middle; i++)
        {
            buffer1.add(array[i]);
        }

        for (int i = middle + 1; i <= high; i++)
        {
            buffer2.add(array[i]);
        }

        int i = low;

        while(!buffer1.isEmpty() || !buffer2.isEmpty())
        {
            if(buffer1.isEmpty())
                s[i++] = buffer2.remove();
            else if (buffer2.isEmpty())
                s[i++] = buffer1.remove();
            else if (buffer1.peek() <= buffer2.peek())
                s[i++] = buffer1.remove();
            else
                s[i++] = buffer2.remove();
        }

        return s;
    }
}
