package com.huijianzhu.attendance.definition;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 描述：   部门属性配置类
 *
 * @author 刘梓江
 * @date 2020/5/21  13:17
 */
@Data
public class DeptDefinition {

    /**
     * 部门id
     */
    private Integer deptId;

    /**
     * 部门编号
     */
    @NotBlank
    private String deptNo;

    /**
     * 部门名称
     */
    @NotBlank
    private String deptName;

    /**
     * 部门排序号
     */
    @NotNull
    private Integer deptSort;
}
