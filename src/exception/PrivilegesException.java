package exception;

public class PrivilegesException extends Exception {
    private String errorMsg;

    public PrivilegesException(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
