import java.util.ArrayList;

public class StoreModel {
    
    // list of parts
    private ArrayList<Part> parts;
    // number of total types of parts
    private int numberOfPartTypes;
    
    public StoreModel() {
        parts.add(new GPU("RX 7800 XT", "AMD", 529.99, 2023, 2430, 16));
        calculateNumberOfPartTypes();
    }
    
    private void addPart(Part part) {
        parts.add(part);
    }
    
    public void buy() {
    
    }
    
    public void sell() {
    
    }
    
    public int getNumberOfPartTypes() {
        return numberOfPartTypes;
    }
    
    public void calculateNumberOfPartTypes() {
        if (parts==null) return;
        ArrayList<String> foundTypes = new ArrayList<>();
        String currentType;
        for (int i = 0; i < parts.size(); i++) {
            currentType = parts.get(i).getType();
            // if the type hasn't already been found
            if (!foundTypes.contains(currentType)) {
                foundTypes.add(currentType) ;
                numberOfPartTypes++;
            }
        }
    }
    
}
