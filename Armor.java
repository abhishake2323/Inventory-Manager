package InventoryManager;

/**
 *
 * @author abbyf
 */
// Veevek
class Armor extends Usable{
    private ArmorType armorType;
    
    public Armor(String name, double value, double weight, boolean inUse, ArmorType armorType) {
        super(name, value, weight, inUse);
        this.armorType = armorType;
        category = ItemCategory.ARMOR;
    }

    @Override
    public String getType() {
       // Veevek
       // this will provide damage type
    }
 @Override
    public String toString(){
        // Veevek
        // will override string to print useable item info + armor type info
    }

}
