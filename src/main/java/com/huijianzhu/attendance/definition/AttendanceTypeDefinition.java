package com.huijianzhu.attendance.definition;

import com.huijianzhu.attendance.entity.OaAttendanceType;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 描述：   考勤类型属性定义类
 * @author 刘梓江
 * @date 2020/5/21  16:41
 */
@Data
public class AttendanceTypeDefinition {

    /**
     * 类型id
     */
    private Integer typeId;


    /**
     * 类型编号
     */
    @NotBlank
    private String typeNo;


    /**
     * 类型名称
     */
    @NotBlank
    private String typeName;
}
