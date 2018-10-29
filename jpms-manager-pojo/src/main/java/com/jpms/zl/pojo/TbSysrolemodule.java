package com.jpms.zl.pojo;

import java.io.Serializable;

public class TbSysrolemodule implements Serializable{
    private String roleid;

    private String moduleid;

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }

    public String getModuleid() {
        return moduleid;
    }

    public void setModuleid(String moduleid) {
        this.moduleid = moduleid == null ? null : moduleid.trim();
    }
}