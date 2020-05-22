package com.huijianzhu.attendance.mapper.extend;

import com.huijianzhu.attendance.entity.OaDept;
import com.huijianzhu.attendance.mapper.OaDeptMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 描述：   操作部门信息数据mapper扩展接口
 * @author 刘梓江
 * @date 2020/5/21  13:23
 */
public interface OaDeptExtendMapper  extends OaDeptMapper {

    /**
     * 获取所有有效的部门信息
     * @param deleteFlag    删除标志
     * @param deptName      部门名称
     * @return
     */
    @Select({"<script>",
             "select * from oa_dept  " +
             "where  is_delete=#{deleteFlag}  " +
             "<if test='deptName!=null'>",
                "and dept_name like  concat('%',#{deptName},'%') " +
             "</if>",
             "order by dept_sort asc ,create_time  desc ",
             "</script>"})
    List<OaDept> findAll(String deptName,String deleteFlag);


    /**
     * 通过指定条件获取对应的部门信息
     * @param dept          部门信息
     * @param deleteFlag    删除标志

     * @return
     */
    @Select({"<script>",
             "select * from  " ,
             "(select * from  oa_dept  where is_delete=#{deleteFlag} and dept_name=#{dept.deptName} ",
              "or is_delete=#{deleteFlag} and  dept_no=#{dept.deptNo} ) temp1  " ,
             "<if test='dept.deptId!=null'>",
              "where temp1.dept_id!=#{dept.deptId}",
             "</if>",
             "</script>"})
    List<OaDept>  findDeptContent(OaDept dept,String deleteFlag);
}