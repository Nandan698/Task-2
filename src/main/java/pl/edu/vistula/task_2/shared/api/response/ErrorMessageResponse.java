package pl.edu.vistula.task_2.shared.api.response;


public class ErrorMessageResponse
{
    private final String message;

    public ErrorMessageResponse(String message)
    {
        this.message = message;
    }
    public String getMessage()
    {
        return message;
    }
}