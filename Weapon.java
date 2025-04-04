package InventoryManager;

/**
 *
 * @author abbyf
 */
// Veevek
class Weapon extends Usable{
    private DamageType damageType;
    
    public Weapon(String name, double value, double weight, boolean inUse, DamageType damageType) {
        super(name, value, weight, inUse);
        this.damageType = damageType;
        category = ItemCategory.WEAPON;
    }

    @Override
    public String getType() {
        // Veevek
       // this will provide damage type
    }
 @Override
    public String toString(){
        // Veevek
        // will override string to print useable item info + damage type info
    }
}
