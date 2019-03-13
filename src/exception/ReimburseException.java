package exception;

public class ReimburseException extends Exception {
    private String ErrorMsg;
    public ReimburseException(String errorMsg) {
        super(errorMsg);
        this.ErrorMsg = errorMsg;
    }
    public String getErrorMsg() {
        return ErrorMsg;
    }
}
