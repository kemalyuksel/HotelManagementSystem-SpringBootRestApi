package com.soyukkahve.myhotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RoomIsNotEnabledException extends RuntimeException{

    public RoomIsNotEnabledException(String message) {
        super(message);
    }
}
