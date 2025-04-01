public abstract class InventoryException extends Exception {
    private String errorCode; // Common field for all inventory exceptions

    // Constructor to initialize error message and error code
    protected InventoryException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    // Common functionality for all inventory exceptions
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String toString() {
        return "InventoryException{" +
                "errorCode='" + errorCode + '\'' +
                ", message='" + getMessage() + '\'' +
                '}';
    }
}

public class FullInventoryException extends InventoryException {
    private int currentSize; // Current size of the inventory
    private int maxSize;     // Maximum size of the inventory

    // Constructor to initialize the exception with relevant details
    public FullInventoryException(String message, String errorCode, int currentSize, int maxSize) {
        super(message, errorCode); // Pass message and error code to the parent class
        this.currentSize = currentSize;
        this.maxSize = maxSize;
    }

    // Getters for additional fields
    public int getCurrentSize() {
        return currentSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    @Override
    public String toString() {
        return "FullInventoryException{" +
                "errorCode='" + getErrorCode() + '\'' +
                ", message='" + getMessage() + '\'' +
                ", currentSize=" + currentSize +
                ", maxSize=" + maxSize +
                '}';
    }
}

// in caller block
// if (currentSize >= maxSize) {
//     throw new FullInventoryException(
//         "Inventory is full. Cannot add more items.",
//         "FULL_INVENTORY_ERROR",
//         currentSize,
//         maxSize
//     );
// }

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

// if (!inventory.contains(itemName)) {
//     throw new ItemNotFoundException(
//         "Item not found in the inventory.",
//         "ITEM_NOT_FOUND_ERROR",
//         itemName
//     );
// }

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

// if (usesRemaining == 0) {
//     throw new NoUsesRemainingException(
//         "No uses remaining for this item.",
//         "NO_USES_REMAINING_ERROR",
//         itemName,
//         usesRemaining
//     );
// }

public class InvalidItemException extends InventoryException {
    private String invalidField; // Name of the invalid field
    private Object invalidValue; // Value causing the issue

    // Constructor to initialize the exception with relevant details
    public InvalidItemException(String message, String errorCode, String invalidField, Object invalidValue) {
        super(message, errorCode); // Pass message and error code to the parent class
        this.invalidField = invalidField;
        this.invalidValue = invalidValue;
    }

    // Getters for additional fields
    public String getInvalidField() {
        return invalidField;
    }

    public Object getInvalidValue() {
        return invalidValue;
    }

    @Override
    public String toString() {
        return "InvalidItemException{" +
                "errorCode='" + getErrorCode() + '\'' +
                ", message='" + getMessage() + '\'' +
                ", invalidField='" + invalidField + '\'' +
                ", invalidValue=" + invalidValue +
                '}';
    }
}

// if (weight < 0 || value < 0 || name == null || name.isEmpty()) {
//     throw new InvalidItemException(
//         "Invalid item properties provided.",
//         "INVALID_ITEM_ERROR",
//         "weight or name",
//         weight < 0 ? weight : name
//     );
// }

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

// if (inventory.contains(itemName)) {
//     throw new DuplicateItemException(
//         "Item already exists in the inventory.",
//         "DUPLICATE_ITEM_ERROR",
//         itemName
//     );
// }