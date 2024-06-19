package Claridad.Response;

public class SuccessResponse extends Response {
    private Object data;

    public SuccessResponse(Object data) {
        super("success");
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
