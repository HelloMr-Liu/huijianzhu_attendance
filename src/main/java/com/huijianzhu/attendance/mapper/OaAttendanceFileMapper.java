package com.huijianzhu.attendance.mapper;

import com.huijianzhu.attendance.entity.OaAttendanceFile;

public interface OaAttendanceFileMapper {
    int deleteByPrimaryKey(String fileId);

    int insert(OaAttendanceFile record);

    int insertSelective(OaAttendanceFile record);

    OaAttendanceFile selectByPrimaryKey(String fileId);

    int updateByPrimaryKeySelective(OaAttendanceFile record);

    int updateByPrimaryKey(OaAttendanceFile record);
}