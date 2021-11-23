package sunat.api;

public class Result {
    private long result;
    private String message;

    public Result(long result, String message) {
        this.result = result;
        this.message = message;
    }

    public long getResult() {
        return result;
    }

    public void setResult(long result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
