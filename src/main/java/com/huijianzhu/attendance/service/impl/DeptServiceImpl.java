package com.huijianzhu.attendance.service.impl;

import cn.hutool.core.util.StrUtil;
import com.huijianzhu.attendance.definition.DeptDefinition;
import com.huijianzhu.attendance.entity.OaDept;
import com.huijianzhu.attendance.enums.GLOBAL_TABLE_FILED_STATE;
import com.huijianzhu.attendance.enums.SYSTEM_RESULT_STATE;
import com.huijianzhu.attendance.lock.DeptLock;
import com.huijianzhu.attendance.mapper.extend.OaDeptExtendMapper;
import com.huijianzhu.attendance.service.DeptService;
import com.huijianzhu.attendance.vo.SystemResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 描述：   部门业务接口实现
 *
 * @author 刘梓江
 * @date 2020/5/21  13:21
 */
@Slf4j
@Service
public class DeptServiceImpl implements DeptService {

    /**
     * 注入： 部门信息数据mapper扩展接口
     */
    @Autowired
    private OaDeptExtendMapper oaDeptExtendMapper;

    /**
     * 获取所有部门信息(默认查询全部)
     * @param deptName 部门名称
     * @return
     */
    public SystemResult findAll(String deptName){
        if(StrUtil.hasBlank(deptName))deptName=null;
        //获取所有有效的部门信息
        List<OaDept> deptList = oaDeptExtendMapper.findAll(deptName,GLOBAL_TABLE_FILED_STATE.NO.KEY);
        return SystemResult.ok(deptList);
    }

    /**
     * 添加一个部门信息
     * @param deptDefinition 部门属性定义类
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public SystemResult add(DeptDefinition deptDefinition){
        try{
            //开启原子锁防止重复添加
            DeptLock.UPDATE_LOCK.writeLock().lock();

            //创建一个部门对象封装新部门信息
            OaDept dept=new OaDept();
            dept.setDeptNo(deptDefinition.getDeptNo());                 //部门编号
            dept.setDeptName(deptDefinition.getDeptName());             //部门名称
            dept.setDeptSort(deptDefinition.getDeptSort());             //部门排序
            dept.setUserNoConfig("0000");                               //部门员工编号配置，默认是从4个0开始
            dept.setIsDelete(GLOBAL_TABLE_FILED_STATE.NO.KEY);          //删除标志
            dept.setCreateTime(new Date());
            dept.setUpdateTime(new Date());
            //dept.setUpdateUserNo();   // 后期扩展
            //dept.setUpdateUserName(); // 后期扩展

            //判断新添加的内容是否存在
            List<OaDept> deptContent = oaDeptExtendMapper.findDeptContent(dept, GLOBAL_TABLE_FILED_STATE.NO.KEY);

            if(deptContent!=null&&deptContent.size()>0){
                //添加失败
                return SystemResult.build(SYSTEM_RESULT_STATE.INSERT_FAILURE.KEY,"新添加的部门信息,以存储不能重复");
            }
            //持久化到数据库中
            oaDeptExtendMapper.insertSelective(dept);

            return SystemResult.build(SYSTEM_RESULT_STATE.SUCCESS.KEY,"部门添加成功");
        }finally {
            //释放原子锁
            DeptLock.UPDATE_LOCK.writeLock().unlock();
        }
    }

    /**
     * 获取指定部门编号
     * @param deptId  部门id
     * @return
     */
    public SystemResult one(Integer deptId){
        //获取指定部门信息
        OaDept dept = oaDeptExtendMapper.selectByPrimaryKey(deptId);

        if(dept==null){
            //出现为空有可能就是并发操作的时候删除了该部门信息同时又获取该部门信息操作部门信息获取失败
            return SystemResult.build(SYSTEM_RESULT_STATE.UPDATE_FAILURE.KEY,"当前部门信息为空,请刷新部门重试");
        }
        return SystemResult.ok(dept);
    }


    /**
     * 修改部门信息
     * @param deptDefinition 部门属性定义类
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public SystemResult update(DeptDefinition deptDefinition){
        try {
            //开启原子锁防止添加修改会有相同的数据
            DeptLock.UPDATE_LOCK.writeLock().lock();

            //创建一个部门对象封装新部门信息
            OaDept dept=new OaDept();
            dept.setDeptId(deptDefinition.getDeptId());                 //部门id
            dept.setDeptNo(deptDefinition.getDeptNo());                 //部门编号
            dept.setDeptName(deptDefinition.getDeptName());             //部门名称
            dept.setDeptSort(deptDefinition.getDeptSort());             //部门排序
            dept.setUpdateTime(new Date());
            //dept.setUpdateUserNo();   // 后期扩展
            //dept.setUpdateUserName(); // 后期扩展

            //判断修改的内容是否存在
            List<OaDept> deptContent = oaDeptExtendMapper.findDeptContent(dept, GLOBAL_TABLE_FILED_STATE.NO.KEY);

            if(deptContent!=null&&deptContent.size()>0){
                //修改失败
                return SystemResult.build(SYSTEM_RESULT_STATE.UPDATE_FAILURE.KEY,"修改的部门信息,以存储不能重复");
            }
            //持久化到数据库中
            oaDeptExtendMapper.updateByPrimaryKeySelective(dept);
            return SystemResult.build(SYSTEM_RESULT_STATE.SUCCESS.KEY,"部门修改成功");

        }finally {
            //解锁操作
            DeptLock.UPDATE_LOCK.writeLock().unlock();
        }

    }

    /**
     * 删除部门信息
     * @param deptId 部门id
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public SystemResult delete(Integer deptId){

        //创建一个部门对象封装新部门信息
        OaDept dept=new OaDept();
        dept.setDeptId(deptId);          //部门id
        dept.setUpdateTime(new Date());
        dept.setIsDelete(GLOBAL_TABLE_FILED_STATE.YES.KEY);

        //持久化到数据库中
        oaDeptExtendMapper.updateByPrimaryKeySelective(dept);
        return SystemResult.build(SYSTEM_RESULT_STATE.SUCCESS.KEY,"部门删除成功");
    }
}
