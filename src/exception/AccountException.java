package exception;

public class AccountException extends Exception {
    private String errorMsg;

    public AccountException(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
