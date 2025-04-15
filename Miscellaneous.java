package InventoryManager;

/**
 *
 * @author abbyf
 */
// Veevek + Abby
class Miscellaneous extends Item{
    private String notes;
    
    // Constructor for Miscellaneous
    // Abby
    public Miscellaneous(String name, double value, double weight, String notes) {
        super(name, value, weight);
        this.notes = notes;
        category = ItemCategory.MISCELLANEOUS;
    }
    
    // Getter
    // Veevek
    public String getNotes() {
        return notes;
    }
    
    // Setter
    // Veevek    
    public void setNotes(String notes){
        this.notes = notes;
        System.out.println(getName() + " notes successfully updated.\n");
    }
    
    @Override
    public String toString(){
        // Veevek
        return super.toString() + "Notes: " + notes  + "\n";
    }
    
}
