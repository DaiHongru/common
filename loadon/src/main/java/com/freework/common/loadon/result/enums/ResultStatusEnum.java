package com.freework.common.loadon.result.enums;

/**
 * @author daihongru
 */

public enum ResultStatusEnum {
    /**
     * 枚举字段
     */
    OK(200, "请求已经成功处理"),
    BAD_REQUEST(400, "请求错误"),
    UNAUTHORIZED(401, "没有认证或者认证已经失效"),
    NOT_FOUND(404, "资源未找到"),
    INTERNAL_SERVER_ERROR(500, "服务器错误");

    /**
     * 状态表示
     */
    private int state;

    /**
     * 状态说明
     */
    private String stateInfo;

    ResultStatusEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    /**
     * 依据传入的state返回相应的enum值
     */
    public static ResultStatusEnum stateOf(int state) {
        for (ResultStatusEnum stateEnum : values()) {
            if (stateEnum.getState() == state) {
                return stateEnum;
            }
        }
        return null;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }
}
