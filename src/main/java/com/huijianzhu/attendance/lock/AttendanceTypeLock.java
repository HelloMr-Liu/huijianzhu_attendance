package com.huijianzhu.attendance.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 描述：   考勤类型操作锁
 *
 * @author 刘梓江
 * @date 2020/5/21  16:49
 */
public class AttendanceTypeLock {


    /**
     * 修改锁
     */
    public static ReentrantReadWriteLock UPDATE_LOCK=new ReentrantReadWriteLock();
}
