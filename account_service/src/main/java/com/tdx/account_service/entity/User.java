package com.tdx.account_service.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhouzhenjang123
 * @since 2018-07-11
 */
@TableName("um_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    private String userId;
    /**
     * 21教育网用户iD
     */
    private String uid;
    private String userName;
    private String password;
    private String actualName;
    private String schoolId;
    private String userType;
    private String roleId;
    /**
     * 区县ID
     */
    private String platformId;
    private String sysGroupId;
    private String validFlag;
    private Date makeTime;
    private String makeUser;
    private Date modifyTime;
    private String modifyUser;
    /**
     * 微信
     */
    private String wechat;
    /**
     * 用户头像
     */
    private String head;
    /**
     * 0最后一次登录
     */
    private Integer lastLogin;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getActualName() {
        return actualName;
    }

    public void setActualName(String actualName) {
        this.actualName = actualName;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getSysGroupId() {
        return sysGroupId;
    }

    public void setSysGroupId(String sysGroupId) {
        this.sysGroupId = sysGroupId;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    public Date getMakeTime() {
        return makeTime;
    }

    public void setMakeTime(Date makeTime) {
        this.makeTime = makeTime;
    }

    public String getMakeUser() {
        return makeUser;
    }

    public void setMakeUser(String makeUser) {
        this.makeUser = makeUser;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public Integer getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Integer lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

    @Override
    public String toString() {
        return "User{" +
        ", userId=" + userId +
        ", uid=" + uid +
        ", userName=" + userName +
        ", password=" + password +
        ", actualName=" + actualName +
        ", schoolId=" + schoolId +
        ", userType=" + userType +
        ", roleId=" + roleId +
        ", platformId=" + platformId +
        ", sysGroupId=" + sysGroupId +
        ", validFlag=" + validFlag +
        ", makeTime=" + makeTime +
        ", makeUser=" + makeUser +
        ", modifyTime=" + modifyTime +
        ", modifyUser=" + modifyUser +
        ", wechat=" + wechat +
        ", head=" + head +
        ", lastLogin=" + lastLogin +
        "}";
    }
}
