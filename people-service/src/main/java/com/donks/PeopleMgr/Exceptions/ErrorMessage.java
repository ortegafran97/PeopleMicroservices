package com.donks.PeopleMgr.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class ErrorMessage {
    private String message;
    private String detail;
    private String code;
    private String path;
}