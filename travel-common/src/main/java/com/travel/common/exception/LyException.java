package com.travel.common.exception;

import com.travel.common.enmus.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LyException extends RuntimeException {

    private ExceptionEnum exceptionEnum;
}
