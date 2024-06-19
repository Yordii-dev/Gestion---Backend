package Claridad.Response;

public class ErrorResponse extends Response {
    private String statusText;

    public ErrorResponse(String statusText) {
        super("error");
        this.statusText = "Error de servidor: " + statusText;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }
}
