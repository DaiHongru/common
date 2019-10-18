package com.freework.common.loadon.exception;

import com.freework.common.loadon.result.entity.ResultVo;
import com.freework.common.loadon.result.enums.ResultStatusEnum;
import com.freework.common.loadon.result.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author daihongru
 */
@ControllerAdvice
public class ExceptionHandle {
    private static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultVo handler(Exception e) {
        logger.error("系统异常：" + e);
        return ResultUtil.error(ResultStatusEnum.INTERNAL_SERVER_ERROR);
    }
}
