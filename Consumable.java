package InventoryManager;

/**
 *
 * @author abbyf
 */

// Abby
class Consumable extends Item {

    public Consumable(String name, double value, double weight, int maxUses) {
        super(name, value, weight);
        category = ItemCategory.CONSUMABLE;
    }
    
}
