package com.bookstore.pojo.practise.instructor;

import java.util.List;

public class Courses {
    private List<WebAutomation> webAutomation;
    private List<ApiAutomation> apiAutomation;
    private List<MobileAutomation> mobileAutomation;

    public List<WebAutomation> getWebAutomation() {
        return webAutomation;
    }

    public void setWebAutomation(List<WebAutomation> webAutomation) {
        this.webAutomation = webAutomation;
    }

    public List<ApiAutomation> getApiAutomation() {
        return apiAutomation;
    }

    public void setApiAutomation(List<ApiAutomation> apiAutomation) {
        this.apiAutomation = apiAutomation;
    }

    public List<MobileAutomation> getMobileAutomation() {
        return mobileAutomation;
    }

    public void setMobileAutomation(List<MobileAutomation> mobileAutomation) {
        this.mobileAutomation = mobileAutomation;
    }

    public static class WebAutomation{
        private String price;
        private String courseTitle;

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getCourseTitle() {
            return courseTitle;
        }

        public void setCourseTitle(String courseTitle) {
            this.courseTitle = courseTitle;
        }
    }
    public static class ApiAutomation{
        private String price;
        private String courseTitle;
        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getCourseTitle() {
            return courseTitle;
        }

        public void setCourseTitle(String courseTitle) {
            this.courseTitle = courseTitle;
        }
    }
    public static class MobileAutomation{
        private String price;
        private String courseTitle;
        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getCourseTitle() {
            return courseTitle;
        }

        public void setCourseTitle(String courseTitle) {
            this.courseTitle = courseTitle;
        }

    }
}
