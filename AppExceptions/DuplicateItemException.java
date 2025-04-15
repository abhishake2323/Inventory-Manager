package InventoryManager.AppExceptions;
// Abhishek
public class DuplicateItemException extends InventoryException {
    private String itemName; // Name of the duplicate item

    // Constructor to initialize the exception with relevant details
    public DuplicateItemException(String message, String errorCode, String itemName) {
        super(message, errorCode); // Pass message and error code to the parent class
        this.itemName = itemName;
    }

    // Getter for the name of the duplicate item
    public String getItemName() {
        return itemName;
    }

    @Override
    public String toString() {
        return "DuplicateItemException{" +
                "errorCode='" + getErrorCode() + '\'' +
                ", message='" + getMessage() + '\'' +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}