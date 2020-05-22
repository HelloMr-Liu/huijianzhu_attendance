package com.huijianzhu.attendance.service;

import com.huijianzhu.attendance.definition.AttendanceUserDefinition;
import com.huijianzhu.attendance.vo.SystemResult;

/**
 * 描述：考勤业务接口
 *
 * @author 刘梓江
 * @date 2020/5/22  16:18
 */
public interface AttendanceUserService {


    /**
     * 按照指定查询条件查询对应的考勤用户信息集
     * @param definition 考勤用户属性定义类
     * @return
     */
    public SystemResult findAllByQuery(AttendanceUserDefinition definition);


    /**
     * 添加考勤人员信息
     * @param definition 考勤用户属性定义类
     * @return
     */
    public SystemResult add(AttendanceUserDefinition definition);


    /**
     * 按照指定用户编号获取对应考勤人员信息
     * @param userNo 用户编号
     * @return
     */
    public SystemResult findOneByUserNo(String userNo);


    /**
     * 修改考勤人员信息
     * @param definition
     * @return
     */
    public SystemResult update(AttendanceUserDefinition definition);


    /**
     * 删除指定的考勤用户信息
     * @param userNos 用户编号集
     * @return
     */
    public SystemResult deleteById(String userNos);

    /**
     * 修改用户离职状态信息
     * @param userNos  用户编号集
     * @return
     */
    public SystemResult updateUserDepartureState(String userNos);
}