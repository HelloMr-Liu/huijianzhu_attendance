package com.huijianzhu.attendance.service;

import com.huijianzhu.attendance.definition.DeptDefinition;
import com.huijianzhu.attendance.vo.SystemResult;

/**
 * 描述：   考勤部门信息业务接口
 *
 * @author 刘梓江
 * @date 2020/5/21  13:15
 */
public interface DeptService {


    /**
     * 获取所有部门信息(默认查询全部)
     * @param deptName 部门名称
     * @return
     */
    public SystemResult findAll(String deptName);

    /**
     * 添加一个部门信息
     * @param deptDefinition 部门属性定义类
     * @return
     */
    public SystemResult add(DeptDefinition deptDefinition);

    /**
     * 获取指定部门编号
     * @param deptId 部门id
     * @return
     */
    public SystemResult one(Integer deptId);


    /**
     * 修改部门信息
     * @param deptDefinition 部门属性定义类
     * @return
     */
    public SystemResult update(DeptDefinition deptDefinition);


    /**
     * 删除部门信息
     * @param deptId 部门id
     * @return
     */
    public SystemResult delete(Integer deptId);

}