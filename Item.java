package InventoryManager;

/**
 *
 * @author abbyf
 */
abstract class Item {
    protected String name;
    protected double value;
    protected double weight;
    protected ItemCategory category;
    
    // Constructor
    public Item(String name, double value, double weight) {
        this.name = name;
        this.value = value;
        this.weight = weight;
        category = null;
    }
    
    // Getters
    
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

    
}
