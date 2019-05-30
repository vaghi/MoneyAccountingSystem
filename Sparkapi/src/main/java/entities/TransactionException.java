package entities;

public class TransactionException extends Exception {
    private final int code;
    private final String errorMessage;

    public TransactionException(int code, String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public int getCode(){ return this.code; }
    public String getErrorMessage(){ return this.errorMessage; }
}
