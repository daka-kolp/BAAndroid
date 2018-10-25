package com.brainacad.apptask17;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {

    private int id;
    private String name;
    private String username;
    private Address address;
    private String email;
    private String phone;
    private String website;
    private Company company;


    public int getIdStr() {
        return id;
    }

    public void setIdStr(int idStr) {
        this.id = idStr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public class Address {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getSuite() {
            return suite;
        }

        public void setSuite(String suite) {
            this.suite = suite;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public Geo getGeo() {
            return geo;
        }

        public void setGeo(Geo geo) {
            this.geo = geo;
        }

        public class Geo {
            private String lat;
            private String lng;

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLng() {
                return lng;
            }

            public void setLng(String lng) {
                this.lng = lng;
            }
        }
    }

    public class Company{
        @SerializedName("name")
        private String companyName;
        private String catchPhrase;
        private String bs;

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getCatchPhrase() {
            return catchPhrase;
        }

        public void setCatchPhrase(String catchPhrase) {
            this.catchPhrase = catchPhrase;
        }

        public String getBs() {
            return bs;
        }

        public void setBs(String bs) {
            this.bs = bs;
        }
    }
}
