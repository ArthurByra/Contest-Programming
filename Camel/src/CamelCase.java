import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CamelCase {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();

        String retVal;
        String input;


        while(sc.hasNextLine())
        {
            input = sc.nextLine();

            String[] line;

            line = input.split(" ");

            for (int i = 0; i < line.length; i++)
            {
                boolean timeForUpper = false;

                if(line[i].equals("_"))
                {
                    sb.append(line[i]);
                    sb.append(" ");
                }
                else if(line[i].contains("_") && !line[i].equals("_"))
                {
                    String tempLine[];
                    tempLine = line[i].toLowerCase().split("_");

                    for(int j = 0; j < tempLine.length; j++)
                    {
                        if (!tempLine[j].equals("") && timeForUpper == false)
                        {
                            sb.append(tempLine[j]);
                            timeForUpper = true;
                        }
                        else if(!tempLine[j].equals("") && timeForUpper == true)
                        {
                            tempLine[j] = tempLine[j].substring(0, 1).toUpperCase() + tempLine[j].substring(1);
                            sb.append(tempLine[j]);
                        }
                    }
                    sb.append(" ");
                }
                else
                {
                    sb.append(line[i]);
                    sb.append(" ");
                }
            }
            retVal = sb.toString();
            if (retVal.charAt(retVal.length() - 1) == ' ')
            {
                retVal = retVal.substring(0, retVal.length());
            }
            System.out.println(retVal);
            sb.delete(0, sb.length() + 1);
        }
    }
}