package is.ru.stringcalculator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;

public class Calculator {
static ArrayList<String> negativeVal = new ArrayList<String>();
	public static int add(String text)
	{
		Pattern pattern = Pattern.compile("^-?[0-9]{1}$");
		Matcher matcher = pattern.matcher(text);
		
		if(text.isEmpty())
		{
			return 0;
		}
		else if(text.contains(","))
		{
			if(text.contains("\n"))
			{
				text = validateNewlineInput(text);
			}
			return multipleNumbers(text);
		}
		else 
		{
			if(matcher.find())
			{
				return oneNumber(text);
			}
			
			if(text.startsWith("//"))
			{
				text = validateDelimiterInput(text);
				return multipleNumbers(text);
			}
				
			return 42;	
		}
			
	}		
			
	// Input validation helper 
	private static boolean isEmpty(String text)
	{
		if(text.equals(""))
		{
			return true;
		}
		return false;
	}
	
	private static String validateDelimiterInput(String text)
	{
		
			String[] tokens = text.split("\n");
				String newString = "";
				for(String s : tokens)
				{
					newString+=s;
				}
				newString = newString.replaceAll("[\\D]",",");
				String theNew = "";
				theNew = newString.substring(3, newString.length()); 

				return theNew;
				
	}
	
	private static String validateNewlineInput(String text)
	{
		text = text.replaceAll("\\n",",");
		return text;
	}
	
	private static String print()
	{
		String finalString ="";
		
		for(String numbers : negativeVal)
		{
			finalString+=numbers;
		}
		return finalString;
	}
	
	//Calculations helper function
	private static void calculateInput(String text)
	{
		if(text.equals("1"))
		{
			oneNumber(text);
		}
		
		if(text.contains(","))
		{
			multipleNumbers(text);
		}
	}
	
	private static int oneNumber(String text)
	{
		if(toInt(text) >= 0)
		{
			return toInt(text);
		}
		throw new java.lang.IllegalArgumentException("Negatives not allowed: "+toInt(text));
	}
	
	private static int multipleNumbers(String text)
	{
		String numbers[] = text.split(",");
		return sum(numbers);
	}
	
	private static int sum(String[] numbers)
	{
		int total = 0;
		
		for(String number : numbers)
		{
			total += toInt(number);
		}
		
		if(negativeVal.size() == 0)
		{
			return total;
		}
		
		else 
		{
			throw new java.lang.IllegalArgumentException("Negatives not allowed: " +print());
		}
	}
	
	private static int toInt(String number)
	{
		if(Integer.parseInt(number) > 1000)
		{
			return 0;
		}
		
		if(Integer.parseInt(number) < 0)
		{
			
			if(negativeVal.size() == 0)
			{
				negativeVal.add(number);
			}
			
			negativeVal.add(","+number);
		}
		return Integer.parseInt(number);
	}
	
	
	public static void main(String[] args)
	{
		return;
	}
}


// javac /... /*.java buildar alla klassa í möppu