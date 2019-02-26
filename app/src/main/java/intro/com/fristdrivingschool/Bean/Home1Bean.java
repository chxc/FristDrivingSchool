package intro.com.fristdrivingschool.Bean;

import java.util.List;

public class Home1Bean {

    /**
     * ret : 200
     * data : {"coachdata":{"id":1,"school_id":1,"name":"张教练","sex":1,"t":"8:00-10:00|10:00-12:00|13:00-15:00|15:00-17:00","num":4,"location":null,"license":"1,2","status":1,"connect":"15178669950","ctime":null,"deleted_at":null,"date":3,"coach_id":1,"school":"必过"},"date":[{"id":18,"coach_id":1,"num":"|||","t":1551110400,"isin":0,"appointment":[{"sort":0,"time":"8:00-10:00","hasNum":0,"notNum":4},{"sort":1,"time":"10:00-12:00","hasNum":0,"notNum":4},{"sort":2,"time":"13:00-15:00","hasNum":0,"notNum":4},{"sort":3,"time":"15:00-17:00","hasNum":0,"notNum":4}]},{"id":19,"coach_id":1,"num":"|||","t":1551196800,"isin":0,"appointment":[{"sort":0,"time":"8:00-10:00","hasNum":0,"notNum":4},{"sort":1,"time":"10:00-12:00","hasNum":0,"notNum":4},{"sort":2,"time":"13:00-15:00","hasNum":0,"notNum":4},{"sort":3,"time":"15:00-17:00","hasNum":0,"notNum":4}]},{"id":20,"coach_id":1,"num":"|||","t":1551283200,"isin":0,"appointment":[{"sort":0,"time":"8:00-10:00","hasNum":0,"notNum":4},{"sort":1,"time":"10:00-12:00","hasNum":0,"notNum":4},{"sort":2,"time":"13:00-15:00","hasNum":0,"notNum":4},{"sort":3,"time":"15:00-17:00","hasNum":0,"notNum":4}]}]}
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
         * coachdata : {"id":1,"school_id":1,"name":"张教练","sex":1,"t":"8:00-10:00|10:00-12:00|13:00-15:00|15:00-17:00","num":4,"location":null,"license":"1,2","status":1,"connect":"15178669950","ctime":null,"deleted_at":null,"date":3,"coach_id":1,"school":"必过"}
         * date : [{"id":18,"coach_id":1,"num":"|||","t":1551110400,"isin":0,"appointment":[{"sort":0,"time":"8:00-10:00","hasNum":0,"notNum":4},{"sort":1,"time":"10:00-12:00","hasNum":0,"notNum":4},{"sort":2,"time":"13:00-15:00","hasNum":0,"notNum":4},{"sort":3,"time":"15:00-17:00","hasNum":0,"notNum":4}]},{"id":19,"coach_id":1,"num":"|||","t":1551196800,"isin":0,"appointment":[{"sort":0,"time":"8:00-10:00","hasNum":0,"notNum":4},{"sort":1,"time":"10:00-12:00","hasNum":0,"notNum":4},{"sort":2,"time":"13:00-15:00","hasNum":0,"notNum":4},{"sort":3,"time":"15:00-17:00","hasNum":0,"notNum":4}]},{"id":20,"coach_id":1,"num":"|||","t":1551283200,"isin":0,"appointment":[{"sort":0,"time":"8:00-10:00","hasNum":0,"notNum":4},{"sort":1,"time":"10:00-12:00","hasNum":0,"notNum":4},{"sort":2,"time":"13:00-15:00","hasNum":0,"notNum":4},{"sort":3,"time":"15:00-17:00","hasNum":0,"notNum":4}]}]
         */

        private CoachdataBean coachdata;
        private List<DateBean> date;

        public CoachdataBean getCoachdata() {
            return coachdata;
        }

        public void setCoachdata(CoachdataBean coachdata) {
            this.coachdata = coachdata;
        }

        public List<DateBean> getDate() {
            return date;
        }

        public void setDate(List<DateBean> date) {
            this.date = date;
        }

        public static class CoachdataBean {
            /**
             * id : 1
             * school_id : 1
             * name : 张教练
             * sex : 1
             * t : 8:00-10:00|10:00-12:00|13:00-15:00|15:00-17:00
             * num : 4
             * location : null
             * license : 1,2
             * status : 1
             * connect : 15178669950
             * ctime : null
             * deleted_at : null
             * date : 3
             * coach_id : 1
             * school : 必过
             */

            private int id;
            private int school_id;
            private String name;
            private int sex;
            private String t;
            private int num;
            private String location;
            private String license;
            private int status;
            private String connect;
            private String ctime;
            private String deleted_at;
            private int date;
            private int coach_id;
            private String school;

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

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
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

            public int getDate() {
                return date;
            }

            public void setDate(int date) {
                this.date = date;
            }

            public int getCoach_id() {
                return coach_id;
            }

            public void setCoach_id(int coach_id) {
                this.coach_id = coach_id;
            }

            public String getSchool() {
                return school;
            }

            public void setSchool(String school) {
                this.school = school;
            }
        }

        public static class DateBean {
            /**
             * id : 18
             * coach_id : 1
             * num : |||
             * t : 1551110400
             * isin : 0
             * appointment : [{"sort":0,"time":"8:00-10:00","hasNum":0,"notNum":4},{"sort":1,"time":"10:00-12:00","hasNum":0,"notNum":4},{"sort":2,"time":"13:00-15:00","hasNum":0,"notNum":4},{"sort":3,"time":"15:00-17:00","hasNum":0,"notNum":4}]
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

            public static class AppointmentBean {
                /**
                 * sort : 0
                 * time : 8:00-10:00
                 * hasNum : 0
                 * notNum : 4
                 */

                private int sort;
                private String time;
                private int hasNum;
                private int notNum;

                public int getSort() {
                    return sort;
                }

                public void setSort(int sort) {
                    this.sort = sort;
                }

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
