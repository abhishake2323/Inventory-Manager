package InventoryManager;

import InventoryManager.AppExceptions.NoUsesRemainingException;

/**
 *
 * @author abbyf
 */

// Abby
class Consumable extends Item {

    private final int maxUses;
    private int usesRemaining;
    
    // Constructor
    // Abby
    public Consumable(String name, double value, double weight, int maxUses) {
        super(name, value, weight);
        category = ItemCategory.CONSUMABLE;
        this.maxUses = maxUses;
        usesRemaining = this.maxUses;
    }
    // Getter, gets max item uses
    // Abby
    public int getMaxUses() {
        return maxUses;
    }
    // Getter gets remaining item uses
    public int getUsesRemaining() {
        return usesRemaining;
    }
    
    // Prints remaining item uses
    // Abby
    public void printUsesRemaining() {
         System.out.println("Uses Remaining: " + getUsesRemaining() + "\n");
    }
    
    // Prints max item uses
    // Abby
    public void printMaxUses() {
         System.out.println("Max Item Uses: " + getMaxUses() + "\n");
    }
    
    // Reduce remaining uses on item by one
    // Abby
    public void consumeUse() {
        // if uses are at 0 throw no uses exception
        if (usesRemaining == 0) {
            try {
                throw new NoUsesRemainingException("You have expended all uses of this item", "ITEM_USES_EXPENDED", this.name, this.usesRemaining);
            } catch (NoUsesRemainingException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("One use expended.");
            usesRemaining--;
        }
    }
    // increase remaining uses on item by one
    // Abby
    public void chargeUse() {
         if (usesRemaining == maxUses) {
             System.out.println("Item is fully charged.");
         }else{
         System.out.println("One use charged.");
         usesRemaining++;
         }     
    }
 // Abby
 @Override
    public String toString(){
        return super.toString() + String.format("Max Uses: %d%nUses Remaining: %d%n", getMaxUses(), getUsesRemaining());
    }
}
