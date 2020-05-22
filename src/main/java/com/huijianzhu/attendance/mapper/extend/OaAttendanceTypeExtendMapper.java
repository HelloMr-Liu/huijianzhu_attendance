package com.huijianzhu.attendance.mapper.extend;

import com.huijianzhu.attendance.entity.OaAttendanceType;
import com.huijianzhu.attendance.mapper.OaAttendanceTypeMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 描述：操作考勤类型信息数据mapper扩展接口
 *
 * @author 刘梓江
 * @date 2020/5/21  16:16
 */
public interface OaAttendanceTypeExtendMapper extends OaAttendanceTypeMapper {

    /**
     * 获取所有有效考勤类型信息
     * @param delFlag 删除标志
     * @return
     */
    @Select(" select * from oa_attendance_type where is_delete=#{delFlag} ORDER BY type_no ")
    List<OaAttendanceType> findAll(String delFlag);


    /**
     * 获取指定类型名称下的考勤类型
     * @param type
     * @param delFlag
     * @return
     */
    @Select({"<script>",
            " select * from  " ,
            " (select *  from oa_attendance_type where type_name=#{type.typeName} or type_no=#{type.typeNo}) temp1 ",
            " where temp1.is_delete=#{delFlag} ",
            " <if test='type.typeId!=null'>",
            "  and type_id!=#{type.typeId}  " ,
            " </if>",
            "</script>"})
    List<OaAttendanceType> findOneByName(OaAttendanceType type,String delFlag);


}