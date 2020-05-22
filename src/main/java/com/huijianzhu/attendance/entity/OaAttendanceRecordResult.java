package com.huijianzhu.attendance.entity;

import java.util.Date;

public class OaAttendanceRecordResult {
    private String resultId;

    private String onWork;

    private Integer onTypeId;

    private String onTypeName;

    private String afterWord;

    private Integer afterTypeId;

    private String afterTypeName;

    private String takeTime;

    private String isDelete;

    private Date createTime;

    private Date updateTime;

    private String updateUserNo;

    private String updateUserName;

    private String extend1;

    private String extend2;

    private String extend3;

    private String extend4;

    private String extend5;

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId == null ? null : resultId.trim();
    }

    public String getOnWork() {
        return onWork;
    }

    public void setOnWork(String onWork) {
        this.onWork = onWork == null ? null : onWork.trim();
    }

    public Integer getOnTypeId() {
        return onTypeId;
    }

    public void setOnTypeId(Integer onTypeId) {
        this.onTypeId = onTypeId;
    }

    public String getOnTypeName() {
        return onTypeName;
    }

    public void setOnTypeName(String onTypeName) {
        this.onTypeName = onTypeName == null ? null : onTypeName.trim();
    }

    public String getAfterWord() {
        return afterWord;
    }

    public void setAfterWord(String afterWord) {
        this.afterWord = afterWord == null ? null : afterWord.trim();
    }

    public Integer getAfterTypeId() {
        return afterTypeId;
    }

    public void setAfterTypeId(Integer afterTypeId) {
        this.afterTypeId = afterTypeId;
    }

    public String getAfterTypeName() {
        return afterTypeName;
    }

    public void setAfterTypeName(String afterTypeName) {
        this.afterTypeName = afterTypeName == null ? null : afterTypeName.trim();
    }

    public String getTakeTime() {
        return takeTime;
    }

    public void setTakeTime(String takeTime) {
        this.takeTime = takeTime == null ? null : takeTime.trim();
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUserNo() {
        return updateUserNo;
    }

    public void setUpdateUserNo(String updateUserNo) {
        this.updateUserNo = updateUserNo == null ? null : updateUserNo.trim();
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName == null ? null : updateUserName.trim();
    }

    public String getExtend1() {
        return extend1;
    }

    public void setExtend1(String extend1) {
        this.extend1 = extend1 == null ? null : extend1.trim();
    }

    public String getExtend2() {
        return extend2;
    }

    public void setExtend2(String extend2) {
        this.extend2 = extend2 == null ? null : extend2.trim();
    }

    public String getExtend3() {
        return extend3;
    }

    public void setExtend3(String extend3) {
        this.extend3 = extend3 == null ? null : extend3.trim();
    }

    public String getExtend4() {
        return extend4;
    }

    public void setExtend4(String extend4) {
        this.extend4 = extend4 == null ? null : extend4.trim();
    }

    public String getExtend5() {
        return extend5;
    }

    public void setExtend5(String extend5) {
        this.extend5 = extend5 == null ? null : extend5.trim();
    }
}