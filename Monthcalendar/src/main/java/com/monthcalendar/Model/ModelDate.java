package com.monthcalendar.Model;

import java.util.List;

public class ModelDate {
    private int code;
    private String message;
    private List<ResultBean> result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        private int _id;

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        private String date;
        private String day;
        private String dateformat;

        public String getDateformat() {
            return dateformat;
        }

        public void setDateformat(String dateformat) {
            this.dateformat = dateformat;
        }

        private boolean isChecked;

        public boolean isChecked() {
            return isChecked;
        }

        public void setChecked(boolean checked) {
            isChecked = checked;
        }

        public int get_id() {
            return _id;
        }

        public void set_id(int _id) {
            this._id = _id;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }
}
