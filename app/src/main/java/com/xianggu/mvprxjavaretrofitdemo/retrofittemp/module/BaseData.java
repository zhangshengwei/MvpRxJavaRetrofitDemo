package com.xianggu.mvprxjavaretrofitdemo.retrofittemp.module;

/**
 * @Description:
 * @Author: xianggu
 * @CreateDate: 2019-09-18 19:52
 */
public class BaseData<T> {

    private T data;
    private int code;
    private String msg;
    /**
     * extra : {"count":374,"page":"1","limit":"6"}
     * data : [{"book_id":49,"book_title":"元尊武魂"},{"book_id":32,"book_title":"我的淘宝通六界"},{"book_id":31,"book_title":"超能小神医"},{"book_id":448,"book_title":"暖婚君爱"},{"book_id":19,"book_title":"恶魔帝少轻轻宠"},{"book_id":42,"book_title":"神级龙卫"}]
     */

    private ExtraBean extra;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ExtraBean getExtra() {
        return extra;
    }

    public void setExtra(ExtraBean extra) {
        this.extra = extra;
    }

    public static class ExtraBean {
        /**
         * count : 374
         * page : 1
         * limit : 6
         */

        private int count;
        private String page;
        private String limit;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getLimit() {
            return limit;
        }

        public void setLimit(String limit) {
            this.limit = limit;
        }
    }

//    public T getExtra() {
//        return extra;
//    }
//
//    public void setExtra(T extra) {
//        this.extra = extra;
//    }
}
