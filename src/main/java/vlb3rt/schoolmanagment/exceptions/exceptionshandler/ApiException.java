package vlb3rt.schoolmanagment.exceptions.exceptionshandler;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiException {

    private String message;
    private HttpStatus httpStatus;
    private ZonedDateTime time;

    public ApiException(
            String message,
            HttpStatus httpStatus,
            ZonedDateTime time
    ) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public void setTime(ZonedDateTime time) {
        this.time = time;
    }
}
