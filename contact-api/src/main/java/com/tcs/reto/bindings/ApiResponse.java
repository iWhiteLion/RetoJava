package com.tcs.reto.bindings;

import lombok.Builder;

@Builder
public record ApiResponse(int code, String message, Object data) {

    public static ApiResponse success(Object data) {
        return new ApiResponse(200, "Operación exitosa", data);
    }

    public static ApiResponse notFound(String message) {
        return new ApiResponse(404, message, null);
    }

    public static ApiResponse error(String message) {
        return new ApiResponse(500, message, null);
    }

    public static ApiResponse badRequest(String message) {
        return new ApiResponse(400, message, null);
    }
}
