package com.huijianzhu.attendance.service.impl;

import cn.hutool.core.util.StrUtil;
import com.huijianzhu.attendance.definition.AttendanceUserDefinition;
import com.huijianzhu.attendance.entity.OaAttendanceUser;
import com.huijianzhu.attendance.enums.ATTENDANCE_USER_TABLE_STATE;
import com.huijianzhu.attendance.enums.GLOBAL_TABLE_FILED_STATE;
import com.huijianzhu.attendance.mapper.extend.OaAttendanceUserExtendMapper;
import com.huijianzhu.attendance.service.AttendanceUserService;
import com.huijianzhu.attendance.vo.SystemResult;
import lombok.Generated;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述： 考勤人员信息业务接口
 *
 * @author 刘梓江
 * @date 2020/5/22  18:18
 */
@Slf4j
@Service
public class AttendanceUserServiceImpl  implements AttendanceUserService {


    /**
     * 注入：操作考勤人员信息数据mapper扩展接口
     */
    @Autowired
    private OaAttendanceUserExtendMapper oaAttendanceUserExtendMapper;



    /**
     * 按照指定查询条件查询对应的用户入职信息集
     * @param definition 考勤用户属性定义类
     * @return
     */
    public SystemResult findAllByQuery(AttendanceUserDefinition definition){

        //封装查询条件（部门编号、用户名称、是否离职）
        definition.setDeptNo(StrUtil.hasBlank(definition.getDeptNo())?null:definition.getDeptNo());
        definition.setUserName(StrUtil.hasBlank(definition.getUserName())?null:definition.getUserName());
        //默认是未离职标志
        String isDeparture= ATTENDANCE_USER_TABLE_STATE.NO_DEPARTURE.KEY;
        definition.setIsDeparture(StrUtil.hasBlank(definition.getIsDeparture())?isDeparture:definition.getIsDeparture());


        //获取对应的信息用户入职信息
        List<OaAttendanceUser> allByQuery = oaAttendanceUserExtendMapper.findAllByQuery(definition, GLOBAL_TABLE_FILED_STATE.NO.KEY, definition.getFileType());

        return SystemResult.ok(allByQuery);

    }


    /**
     * 添加考勤人员信息
     * @param definition 考勤用户属性定义类
     * @return
     */
    public SystemResult add(AttendanceUserDefinition definition){

        return null;
    }


    /**
     * 按照指定用户编号获取对应考勤人员信息
     * @param userNo 用户编号
     * @return
     */
    public SystemResult findOneByUserNo(String userNo){

        return null;
    }

    /**
     * 修改考勤人员信息
     * @param definition
     * @return
     */
    public SystemResult update(AttendanceUserDefinition definition){

        return null;
    }

    /**
     * 删除指定的考勤用户信息
     * @param userNos 用户编号集
     * @return
     */
    public SystemResult deleteById(String userNos){

        return null;
    }

    /**
     * 修改用户离职状态信息
     * @param userNos  用户编号集
     * @return
     */
    public SystemResult updateUserDepartureState(String userNos){

        return null;
    }


}
