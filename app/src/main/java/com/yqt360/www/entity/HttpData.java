package com.yqt360.www.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/4/20.
 */
public class HttpData {
    public Integer status;
    public String message;
    public List<CompanyList.Company> data;
    public List<CompanyList.Company> getData() {
        return data;
    }

    public void setData(List<CompanyList.Company> data) {
        this.data = data;
    }









    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }




}
