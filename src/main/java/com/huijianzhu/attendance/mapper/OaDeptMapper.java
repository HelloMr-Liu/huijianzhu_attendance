package com.huijianzhu.attendance.mapper;

import com.huijianzhu.attendance.entity.OaDept;

public interface OaDeptMapper {
    int deleteByPrimaryKey(Integer deptId);

    int insert(OaDept record);

    int insertSelective(OaDept record);

    OaDept selectByPrimaryKey(Integer deptId);

    int updateByPrimaryKeySelective(OaDept record);

    int updateByPrimaryKey(OaDept record);
}