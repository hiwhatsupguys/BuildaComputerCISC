import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PartFactory {
    
    public static void main(String[] args) {
       makePartsFromList("src/GpuInventory.csv");
    }
    
    /**
     * gets the information string from readPartsFromFile, and returns the
     * @param fileName
     * @return part array
     */
    public static ArrayList<Part> makePartsFromList(String fileName) {
        ArrayList<String> partInfoStringArray = readPartsFromFile(fileName);
        ArrayList<Part> parts = new ArrayList<>();
        //System.out.println(partInfoStringArray);
        switch (partInfoStringArray.get(0)) {
            case "GPU":
//                Part part = new Gpu();
                //
                    break;
            
        }
        Part partName = new Gpu(partInfoStringArray.get(0), "AMD",529.99, 2023, 2430, 16);
        return null;
    }
    
    private static ArrayList<String> readPartsFromFile(String fileName) {
        ArrayList<String> parts = new ArrayList<>();
        
        File file;
        
        Scanner sc0 = null;
        Scanner sc1 = null;
        try {
            
            // open the file
            file = new File(fileName);
            sc0 = new Scanner(file);
            while (sc0.hasNextLine()) {
                String line = sc0.nextLine();
                sc1 = new Scanner(line);
                sc1.useDelimiter(",");
                while (sc1.hasNext()) {
                    String testScanner1String = "";
                    testScanner1String += sc1.next();
                    System.out.println(testScanner1String);
                    parts.add(testScanner1String);
                }
// for testing purposes
//              boolean hasNextLine = sc0.hasNextLine();
//				switch (hasNextLine)
//				{
//                    case true:
//					default:
//						System.out.print("Nothing was scanned");
//						break;
//				}
            }
            // use the scanner.useDelimiter method
        } catch (FileNotFoundException e) {
            
            // in the event something goes wrong
            System.out.println(e);
//            System.exit(0);
        } finally {
            // close the file
            System.out.println(parts);
            if(sc0 != null && sc1 != null)
            {
            sc0.close();
            sc1.close();
            }
        }
        return parts;
    }
    
    public static void savePartsToFile(ArrayList<Part> partsList) {
//		try
//		{
//			// open the file...
//
//		}
//		catch(FileNotFoundException e)
//		{
//			// in the event something goes wrong
//		}
//		finally
//		{
//			// close the file
//		}
    }
    
}
