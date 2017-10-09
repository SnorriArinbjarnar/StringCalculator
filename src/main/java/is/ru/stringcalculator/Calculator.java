package is.ru.stringcalculator;

public class Calculator {

	public int add(String text)
	{
		if(text.equals(""))
		{
			return 0;
		}
		else
		{
			if(text.equals("1"))
			{
				return toInt(text);
			}
			
			if(text.contains(","))
			{
				String numbers[] = text.split(",");
				return sum(numbers);
			}
			
			if(text.contains("\n"))
			{
				text.replaceAll("\n","");
			}
		}
		return 1;
	}
	
	private static int sum(String[] numbers)
	{
		
		int total = 0;
		
		for(String number : numbers)
		{
			total += toInt(number);
		}
		return total;
	}
	
	private static int toInt(String number)
	{
		if(Integer.parseInt(number) > 1000)
		{
			return 0;
		}
		
		return Integer.parseInt(number);
	
	}
	
	
	public static void main(String[] args)
	{
		return;
	}
}


// javac /... /*.java buildar alla klassa í möppu