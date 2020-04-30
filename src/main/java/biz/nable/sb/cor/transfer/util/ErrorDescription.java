package biz.nable.sb.cor.transfer.util;

public class ErrorDescription {

    private ErrorDescription() {
        throw new IllegalStateException("Error Description class");
    }

    public static final String INPUT_PARAMETERS_ARE_NOT_VALID = "Input parameters are not valid";
    public static final String INTERNAL_SERVER_ERROR = "Internal server error";
}
