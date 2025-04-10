package InventoryManager;

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
    
    
    public String getNotes() {
        return notes;
    }
    
    public void setNotes(String notes){
        this.notes = notes;
        System.out.println(getName() + " notes successfully updated.");
    }
    
    @Override
    public String toString(){
        return super.toString() + "Notes: " + notes;
    }
    
}
