package com.huijianzhu.attendance.enums;

/**
 * 描述：考勤人员表字段状态信息
 *
 * @author 刘梓江
 * @date 2020/5/22  12:02
 */
 public enum ATTENDANCE_USER_TABLE_STATE {
    YES_DEPARTURE("YES","代表已经离职"),
    NO_DEPARTURE("NO",  "代表没有离职");

    public String KEY;       //反馈的值
    public String VALUE;     //反馈的描述信息
    ATTENDANCE_USER_TABLE_STATE(String state,String mess){
        this.KEY=state;
        this.VALUE=mess;
    }
}