package inventorymanager;

/**
 *
 * @author abbyf
 */
// Veevek
class Miscellaneous extends Item{
    private String notes;
    public Miscellaneous(String name, double value, double weight, String notes) {
        super(name, value, weight);
        this.notes = notes;
        category = ItemCategory.MISCELLANEOUS;
    }
    
}
