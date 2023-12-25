package org.marinfo.mapleinfobe.exception;


import lombok.Getter;

import java.io.Serial;

@Getter
public class NexonOpenApiException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -6935126581413147239L;
    private final String name;
    private final String message;

    public NexonOpenApiException() {
        super("Nexon Open Api 요청 실패.");
        this.name = "";
        this.message = "Nexon Open Api 요청 실패.";
    }

    public NexonOpenApiException(String name, String message) {
        super(message);
        this.name = name;
        this.message = message;
    }


}
