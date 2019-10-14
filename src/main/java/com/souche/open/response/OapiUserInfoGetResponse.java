package com.souche.open.response;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

public class OapiUserInfoGetResponse extends BaseResponse {
    private Data data;

    public void setData(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }


    /**
     * 用户返回对象
     */
    public static class Data implements Serializable {
        // 姓名
        private String name;
        // 用户 ID
        private String id;
        // 昵称
        private String nickname;
        // 用户唯一自增标识,
        private long iid;
        // 邮箱
        private String email;
        // 账号
        private String account;
        // 店铺code
        private String shopCode;
        // 钉钉 id
        private String dingId;
        // 性别 1:女 2:男
        private Integer sex;
        // 钉钉部门
        private String dingDepartment;
        // 最近一次登录IP
        private String lastLoginIp;
        // 工号
        private String jobnumber;
        // 电话
        private String phone;
        // 头像
        private String headImgurl;
        // 登录用的钉id
        private String ssoDingId;
        // 组织
        private String organization;
        // 状态，0:在职，1:离职，2:冻结
        private Integer status;
        // 外部账号
        private String outerCode;
        // 创建时间
        @JSONField(format = "yyyy-MM-dd HH:mm:ss")
        private Date dateCreate;
        // 更新时间
        @JSONField(format = "yyyy-MM-dd HH:mm:ss")
        private Date dateUpdate;


        private static final long serialVersionUID = 4320238470608281545L;

        public Data() {
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public Date getDateCreate() {
            return dateCreate;
        }

        public void setDateCreate(Date dateCreate) {
            this.dateCreate = dateCreate;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public long getIid() {
            return iid;
        }

        public void setIid(long iid) {
            this.iid = iid;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getShopCode() {
            return shopCode;
        }

        public void setShopCode(String shopCode) {
            this.shopCode = shopCode;
        }

        public String getDingId() {
            return dingId;
        }

        public void setDingId(String dingId) {
            this.dingId = dingId;
        }

        public Integer getSex() {
            return sex;
        }

        public void setSex(Integer sex) {
            this.sex = sex;
        }

        public String getDingDepartment() {
            return dingDepartment;
        }

        public void setDingDepartment(String dingDepartment) {
            this.dingDepartment = dingDepartment;
        }

        public String getLastLoginIp() {
            return lastLoginIp;
        }

        public void setLastLoginIp(String lastLoginIp) {
            this.lastLoginIp = lastLoginIp;
        }

        public String getJobnumber() {
            return jobnumber;
        }

        public void setJobnumber(String jobnumber) {
            this.jobnumber = jobnumber;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getHeadImgurl() {
            return headImgurl;
        }

        public void setHeadImgurl(String headImgurl) {
            this.headImgurl = headImgurl;
        }

        public String getSsoDingId() {
            return ssoDingId;
        }

        public void setSsoDingId(String ssoDingId) {
            this.ssoDingId = ssoDingId;
        }

        public String getOrganization() {
            return organization;
        }

        public void setOrganization(String organization) {
            this.organization = organization;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getOuterCode() {
            return outerCode;
        }

        public void setOuterCode(String outerCode) {
            this.outerCode = outerCode;
        }

        public Date getDateUpdate() {
            return dateUpdate;
        }

        public void setDateUpdate(Date dateUpdate) {
            this.dateUpdate = dateUpdate;
        }
    }
}
