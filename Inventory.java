package InventoryManager;

import InventoryManager.AppExceptions.FullInventoryException;
import InventoryManager.AppExceptions.ItemNotFoundException;

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

    public Inventory(int maxSize) {
        // Abby
        this.maxSize = maxSize;
        currentSize = 0;
        items = new Item[maxSize];
    }

    public boolean addItem(Item item) {
        // Abby
        // returns true if item added successfully or false in not
        // will trigger exceptions
    }

    public boolean removeItem(String name) {
        // Abby
        // returns true if item removed successfully or false in not
        // will trigger exceptions
    }

    public Item getItemByName(String name) {
        // Abhishek
        // will search for item by name and return it
        for (Item item : items) {
            if (item.name.equalsIgnoreCase(name)) { // Case-insensitive search
                return item;
            }
        }
        throw new ItemNotFoundException("Item not found in the inventory!", "ITEM_NOT_FOUND_ERROR", name);

    }

    public Item[] getItemsByCategory(ItemCategory category) {
        // Abhishek
        // will search for items by ItemCategory emun and return an array
        int count = 0;

        // Count matching items
        for (Item item : items) {
            if (item.getCategory() == category) {
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
            if (item.getCategory() == category) {
                filteredItems[index++] = item;
            }
        }

        return filteredItems;

    }

    public void printInventoryDetails() {
        // Abhishek
        // calls toString override in a for each loop to print all inventory details
        for (Item item : items) {
            System.out.println(item.toString());
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
        if (maxSize < currentSize) {
            try {
                throw new FullInventoryException("Inventory is Full", "INVENTORY_IS_FULL", currentSize, maxSize);
            } catch (FullInventoryException e) {
                System.out.println(e.getMessage());
            }
        }

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
            totalValue += item.getValue();
        }

        // Print the total inventory value
        System.out.println("Total inventory value: " + totalValue);

        return totalValue;

    }

    public void help() {
        // Abby
        // prints explanation of code
    }
}
