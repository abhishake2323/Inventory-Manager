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
    }
        
    public void equip(){
        // will set an item to inUse = true
        // checks wether the item is already equipped
        
        if (inUse){
            System.out.println( getName()+ " is already equipped!");
        }
        else {
        inUse = true;
        System.out.println(getName() + " is now equipped!");
        }
    }
    public void unequip(){
        // will set an item to inUse = false
        // checks wether the item is already unequipped

         if (inUse){
            System.out.println( getName()+ " is now unequipped!");
        }
        else {
        inUse = false;
        System.out.println(getName() + "is already unequipped!");
        }
        
    }
    @Override
    public String toString(){
        //will override string to print useable item info
        
        return super.toString() + "In Use: " + inUse;
    }
}
