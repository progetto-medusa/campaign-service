package com.progettomedusa.campaign_service.model.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorMsg {
    CPGSRV01("CPGSRV01", "Invalid fields:", HttpStatus.BAD_REQUEST),

    CPGSRV02("CPGSRV02", "Bad request", HttpStatus.BAD_REQUEST),

    CPGSRV03 ("CPGSRV03", "Bad request", HttpStatus.BAD_REQUEST),

    CPGSRV04("CPGSRV04", "Bad request", HttpStatus.BAD_REQUEST),

    CPGSRV05("CPGSRV05", "Bad request", HttpStatus.BAD_REQUEST),

    CPGSRV06("CPGSRV06", "Bad request", HttpStatus.BAD_REQUEST),

    CPGSRV07("CPGSRV07", "Activity details not found", HttpStatus.BAD_REQUEST),

    CPGSRV08("CPGSRV08", "Executions details not found", HttpStatus.BAD_REQUEST),

    CPGSRV09("CPGSRV09", "Error from DIM SDK", HttpStatus.BAD_REQUEST),

    CPGSRV10("CPGSRV10", "Error from Decoding Algorithm", HttpStatus.BAD_REQUEST),

    CPGSRV11("CPGSRV11", "Activity already closed", HttpStatus.BAD_REQUEST),

    CPGSRV12("CPGSRV12", "Decryption error", HttpStatus.BAD_REQUEST),

    CPGSRV13("CPGSRV13", "Missing mandatory parameters", HttpStatus.BAD_REQUEST),

    CPGSRV14("CPGSRV14", "Wrong password provided", HttpStatus.INTERNAL_SERVER_ERROR),

    CPGSRV15("CPGSRV15", "User not found in the system", HttpStatus.NOT_FOUND),

    CPGSRV16("CPGSRVV16", "There's already a campaign with that name", HttpStatus.BAD_REQUEST),

    CPGSRV17("CPGSRVV17", "Password must be between 8 and 24 characters", HttpStatus.BAD_REQUEST),

    CPGSRV69("CPGSRV69", "Bad Request: missing parameters", HttpStatus.BAD_REQUEST),

    CPGSRV99("CPGSRV99", "Generic error", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String code;

    private final String message;

    private final HttpStatus httpStatus;

    ErrorMsg(String code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

}
