package exception;

public class EmpException extends  Exception{
    String errorMsg;
    public EmpException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }
    public String getErrorMsg(){
        return errorMsg;
    }
}
