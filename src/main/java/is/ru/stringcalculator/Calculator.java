package is.ru.stringcalculator;
import java.util.ArrayList;
import java.util.Arrays;

public class Calculator {
static ArrayList<String> negativeVal = new ArrayList<String>();
	public int add(String text)
	{
		
		
		if(isEmpty(text))
		{
			return 0;
		}
		else
		{
			calculateInput(text);
			
			
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
		return 42;
	}
	
	private boolean isEmpty(String text)
	{
		if(text.equals(""))
		{
			return true;
		}
		return false;
	}
	
	private int oneNumber(String text)
	{
		if(toInt(text) >= 0)
		{
			return toInt(text);
		}
		throw new java.lang.IllegalArgumentException("Negatives not allowed: "+toInt(text));
	}
	
	private int multipleNumbers(String text)
	{
		String numbers[] = text.split(",");
		return sum(numbers);
	}
	
	private void calculateInput(String text)
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
			//print(negativeVal);
		}
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