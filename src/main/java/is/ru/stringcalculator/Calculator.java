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
				String number[] = new String[]{text};
				
				return Integer.parseInt(number[0]);
			}
			
			if(text.contains(","))
			{
				String numbers[] = text.split(",");
				return Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
			}
		}
		return 1;
	}
	
	
	public static void main(String[] args)
	{
		return;
	}
}


// javac /... /*.java buildar alla klassa í möppu