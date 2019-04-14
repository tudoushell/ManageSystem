package exception;

public class HolidayException extends Exception {
    private String errorMsg;
    public HolidayException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
