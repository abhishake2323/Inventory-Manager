package InventoryManager;

/**
 *
 * @author abbyf
 */

// Abby
abstract class Item {
    protected String name;
    protected double value;
    protected double weight;
    protected ItemCategory category;
    
    // Constructor
    // Abby
    public Item(String name, double value, double weight) {
        this.name = name;
        this.value = value;
        this.weight = weight;
        category = null;
    }
    
    // Getters
    // Abby
    public String getName() {     
        return name;
    }

    public double getValue() {
        return value;
    }

    public double getWeight() {
        return weight;
    }
    
    public ItemCategory getCategory() {
        return category;
    }

    @Override
    public String toString(){
       // Abby
       // Prints the attributes shared by all items
       return String.format("Name: %s%nValue: %.2f%nWeight: %.2f%nCategory: %s%n", name, value, weight, category);
    }
}
