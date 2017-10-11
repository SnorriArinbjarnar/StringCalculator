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
		Pattern pattern = Pattern.compile("[0-9]");
		Matcher matcher = pattern.matcher(text);
		
		if(text.isEmpty())
		{
			return 0;
		}
		else 
		{
			if(matcher.find())
			{
				return oneNumber(text);
			}
			//validateInput(text);
			
			if(text.contains(","))
			{
				return multipleNumbers(text);
			}
			
			return 42;
		}
			
		
		
	}
	
	// Input validation helper 
	public static boolean isEmpty(String text)
	{
		if(text.equals(""))
		{
			return true;
		}
		return false;
	}
	
	public static void validateInput(String text)
	{
		if(text.contains("\n"))
		{
			text.replaceAll("\n","");
		}
		
		if(text.contains("//"))
		{
			String[] tokens = text.split("[//\n]+;");
				String newString = "";
				for(String s : tokens)
				{
					newString+=s;
				}
				newString.replaceAll("[\\D]",",");
				add(newString);
		}
	}
	
	public static String print()
	{
		String finalString ="";
		
		for(String numbers : negativeVal)
		{
			finalString+=numbers;
		}
		return finalString;
	}
	
	//Calculations helper function
	public static void calculateInput(String text)
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
	
	public static int oneNumber(String text)
	{
		if(toInt(text) >= 0)
		{
			return toInt(text);
		}
		throw new java.lang.IllegalArgumentException("Negatives not allowed: "+toInt(text));
	}
	
	public static int multipleNumbers(String text)
	{
		String numbers[] = text.split(",");
		return sum(numbers);
	}
	
	public static int sum(String[] numbers)
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
	
	public static int toInt(String number)
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