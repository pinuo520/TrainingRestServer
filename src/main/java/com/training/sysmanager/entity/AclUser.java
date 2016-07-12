package com.training.sysmanager.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.training.core.annotation.MapperClass;
import com.training.core.entity.BaseEntity;
import com.training.sysmanager.dao.acluser.AclUserMapper;
import org.apache.ibatis.type.Alias;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by Athos on 2016-06-29.
 */
@NameStyle(value = Style.camelhumpAndLowercase)
@Table(name="tbl_sysmgr_acluser")
@Alias("acluser")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@MapperClass(AclUserMapper.class)
public class AclUser extends BaseEntity {
    public AclUser(){}

    public AclUser(String userName,String userPwd){
        this.userName = userName;
        this.userPwd = userPwd;
    }

    /**
     * 用户名
     */
    @Column
    private String userName;
    /**
     * 密码
     */
    @Column
    private String userPwd;
    /**
     * 角色 json 格式 或转换为数组
     */
    @Column
    private String roleses;

    /**
     * 转换为数据 瞬时
     */
    @Transient
    private String [] rolesesArray;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getRoleses() {
        return roleses;
    }

    public void setRoleses(String roleses) {
        this.roleses = roleses;
    }

    public String[] getRolesesArray() {
        return rolesesArray;
    }

    public void setRolesesArray(String[] rolesesArray) {
        this.rolesesArray = rolesesArray;
    }
}
