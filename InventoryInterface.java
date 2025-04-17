package InventoryManager;

import InventoryManager.AppExceptions.ItemNotFoundException;

/**
 *
 * @author abbyf
 */

// Abby
interface InventoryInterface {
    
    // Add item to inventory
    public void addItem(Item newItem);
    public void removeItem(String name);
    
    // Get item/category info
    public Item getItemByName(String name)  throws ItemNotFoundException;
    public Item[] getItemsByCategory(ItemCategory category) throws ItemNotFoundException;
    
    // Print inventory details
    public void printInventoryDetails();
    public void printCategoryDetails(ItemCategory category);
    public void printItemDetails(String name);
    public void getRemainingSpace();
    public void getTotalValue();
     
}
