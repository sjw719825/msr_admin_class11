package com.msr.common.handler;

/**
 * @author tom
 * @version V1.0
 * @Package com.msr.common.handler
 * @date 2020/6/8 14:44
 * @Copyright © 株式会社多言语系统研究所
 */

import com.fasterxml.jackson.core.JsonParseException;
import com.msr.common.constants.ResultCodeEnum;
import com.msr.common.exception.MSRException;
import com.msr.common.util.ExceptionUtil;
import com.msr.common.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理类
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
//        e.printStackTrace();
//        log.error(e.getMessage());
        log.error(ExceptionUtil.getMessage(e));
        return R.error();
    }

    @ExceptionHandler(BadSqlGrammarException.class)
    @ResponseBody
    public R error(BadSqlGrammarException e){
//        e.printStackTrace();
//        log.error(e.getMessage());
        log.error(ExceptionUtil.getMessage(e));
        return R.setResult(ResultCodeEnum.BAD_SQL_GRAMMAR);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public R error(JsonParseException e){
//        e.printStackTrace();
//        log.error(e.getMessage());
        log.error(ExceptionUtil.getMessage(e));
        return R.setResult(ResultCodeEnum.JSON_PARSE_ERROR);
    }

    @ExceptionHandler(MSRException.class)
    @ResponseBody
    public R error(MSRException e){
//        e.printStackTrace();
//        log.error(e.getMessage());
        log.error(ExceptionUtil.getMessage(e));
        return R.error().message(e.getMessage()).code(e.getCode());
    }
}
