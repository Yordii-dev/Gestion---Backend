package Claridad.Response;

public class FailResponse extends Response {
    private String message;
    private String details;

    public FailResponse(String message, String details) {
        super("fail");
        this.message = message;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
