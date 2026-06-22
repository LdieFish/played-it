package com.playedit.module.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

/**
 * 用户表
 * @TableName users
 */
@TableName(value ="users")
public class Users {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 微信 openid
     */
    @TableField(value = "openid")
    private String openid;

    /**
     * 微信 unionid（多端统一时使用）
     */
    @TableField(value = "unionid")
    private String unionid;

    /**
     * 昵称
     */
    @TableField(value = "nickname")
    private String nickname;

    /**
     * 头像 URL
     */
    @TableField(value = "avatar_url")
    private String avatarUrl;

    /**
     * Steam 64 位 ID
     */
    @TableField(value = "steam_id")
    private String steamId;

    /**
     * Steam 昵称
     */
    @TableField(value = "steam_nickname")
    private String steamNickname;

    /**
     * Steam 个人主页链接
     */
    @TableField(value = "steam_profile_url")
    private String steamProfileUrl;

    /**
     * 绑定方式：OPENID / MANUAL
     */
    @TableField(value = "steam_bind_type")
    private String steamBindType;

    /**
     * 是否官方验证：0 否 / 1 是（OpenID）
     */
    @TableField(value = "steam_verified")
    private Integer steamVerified;

    /**
     * Steam 绑定时间
     */
    @TableField(value = "steam_bind_time")
    private Date steamBindTime;

    /**
     * 角色：user / admin
     */
    @TableField(value = "user_role")
    private String userRole;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 业务数据更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 逻辑删除：0 未删 / 1 已删
     */
    @TableField(value = "deleted")
    private Integer deleted;

    /**
     * 逻辑删除时间（deleted=1 时写入，与 update_time 分离）
     */
    @TableField(value = "delete_time")
    private Date deleteTime;

    /**
     * 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 微信 openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 微信 openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * 微信 unionid（多端统一时使用）
     */
    public String getUnionid() {
        return unionid;
    }

    /**
     * 微信 unionid（多端统一时使用）
     */
    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    /**
     * 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 头像 URL
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * 头像 URL
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    /**
     * Steam 64 位 ID
     */
    public String getSteamId() {
        return steamId;
    }

    /**
     * Steam 64 位 ID
     */
    public void setSteamId(String steamId) {
        this.steamId = steamId;
    }

    /**
     * Steam 昵称
     */
    public String getSteamNickname() {
        return steamNickname;
    }

    /**
     * Steam 昵称
     */
    public void setSteamNickname(String steamNickname) {
        this.steamNickname = steamNickname;
    }

    /**
     * Steam 个人主页链接
     */
    public String getSteamProfileUrl() {
        return steamProfileUrl;
    }

    /**
     * Steam 个人主页链接
     */
    public void setSteamProfileUrl(String steamProfileUrl) {
        this.steamProfileUrl = steamProfileUrl;
    }

    /**
     * 绑定方式：OPENID / MANUAL
     */
    public String getSteamBindType() {
        return steamBindType;
    }

    /**
     * 绑定方式：OPENID / MANUAL
     */
    public void setSteamBindType(String steamBindType) {
        this.steamBindType = steamBindType;
    }

    /**
     * 是否官方验证：0 否 / 1 是（OpenID）
     */
    public Integer getSteamVerified() {
        return steamVerified;
    }

    /**
     * 是否官方验证：0 否 / 1 是（OpenID）
     */
    public void setSteamVerified(Integer steamVerified) {
        this.steamVerified = steamVerified;
    }

    /**
     * Steam 绑定时间
     */
    public Date getSteamBindTime() {
        return steamBindTime;
    }

    /**
     * Steam 绑定时间
     */
    public void setSteamBindTime(Date steamBindTime) {
        this.steamBindTime = steamBindTime;
    }

    /**
     * 角色：user / admin
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * 角色：user / admin
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 业务数据更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 业务数据更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 逻辑删除：0 未删 / 1 已删
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * 逻辑删除：0 未删 / 1 已删
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    /**
     * 逻辑删除时间（deleted=1 时写入，与 update_time 分离）
     */
    public Date getDeleteTime() {
        return deleteTime;
    }

    /**
     * 逻辑删除时间（deleted=1 时写入，与 update_time 分离）
     */
    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Users other = (Users) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOpenid() == null ? other.getOpenid() == null : this.getOpenid().equals(other.getOpenid()))
            && (this.getUnionid() == null ? other.getUnionid() == null : this.getUnionid().equals(other.getUnionid()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getAvatarUrl() == null ? other.getAvatarUrl() == null : this.getAvatarUrl().equals(other.getAvatarUrl()))
            && (this.getSteamId() == null ? other.getSteamId() == null : this.getSteamId().equals(other.getSteamId()))
            && (this.getSteamNickname() == null ? other.getSteamNickname() == null : this.getSteamNickname().equals(other.getSteamNickname()))
            && (this.getSteamProfileUrl() == null ? other.getSteamProfileUrl() == null : this.getSteamProfileUrl().equals(other.getSteamProfileUrl()))
            && (this.getSteamBindType() == null ? other.getSteamBindType() == null : this.getSteamBindType().equals(other.getSteamBindType()))
            && (this.getSteamVerified() == null ? other.getSteamVerified() == null : this.getSteamVerified().equals(other.getSteamVerified()))
            && (this.getSteamBindTime() == null ? other.getSteamBindTime() == null : this.getSteamBindTime().equals(other.getSteamBindTime()))
            && (this.getUserRole() == null ? other.getUserRole() == null : this.getUserRole().equals(other.getUserRole()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()))
            && (this.getDeleteTime() == null ? other.getDeleteTime() == null : this.getDeleteTime().equals(other.getDeleteTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOpenid() == null) ? 0 : getOpenid().hashCode());
        result = prime * result + ((getUnionid() == null) ? 0 : getUnionid().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getAvatarUrl() == null) ? 0 : getAvatarUrl().hashCode());
        result = prime * result + ((getSteamId() == null) ? 0 : getSteamId().hashCode());
        result = prime * result + ((getSteamNickname() == null) ? 0 : getSteamNickname().hashCode());
        result = prime * result + ((getSteamProfileUrl() == null) ? 0 : getSteamProfileUrl().hashCode());
        result = prime * result + ((getSteamBindType() == null) ? 0 : getSteamBindType().hashCode());
        result = prime * result + ((getSteamVerified() == null) ? 0 : getSteamVerified().hashCode());
        result = prime * result + ((getSteamBindTime() == null) ? 0 : getSteamBindTime().hashCode());
        result = prime * result + ((getUserRole() == null) ? 0 : getUserRole().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        result = prime * result + ((getDeleteTime() == null) ? 0 : getDeleteTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", openid=").append(openid);
        sb.append(", unionid=").append(unionid);
        sb.append(", nickname=").append(nickname);
        sb.append(", avatarUrl=").append(avatarUrl);
        sb.append(", steamId=").append(steamId);
        sb.append(", steamNickname=").append(steamNickname);
        sb.append(", steamProfileUrl=").append(steamProfileUrl);
        sb.append(", steamBindType=").append(steamBindType);
        sb.append(", steamVerified=").append(steamVerified);
        sb.append(", steamBindTime=").append(steamBindTime);
        sb.append(", userRole=").append(userRole);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleted=").append(deleted);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append("]");
        return sb.toString();
    }
}