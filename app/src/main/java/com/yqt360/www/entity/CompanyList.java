package com.yqt360.www.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/4/20.
 */
public class CompanyList extends HttpData implements java.io.Serializable {

    List<Company> data;

    public class Company {
        public Integer companyID;
        public String companyName;
        public String regStatus;
        public String legalPersonName;
        public String regCapital;
        public String establishTime;

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public Integer getCompanyID() {
            return companyID;
        }

        public void setCompanyID(Integer companyID) {
            this.companyID = companyID;
        }

        public String getRegStatus() {
            return regStatus;
        }

        public void setRegStatus(String regStatus) {
            this.regStatus = regStatus;
        }

        public String getLegalPersonName() {
            return legalPersonName;
        }

        public void setLegalPersonName(String legalPersonName) {
            this.legalPersonName = legalPersonName;
        }

        public String getRegCapital() {
            return regCapital;
        }

        public void setRegCapital(String regCapital) {
            this.regCapital = regCapital;
        }

        public String getEstablishTime() {
            return establishTime;
        }

        public void setEstablishTime(String establishTime) {
            this.establishTime = establishTime;
        }
    }

}
