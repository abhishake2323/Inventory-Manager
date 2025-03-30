package inventorymanager;

/**
 *
 * @author abbyf
 */

// Abby + Abhishek
class Inventory {
    // Abby
    private Item[] items;
    private int maxSize;
    private int currentSize;

    public Inventory(int maxSize){
    // Abby
        this.maxSize = maxSize;
        currentSize = 0;
        items = new Item[maxSize];
    }
    public boolean addItem(Item item){
    // Abby
    // returns true if item added successfully or false in not
    // will trigger exceptions
    }
    public boolean removeItem(String name){
    // Abby
    // returns true if item removed successfully or false in not
    // will trigger exceptions
    }
    
    public Item getItemByName(String name){
    // Abhishek
    // will search for item by name and return it
    }
    }
    public Item[] getItemsByCategory(ItemCategory category){
    // Abhishek
    // will search for items by ItemCategory emun and return an array
    }
    public void printInventoryDetails(){
       // Abhishek
    // calls toString override in a for each loop to print all inventory details
    }
    public void printCategoryDetails(ItemCategory category){
        // Abhishek
        // uses getItemsByCategory to sort items then
        // calls toString override in a for each loop to print all 
        // inventory details for sorted items
    }
    public void printItemDetails(String name){
        // Abhishek
        // uses getItemByName to find item then
        // calls toString to print item details
    }
    public int getRemainingSpace(){
        // Abhishek
        // retrieves remaining inventory space(max-current) and prints
    }
    public double getTotalValue(){
        // Abhishek
        // calculates total inventory value and prints
    }
    public void help(){
        // Abby
        // prints explanation of code
    }
