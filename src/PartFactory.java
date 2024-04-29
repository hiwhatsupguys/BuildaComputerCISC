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
     * @throws FileNotFoundException 
     */

    public static ArrayList<Part> makePartsFromList(String fileName) throws FileNotFoundException {
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

    
    

    
    private static ArrayList<String> readPartsFromFile(String fileName) throws FileNotFoundException {

        ArrayList<String> parts = new ArrayList<>();
        // rewrite so the File object is being initialized in a try block
        File file = new File(fileName);
        // rewrite to initialize reader in a try block
        Scanner reader = new Scanner(file);
        // use the next line character to distinguish what is being read
        reader.useDelimiter("\n");
        // while there is a next line in the file
        while(reader.hasNextLine())
        {
        	// partsString holds the information from the file as a String
        	String partsString = reader.nextLine();
        	// print out the line (for testing mostly)
        	System.out.println(partsString);
        	// partsScanner is a new scanner that scans partsString
        	Scanner partsScanner = new Scanner(partsString);
        	// use the , character to distinguish between what's in the file
        	partsScanner.useDelimiter(",");
        	
        	// inner while loop, while partsScanner has something next
        	while(partsScanner.hasNext())
        	{
        		// temporary part
        		Part part;
        		//
        		String element = partsScanner.next();
        		
        		System.out.println(element);
        		
    
//        		switch(element)
//        		{
//        			case "GPU": part = new Gpu();
//        			break;
//        			case "CPU": part = new Cpu();
//        			break;
//        		}
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
