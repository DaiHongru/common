package com.freework.common.loadon.enums;

/**
 * @author daihongru
 */

public enum NewsStateEnum {
    /**
     * 枚举字段
     */
    UNREAD(0, "投递中"),
    READ(1, "已通过");

    public final static String NEWS_TYPE_ENTERPRISE = "enterprise";
    public final static String NEWS_TYPE_USER = "user";

    /**
     * 状态表示
     */
    private int state;

    /**
     * 状态说明
     */
    private String stateInfo;

    NewsStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    /**
     * 依据传入的state返回相应的enum值
     */
    public static NewsStateEnum stateOf(int state) {
        for (NewsStateEnum stateEnum : values()) {
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
