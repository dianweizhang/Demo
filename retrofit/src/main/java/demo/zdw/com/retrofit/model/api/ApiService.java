package demo.zdw.com.retrofit.model.api;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by yidatec on 2019/2/19.
 *
 * Retrofit 是一个RESTful的HTTP网络请求框架的封装，它将Http请求抽象成Java接口：采用"注解"描述网络请求参数和配置网络请求参数。
 */

public interface ApiService {

    /**
     * 注解类型：
     * 网络请求关键字 ：
     * @GET
     * @POST
     * @DELETE
     * @PUT
     * @PATH
     * @HEAD
     * @OPTIONS
     * @HTTP
     */
    @GET("body/")
    Call<ResponseBody> getResponseBody1();

    /**
     * @HTTP 作用：替换@GET、@POST、@PUT、@DELETE、@HEAD注解的作用 及 更多功能拓展
     * method：网络请求的方法（区分大小写）
     * path：网络请求地址路径
     * hasBody：是否有请求体
     */
    @HTTP(method = "GET", path = "body/", hasBody = false)
    Call<ResponseBody> getResponseBody2();

    /**
     * 注解类型：
     * 标记关键字：
     * @FormUrlEncoded  : 表示请求体是一个Form表单，发送form-encoded的数据。每个键值对需要用@Field来注解键名，随后的对象需要提供值。（Key-Value）
     * @Multipart       ：表示请求体是一个支持文件上传的Form表单，发送form-encoded的数据。每个键值对需要用@Part来注解键名，随后的对象需要提供值。
     * @Streaming       ：表示返回的数据以流的形式返回；适用于返回数据量较大的场景。
     */
    @POST("form/")
    @FormUrlEncoded
    Call<ResponseBody> testFormUrlEncoded(@Field("username") String name, @Field("password") String password);
    //使用ex：  Call<ResponseBody> call = service.testFormUrlEncoded1("Carson", "123456");

    @POST("form/")
    @Multipart
    Call<ResponseBody> testMultipart(@Part("name") RequestBody name, @Part MultipartBody.Part file);
    // 使用ex： RequestBody name = RequestBody.create(textType, "Carson");
    // MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", "test.txt", file);
    // Call<ResponseBody> call3 = service.testFileUpload1(name, filePart);

    /**
     * 注解类型：
     * 网络请求参数关键字：
     * @Headers     添加请求头
     * @Header      添加不固定的请求头
     * @HeaderMap   添加不固定的请求头
     * @Body        用于非表单请求体
     * @Field       向POST表单传入键值对
     * @FieldMap    向POST表单传入键值对
     * @Part        用于表单字段（文件上传）
     * @PartMap     用于表单字段（文件上传）
     * @Query       用于表单字段，功能同@Field，区别在于@Query的数据体现在URL上面；@Field数据体现在请求体上
     * @QueryMap    用于表单字段，功能同@FieldMap，区别在于@QueryMap的数据体现在URL上面；@FieldMap数据体现在请求体上
     * @Path        URL 缺省值
     * @URL         URL设置
     */

    /**
     *  @Header 作用于方法的参数,用于添加不固定的请求头
     */
    @GET("user")
    Call<ResponseBody> getUser(@Header("Authorization") String authorization);

    /**
     *
     * @Headers 作用于方法,用于添加固定的请求头
     */
    @Headers("Authorization: authorization")
    @GET("user")
    Call<ResponseBody> getUser();

    /**
     *@HeaderMap 作用于参数，用于添加不固定的请求头Map<,>形式
     */
    @GET("user")
    Call<ResponseBody> getUser(@HeaderMap Map<String, String> pHeaders);

    /**
     * @Body 以Post方式传递自定义数据类型给服务器
     * RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), pBody);
     */
    @POST("data")
    Call<ResponseBody> postData(@Header("header") String header, @Body RequestBody body);

    /**
     * @Query 用于@GET方法的查询参数（Query = Url 中 ‘?’ 后面的 key-value）如：url = http://www.println.net/?name=zhangsan，其中，Query = name
     */
    @GET("user")
    Call<String> getUser2(@Query("name") String username);

    /**
     *@Path 作用：URL地址的缺省值.
     */
    @GET("users/{user}/repos")
    Call<ResponseBody>  getBlog(@Path("user") String user);

    /**
     * @Url作用：直接传入一个请求的 URL变量 用于URL设置
     * 当有URL注解时，@GET传入的URL就可以省略,使用的是参数url作为请求的访问地址
     * 注：使用@Url时，不需要为@GET、@POST配置路径参数
     */
    @GET
    Call<ResponseBody> testUrlAndQuery(@Url String url, @Query("showAll") boolean showAll);


    /**
     * 同RxJava配合使用时，返回类型为Observable
     * @return
     */
    @GET("test")
    Observable<ResponseBody> testRxJava();
}
