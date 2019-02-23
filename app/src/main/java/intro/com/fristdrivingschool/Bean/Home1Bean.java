package intro.com.fristdrivingschool.Bean;

import java.util.List;

public class Home1Bean {


    /**
     * ret : 200
     * data : {"coachdata":{"id":1,"school_id":1,"name":"张教练","sex":1,"t":"8:00-10:00|10:00-12:00|13:00-15:00|15:00-17:00","num":4,"license":"1,2","status":1,"connect":"15178669950","ctime":null,"deleted_at":null,"coach_id":1},"today":{"id":10,"coach_id":1,"num":"","t":1550678400,"isin":0,"appointment":[{"time":"8:00-10:00","hasNum":0,"notNum":4},{"time":"10:00-12:00","hasNum":0,"notNum":4},{"time":"13:00-15:00","hasNum":0,"notNum":4},{"time":"15:00-17:00","hasNum":0,"notNum":4}]},"tomorrow":{"id":11,"coach_id":1,"num":"","t":1550764800,"isin":0,"appointment":[{"time":"8:00-10:00","hasNum":0,"notNum":4},{"time":"10:00-12:00","hasNum":0,"notNum":4},{"time":"13:00-15:00","hasNum":0,"notNum":4},{"time":"15:00-17:00","hasNum":0,"notNum":4}]}}
     * msg :
     */

    private int ret;
    private DataBean data;
    private String msg;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        /**
         * coachdata : {"id":1,"school_id":1,"name":"张教练","sex":1,"t":"8:00-10:00|10:00-12:00|13:00-15:00|15:00-17:00","num":4,"license":"1,2","status":1,"connect":"15178669950","ctime":null,"deleted_at":null,"coach_id":1}
         * today : {"id":10,"coach_id":1,"num":"","t":1550678400,"isin":0,"appointment":[{"time":"8:00-10:00","hasNum":0,"notNum":4},{"time":"10:00-12:00","hasNum":0,"notNum":4},{"time":"13:00-15:00","hasNum":0,"notNum":4},{"time":"15:00-17:00","hasNum":0,"notNum":4}]}
         * tomorrow : {"id":11,"coach_id":1,"num":"","t":1550764800,"isin":0,"appointment":[{"time":"8:00-10:00","hasNum":0,"notNum":4},{"time":"10:00-12:00","hasNum":0,"notNum":4},{"time":"13:00-15:00","hasNum":0,"notNum":4},{"time":"15:00-17:00","hasNum":0,"notNum":4}]}
         */

        private CoachdataBean coachdata;
        private TodayBean today;
        private TomorrowBean tomorrow;

        public CoachdataBean getCoachdata() {
            return coachdata;
        }

        public void setCoachdata(CoachdataBean coachdata) {
            this.coachdata = coachdata;
        }

        public TodayBean getToday() {
            return today;
        }

        public void setToday(TodayBean today) {
            this.today = today;
        }

        public TomorrowBean getTomorrow() {
            return tomorrow;
        }

        public void setTomorrow(TomorrowBean tomorrow) {
            this.tomorrow = tomorrow;
        }

        public class CoachdataBean {
            /**
             * id : 1
             * school_id : 1
             * name : 张教练
             * sex : 1
             * t : 8:00-10:00|10:00-12:00|13:00-15:00|15:00-17:00
             * num : 4
             * license : 1,2
             * status : 1
             * connect : 15178669950
             * ctime : null
             * deleted_at : null
             * coach_id : 1
             */

            private int id;
            private int school_id;
            private String name;
            private int sex;
            private String t;
            private int num;
            private String license;
            private int status;
            private String connect;
            private String ctime;
            private String deleted_at;
            private String school;
            private int coach_id;

            public String getSchool() {
                return school;
            }

            public void setSchool(String school) {
                this.school = school;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getSchool_id() {
                return school_id;
            }

            public void setSchool_id(int school_id) {
                this.school_id = school_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }

            public String getT() {
                return t;
            }

            public void setT(String t) {
                this.t = t;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public String getLicense() {
                return license;
            }

            public void setLicense(String license) {
                this.license = license;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getConnect() {
                return connect;
            }

            public void setConnect(String connect) {
                this.connect = connect;
            }

            public String getCtime() {
                return ctime;
            }

            public void setCtime(String ctime) {
                this.ctime = ctime;
            }

            public String getDeleted_at() {
                return deleted_at;
            }

            public void setDeleted_at(String deleted_at) {
                this.deleted_at = deleted_at;
            }

            public int getCoach_id() {
                return coach_id;
            }

            public void setCoach_id(int coach_id) {
                this.coach_id = coach_id;
            }
        }

        public class TodayBean {
            /**
             * id : 10
             * coach_id : 1
             * num :
             * t : 1550678400
             * isin : 0
             * appointment : [{"time":"8:00-10:00","hasNum":0,"notNum":4},{"time":"10:00-12:00","hasNum":0,"notNum":4},{"time":"13:00-15:00","hasNum":0,"notNum":4},{"time":"15:00-17:00","hasNum":0,"notNum":4}]
             */

            private int id;
            private int coach_id;
            private String num;
            private int t;
            private int isin;
            private List<AppointmentBean> appointment;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getCoach_id() {
                return coach_id;
            }

            public void setCoach_id(int coach_id) {
                this.coach_id = coach_id;
            }

            public String getNum() {
                return num;
            }

            public void setNum(String num) {
                this.num = num;
            }

            public int getT() {
                return t;
            }

            public void setT(int t) {
                this.t = t;
            }

            public int getIsin() {
                return isin;
            }

            public void setIsin(int isin) {
                this.isin = isin;
            }

            public List<AppointmentBean> getAppointment() {
                return appointment;
            }

            public void setAppointment(List<AppointmentBean> appointment) {
                this.appointment = appointment;
            }

            public class AppointmentBean {
                /**
                 * time : 8:00-10:00
                 * hasNum : 0
                 * notNum : 4
                 */

                private String time;
                private int hasNum;
                private int notNum;

                public String getTime() {
                    return time;
                }

                public void setTime(String time) {
                    this.time = time;
                }

                public int getHasNum() {
                    return hasNum;
                }

                public void setHasNum(int hasNum) {
                    this.hasNum = hasNum;
                }

                public int getNotNum() {
                    return notNum;
                }

                public void setNotNum(int notNum) {
                    this.notNum = notNum;
                }
            }
        }

        public static class TomorrowBean {
            /**
             * id : 11
             * coach_id : 1
             * num :
             * t : 1550764800
             * isin : 0
             * appointment : [{"time":"8:00-10:00","hasNum":0,"notNum":4},{"time":"10:00-12:00","hasNum":0,"notNum":4},{"time":"13:00-15:00","hasNum":0,"notNum":4},{"time":"15:00-17:00","hasNum":0,"notNum":4}]
             */

            private int id;
            private int coach_id;
            private String num;
            private int t;
            private int isin;
            private List<AppointmentBeanX> appointment;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getCoach_id() {
                return coach_id;
            }

            public void setCoach_id(int coach_id) {
                this.coach_id = coach_id;
            }

            public String getNum() {
                return num;
            }

            public void setNum(String num) {
                this.num = num;
            }

            public int getT() {
                return t;
            }

            public void setT(int t) {
                this.t = t;
            }

            public int getIsin() {
                return isin;
            }

            public void setIsin(int isin) {
                this.isin = isin;
            }

            public List<AppointmentBeanX> getAppointment() {
                return appointment;
            }

            public void setAppointment(List<AppointmentBeanX> appointment) {
                this.appointment = appointment;
            }

            public static class AppointmentBeanX {
                /**
                 * time : 8:00-10:00
                 * hasNum : 0
                 * notNum : 4
                 */

                private String time;
                private int hasNum;
                private int notNum;

                public String getTime() {
                    return time;
                }

                public void setTime(String time) {
                    this.time = time;
                }

                public int getHasNum() {
                    return hasNum;
                }

                public void setHasNum(int hasNum) {
                    this.hasNum = hasNum;
                }

                public int getNotNum() {
                    return notNum;
                }

                public void setNotNum(int notNum) {
                    this.notNum = notNum;
                }
            }
        }
    }
}
