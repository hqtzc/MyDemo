package zc.test.com.mydemo.bean;

import java.util.List;

public class ContactBean {

    /**
     * code : 0
     * msg :
     * data : {"total":12,"per_page":10,"current_page":1,"last_page":2,"data":[{"id":"1b3f912d87dd24f0b621eb8a45e3828b","category_id":1,"title":"新闻资讯9","content":"新闻资讯9新闻资讯9新闻资讯9新闻资讯9新闻资讯9新闻资讯9新闻资讯9新闻资讯9新闻资讯9新闻资讯9新闻资讯9新闻资讯9","cover":"","create_time":"2019-06-27 10:30:00"},{"id":"5ec1ccaa9b3430f5fddcd0902107f3f3","category_id":1,"title":"新闻资讯8","content":"新闻资讯8新闻资讯8新闻资讯8新闻资讯8新闻资讯8新闻资讯8新闻资讯8新闻资讯8新闻资讯8新闻资讯8新闻资讯8新闻资讯8","cover":"","create_time":"2019-06-27 10:29:49"},{"id":"8d65a00e51e4d3d40f3861a6742c39e4","category_id":1,"title":"新闻资讯6","content":"新闻资讯6新闻资讯6新闻资讯6新闻资讯6新闻资讯6新闻资讯6新闻资讯6新闻资讯6新闻资讯6新闻资讯6新闻资讯6新闻资讯6","cover":"","create_time":"2019-06-27 10:29:28"},{"id":"a3dd9055bc4da18c064ae4f736854731","category_id":1,"title":"新闻资讯5","content":"新闻资讯5新闻资讯5新闻资讯5新闻资讯5新闻资讯5新闻资讯5新闻资讯5新闻资讯5新闻资讯5新闻资讯5新闻资讯5新闻资讯5","cover":"","create_time":"2019-06-27 10:29:15"},{"id":"a4f024bec24ac8aeb5e23430efe67eb8","category_id":1,"title":"新闻资讯12","content":"新闻资讯12新闻资讯12新闻资讯12新闻资讯12新闻资讯12新闻资讯12新闻资讯12新闻资讯12新闻资讯12新闻资讯12","cover":"","create_time":"2019-06-27 10:30:38"},{"id":"a5b1695c53b53976f1ce7390182ddc67","category_id":1,"title":"新闻资讯7","content":"新闻资讯7新闻资讯7新闻资讯7新闻资讯7新闻资讯7新闻资讯7新闻资讯7新闻资讯7新闻资讯7新闻资讯7新闻资讯7新闻资讯7","cover":"","create_time":"2019-06-27 10:29:38"},{"id":"b9e69943624bd793c63564b186f6dc4c","category_id":1,"title":"新闻资讯1","content":"新闻资讯1新闻资讯1新闻资讯1新闻资讯1新闻资讯1新闻资讯1新闻资讯1新闻资讯1新闻资讯1新闻资讯1新闻资讯1新闻资讯1","cover":"","create_time":"2019-06-27 10:28:13"},{"id":"bed610fb2407503a5d2ff07cf9d33a5d","category_id":1,"title":"新闻资讯3","content":"新闻资讯3新闻资讯3新闻资讯3新闻资讯3新闻资讯3新闻资讯3新闻资讯3新闻资讯3新闻资讯3新闻资讯3新闻资讯3新闻资讯3","cover":"","create_time":"2019-06-27 10:28:49"},{"id":"d5fc3558ec42d82ab4885fa4aaa68d32","category_id":1,"title":"新闻资讯4","content":"新闻资讯4新闻资讯4新闻资讯4新闻资讯4新闻资讯4新闻资讯4新闻资讯4新闻资讯4新闻资讯4新闻资讯4新闻资讯4新闻资讯4","cover":"","create_time":"2019-06-27 10:29:05"},{"id":"d96024e898789db73cb9fe68e84f729a","category_id":1,"title":"新闻资讯11","content":"新闻资讯11新闻资讯11新闻资讯11新闻资讯11新闻资讯11新闻资讯11新闻资讯11新闻资讯11新闻资讯11新闻资讯11","cover":"","create_time":"2019-06-27 10:30:27"}]}
     */

    private int code;
    private String msg;
    private DataBeanX data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * total : 12
         * per_page : 10
         * current_page : 1
         * last_page : 2
         * data : [{"id":"1b3f912d87dd24f0b621eb8a45e3828b","category_id":1,"title":"新闻资讯9","content":"新闻资讯9新闻资讯9新闻资讯9新闻资讯9新闻资讯9新闻资讯9新闻资讯9新闻资讯9新闻资讯9新闻资讯9新闻资讯9新闻资讯9","cover":"","create_time":"2019-06-27 10:30:00"},{"id":"5ec1ccaa9b3430f5fddcd0902107f3f3","category_id":1,"title":"新闻资讯8","content":"新闻资讯8新闻资讯8新闻资讯8新闻资讯8新闻资讯8新闻资讯8新闻资讯8新闻资讯8新闻资讯8新闻资讯8新闻资讯8新闻资讯8","cover":"","create_time":"2019-06-27 10:29:49"},{"id":"8d65a00e51e4d3d40f3861a6742c39e4","category_id":1,"title":"新闻资讯6","content":"新闻资讯6新闻资讯6新闻资讯6新闻资讯6新闻资讯6新闻资讯6新闻资讯6新闻资讯6新闻资讯6新闻资讯6新闻资讯6新闻资讯6","cover":"","create_time":"2019-06-27 10:29:28"},{"id":"a3dd9055bc4da18c064ae4f736854731","category_id":1,"title":"新闻资讯5","content":"新闻资讯5新闻资讯5新闻资讯5新闻资讯5新闻资讯5新闻资讯5新闻资讯5新闻资讯5新闻资讯5新闻资讯5新闻资讯5新闻资讯5","cover":"","create_time":"2019-06-27 10:29:15"},{"id":"a4f024bec24ac8aeb5e23430efe67eb8","category_id":1,"title":"新闻资讯12","content":"新闻资讯12新闻资讯12新闻资讯12新闻资讯12新闻资讯12新闻资讯12新闻资讯12新闻资讯12新闻资讯12新闻资讯12","cover":"","create_time":"2019-06-27 10:30:38"},{"id":"a5b1695c53b53976f1ce7390182ddc67","category_id":1,"title":"新闻资讯7","content":"新闻资讯7新闻资讯7新闻资讯7新闻资讯7新闻资讯7新闻资讯7新闻资讯7新闻资讯7新闻资讯7新闻资讯7新闻资讯7新闻资讯7","cover":"","create_time":"2019-06-27 10:29:38"},{"id":"b9e69943624bd793c63564b186f6dc4c","category_id":1,"title":"新闻资讯1","content":"新闻资讯1新闻资讯1新闻资讯1新闻资讯1新闻资讯1新闻资讯1新闻资讯1新闻资讯1新闻资讯1新闻资讯1新闻资讯1新闻资讯1","cover":"","create_time":"2019-06-27 10:28:13"},{"id":"bed610fb2407503a5d2ff07cf9d33a5d","category_id":1,"title":"新闻资讯3","content":"新闻资讯3新闻资讯3新闻资讯3新闻资讯3新闻资讯3新闻资讯3新闻资讯3新闻资讯3新闻资讯3新闻资讯3新闻资讯3新闻资讯3","cover":"","create_time":"2019-06-27 10:28:49"},{"id":"d5fc3558ec42d82ab4885fa4aaa68d32","category_id":1,"title":"新闻资讯4","content":"新闻资讯4新闻资讯4新闻资讯4新闻资讯4新闻资讯4新闻资讯4新闻资讯4新闻资讯4新闻资讯4新闻资讯4新闻资讯4新闻资讯4","cover":"","create_time":"2019-06-27 10:29:05"},{"id":"d96024e898789db73cb9fe68e84f729a","category_id":1,"title":"新闻资讯11","content":"新闻资讯11新闻资讯11新闻资讯11新闻资讯11新闻资讯11新闻资讯11新闻资讯11新闻资讯11新闻资讯11新闻资讯11","cover":"","create_time":"2019-06-27 10:30:27"}]
         */

        private int total;
        private int per_page;
        private int current_page;
        private int last_page;
        private List<DataBean> data;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPer_page() {
            return per_page;
        }

        public void setPer_page(int per_page) {
            this.per_page = per_page;
        }

        public int getCurrent_page() {
            return current_page;
        }

        public void setCurrent_page(int current_page) {
            this.current_page = current_page;
        }

        public int getLast_page() {
            return last_page;
        }

        public void setLast_page(int last_page) {
            this.last_page = last_page;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * id : 1b3f912d87dd24f0b621eb8a45e3828b
             * category_id : 1
             * title : 新闻资讯9
             * content : 新闻资讯9新闻资讯9新闻资讯9新闻资讯9新闻资讯9新闻资讯9新闻资讯9新闻资讯9新闻资讯9新闻资讯9新闻资讯9新闻资讯9
             * cover :
             * create_time : 2019-06-27 10:30:00
             */

            private String id;
            private int category_id;
            private String title;
            private String content;
            private String cover;
            private String create_time;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public int getCategory_id() {
                return category_id;
            }

            public void setCategory_id(int category_id) {
                this.category_id = category_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }
        }
    }
}
