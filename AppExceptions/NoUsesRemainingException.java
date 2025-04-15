package InventoryManager.AppExceptions;
// Abhishek
public class NoUsesRemainingException extends InventoryException {
    private String itemName;  // Name of the consumable item
    private int usesRemaining; // Remaining uses of the consumable item

    // Constructor to initialize the exception with relevant details
    public NoUsesRemainingException(String message, String errorCode, String itemName, int usesRemaining) {
        super(message, errorCode); // Pass message and error code to the parent class
        this.itemName = itemName;
        this.usesRemaining = usesRemaining;
    }

    // Getters for additional fields
    public String getItemName() {
        return itemName;
    }

    public int getUsesRemaining() {
        return usesRemaining;
    }

    @Override
    public String toString() {
        return "NoUsesRemainingException{" +
                "errorCode='" + getErrorCode() + '\'' +
                ", message='" + getMessage() + '\'' +
                ", itemName='" + itemName + '\'' +
                ", usesRemaining=" + usesRemaining +
                '}';
    }
}

