package com.brainacad.apptask17;

import java.io.Serializable;

public class User implements Serializable {
    private int idStr;
    private String nameStr;
    private String usernameStr;
    private String emailStr;
    private String phoneStr;
    private String websiteStr;

    public int getIdStr() {
        return idStr;
    }

    public void setIdStr(int idStr) {
        this.idStr = idStr;
    }

    public String getNameStr() {
        return nameStr;
    }

    public void setNameStr(String nameStr) {
        this.nameStr = nameStr;
    }

    public String getUsernameStr() {
        return usernameStr;
    }

    public void setUsernameStr(String usernameStr) {
        this.usernameStr = usernameStr;
    }

    public String getEmailStr() {
        return emailStr;
    }

    public void setEmailStr(String emailStr) {
        this.emailStr = emailStr;
    }

    public String getPhoneStr() {
        return phoneStr;
    }

    public void setPhoneStr(String phoneStr) {
        this.phoneStr = phoneStr;
    }

    public String getWebsiteStr() {
        return websiteStr;
    }

    public void setWebsiteStr(String websiteStr) {
        this.websiteStr = websiteStr;
    }

    public class Address {
        private String addressStreetStr;
        private String addressSuiteStr;
        private String addressZipcodeStr;

        public String getAddressStreetStr() {
            return addressStreetStr;
        }

        public void setAddressStreetStr(String addressStreetStr) {
            this.addressStreetStr = addressStreetStr;
        }

        public String getAddressSuiteStr() {
            return addressSuiteStr;
        }

        public void setAddressSuiteStr(String addressSuiteStr) {
            this.addressSuiteStr = addressSuiteStr;
        }

        public String getAddressZipcodeStr() {
            return addressZipcodeStr;
        }

        public void setAddressZipcodeStr(String addressZipcodeStr) {
            this.addressZipcodeStr = addressZipcodeStr;
        }

        public class Geo {
            private String geoLatStr;
            private String geoLngStr;

            public String getGeoLatStr() {
                return geoLatStr;
            }

            public void setGeoLatStr(String geoLatStr) {
                this.geoLatStr = geoLatStr;
            }

            public String getGeoLngStr() {
                return geoLngStr;
            }

            public void setGeoLngStr(String geoLngStr) {
                this.geoLngStr = geoLngStr;
            }
        }
    }

    public class Company {
        private String companyNameStr;
        private String companyCatchPhraseStr;
        private String companyBsStr;

        public String getCompanyNameStr() {
            return companyNameStr;
        }

        public void setCompanyNameStr(String companyNameStr) {
            this.companyNameStr = companyNameStr;
        }

        public String getCompanyCatchPhraseStr() {
            return companyCatchPhraseStr;
        }

        public void setCompanyCatchPhraseStr(String companyCatchPhraseStr) {
            this.companyCatchPhraseStr = companyCatchPhraseStr;
        }

        public String getCompanyBsStr() {
            return companyBsStr;
        }

        public void setCompanyBsStr(String companyBsStr) {
            this.companyBsStr = companyBsStr;
        }
    }
}
