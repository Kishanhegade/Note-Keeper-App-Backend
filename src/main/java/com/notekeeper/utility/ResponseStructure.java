package com.notekeeper.utility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseStructure<T> {
    private Integer status;
    private String message;
    private T data;

    public static <T>ResponseStructure<T> create(int status, String message, T data) {
        ResponseStructure<T> structure = new ResponseStructure<>();
        structure.setStatus(status);
        structure.setMessage(message);
        structure.setData(data);
        return structure;
    }
}
