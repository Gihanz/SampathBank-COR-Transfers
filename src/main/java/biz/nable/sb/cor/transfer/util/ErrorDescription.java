package biz.nable.sb.cor.transfer.util;

public class ErrorDescription {

    private ErrorDescription() {
        throw new IllegalStateException("Error Description class");
    }

    public static final String INPUT_PARAMETERS_ARE_NOT_VALID = "Input parameters are not valid";
    public static final String INTERNAL_SERVER_ERROR = "Internal server error";
    public static final String NO_TRANSFER_RECORD_FOUND = "No transfer record found";
    public static final String NO_TRANSFER_HISTORY_RECORD_FOUND = "No transfer history record found";
    public static final String NO_COMMISSION_COLLECTION_RECORD_FOUND = "No commission collection record found";
    
    public static final String GET_FAILD_TRANSFER_DETAILS_SUCCESS = "Successfully retrieve failed transfer details";
    
    public static final String SUCCESS = "Successfully retrieve transfer details ";
}
