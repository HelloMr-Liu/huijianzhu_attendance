package com.huijianzhu.attendance.controller;

import com.huijianzhu.attendance.definition.AttendanceTypeDefinition;
import com.huijianzhu.attendance.service.AttendanceTypeService;
import com.huijianzhu.attendance.vo.SystemResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：考勤类型请求接口控制器
 *
 * @author 刘梓江
 * @date 2020/5/21  17:34
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/attendance/type")
public class AttendanceTypeController {


    /**
     * 注入：考勤类型业务接口
     */
    @Autowired
    private AttendanceTypeService attendanceTypeService;


    /**
     * 获取所有考勤类型信息
     * @return
     */
    @PostMapping("/find/all")
    public SystemResult findAll(){
        return attendanceTypeService.findAll();
    }


    /**
     * 添加考勤类型信息
     * @param definition 考勤属性信息
     * @return
     */
    @PostMapping("/add")
    public SystemResult add(AttendanceTypeDefinition definition){
        return attendanceTypeService.add(definition);
    }


    /**
     * 获取指定考勤类型
     * @param typeId 考勤类型id
     * @return
     */
    @PostMapping("/find/id")
    public SystemResult findOne(Integer typeId){
        return attendanceTypeService.findOne(typeId);
    }


    /**
     * 修改考勤类型信息
     * @param definition 考勤属性信息
     * @return
     */
    @PostMapping("/update")
    public SystemResult update(AttendanceTypeDefinition definition){
        return attendanceTypeService.update(definition);
    }


    /**
     * 删除指定考勤类型
     * @param typeId 考勤类型id
     * @return
     */
    @PostMapping("/delete/id")
    public SystemResult deleteById(Integer typeId){
        return attendanceTypeService.deleteById(typeId);

    }
}
