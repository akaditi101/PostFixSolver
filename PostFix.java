//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.Stack;
import java.util.Scanner;

public class PostFix
{
    private static final String DIGITS = "0123456789";
    private static final String OPERATORS = "+-*/^";
    private Stack<Double> stack;
    private String expression;
    private double result;

    public PostFix(String exp)
    {
        stack = new Stack<Double>();
        expression = exp;
        result = 0;
    }

    private boolean isOperator(String str)
    {
        return !DIGITS.contains(str);
    }
    
     private boolean isDigit(String str)
    {
        return DIGITS.contains(str);
    }
    
    public void solve()
    {
        Scanner chopper = new Scanner(expression);
        while(chopper.hasNext())
        {
            String str = chopper.next();
            
            if (DIGITS.contains(str))
            {
                double val = Double.parseDouble(str);
                stack.push(val);
            }
            else if (OPERATORS.contains(str))
            {
                double rhs, lhs;
                rhs = stack.pop();
                lhs = stack.pop();
                if (str.equals("+"))
                {
                    stack.push(lhs + rhs);
                }
                else if (str.equals("-"))
                {
                    stack.push(lhs - rhs);
                }
                else if (str.equals("*"))
                {
                    stack.push(lhs * rhs);
                }
                else if (str.equals("/"))
                {
                    stack.push(lhs / rhs);
                }
                else if (str.equals("^"))
                {
                    stack.push(Math.pow(lhs, rhs));
                }
            }
            result = stack.peek();
        }
    }

    public String toString()
    {
        return expression +  " = " + result ;
    }
}