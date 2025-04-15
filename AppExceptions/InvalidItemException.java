package InventoryManager.AppExceptions;
// Abhishek
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