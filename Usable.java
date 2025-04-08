package InventoryManager;

/**
 *
 * @author abbyf
 */
// Veevek
abstract class Usable extends Item{
    
    protected boolean inUse;
    
    public Usable(String name, double value, double weight, boolean inUse) {
        super(name, value, weight);
        this.inUse = inUse;
    }
    
    // in Armor will get armor type in weapon will get weapon type
    public abstract String getType();
    
    public boolean isInUse(){
         // will tell user if item is in use or not
         return inUse;
    };
        
    public void equip(){
        // will set an item to inUse = true
        
        inUse = true;
    };
    public void unequip(){
        // will set an item to inUse = false
        
        inUse = false;
    };
    @Override
    public String toString(){
        //will override string to print useable item info
        
        return super.toString() + "In Use: " + inUse;
    }
}
