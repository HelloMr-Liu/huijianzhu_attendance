package com.huijianzhu.attendance.definition;

import com.huijianzhu.attendance.entity.OaAttendanceRecordResult;
import com.huijianzhu.attendance.entity.OaAttendanceUser;
import lombok.Data;

/**
 * 描述：考勤人员属性定义类
 *
 * @author 刘梓江
 * @date 2020/5/22  15:37
 */
@Data
public class AttendanceUserDefinition   {


    /**
     * 用户id
     */
    private String userId;


    /**
     * 部门信息id
     */
    private String deptId;


    /**
     * 部门编号信息
     */
    private String deptNo;


    /**
     *
     * 考勤人员名称
     */
    private String userName;


    /**
     * 是否离职 YES、NO
     */
    private String isDeparture;

    /**
     * 文件类型 1入职文件 2：人员考勤文件
     */
    private String fileType;


    private String uSex;
    private String uAddress;
}
