import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Lead Author(s):
 *
 * @author Anthony Bazalaki, Elias Zarate
 * <p>
 * Class Responsibilities:
 * This class is responsible for creating parts from a csv file. Since Subclasses of the Part Superclass have a constructor
 * that take an Array as a parameter for creating computer part objects.
 * 
 */
public class PartFactory {
    
    //private static final File partsListFile = new File("src/Inventory.csv");
    // better to pass the file name to the methods than a file object
    // The PartFactory class has a static partListFile  that it will read from
    private static final String partsListFile = "src/Inventory.csv";
    
    // for testing purposes
//    public static void main(String[] args) {
//        makePartsFromList("src/Inventory.csv");
//        try {
//            ArrayList<Part> partsList = makePartsFromFile();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    
    /**
     * makes specific Parts from a file that holds a parameter list for parts to be made
     *
     * @return partsList
     * @throws FileNotFoundException
     */
    public static ArrayList<Part> makePartsFromFile() {
        // a new ArrayList partsList to hold the parts being read from the file
        ArrayList<Part> partsList = new ArrayList<>();
        // to hold the file
        File file;
        // to read the file
        Scanner scanner = null;
        // to hold the part being read
        Part part;
        // to hold a line being read from the file
        String line;
        try {
            // open the file
            file = new File(partsListFile);
            // start the reading the file
            scanner = new Scanner(file);
            // to hold what is being read 
            String[] parameters;
            // index
            int i = 0;
            // while the scanner has a next line
            while (scanner.hasNextLine()) {
                // part is null (for now)
                part = null;
                // store the next line
                line = scanner.nextLine();
                // add the line into the array with a , splitting the line up
                parameters = line.split(",");
                // the part type of a the part to be made is the value stored in index 0
                String partType = parameters[0];
                // switch through the part types and make a new part for every case
                switch (partType) {
                    case "GPU":
                        part = new GPU(parameters);
                        break;
                    case "CPU":
                        part = new CPU(parameters);
                        break;
                    case "Motherboard":
                        part = new Motherboard(parameters);
                        break;
                    case "RAM":
                        part = new RAM(parameters);
                        break;
                    case "Power Supply":
                        part = new PowerSupply(parameters);
                        break;
                    case "Storage Device":
                        part = new StorageDevice(parameters);
                        break;
                }
                // if part is not null
                if (part != null) {
                    // add the part to the partsList
                    partsList.add(part);
                }
                //VV uncomment to prove it works
                //System.out.println(partsList.get(i).getInfo());
                // increment through the index
                i++;
            }
        } catch (FileNotFoundException e) {
            // print out the error
            System.err.println(e);
            // return an empty ArrayList of Parts
            return new ArrayList<Part>();
        } finally {
            // if the scanner is not null
            if (scanner != null) {
                // close the scanner
                scanner.close();
            }
        }
        return partsList;
    }
}
