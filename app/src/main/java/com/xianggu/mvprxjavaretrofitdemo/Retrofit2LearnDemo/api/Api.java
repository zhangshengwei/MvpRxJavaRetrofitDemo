package com.xianggu.mvprxjavaretrofitdemo.Retrofit2LearnDemo.api;

import com.xianggu.mvprxjavaretrofitdemo.Retrofit2LearnDemo.module.BaseData;
import com.xianggu.mvprxjavaretrofitdemo.Retrofit2LearnDemo.module.BookBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * @Description:  参考地址:https://blog.csdn.net/m0_37796683/article/details/90702095
 * @Author: xianggu
 * @CreateDate: 2019-09-17 21:18
 */
public interface Api {

    //完整api路径   http://porth5.haokanread.com/index/searchHot/page/1/limit/6   通过post请求

    //Retrofit2  网络请求的完整地址Url = Retrofit实例.baseUrl()+网络请求接口注解()
    /*----------------------------------------@GET------------------------------------------*/
//    @GET("pub/bible/available/all")
//    Call<BibleBean> getBibleData();


    /**
     * 通过具体参数请求
     * @Query           请求参数注解，用于Get请求中的参数
     * id/name          参数字段，与后台给的字段需要一致
     * long/String      声明的参数类型
     * idLon/nameStr    实际参数
     */
//    Call<BibleBean> getBibleData(@Query("id") long idLon, @Query("name") String nameStr);

    /**
     * 用于不确定的参数
     * @QueryMap                     请求参数注解，与@Query类似，用于不确定表单参数
     * Map<String, Object> map       通过Map将不确定的参数传入，相当于多个Query参数
     */
//    Call<BibleBean> getData3(@QueryMap Map<String, Object> map);



    /*----------------------------------------@POST------------------------------------------*/
    /**
     * @FormUrlEncoded        请求格式注解，请求实体是一个From表单，每个键值对需要使用@File注解
     */
//    @FormUrlEncoded
//    @POST("pub/bible/available/all")
//    Call<BibleBean> getPostData();

    /**
     * @Field                 请求参数注解，提交请求的表单字段，必须要添加，而且需要配合@FormUrlEncoded使用
     * "name"/"sex"           参数字段，与后台给的字段需要一致
     * String                 声明的参数类型
     * nameStr/sexStr         实际参数，表示后面nameStr的取值作为"name"的值，sexStr的取值作为"sex"的值
     */
//    Call<BibleBean> getPostData2(@Field("name") String nameStr, @Field("sex") String sexStr);


    /**
     * @FieldMap                    请求参数注解，与@Field作用一致，用于不确定表单参数
     * Map<String, Object> map      通过Map将不确定的参数传入，相当于多个Field参数
     */
//    Call<BibleBean> getPsotData3(@FieldMap Map<String, Object> map);

    /**
     * @Body          上传json格式数据，直接传入实体它会自动转为json，这个转化方式是GsonConverterFactory定义的
     * 适用于Post请求的还有一个注解@Body，@Body可以传递自定义类型数据给服务器，
     * 多用于post请求发送非表单数据，比如用传递Json格式数据，它可以注解很多东西，比如HashMap、实体类等，我们来看看它用法：
     */
//    Call<BibleBean> getPsotDataBody(@Body BibleBean body);



    /*----------------------------------------@HTTP------------------------------------------*/

    //@HTTP注解的作用是替换@GET、@POST、@PUT、@DELETE、@HEAD以及更多拓展功能

    /**
     * method             表示请求的方法，区分大小写，这里的值retrofit不会再做任何处理，必须要保证正确
     * path               网络请求地址路径
     * hasBody            是否有请求体，boolean类型
     * @return
     */
//    @HTTP(method = "GET", path = "pub/bible/available/all", hasBody = false)
//    Call<BibleBean> getHttpData();



    /*----------------------------------------@Path------------------------------------------*/

    /**
     * @Path                     请求参数注解，用于Url中的占位符{}，所有在网址中的参数
     * @Path注解用于Url中的占位符{}，所有在网址中的参数，如上面的id，通过{}占位符来标记id，使用@Path注解传入idLon的值，
     * 注意有的Url既有占位符又有"?"后面的键值对，其实@Query和@Path两者是可以共用的。在发起请求时，{id}会被替换为方法中第二个参数的值idLon。
     */
//    @GET("orgs/{id}")
//    Call<BibleBean> getPathData(@Query("name") String nameStr, @Path("id") long idLon);



    /*----------------------------------------@Url------------------------------------------*/

    /**
     * @Url                         表示指定请求路径，可以当做参数传入
     * 如果需要重新地址接口地址，可以使用@Url，将地址以参数的形式传入即可。如果有@Url注解时，GET传入的Url可以省略。
     */
//    @GET
//    Call<BibleBean> getUrlData(@Url String nameStr, @Query("id") long idLon);


    /*----------------------------------------@Header,@Headers------------------------------------------*/

    /**
     * @header                      请求头注解，用于添加不固定请求头
     * 我们可以在方法参数内添加请求头，@Header用于添加不固定的请求头，作用于方法的参数，作为方法的参数传入，该注解会更新已有的请求头
     */
//    @GET("user/emails")
//    Call<BibleBean> getHeaderData(@Header("token") String token);

    /**
     * @headers                      请求头注解，用于添加固定请求头，可以添加多个
     * 我们想对某个方法添加固定请求头时可以参考下面的写法，
     * @headers用于添加固定的请求头，作用于方法，可以同时添加多个，通过该注解添加的请求头不会相互覆盖，而是共同存在。
     */
//    @Headers({"phone-type:android", "version:1.1.1"})
//    @GET("user/emails")
//    Call<BibleBean> getHeadersData();



    /*----------------------------------------@Streaming------------------------------------------*/

    /**
     * @Streaming                 表示响应体的数据用流的方式返回，使用于返回数据比较大，该注解在下载大文件时特别有用
     * 我们在使用下载比较大的文件的时候需要添加@Streaming注解
     */
//    @Streaming
//    @POST("gists/public")
//    Call<BibleBean> getStreamingBig();



    /*----------------------------------------@Multipart、@part、@PartMap------------------------------------------*/

    /**
     * @Multipart        表示请求实体是一个支持文件上传的表单，需要配合@Part和@PartMap使用，适用于文件上传
     * @Part             用于表单字段，适用于文件上传的情况，@Part支持三种类型：RequestBody、MultipartBody.Part、任意类型
     * @PartMap          用于多文件上传， 与@FieldMap和@QueryMap的使用类似
     * 上面的使用是一个上传文字和文件的写法，在使用@Part注解时需要在头部添加@Multipart注解，实现支持文件上传，我们来看看上面代码怎么使用：
     */
//    @Multipart
//    @POST("user/followers")
//    Call<BibleBean> getPartData(@Part("name") RequestBody name, @Part MultipartBody.Part file);


    //http://porth5.haokanread.com/index/searchHot/page/1/limit/6
    @POST("index/searchHot/page/1/limit/6")
    Call<BaseData<List<BookBean>>> getBookData();
}
