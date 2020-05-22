package com.huijianzhu.attendance.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 描述：   部门信息操作锁
 *
 * @author 刘梓江
 * @date 2020/5/21  13:32
 */
public class DeptLock {

    /**
     * 部门修改锁操作
     */
    public static ReentrantReadWriteLock UPDATE_LOCK=new ReentrantReadWriteLock();
}
