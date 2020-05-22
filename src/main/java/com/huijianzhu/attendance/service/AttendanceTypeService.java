package com.huijianzhu.attendance.service;

import com.huijianzhu.attendance.definition.AttendanceTypeDefinition;
import com.huijianzhu.attendance.vo.SystemResult;

/**
 * 描述：   考勤类型业务接口
 *
 * @author 刘梓江
 * @date 2020/5/21  16:32
 */
public interface AttendanceTypeService {


    /**
     * 获取所有考勤类型信息
     * @return
     */
    public SystemResult findAll();


    /**
     * 添加考勤类型信息
     * @param definition 考勤属性信息
     * @return
     */
    public SystemResult add(AttendanceTypeDefinition definition);


    /**
     * 获取指定考勤类型
     * @param typeId 考勤类型id
     * @return
     */
    public SystemResult findOne(Integer typeId);


    /**
     * 修改考勤类型信息
     * @param definition 考勤属性信息
     * @return
     */
    public SystemResult update(AttendanceTypeDefinition definition);


    /**
     * 删除指定考勤类型
     * @param typeId 考勤类型id
     * @return
     */
    public SystemResult deleteById(Integer typeId);


}