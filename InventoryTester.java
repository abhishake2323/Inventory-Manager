package InventoryManager;

/**
 *
 * @author abbyf
 */
public class InventoryTester {

    public InventoryTester(){
        
        // test data to be changed later
        
        // Create New Inventory
        Inventory test = new Inventory(5);
        // Create Items
        Miscellaneous t1 = new Miscellaneous("Large Shirt", 10, 2, "Good in warm weather");
        Miscellaneous t2 = new Miscellaneous("Pants", 12, 2, "In need of repair");
        Consumable c1 = new Consumable ("Wand", 300, 1, 4);
        Consumable  c2 = new Consumable ("Potion", 200, 2, 2);
        
        test.addItem(t1);
        test.addItem(t2);
        test.addItem(c1);
        test.addItem(c2);
        test.removeItem("Large Shirt");
        test.getTotalValue();
        
        System.out.println(c1.getUsesRemaining());
        c1.consumeUse();
         System.out.println(c1.getUsesRemaining());
        System.out.println(c1.toString());
        
    }
    public static void main(String[] args) {
        new InventoryTester();
    }
    
}
