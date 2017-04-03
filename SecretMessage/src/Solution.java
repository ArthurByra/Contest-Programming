import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by byraa on 3/27/2017.
 */
public class Solution {

    public static void main(String[] args)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String message;
        int lengthOfMessage;
        int num;

        try
        {
            num = Integer.valueOf(reader.readLine());

            for (int i = 0; i < num; i++)
            {
                int square = 0;
                int rowCol = 0;

                message = reader.readLine();
                lengthOfMessage = message.length();

                for (int j = 0; square < lengthOfMessage; j++)
                {
                    square = j * j; //finding smallest square number greater than or equal to length of message
                    rowCol = j;
                }

                int padding = square - lengthOfMessage; //number of asterisks to add
                String ast = "";

                for (int j = 0; j < padding; j++) //adds proper padding
                {
                    ast = ast + "*";
                }

                message = message + ast; //adds padding to message

                char[][] array = new char[rowCol][rowCol]; //create the array
                int count = 0; //counter for charAt

                for(int j = 0; j < rowCol; j++)
                {
                    for (int k = 0; k < rowCol; k++)
                    {
                        array[j][k] = message.charAt(count); //add message to array
                        count++;
                    }
                }

                for(int j = 0; j < rowCol; j++) //reading from 90 degrees
                {
                    for (int k = rowCol - 1; k >= 0; k--)
                    {
                        if(array[k][j] != '*')
                            System.out.print(array[k][j]);
                    }
                }

                System.out.println();

            } //end first for loop
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

}
