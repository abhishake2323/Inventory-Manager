package InventoryManager;

import java.util.Locale.Category;

import InventoryManager.AppExceptions.DuplicateItemException;
import InventoryManager.AppExceptions.FullInventoryException;
import InventoryManager.AppExceptions.InvalidItemException;
import InventoryManager.AppExceptions.ItemNotFoundException;

/**
 *
 * @author abbyf
 */

// All
public class InventoryTester {

    public InventoryTester() {

        ///////////////// Create New Inventory /////////////////
        Inventory test = new Inventory(8);

        /////////////////// Create Items ///////////////////

        // Miscellaneous Category
        Miscellaneous shirt = new Miscellaneous("Large Shirt", 10, 2, "Good in warm weather");
        Miscellaneous pants = new Miscellaneous("Pants", 12, 2, "In need of repair");

        // Consumable Category
        Consumable wand = new Consumable("Wand", 300, 1, 4);
        Consumable potion = new Consumable("Potion", 200, 2, 2);

        // Weapon Category
        Weapon machette = new Weapon("Machette", 278, 5.5, false, DamageType.SLASHING);
        Weapon fork = new Weapon("Metal Fork", 76, 0.25, true, DamageType.PIERCING);

        // Armor Category
        Armor uppershield = new Armor("Upper Body Shield", 180.0, 7.0, true, ArmorType.HEAVY);
        Armor lowershield = new Armor("Lower Body Shield", 90.0, 5.0, false, ArmorType.MEDIUM);

        // Array of items
        Item[] items = { shirt, pants, wand, potion, fork };

        ///////////////// Help Method /////////////////
        System.out.println("______________Helper Method______________\n");
        test.help();

        ///////////////// Basic Inventory Manipulation Methods /////////////////
        System.out.println("\n______________Basic Inventory Manipulation Methods______________\n");

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
        System.out.println("\n______________Basic Print Methods______________\n");

        // Print all Inventory Details
        System.out.println("--Start Full Inventory Details--\n");
        test.printInventoryDetails();
        System.out.println("--End Full Inventory Details--\n");

        // Print inventory value
        test.getTotalValue();

        // Print space remaining in inventory
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

        System.out.println("______________Weapon Subclass Methods______________\n");

        test.printItemDetails("Machette");

        System.out.println("Machette Damage Type: " + machette.getType() + "\n");

        System.out.println(fork.toString());

        ///////////////// Armor Subclass Methods /////////////////

        System.out.println("______________Armor Subclass Methods______________\n");

        test.printItemDetails("Upper Body Shield");

        System.out.println("Upper Body Shield Armor Type: " + uppershield.getType() + "\n");

        test.printItemDetails("Upper Body Shield");

        ///////////////// Consumable Subclass Methods /////////////////

        System.out.println("______________Consumable Subclass Methods______________\n");

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

        //////////////////// Miscellaneous Subclass Methods /////////////////
        System.out.println("______________Miscellaneous Subclass Methods______________\n");

        System.out.println(pants.toString());

        // Update notes
        pants.setNotes("These pants are waterproof and fireproof");
        System.out.println(pants.toString());

        //////////////////// Usable Class Methods /////////////////

        System.out.println("______________Usable Subclass Methods (Armor and Weapon)______________\n");

        // Equip + Unequip Armor Items
        machette.isInUse();

        machette.equip();
        machette.equip();
        machette.unequip();
        machette.unequip();

        machette.isInUse();

        // Equip + Unequip Weapon Items
        uppershield.isInUse();

        uppershield.equip();
        uppershield.unequip();
        uppershield.unequip();

        uppershield.isInUse();

        //////////////////// Examples of Exception Handling /////////////////

        System.out.println("______________Examples of Exception Handling______________\n");

        Inventory test2 = new Inventory(4);
        
        Consumable wand1 = new Consumable("Wand1", 300, 1, 4);
        // Consumable Category
        Consumable wand2 = new Consumable("Wand", 300, 1, 4);

        // Weapon Category
        Weapon machette2 = new Weapon("Machette", 278, 5.5, false, DamageType.SLASHING);
        Weapon machette3 = new Weapon("Machette", 278, 5.5, false, DamageType.SLASHING);

        // Armor Category
        Armor upperShield2 = new Armor("Upper Body Shield", 90.0, 5.0, false, ArmorType.HEAVY);
        Armor lowershield2 = new Armor("Lower Body Shield", 90.0, 5.0, false, ArmorType.MEDIUM);

        try{
            test2.addItem(null); //Throws InvalidItemException 
        }
        catch(Exception e){
            System.out.println(e); 
        }
        try{
            test2.addItem(new Miscellaneous(null, 0, 0, null)); //Throws InvalidItemException 
        }
        catch(Exception e){
            System.out.println(e); 
        }


        test2.addItem(wand1);
        test2.addItem(wand2);
        test2.addItem(machette2);
        test2.addItem(machette3); // Throws DuplicateItemException Since machette2 and machette3 are same in
                                  // definition as above

        test2.addItem(lowershield2);
        test2.addItem(upperShield2); // throws FullInventoryException
        try {
            test2.getItemByName("Machette");
            test2.getItemByName("Some_random_item");// throws ItemNotFoundException

        } catch (ItemNotFoundException e) {
            System.out.println(e);
        }

        try {
             
            test2.getItemsByCategory(ItemCategory.MISCELLANEOUS  );// throws ItemNotFoundException since there are no items with this category added!

        } catch (ItemNotFoundException e) {
            System.out.println(e);
        }


        wand2.consumeUse();
        wand2.consumeUse();
        wand2.consumeUse();
        wand2.consumeUse();
        wand2.consumeUse(); // throws NoUsesRemainingException since overused than specified (4 times)
        test2.printInventoryDetails();

    }

    public static void main(String[] args) {
        new InventoryTester();
    }

}
