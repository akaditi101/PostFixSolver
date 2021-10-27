import java.util.Scanner;
/**
 * Write a description of class StringScannerStuff here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StringScannerStuff
{
    private static final String DIGITS = "0123456789";
    public static void main(String[] args)
    {
        Scanner chopper = new Scanner("1 2 3 + 4 * /");
        
        while (chopper.hasNext())
        {
            String s = chopper.next();
            if (DIGITS.contains(s))
            {
                double val = Double.parseDouble(s);
            }
            else
            {
                System.out.println(s + " is an operator");
            }
        }
    }
}
