package exception;

public class DeptException extends Exception {
    private String errorMsg;

    public DeptException(String errorMsg){
        super(errorMsg);
        this.errorMsg = errorMsg;
    }
    
    public String getErrorMsg(){
        return errorMsg;
    }

}
