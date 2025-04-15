package InventoryManager;

import InventoryManager.AppExceptions.DuplicateItemException;
import InventoryManager.AppExceptions.FullInventoryException;
import InventoryManager.AppExceptions.InvalidItemException;
import InventoryManager.AppExceptions.ItemNotFoundException;

/**
 *
 * @author abbyf
 */

// Abby + Abhishek
class Inventory {
    protected Item[] items;
    protected int maxSize;
    protected int currentSize;
    
    // Inventory Constructor
    // Abby
    public Inventory(int maxSize) {
        this.maxSize = maxSize;
        currentSize = 0;
        items = new Item[maxSize];
    }
    
    // Utility Methods
    // Abby
    
    // Checks if the item requested is null
    private boolean itemExists(Item item) {
        return item != null;
    }
    
    // Checks if item is null and if the name matches another item name
    // Case-insensitive search
    private boolean isSameName(Item item, String name) {
        return itemExists(item) && item.getName().equalsIgnoreCase(name);
    }
    // Add item to inventory with extensive validation
    // Abby
    public void addItem(Item newItem) {
        // Validate item before adding
    if (newItem == null) {
        try {
            throw new InvalidItemException(
                "Item cannot be null",
                "INVALID_ITEM_ERROR",
                "item",
                null
            );
        } catch (InvalidItemException e) {
            System.out.println(e);
            return;
        }
    }

    // Validate item properties
    if (newItem.getName() == null || newItem.getName().trim().isEmpty()) {
        try {
            throw new InvalidItemException(
                "Item name cannot be empty",
                "INVALID_ITEM_ERROR",
                "name",
                newItem.getName()
            );
        } catch (InvalidItemException e) {
            System.out.println(e);
            return;
        }
    }

    if (newItem.getValue() < 0) {
        try {
            throw new InvalidItemException(
                "Item value cannot be negative",
                "INVALID_ITEM_ERROR",
                "value",
                newItem.getValue()
            );
        } catch (InvalidItemException e) {
            System.out.println(e);
            return;
        }
    }
        // Check if item is already in Inventory
        // if it is, trigger the duplicate item exception
        for (Item item : items) {
            if (isSameName(item, newItem.getName())) {
                try {
                    throw new DuplicateItemException(
                            "Item already exists in the inventory.",
                            "DUPLICATE_ITEM_ERROR",
                            newItem.getName()
                    );
                } catch (DuplicateItemException e) {
                    System.out.println(e);
                    return;
                }
            }
        }
        // Check if there is space for a new item
        // if there isn't, trigger the full inventory exception
        if (currentSize >= maxSize) {
            try {
                throw new FullInventoryException(
                    "Inventory is full! Cannot add more items.",
                    "FULL_INVENTORY_ERROR", 
                    currentSize, 
                    maxSize);
            } catch (FullInventoryException e) {
                System.out.println(e);
                return;
            }
        }
        // Find the first empty array slot and add the item
        for (int i = 0; i < maxSize; i++) {
            if (items[i] == null) {
                items[i] = newItem;
                // increase current inventory size when item is added
                currentSize++;
                System.out.printf("%s added successfully. %n", newItem.getName());
                return;
            }
        }
    }
    
    // Bulk Add Item
    // Abby
    public void addMultiple(Item[] items){
        // Adds multiple items to the inventory at once as an array
        for (Item item : items){
            addItem(item);
    }
    }
    
    // Remove item from inventory
    // Abby
    public void removeItem(String name) {
        // To track if item is found
        boolean itemFound = false;
        // Loop the inventory to try to find item and delete it
        for (int i = 0; i < maxSize; i++) {
            if (isSameName(items[i], name)) {
                items[i] = null;
                // reduce current inventory size when item is removed
                currentSize--;
                System.out.printf("%s removed successfully. %n", name);
                itemFound = true;
                break;
            }
        }
        // If the item is not found in the inventory
        // trigger the item not found exception
        if (!itemFound) {
            try {
                throw new ItemNotFoundException("Item not found in the inventory!", "ITEM_NOT_FOUND_ERROR", name);
            } catch (ItemNotFoundException e) {
                System.out.println(e);
            }
        }
    }
    // Search for an item by name
    // Abhishek
    public Item getItemByName(String name) throws ItemNotFoundException {
        // will search for item by name and return it
        for (Item item : items) {
            if (isSameName(item, name)) { 
                return item;
            }
        }
        // if item was not found trigger not found exception
        throw new ItemNotFoundException("Item not found in the inventory!", "ITEM_NOT_FOUND_ERROR", name);
    }
    
    // Search for items by category and return matching items
    // Abhishek
    public Item[] getItemsByCategory(ItemCategory category) throws ItemNotFoundException {
        // will search for items by ItemCategory emun and return an array
        int count = 0;
        // Count matching items
        for (Item item : items) {
            if (itemExists(item) && item.getCategory() == category) {
                count++;
            }
        }
        // if no items are found in the category
        // trigger not found exception
        if (count == 0) {
            throw new ItemNotFoundException("Items not found in the inventory with specified category!",
                    "ITEM_NOT_FOUNDS_WITH_CATEGORY", category.toString());
        }
        // New array for filtered items
        Item[] filteredItems = new Item[count];
        int index = 0;
        // ensures item is valid and the category matches the request
        for (Item item : items) {
            if (itemExists(item) && item.getCategory() == category) {
                filteredItems[index++] = item;
            }
        }
        // returns array of items that match the category
        return filteredItems;
    }
    
    // Prints all inventory details
    // Abhishek
    public void printInventoryDetails() {
        // calls toString override in a for each loop to print all inventory details
        for (Item item : items) {
            if (item != null) {
                System.out.println(item.toString());
            }
        }
        getRemainingSpace();
        getTotalValue();
    }
    
    // Prints details for all items in a specific category
    // Abhishek
    public void printCategoryDetails(ItemCategory category) {
        // uses getItemsByCategory to sort items then
        // calls toString override in a for each loop to print all
        // inventory details for sorted items
        try {
            // Get sorted items by category using getItemsByCategory
            Item[] filteredItems = getItemsByCategory(category);
            // Print details of sorted items
            System.out.println("Items in category: " + category);
            for (Item item : filteredItems) {
                System.out.println(item.toString());
            }
        // will print exception if items are not found
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
    
    // Prints specific Item Details based on name
    // Abhishek
    public void printItemDetails(String name) {
        // uses getItemByName to find item then
        // calls toString to print item details
        try {
            System.out.println(getItemByName(name));
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
    
    // Retrieves the remaining space of the inventory
    // Abhishek
    public void getRemainingSpace() {
        // retrieves remaining inventory space(max-current) and prints
        int remainingSpace = maxSize - currentSize;
        System.out.println("Remaining space: " + remainingSpace + "\n");
    }
    
    // Retrieves the total value of the inventory
    // Abhishek
    public void getTotalValue() {
        // calculates total inventory value and prints

        double totalValue = 0;
        // Iterate through the array of item values to calculate the total value
        for (Item item : items) {
            if(itemExists(item)){
            totalValue += item.getValue();
            }
        }
        // Print the total inventory value
        System.out.println("Total inventory value: " + totalValue + "\n");
    }

    // Help method for explaining usage
    // Abby
    public void help() {
        
        System.out.println("Inventory Management Help:");
        System.out.println("- addItem: Adds an item to the inventory. Item must be created first.");
        System.out.println("- addMultiple: Adds multiple items to the inventory. Items must in an Item array.");
        System.out.println("- removeItem: Removes an item from the inventory by name.");
        System.out.println("- getItemByName: Returns an item by its name.");
        System.out.println("- getItemsByCategory: Returns items by category.");
        System.out.println("- printInventoryDetails: Prints all items in the inventory and inventory details.");
        System.out.println("- printCategoryDetails: Prints all items in a specific category.");
        System.out.println("- printItemDetails: Prints details of a specific item.");
        System.out.println("- getRemainingSpace: Prints available inventory slots.");
        System.out.println("- getTotalValue: Calculates and prints total value of inventory.");
        System.out.println("- equip - Equip an Armor/Weapon item");
        System.out.println("- unequip - Unequip a Armor/Weapon item");
        System.out.println("- getType - Display the damage or armor type");
        System.out.println("- setNotes - Update notes for miscellaneous items");
        System.out.println("- isInUse - Check if a Armor/Weapon item is currently equipped");
    }
}
