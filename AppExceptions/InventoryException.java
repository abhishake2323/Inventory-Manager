package InventoryManager.AppExceptions;


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


//Usage
// in caller block
// if (currentSize >= maxSize) {
//     throw new FullInventoryException(
//         "Inventory is full. Cannot add more items.",
//         "FULL_INVENTORY_ERROR",
//         currentSize,
//         maxSize
//     );
// }


// if (!inventory.contains(itemName)) {
//     throw new ItemNotFoundException(
//         "Item not found in the inventory.",
//         "ITEM_NOT_FOUND_ERROR",
//         itemName
//     );
// }

// if (usesRemaining == 0) {
//     throw new NoUsesRemainingException(
//         "No uses remaining for this item.",
//         "NO_USES_REMAINING_ERROR",
//         itemName,
//         usesRemaining
//     );
// }



// if (weight < 0 || value < 0 || name == null || name.isEmpty()) {
//     throw new InvalidItemException(
//         "Invalid item properties provided.",
//         "INVALID_ITEM_ERROR",
//         "weight or name",
//         weight < 0 ? weight : name
//     );
// }



// if (inventory.contains(itemName)) {
//     throw new DuplicateItemException(
//         "Item already exists in the inventory.",
//         "DUPLICATE_ITEM_ERROR",
//         itemName
//     );
// }