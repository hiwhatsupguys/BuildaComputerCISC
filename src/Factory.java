import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Factory
{
	public static List<Part> readPartsFromFile(String fileName) 
	{
		List<Part> parts = null;
		File file;
		Scanner sc;
		
		try
		{
			//open the file
			file = new File(fileName);
			sc = new Scanner(file);
			
			switch(sc.nextLine())
			{
				case 1:
			}
			
			
			// use the scanner.useDelimiter method
		}
		catch(FileNotFoundException e)
		{
			// in the event something goes wrong
			System.out.println(e);
		}
		finally
		{
			//close the file
			
		}
		
		return part;
	}
	
	public static void savePartsToFile(List<Part> partsList)
	{
		try
		{
			// open the file...
			
		}
		catch()
		{
			// in the event something goes wrong
		}
		finally
		{
			// close the file
		}
	}

}
