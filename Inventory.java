package InventoryManager;

import InventoryManager.AppExceptions.DuplicateItemException;
import InventoryManager.AppExceptions.FullInventoryException;
import InventoryManager.AppExceptions.ItemNotFoundException;

/**
 *
 * @author abbyf
 */
// Abby + Abhishek
class Inventory {

    // Abby
    protected Item[] items;
    protected int maxSize;
    protected int currentSize;

    public Inventory(int maxSize) {
        // Abby
        this.maxSize = maxSize;
        currentSize = 0;
        items = new Item[maxSize];
    }

    private boolean itemExists(Item item) {
        // Abby
        // checks if the item requested is null
        return item != null;
    }

    private boolean isSameName(Item item, String name) {
        // Abby
        // checks if item is null and if the name matches another item name
        return itemExists(item) && item.getName().equalsIgnoreCase(name);
    }

    public void addItem(Item newItem) {
        // Abby
        // Check if item is already in Inventory
        // if it is, trigger the exception
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
        // if there isn't, trigger the exception
        if (currentSize >= maxSize) {
            try {
                throw new FullInventoryException("Inventory is full! Cannot add more items.", "FULL_INVENTORY_ERROR", currentSize, maxSize);
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

    public void removeItem(String name) {
        // Abby
        // a variable to track if item is found
        boolean itemFound = false;
        // Try to find item and delete
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
        if (!itemFound) {
            try {
                throw new ItemNotFoundException("Item not found in the inventory!", "ITEM_NOT_FOUND_ERROR", name);
            } catch (ItemNotFoundException e) {
                System.out.println(e);
            }
        }
    }

    public Item getItemByName(String name) throws ItemNotFoundException {
        // Abhishek
        // will search for item by name and return it
        for (Item item : items) {
            if (isSameName(item, name)) { // Case-insensitive search
                return item;
            }
        }
        throw new ItemNotFoundException("Item not found in the inventory!", "ITEM_NOT_FOUND_ERROR", name);

    }

    public Item[] getItemsByCategory(ItemCategory category) throws ItemNotFoundException {
        // Abhishek
        // will search for items by ItemCategory emun and return an array
        int count = 0;

        // Count matching items
        for (Item item : items) {
            if (itemExists(item) && item.getCategory() == category) {
                count++;
            }
        }

        if (count == 0) {
            throw new ItemNotFoundException("Items not found in the inventory with specified category!",
                    "ITEM_NOT_FOUNDS_WITH_CATEGORY", category.toString());
        }

        Item[] filteredItems = new Item[count];
        int index = 0;

        for (Item item : items) {
            if (itemExists(item) && item.getCategory() == category) {
                filteredItems[index++] = item;
            }
        }

        return filteredItems;

    }

    public void printInventoryDetails() {
        // Abhishek
        // calls toString override in a for each loop to print all inventory details
        for (Item item : items) {
            if (item != null) {
                System.out.println(item.toString());
            }
        }

    }

    public void printCategoryDetails(ItemCategory category) {
        // Abhishek
        // uses getItemsByCategory to sort items then
        // calls toString override in a for each loop to print all
        // inventory details for sorted items

        try {
            // Get sorted items by category using getItemsByCategory
            Item[] filteredItems = getItemsByCategory(category);

            // Print details of sorted items
            System.out.println("Items in category: " + category);
            for (Item item : filteredItems) {
                System.out.println(item.toString()); // Call the overridden toString method
            }
        } catch (ItemNotFoundException e) {

            System.out.println(e.getMessage());
        }

    }

    public void printItemDetails(String name) {
        // Abhishek
        // uses getItemByName to find item then
        // calls toString to print item details
        try {
            System.out.println(getItemByName(name));
        } catch (ItemNotFoundException e) {

            System.out.println(e.getMessage());
        }

    }

    public int getRemainingSpace() {
        // Abhishek
        // retrieves remaining inventory space(max-current) and prints
        int remainingSpace = maxSize - currentSize;
        System.out.println("Remaining space: " + remainingSpace);
        return remainingSpace;

    }

    public double getTotalValue() {
        // Abhishek
        // calculates total inventory value and prints

        double totalValue = 0;

        // Iterate through the array of item values to calculate the total value
        for (Item item : items) {
            if(itemExists(item)){
            totalValue += item.getValue();
            }
        }

        // Print the total inventory value
        System.out.println("Total inventory value: " + totalValue);

        return totalValue;

    }

    public void help() {
        // Abby
        System.out.println("Inventory Management Help:");
        System.out.println("- addItem: Adds an item to the inventory. Item must be created first.");
        System.out.println("- removeItem: Removes an item from the inventory by name");
        System.out.println("- getItemByName: Returns an item by its name");
        System.out.println("- getItemsByCategory: Returns items by category");
        System.out.println("- printInventoryDetails: Prints all items in the inventory");
        System.out.println("- printCategoryDetails: Prints all items in a specific category");
        System.out.println("- printItemDetails: Prints details of a specific item");
        System.out.println("- getRemainingSpace: Shows available inventory slots");
        System.out.println("- getTotalValue: Calculates total value of inventory");
    }
}
