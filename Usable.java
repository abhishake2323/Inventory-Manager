package InventoryManager;

/**
 *
 * @author abbyf
 */

// Veevek + Abby
abstract class Usable extends Item{
    protected boolean inUse;
    // Constructor for Usable
    // Abby
    public Usable(String name, double value, double weight, boolean inUse) {
        super(name, value, weight);
        this.inUse = inUse;
    }
    
    // Abstract method for retriving usable type
    // Abby
    // in Armor will get armor type 
    // in weapon will get weapon type
    public abstract String getType();
    
    // In Use
    // Veevek   
    public boolean isInUse(){
        // will tell user if item is in use or not
         return inUse;
    }
    
    // Equip + Unequip Methods
    // Switch the equip state and provide confirmation
    // Veevek
    public void equip(){
        // will set an item to inUse = true
        // checks whether the item is already equipped
        if (inUse){
            System.out.println( getName()+ " is already equipped!");
        }
        else {
        inUse = true;
        System.out.println(getName() + " is now equipped!");
        }
    }
    public void unequip(){
        // Veevek
        // will set an item to inUse = false
        // checks whether the item is already unequipped
         if (!inUse){
            System.out.println( getName()+ " is already unequipped!");
        }
        else {
        inUse = false;
        System.out.println(getName() + "is now unequipped!");
        } 
    }
    @Override
    public String toString(){
        // Veevek
        // will override string to print useable item info
        return super.toString() + "In Use: " + inUse;
    }
}
