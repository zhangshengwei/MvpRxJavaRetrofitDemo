package com.xianggu.mvprxjavaretrofitdemo.rxjava;

import com.xianggu.mvprxjavaretrofitdemo.MyApplication;

/**
 * @author parting_soul
 * @date 2018/1/28
 */

public class Config {

    /**
     * FileProvider授权信息
     */
    public static final String AUTHORITY_FILE_PROVIDER = AppUtils.getAppPackageName() + ".fileProvider";

    public interface NetWorkConfig {
        /**
         * 默认超时时间
         */
        long DEFAULT_TIMEOUT = 15000;


        /**
         * baseUrl
         */
        String BASE_URL = "http://120.55.22.53:8797/";
        //        String BASE_URL = "http://10.1.1.152:8797/";
        String BASE_UR = "http://10.1.1.152:8797";

        /**
         * 用户前缀
         */
        String BASE_USER_URL = BASE_URL + "usr";

        /**
         * 图片前缀
         */
        String BASE_PIC_URL = "http://pic.ecook.cn/web/";

        /**
         * 图片信息提交
         */
        String ALI_BASE_IMG_URL = "https://njliotu.oss-cn-hangzhou.aliyuncs.com/web/";
    }

    /**
     * 网络请求状态响应码
     */
    public interface NetWorkResponseCode {
        /**
         * 请求成功
         */
        String RESPONSE_CODE_SUCCESS = "0";


        String RESPONSE_BQG_CODE_SUCCESS = "200";
    }

    public static class FilePath {
        public static String FILE_CACHE_PATH = MyApplication.getContext().getExternalCacheDir().getAbsolutePath();

    }
}
