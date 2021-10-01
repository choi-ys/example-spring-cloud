package springcloud.gateway.filter;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : choi-ys
 * @date : 2021-09-29 오후 4:38
 */
@Getter
public class ErrorResponse {
    private String message;
    private LocalDateTime timestamp;
    private Map<String, Object> errorDetails = new HashMap<>();

    public ErrorResponse(String message, LocalDateTime timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    public static ErrorResponse defaultBuild(String errorMessage) {
        return new ErrorResponse(errorMessage, LocalDateTime.now());
    }
}
