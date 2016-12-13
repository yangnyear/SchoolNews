package com.swpuiot.schoolnews.emtity;

import java.io.Serializable;

/**
 * Created by 羊荣毅_L on 2016/12/6.
 */
public class UserResponseEmpty implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * message : success
     * code : 1
     * date : {"id":1,"userId":201431060298,"name":"赵禾才","setLogoSrc":"http://www.bug666.cn:8080/Images/201431060298.png","password":"123","major":"物联网工程","grade":"2014级","phone":15680659519,"inTime":"2014-09-01","putTime":"2018-06-01","facultyId":5}
     */

    private String message;
    private int code;
    /**
     * id : 1
     * userId : 201431060298
     * name : 赵禾才
     * setLogoSrc : http://www.bug666.cn:8080/Images/201431060298.png
     * password : 123
     * major : 物联网工程
     * grade : 2014级
     * phone : 15680659519
     * inTime : 2014-09-01
     * putTime : 2018-06-01
     * facultyId : 5
     */

    private DateBean date;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DateBean getDate() {
        return date;
    }

    public void setDate(DateBean date) {
        this.date = date;
    }

    public static class DateBean implements Serializable{
        private static final long serialVersionUID = 1L;
        private int id;
        private long userId;
        private String name;
        private String setLogoSrc;
        private String password;
        private String major;
        private String grade;
        private long phone;
        private String inTime;
        private String putTime;
        private int facultyId;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSetLogoSrc() {
            return setLogoSrc;
        }

        public void setSetLogoSrc(String setLogoSrc) {
            this.setLogoSrc = setLogoSrc;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public long getPhone() {
            return phone;
        }

        public void setPhone(long phone) {
            this.phone = phone;
        }

        public String getInTime() {
            return inTime;
        }

        public void setInTime(String inTime) {
            this.inTime = inTime;
        }

        public String getPutTime() {
            return putTime;
        }

        public void setPutTime(String putTime) {
            this.putTime = putTime;
        }

        public int getFacultyId() {
            return facultyId;
        }

        public void setFacultyId(int facultyId) {
            this.facultyId = facultyId;
        }
    }
}
