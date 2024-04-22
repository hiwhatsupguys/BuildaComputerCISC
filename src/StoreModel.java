public class StoreModel {
    
    private PartInventory partInventory = new PartInventory();
    private User user;
    private final int initialBalance = 2000;
    
    public StoreModel() {
        user = new User();
        user.setBalance(initialBalance);
    }
    
    public PartInventory getPartInventory() {
        return partInventory;
    }
    
    /**
     * buy the part if there is enough in stock and the user's balance is sufficient
     *
     * @param part
     */
    public void buy(Part part) {
        double price = part.getPrice();
        if (partInventory.getPartCount(part) > 0
                && user.getBalance() >= price) {
            partInventory.removePart(part);
            user.setBalance(user.getBalance() - price);
            user.getInventory().addPart(part);
        } else {
            // decrement part count
            // @TODO throw exception
        }
    }
//
//    public void sell(Part part) {
//        double price = part.getPrice();
//
//    }

//    public int getNumberOfPartTypes() {
//        return numberOfPartTypes;
//    }
//
//    public void getNumberOfPartType() {
//
//    }
    
}
