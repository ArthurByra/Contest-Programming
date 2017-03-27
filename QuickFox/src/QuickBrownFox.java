import java.util.Scanner;

/**
 * Created by byraa on 3/22/2017.
 */
public class QuickBrownFox 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        
        String[] array = new String[] {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        
        int count = sc.nextInt();
        String line = sc.nextLine(); //eats newLine
        
        for (int i = 0; i < count; i++)
        {
            line = sc.nextLine().toLowerCase();
            
            for(int j = 0; j < array.length; j++)
            {
                if (!line.contains(array[j]))
                {
                    sb.append(array[j]);
                }
            }

            if (sb.length() == 0)
                System.out.println("pangram");
            else
            {
                System.out.println("missing " + sb.toString());
            }

            sb.delete(0, sb.length() + 1);
        }
    }
}
