package InventoryManager;

/**
 *
 * @author abbyf
 */
// Veevek
public class Armor extends Usable{
    private ArmorType armorType;
    
    public Armor(String name, double value, double weight, boolean inUse, ArmorType armorType) {
        super(name, value, weight, inUse);
        this.armorType = armorType;
        category = ItemCategory.ARMOR;
    }

    @Override
    public String getType() {
       // Veevek
       // this will provide armor type  
       return armorType.toString();
    }
 @Override
    public String toString(){
        // Veevek
        // will override string to print useable item info and armor type info  
        return super.toString() + "\nArmor Type: " + armorType;
    }

}
