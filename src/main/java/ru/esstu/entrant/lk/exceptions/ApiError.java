package ru.esstu.entrant.lk.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class ApiError {
    private HttpStatus status;
    private String message;
    private Map<String, Object> params;

    public ApiError(HttpStatus status, String message, Map<String, Object> params) {
        this.status = status;
        this.message = message;
        this.params = params;
    }

    public static ApiErrorBuilder builder() {
        return new ApiErrorBuilder();
    }

    public static class ApiErrorBuilder {
        private HttpStatus status;
        private String message;
        private Map<String, Object> params = new HashMap<>();

        ApiErrorBuilder() {
        }

        public ApiErrorBuilder status(HttpStatus status) {
            this.status = status;
            return this;
        }

        public ApiErrorBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ApiErrorBuilder params(Map<String, Object> params) {
            this.params = params;
            return this;
        }

        public ApiErrorBuilder addParam(String key, Object value) {
            this.params.put(key, value);
            return this;
        }

        public ApiError build() {
            return new ApiError(status, message, params);
        }

    }
}
