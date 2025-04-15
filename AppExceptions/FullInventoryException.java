package InventoryManager.AppExceptions;
// Abhishek
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
