import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by byraa on 3/20/2017.
 */
public class ZoomIn
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        HashMap<Character, String[]> map = new HashMap<>();

        String input;
        String toBeAscii;
        int col = sc.nextInt();
        int row = sc.nextInt();
        int count = sc.nextInt();

        input = sc.nextLine(); //to eat the newLine

        for(int i = 0; i < count; i++)
        {
            input = sc.nextLine();

            String[] lines = new String[row];

            for (int j = 0; j < row; j++) {
                lines[j] = sc.nextLine();

            }
            map.put(input.charAt(0), lines);
        }

        count = sc.nextInt();
        input = sc.nextLine(); //to eat the newLine

        for(int i = 0; i < count; i++) //for however many times the program asks you to do it
        {
            toBeAscii = sc.nextLine();

            for (int k = 0; k < row; k++) {
                for (int j = 0; j < toBeAscii.length(); j++) //for each character in the string to be made into ascii
                {
                    System.out.print(map.get(toBeAscii.charAt(j))[k]);
                }
                System.out.println();
            }
        }
    }
}
