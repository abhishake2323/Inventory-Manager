package inventorymanager;

/**
 *
 * @author abbyf
 */
interface InventoryInterface {
    
    // Add item to inventory
    public void addItem();
    public void removeItem();
    
    // Get item/category info
    public Item getItemByName(String name);
    public Item[] getItemsByCategory(ItemCategory category);
    
    // Print inventory details
    public void printInventoryDetails();
    public void printCategoryDetails(ItemCategory category);
    public void printItemDetails(String name);
    
    // Get inventory info
    public int getRemainingSpace();
    public double getTotalValue();
     
}
