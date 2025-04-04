package InventoryManager.AppExceptions;

public class ItemNotFoundException extends InventoryException {
    private String itemName; // Name of the item that was not found

    // Constructor to initialize the exception with relevant details
    public ItemNotFoundException(String message, String errorCode, String itemName) {
        super(message, errorCode); // Pass message and error code to the parent class
        this.itemName = itemName;
    }

    // Getter for the name of the missing item
    public String getItemName() {
        return itemName;
    }

    @Override
    public String toString() {
        return "ItemNotFoundException{" +
                "errorCode='" + getErrorCode() + '\'' +
                ", message='" + getMessage() + '\'' +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}