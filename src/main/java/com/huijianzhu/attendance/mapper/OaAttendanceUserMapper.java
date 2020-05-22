package com.huijianzhu.attendance.mapper;

import com.huijianzhu.attendance.entity.OaAttendanceUser;

public interface OaAttendanceUserMapper {
    int deleteByPrimaryKey(String userNo);

    int insert(OaAttendanceUser record);

    int insertSelective(OaAttendanceUser record);

    OaAttendanceUser selectByPrimaryKey(String userNo);

    int updateByPrimaryKeySelective(OaAttendanceUser record);

    int updateByPrimaryKey(OaAttendanceUser record);
}