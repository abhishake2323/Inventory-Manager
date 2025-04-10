package InventoryManager;

/**
 *
 * @author abbyf
 */

// All
public class InventoryTester {

    public InventoryTester(){
        
        ///////////////// Create New Inventory /////////////////
        Inventory test = new Inventory(8);
        
        /////////////////// Create Items ///////////////////
        
        // Miscellanous Category
        Miscellaneous shirt = new Miscellaneous("Large Shirt", 10, 2, "Good in warm weather");
        Miscellaneous pants = new Miscellaneous("Pants", 12, 2, "In need of repair");
        
        // Consumable Category
        Consumable wand = new Consumable ("Wand", 300, 1, 4);
        Consumable  potion = new Consumable ("Potion", 200, 2, 2);
        
        // Weapon Category
        Weapon machette = new Weapon("Machette", 278, 5.5, false, DamageType.SLASHING);
        Weapon fork = new Weapon("Metal Fork", 76, 0.25, true, DamageType.PIERCING);
        
        // Armor Category
        Armor uppershield = new Armor("Upper Body Shield", 180.0, 7.0, true, ArmorType.HEAVY);
        Armor lowershield = new Armor("Lower Body Shield", 90.0, 5.0, false, ArmorType.MEDIUM);
        
        // Array of items
        Item[] items = {shirt, pants, wand, potion, fork};
        
        ///////////////// Help Method /////////////////
        System.out.println("______________Helper Method______________");
        test.help();
        
        ///////////////// Basic Inventory Manipualtion Methods /////////////////
        System.out.println("______________Basic Inventory Manipualtion Methods______________");
        
        // Add multiple items using array
        test.addMultiple(items);
        
        // Remove an item using name
        test.removeItem("Large Shirt");
        
        // Add individual item
        test.addItem(shirt);
        test.addItem(machette);
        test.addItem(uppershield);
        test.addItem(lowershield);
        
        ///////////////// Basic Print Methods /////////////////
        System.out.println("______________Basic Print Methods______________");
        
        // Print all Inventory Details
        test.printInventoryDetails();
        System.out.println("End Full Inventory Deatils");
        
        // Print inventory value
        test.getTotalValue();
        
        // Print space reamining in inventory
        test.getRemainingSpace();
        
        // Print items by category
        test.printCategoryDetails(ItemCategory.CONSUMABLE);
        
        // Print an item by name
        test.printItemDetails("Machette");
        test.printItemDetails("Large Shirt");
        
        // Print an item with to string
        System.out.println(pants.toString());
        System.out.println(fork.toString());
        
        ///////////////// Weapon Subclass Methods /////////////////
        
        System.out.println("______________Weapon Subclass Methods______________");
        
        test.printItemDetails("Machette");
        System.out.println(fork.toString());
        
        ///////////////// Armor Subclass Methods /////////////////
        
        System.out.println("______________Armor Subclass Methods______________");
        
        test.printItemDetails("Upper Body Shield");
        
        // Equip + Unequip Items
        uppershield.equip();   
        uppershield.unequip();   
        uppershield.unequip();
        
        test.printItemDetails("Upper Body Shield");
        
        ///////////////// Consumable Subclass Methods /////////////////
        
        System.out.println("______________Consumable Subclass Methods______________");
        
        test.printItemDetails("potion");
        
        // Consume and add Uses
        potion.printUsesRemaining();
        potion.printMaxUses();
        potion.consumeUse();
        potion.consumeUse();
        potion.consumeUse();
        potion.printMaxUses();
        potion.printUsesRemaining();
        potion.chargeUse();
        potion.chargeUse();
        potion.chargeUse();
        potion.printMaxUses();
        
        test.printItemDetails("potion");
        
        //////////////////// Miscellanous Subclass Methods /////////////////
        System.out.println("______________Miscellanous Subclass Methods______________");

        System.out.println(pants.toString());
        
        // Update notes
        pants.setNotes("These pants are waterproof and fireproof");
        System.out.println(pants.toString());
        
    }
    public static void main(String[] args) {
        new InventoryTester();
    }
    
}
