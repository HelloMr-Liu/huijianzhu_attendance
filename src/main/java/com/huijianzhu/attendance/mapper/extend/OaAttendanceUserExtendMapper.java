package com.huijianzhu.attendance.mapper.extend;

import com.huijianzhu.attendance.definition.AttendanceUserDefinition;
import com.huijianzhu.attendance.entity.OaAttendanceUser;
import com.huijianzhu.attendance.mapper.OaAttendanceUserMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 描述：操作考勤人员信息数据mapper扩展接口
 *
 * @author 刘梓江
 * @date 2020/5/22  16:00
 */
public interface OaAttendanceUserExtendMapper extends OaAttendanceUserMapper {

    /**
     * 获取所有有效人员[在职、离职]对应的部门编号或人员名称(默认查询所有)
     * @param definition  考勤人员属性定义类
     * @param delFlag     删除标志
     * @return
     */
    @Select({"<script>",
             "select * from  " ,
                     "  ( " ,
                     "   select * from (select * from oa_attendance_user ",
                                        "<if test='def.deptNo!=null || def.userName!=null'>" ,
                                            "where",
                                                "<if test='def.deptNo!=null'>" ,
                                                "  dept_no=#{def.deptNo}  " ,
                                                "</if>",

                                                "<if test=' def.deptNo!=null and def.userName !=null'>" ,
                                                    " and ",
                                                "</if>",

                                                "<if test=' def.userName !=null'>" ,
                                                    " user_name like  concat('%',#{ def.userName },'%')  " ,
                                                "</if>",
                                        "</if>",
                                        ")" ,
                     "   temp1 where temp1.is_delete=#{delFlag} and temp1.is_departure=#{def.isDeparture} " ,
                     "  )temp2  left join oa_attendance_file temp3 on temp2.user_id=temp3.uniqueness_id " ,
                     "  where temp3.is_delete=#{delFlag}  and temp3.file_type=#{fileType} " ,
                     "  ORDER BY temp2.create_time DESC",
            "</script>"})
    List<OaAttendanceUser> findAllByQuery(@Param("def") AttendanceUserDefinition definition, String delFlag,String fileType);


    /**
     * 批量逻辑修改删除
     * @param updateUsers   对应的考勤用户信息
     * @param delFlag      删除标志
     */
    @Update
    ({
        "<script> " ,
            " UPDATE  oa_attendance_user",
            " <trim prefix ='set' prefixOverrides=',' > " ,
    

                "<trim prefix ='is_delete = case' suffix='end,'>",
                    "<foreach collection ='users' item ='item' index = 'index'> ",
                    "when user_no = #{item.userNo} then #{delFlag} "  ,
                    "</foreach>" ,
                "</trim> " ,

                "<trim prefix ='update_time = case' suffix='end,'>",
                    "<foreach collection ='users' item ='item' index = 'index'> ",
                    "when user_no = #{item.userNo} then #{item.updateTime} ",
                    "</foreach>",
                "</trim> ",

                "<trim prefix ='update_user_no = case' suffix='end,'>",
                    "<foreach collection ='users' item ='item' index = 'index'> ",
                    "when user_no = #{item.userNo} then #{item.updateUserNo} ",
                    "</foreach>",
                "</trim> ",
    
                "<trim prefix ='update_user_name = case' suffix='end'>",
                    "<foreach collection ='users' item ='item' index = 'index'> ",
                    "when user_no = #{item.userNo} then #{item.updateUserName} ",
                    "</foreach>",
                "</trim> ",

            " </trim> ",
            " WHERE user_no in " ,
            " (" ,
            "<foreach collection='users' item='item' index='index' separator=','>",
                " #{item.userNo}",
            "</foreach>",
            " )" ,
        "</script>"
    })
    void batchDelete(@Param("users") List<OaAttendanceUser> updateUsers,String delFlag);


    /**
     * 批量逻辑修改离职状态
     * @param updateUsers      对应的考勤用户信息
     * @param isDeparture      批量离职
     */
    @Update
    ({
        "<script> " ,
            " UPDATE  oa_attendance_user",
            " <trim prefix ='set' prefixOverrides=',' > " ,

                "<trim prefix ='is_departure = case' suffix='end,'>",
                    "<foreach collection ='users' item ='item' index = 'index'> ",
                    "when user_no = #{item.userNo} then #{isDeparture} "  ,
                    "</foreach>" ,
                "</trim> " ,

                "<trim prefix ='update_time = case' suffix='end,'>",
                    "<foreach collection ='users' item ='item' index = 'index'> ",
                    "when user_no = #{item.userNo} then #{item.updateTime} ",
                    "</foreach>",
                "</trim> ",

                "<trim prefix ='update_user_no = case' suffix='end,'>",
                    "<foreach collection ='users' item ='item' index = 'index'> ",
                    "when user_no = #{item.userNo} then #{item.updateUserNo} ",
                    "</foreach>",
                "</trim> ",

                "<trim prefix ='update_user_name = case' suffix='end'>",
                    "<foreach collection ='users' item ='item' index = 'index'> ",
                    "when user_no = #{item.userNo} then #{item.updateUserName} ",
                    "</foreach>",
                "</trim> ",

            " </trim> ",
            " WHERE user_no in " ,
            " (" ,
            "<foreach collection='users' item='item' index='index' separator=','>",
                " #{item.userNo}",
            "</foreach>",
            " )" ,
        "</script>"
    })
    void batchDeparture(@Param("users") List<OaAttendanceUser> updateUsers,String isDeparture);




}