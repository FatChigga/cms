package com.cms.sys.entity;

public class SysDictionaryEntityKey {
    private String keycode;

    private String keyvalue;

    public String getKeycode() {
        return keycode;
    }

    public void setKeycode(String keycode) {
        this.keycode = keycode == null ? null : keycode.trim();
    }

    public String getKeyvalue() {
        return keyvalue;
    }

    public void setKeyvalue(String keyvalue) {
        this.keyvalue = keyvalue == null ? null : keyvalue.trim();
    }
}