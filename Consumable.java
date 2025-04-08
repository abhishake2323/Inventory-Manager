package InventoryManager;

import InventoryManager.AppExceptions.NoUsesRemainingException;

/**
 *
 * @author abbyf
 */
// Abby
class Consumable extends Item {

    private int maxUses;
    private int usesRemaining;

    public Consumable(String name, double value, double weight, int maxUses) {
        super(name, value, weight);
        category = ItemCategory.CONSUMABLE;
        this.maxUses = maxUses;
        usesRemaining = this.maxUses;
    }
    // Getter, gets max item uses
    public int getMaxUses() {
        return maxUses;
    }
    // Getter gets remaining item uses
    public int getUsesRemaining() {
        return usesRemaining;
    }
    public void consumeUse() {
        if (usesRemaining == 0) {
            try {
                throw new NoUsesRemainingException("You have expended all uses of this item", "ITEM_USES_EXPENDED", this.name, this.usesRemaining);
            } catch (NoUsesRemainingException e) {
                System.out.println(e.getMessage());
            }
        } else {
            usesRemaining--;
        }
    }

    public void chargeUse() {
         if (usesRemaining == maxUses) {
             System.out.println("Item is fully charged.");
         }else{
         usesRemaining++;
         }     
    }
 @Override
    public String toString(){
        return super.toString() + String.format("Max Uses: %d%nUses Remaining: %d%n", getMaxUses(), getUsesRemaining());
    }
}
