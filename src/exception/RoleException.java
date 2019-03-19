package exception;

public class RoleException extends Exception {
    private String errorMsg;

    public RoleException(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
