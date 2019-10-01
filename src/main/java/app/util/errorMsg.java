package app.util;

public enum errorMsg {
    SUCESS("OK"),
    FAIL001("WrongPass"),
    FAIL002("EmptyPass"),
    Fail003("EmptyID"),
    Fail004("UnknownID");

    private final String msg;
    errorMsg(String msg){
        this.msg = msg;
    }
    public String getMsg(){
        return msg;
    }
}
