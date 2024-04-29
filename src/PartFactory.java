import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PartFactory {
    
    private static final File partsListFile = new File("src/Inventory.csv");
    
    public static void main(String[] args) {
//        makePartsFromList("src/Inventory.csv");
        try {
            ArrayList<Part> partsList = makePartsFromFile(partsListFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * testing, i have an idea Anthony B.
     * update: IT WORKS
     * this could be the highlight of this class
     *
     * @param file
     * @return
     * @throws FileNotFoundException
     */
    public static ArrayList<Part> makePartsFromFile(File file) throws FileNotFoundException {
        ArrayList<Part> partsList = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        String[] parameters;
        int i = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            parameters = line.split(",");
            String partType = parameters[0];
            String name = parameters[1];
            String manufacturer = parameters[2];
            double price = Double.parseDouble(parameters[3]);
            int year = Integer.parseInt(parameters[4]);
            switch (partType) {
                case "GPU":
                    GPU gpu = new GPU(parameters);
                    partsList.add(gpu);
                    break;
                case "CPU":
                    CPU cpu = new CPU(parameters);
                    partsList.add(cpu);
                    break;
                // etc.
            }
            // VV uncomment to prove it works
            System.out.println(partsList.get(i).getInfo());
            i++;
        }
        return null;
    }

//    public static GPU makeGPUFromFile() {
//        return new GPU();
//    }
    
    /**
     * gets the information string from readPartsFromFile, and returns the
     *
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
        Part partName = new GPU(partInfoStringArray.get(0), "AMD", 529.99, 2023, 2430, 16);
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
            if (sc0 != null && sc1 != null) {
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
