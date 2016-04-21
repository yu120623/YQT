package com.yqt360.www.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/4/20.
 */
public class CompanyList extends HttpData implements java.io.Serializable {

    List<Company> data;

    public class Company {
        public String companyAID;
        public String companyName;
        public String regStatus;
        public String legalPersonName;
        public String industry;

        public String getCompanyAID() {
            return companyAID;
        }

        public void setCompanyAID(String companyAID) {
            this.companyAID = companyAID;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
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

        public String getIndustry() {
            return industry;
        }

        public void setIndustry(String industry) {
            this.industry = industry;
        }
    }

}
