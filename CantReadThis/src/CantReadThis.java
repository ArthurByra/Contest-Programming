import java.util.Scanner;

/**
 * Created by byraa on 3/22/2017.
 */
public class CantReadThis
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();

        String line;

        int half;

        while(sc.hasNextLine()) {
            line = sc.nextLine();
            sb.append(line);
        }

        int evenCount = 0;
        int oddCount = 0;

        line = sb.toString();

        half = line.length() / 2 + 1;

        char[] firstHalf = new char[half];
        char[] secondHalf = new char[half - 1];

        for (int i = 0; i < line.length(); i++)
        {

            if (i < half)
            {
                firstHalf[evenCount] = line.charAt(i);
                evenCount++;
            }
            else
            {
                secondHalf[oddCount] = line.charAt(i);
                oddCount++;
            }
        }

        oddCount = 0;
        evenCount = 0;

        for (int i = 0; i < line.length(); i++)
        {
            if (i % 2 == 0) //if even
            {
                if(firstHalf[oddCount] == '*')
                    System.out.println();
                else
                {
                    System.out.print(firstHalf[oddCount]);
                }
                oddCount++;
            }
            else
            {
                if(secondHalf[evenCount] == '*')
                    System.out.println();
                else
                {
                    System.out.print(secondHalf[evenCount]);
                }
                evenCount++;
            }
        }
    }
}
