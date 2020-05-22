package com.huijianzhu.attendance.service.impl;

import com.huijianzhu.attendance.cache.AttendanceTypeCacheManager;
import com.huijianzhu.attendance.definition.AttendanceTypeDefinition;
import com.huijianzhu.attendance.entity.OaAttendanceType;
import com.huijianzhu.attendance.enums.GLOBAL_TABLE_FILED_STATE;
import com.huijianzhu.attendance.enums.SYSTEM_RESULT_STATE;
import com.huijianzhu.attendance.lock.AttendanceTypeLock;
import com.huijianzhu.attendance.mapper.extend.OaAttendanceTypeExtendMapper;
import com.huijianzhu.attendance.service.AttendanceTypeService;
import com.huijianzhu.attendance.vo.SystemResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 描述：   考勤类型业务接口实现
 *
 * @author 刘梓江
 * @date 2020/5/21  16:47
 */
@Service
public class AttendanceTypeServiceImpl implements AttendanceTypeService {

    /**
     * 注入：考勤类型缓存管理容器
     */
    @Autowired
    private AttendanceTypeCacheManager attendanceTypeCacheManager;

    /**
     * 注入：考勤类型信息数据mapper扩展接口
     */
    @Autowired
    private OaAttendanceTypeExtendMapper oaAttendanceTypeExtendMapper;




    /**
     * 获取所有考勤类型信息
     * @return
     */
    public SystemResult findAll(){
        List<OaAttendanceType> collect = attendanceTypeCacheManager.getTypeCahe().entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList());
        return SystemResult.ok(collect);
    }

    /**
     * 添加考勤类型信息
     * @param definition 考勤属性信息
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public SystemResult add(AttendanceTypeDefinition definition){
        try{
            //开启原子锁,防止重复数据
            AttendanceTypeLock.UPDATE_LOCK.writeLock().lock();


            //创建添加考勤类型信息对象
            OaAttendanceType type=new OaAttendanceType();
            type.setTypeName(definition.getTypeName());         //类型名称
            type.setTypeNo(definition.getTypeNo());             //类型编号
            type.setIsDelete(GLOBAL_TABLE_FILED_STATE.NO.KEY);  //删除标志
            type.setCreateTime(new Date());                     //创建时间
            type.setUpdateTime(new Date());                     //修改时间
            //type.setUpdateUserNo();   //后期扩展
            //type.setUpdateUserName(); //后期扩展

            //判断当前新添加的考勤类型是否已存在
            List<OaAttendanceType> oneByName = oaAttendanceTypeExtendMapper.findOneByName(type, GLOBAL_TABLE_FILED_STATE.NO.KEY);
            if(oneByName!=null&&oneByName.size()>0){
                return SystemResult.build(SYSTEM_RESULT_STATE.INSERT_FAILURE.KEY,"考勤信息已重复");
            }

            //持久化到数据库中
            oaAttendanceTypeExtendMapper.insertSelective(type);

            //刷新考勤类型缓存容器
            attendanceTypeCacheManager.refresh();
            return SystemResult.ok("考勤信息添加成功");
        }finally {
            //关闭原子锁
            AttendanceTypeLock.UPDATE_LOCK.writeLock().unlock();
        }
    }

    /**
     * 获取指定考勤类型
     * @param typeId 考勤类型id
     * @return
     */
    public SystemResult findOne(Integer typeId){

        //获取指定考勤类型信息
        OaAttendanceType type = attendanceTypeCacheManager.getTypeCahe().get(typeId);
        if(type==null){
            //考勤类型id已不存在
            return SystemResult.build(SYSTEM_RESULT_STATE.INSERT_FAILURE.KEY,"当前考勤类型信息不存在,重新刷新");
        }
        return SystemResult.ok(type);
    }

    /**
     * 修改考勤类型信息
     * @param definition 考勤属性信息
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public SystemResult update(AttendanceTypeDefinition definition){
        try{
            //开启原子锁,防止重复数据
            AttendanceTypeLock.UPDATE_LOCK.writeLock().lock();

            //创建修改考勤类型信息对象
            OaAttendanceType type=new OaAttendanceType();
            type.setTypeId(definition.getTypeId());             //考勤类型id
            type.setTypeName(definition.getTypeName());         //类型名称
            type.setTypeNo(definition.getTypeNo());             //类型编号
            type.setUpdateTime(new Date());                     //修改时间


            //判断当前新修改的考勤类型是否已存在
            List<OaAttendanceType> oneByName = oaAttendanceTypeExtendMapper.findOneByName(type, GLOBAL_TABLE_FILED_STATE.NO.KEY);
            if(oneByName!=null&&oneByName.size()>0){
                return SystemResult.build(SYSTEM_RESULT_STATE.INSERT_FAILURE.KEY,"考勤信息已重复");
            }

            //持久化到数据库中
            oaAttendanceTypeExtendMapper.updateByPrimaryKeySelective(type);

            //刷新考勤类型缓存容器
            attendanceTypeCacheManager.refresh();
            return SystemResult.ok("考勤信息修改成功");
        }finally {
            //关闭原子锁
            AttendanceTypeLock.UPDATE_LOCK.writeLock().unlock();
        }

    }


    /**
     * 删除指定考勤类型
     * @param typeId 考勤类型id
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public SystemResult deleteById(Integer typeId){
        //创建修改考勤类型信息对象
        OaAttendanceType type=new OaAttendanceType();
        type.setTypeId(typeId);             //考勤类型id
        type.setUpdateTime(new Date());     //修改时间
        type.setIsDelete(GLOBAL_TABLE_FILED_STATE.YES.KEY);

        //持久化到数据库中
        oaAttendanceTypeExtendMapper.updateByPrimaryKeySelective(type);

        //刷新考勤类型缓存容器
        attendanceTypeCacheManager.refresh();
        return SystemResult.ok("考勤信息删除成功");
    }
}
