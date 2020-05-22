package com.huijianzhu.attendance.controller;

import com.huijianzhu.attendance.definition.DeptDefinition;
import com.huijianzhu.attendance.service.DeptService;
import com.huijianzhu.attendance.vo.SystemResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：   部门信息请求接口控制器
 *
 * @author 刘梓江
 * @date 2020/5/21  14:59
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/dept")
public class DeptController {

    /**
     * 注入：部门信息业务接口
     */
    @Autowired
    private DeptService deptService;


    /**
     * 获取所有部门信息(默认查询全部)
     * @param deptName 部门名称
     * @return
     */
    @PostMapping("/findAll/query")
    public SystemResult findAll(String deptName){
        return deptService.findAll(deptName);
    }
    /**
     * 添加一个部门信息
     * @param deptDefinition 部门属性定义类
     * @return
     */
    @PostMapping("/add")
    public SystemResult add(DeptDefinition deptDefinition){
        return deptService.add(deptDefinition);
    }

    /**
     * 获取指定部门编号
     * @param deptId 部门id
     * @return
     */
    @PostMapping("/one/id")
    public SystemResult one(Integer deptId){
        return deptService.one(deptId);
    }

    /**
     * 修改部门信息
     * @param deptDefinition 部门属性定义类
     * @return
     */
    @PostMapping("/update")
    public SystemResult update(DeptDefinition deptDefinition){
        return deptService.update(deptDefinition);
    }

    /**
     * 删除部门信息
     * @param deptId 部门id
     * @return
     */
    @PostMapping("/delete/id")
    public SystemResult delete(Integer deptId){
        return deptService.delete(deptId);
    }
}
