import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PartFactory {
    
    //private static final File partsListFile = new File("src/Inventory.csv");
	// better to pass the file name to the methods than a file object
    private static final String partsListFile = "src/Inventory.csv";
    
    public static void main(String[] args) {
//        makePartsFromList("src/Inventory.csv");
        try {
            ArrayList<Part> partsList = makePartsFromFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * testing, i have an idea Anthony B.
     * update: IT WORKS
     * this could be the highlight of this class
     *
     * @return
     * @throws FileNotFoundException
     */
    public static ArrayList<Part> makePartsFromFile() {
        ArrayList<Part> partsList = new ArrayList<>();
        File file;
        Scanner scanner = null;
        Part part;
        String line;
        try {
            file = new File(partsListFile);
            scanner = new Scanner(file);
            String[] parameters;
            int i = 0;
            while (scanner.hasNextLine()) {
                part = null;
                line = scanner.nextLine();
                parameters = line.split(",");
                String partType = parameters[0];
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
                    case "Ram":
                        part = new Ram(parameters);
                        break;
                }
                if (part != null) {
                    partsList.add(part);
                }
                 //VV uncomment to prove it works
                //System.out.println(partsList.get(i).getInfo());
                i++;
            }
        } catch (FileNotFoundException e) {
         
        	System.err.println(e);
        	return new ArrayList<Part>();
        }
        finally
        {
        	if(scanner != null)
        	{
        		scanner.close();
        	}
        }
        return partsList;
    }
}
