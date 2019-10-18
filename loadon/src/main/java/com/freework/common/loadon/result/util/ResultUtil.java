package com.freework.common.loadon.result.util;


import com.freework.common.loadon.result.entity.ResultVo;
import com.freework.common.loadon.result.enums.ResultStatusEnum;

/**
 * @author daihongru
 */
public class ResultUtil {
    public static ResultVo success(Object object) {
        ResultVo resultVo = new ResultVo<>();
        resultVo.setSuccess(true);
        resultVo.setCode(ResultStatusEnum.OK.getState());
        resultVo.setMsg(ResultStatusEnum.OK.getStateInfo());
        resultVo.setData(object);
        return resultVo;
    }

    public static ResultVo success() {
        ResultVo resultVo = new ResultVo<>();
        resultVo.setSuccess(true);
        resultVo.setCode(ResultStatusEnum.OK.getState());
        resultVo.setMsg(ResultStatusEnum.OK.getStateInfo());
        return resultVo;
    }

    public static ResultVo error(ResultStatusEnum statusEnum) {
        ResultVo resultVo = new ResultVo<>();
        resultVo.setSuccess(false);
        resultVo.setCode(statusEnum.getState());
        resultVo.setMsg(statusEnum.getStateInfo());
        return resultVo;
    }
}
