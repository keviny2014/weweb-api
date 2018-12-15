package com.weweb.sys.entity;

import java.util.Date;

/**
 * Created by wshen on 5/3/2017.
 */
public class SysUserToken {
    private Long tokenId;
    private Long userId;
    private String token;
    private String tokenIp;
    private Date createTime;
    private Date updateTime;
    private Integer type;
    private Integer isOnLine;
    private String series;
    private String userRoleName;
    private String userName;
    public Long getTokenId() {
        return tokenId;
    }

    public void setTokenId(Long tokenId) {
        this.tokenId = tokenId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenIp() {
        return tokenIp;
    }

    public void setTokenIp(String tokenIp) {
        this.tokenIp = tokenIp;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIsOnLine() {
        return isOnLine;
    }

    public void setIsOnLine(Integer isOnLine) {
        this.isOnLine = isOnLine;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getUserRoleName() {
        return userRoleName;
    }

    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
