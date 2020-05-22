package com.huijianzhu.attendance.cache;

import com.huijianzhu.attendance.entity.OaAttendanceType;
import com.huijianzhu.attendance.enums.GLOBAL_TABLE_FILED_STATE;
import com.huijianzhu.attendance.mapper.extend.OaAttendanceTypeExtendMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 描述：   考勤类型缓存管理
 *
 * @author 刘梓江
 * @date 2020/5/21  16:34
 */
@Data
@Component
public class AttendanceTypeCacheManager {

    /**
     * 注入：考勤类型信息数据mapper接口
     */
    @Autowired
    private OaAttendanceTypeExtendMapper oaAttendanceTypeExtendMapper;

    /**
     * 考勤类型缓存容器
     */
    private ConcurrentHashMap<Integer, OaAttendanceType> typeCahe=new ConcurrentHashMap<>();


    /**
     * 初始化容器
     */
    @PostConstruct
    public void init(){
        refresh();
    }

    /**
     * 刷新容器信息
     */
    public void refresh(){
        findAll();
    }

    /**
     * 所有所有考勤类型信息集
     */
    public void findAll(){
        //获取所有考勤类型信息
        List<OaAttendanceType> all = oaAttendanceTypeExtendMapper.findAll(GLOBAL_TABLE_FILED_STATE.NO.KEY);
        all.forEach(
            e->{
                typeCahe.put(e.getTypeId(),e);
            }
        );
    }

}
