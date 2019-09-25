package com.xianggu.mvprxjavaretrofitdemo.Retrofit2LearnDemo.module;

import java.util.List;

/**
 * @Description:
 * @Author: xianggu
 * @CreateDate: 2019-09-17 21:21
 */
public class BibleBean {


    /**
     * title : 中文圣经
     * bibles : [{"bible_group_id":"55","crawler_status":"1","desc":"使用最广泛时间最长,也是最有权威性的一种版本圣经","file_size":"3.187MB","file_url":"txt/简体和合本V4.txt","id":"732","name":"简体和合本","s_name":"和合本","sourceurl":"http://www.chinesebibleonline.com","status":"1","type":"0"},{"bible_group_id":"55","crawler_status":"1","desc":"新翻译的圣经版本,可以作为参考之用","file_size":"3.504MB","file_url":"txt/简体新译本.txt","id":"679","name":"简体新译本","s_name":"新译本","sourceurl":"http://www.godcom.net//xinyiben//index.htm","status":"1","type":"0"},{"bible_group_id":"55","crawler_status":"1","desc":"繁体中文版新译本圣经","file_size":"3.504MB","file_url":"txt/繁体新译本.txt","id":"680","name":"繁体新译本","s_name":"新譯本","sourceurl":"http://www.godcom.net//xyb5//index.htm","status":"1","type":"0"}]
     */

    private String title;
    private List<BiblesBean> bibles;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<BiblesBean> getBibles() {
        return bibles;
    }

    public void setBibles(List<BiblesBean> bibles) {
        this.bibles = bibles;
    }

    public static class BiblesBean {
        /**
         * bible_group_id : 55
         * crawler_status : 1
         * desc : 使用最广泛时间最长,也是最有权威性的一种版本圣经
         * file_size : 3.187MB
         * file_url : txt/简体和合本V4.txt
         * id : 732
         * name : 简体和合本
         * s_name : 和合本
         * sourceurl : http://www.chinesebibleonline.com
         * status : 1
         * type : 0
         */

        private String bible_group_id;
        private String crawler_status;
        private String desc;
        private String file_size;
        private String file_url;
        private String id;
        private String name;
        private String s_name;
        private String sourceurl;
        private String status;
        private String type;

        public String getBible_group_id() {
            return bible_group_id;
        }

        public void setBible_group_id(String bible_group_id) {
            this.bible_group_id = bible_group_id;
        }

        public String getCrawler_status() {
            return crawler_status;
        }

        public void setCrawler_status(String crawler_status) {
            this.crawler_status = crawler_status;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getFile_size() {
            return file_size;
        }

        public void setFile_size(String file_size) {
            this.file_size = file_size;
        }

        public String getFile_url() {
            return file_url;
        }

        public void setFile_url(String file_url) {
            this.file_url = file_url;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getS_name() {
            return s_name;
        }

        public void setS_name(String s_name) {
            this.s_name = s_name;
        }

        public String getSourceurl() {
            return sourceurl;
        }

        public void setSourceurl(String sourceurl) {
            this.sourceurl = sourceurl;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
