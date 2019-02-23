package intro.com.fristdrivingschool.Bean;

public class CoachDetailsBean {


    /**
     * ret : 200
     * data : {"id":1,"school_id":1,"name":"张教练","sex":1,"t":"8:00-10:00|10:00-12:00|13:00-15:00|15:00-17:00","num":4,"location":null,"license":"1,2","status":1,"connect":"15178669950","ctime":null,"deleted_at":null}
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
    }
}
