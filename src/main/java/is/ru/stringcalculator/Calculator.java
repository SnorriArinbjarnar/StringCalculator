package is.ru.stringcalculator;

public class Calculator {

	public int add(String[] text)
	{
		if(text.equals(""))
		{
			return 0;
		}
		else
		{
			if(text.equals("1"))
			{
				return Integer.parseInt(text[0]);
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