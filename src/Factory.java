import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Factory
{
	
	
	public static List<String> readPartsFromFile(String fileName)
	{
		List<String> parts = null;
	
		File file;
	
		Scanner sc = null;
		
		try
		{

			// open the file
			file = new File(fileName);
			sc = new Scanner(file);
			while (sc.useDelimiter(",") != null)
			{
				String testScanner1 = "";
				switch (testScanner1)
				{
					case "": 
						testScanner1 += sc.nextLine();
						System.out.println(testScanner1);
						break;
					default:
						System.out.print("Nothing was scanned");
						break;
				}
				
				
			}

			// use the scanner.useDelimiter method
		}
		catch (FileNotFoundException e)
		{
			
			// in the event something goes wrong
			System.out.println(e);
		}
		finally
		{
			// close the file
			sc.close();
		}
		return parts;
	}

	public static void savePartsToFile(List<Part> partsList)
	{
		try
		{
			// open the file...
			
		}
		catch(FileNotFoundException e)
		{
			// in the event something goes wrong
		}
		finally
		{
			// close the file
		}
	}

	public static void main(String[] args) {
		readPartsFromFile("src/GpuInventory.csv");
	}
}
