import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/**
 * Created by byraa on 4/3/2017.
 */
public class Solution {

    public static void main(String[] args)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Solution s = new Solution();

        try {
            int days = Integer.valueOf(reader.readLine());

            for (int i = 1; i <= days; i++)
            {
                int numberOfItems = Integer.valueOf(reader.readLine());

                int[] array = new int[numberOfItems];
                boolean[] taken = new boolean[numberOfItems];

                for (int j = 0; j <= array.length - 1; j++)
                {
                    array[j] = Integer.valueOf(reader.readLine());
                }

                s.mergeSort(array, 0, array.length - 1);

                boolean flag = false;
                int j = 0;
                int k = array.length - 1;
                int trips = 0;

                while (!flag)
                {
                    int count = 0;
                    int heaviest = array[k];
                    count += heaviest;
                    taken[k] = true;
                    k--;

                    while (count < 50)
                    {
                        count = count + heaviest;
                        taken[j] = true;
                        j++;
                }

                    trips++;

                    if (!s.isRemainingOver50(array, taken, k, j))
                        flag = true;
                }

                System.out.println("Case #" + i + ": " + trips);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public boolean isRemainingOver50(int[] array, boolean[] taken, int indexOfHeaviest, int indexOfFirstTrue)
    {
        if(indexOfHeaviest < 0)
            return false;

        int heaviest = array[indexOfHeaviest];

        if (heaviest >= 50)
            return true;

        int count = heaviest;

        for (int i = indexOfFirstTrue; i < indexOfHeaviest && count < 50; i++)
        {
            if (taken[i] == false)
                count = count + heaviest;
        }

        return count >= 50;
    }

    public void mergeSort(int[] array, int low, int high)
    {
        if (low < high)
        {
            int middle = (low + high) / 2;

            mergeSort(array, low, middle);
            mergeSort(array, middle + 1, high);
            int[] s = array;

            merge(s, low, middle, high);
        }
    }

    public int[] merge(int[] array, int low, int middle, int high)
    {
        ArrayDeque<Integer> buffer1 = new ArrayDeque<>();
        ArrayDeque<Integer> buffer2 = new ArrayDeque<>();

        int[] s = array;

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
