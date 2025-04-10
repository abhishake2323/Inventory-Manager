package InventoryManager;

/**
 *
 * @author abbyf
 */

// Veevek + Abby
public class Weapon extends Usable{
    private final DamageType damageType;  
    public Weapon(String name, double value, double weight, boolean inUse, DamageType damageType) {
        // Abby
        // Constructor for weapon
        super(name, value, weight, inUse);
        this.damageType = damageType;
        // category is set to weapon for all
        category = ItemCategory.WEAPON;
    }

    @Override
    public String getType() {
       // Veevek
       // this will provide damage type
       return damageType.toString();
    }
     
 @Override
    public String toString(){
        // Veevek
        // will override string to print useable item info and damage type info
        return super.toString() + "Damage Type: " + damageType + "\n";
    }
      
}
