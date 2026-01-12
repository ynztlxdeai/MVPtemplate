package com.vincent.template.net;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * packageName:	    com.vincent.template.net
 * className:	    RetrofitHelper
 * author:	        Luoxiang
 * time:	        2017/4/28	6:35
 * desc:	        网络
 *
 * svnVersion:
 * upDateAuthor:    Vincent
 * upDate:          2017/4/28
 * upDateDesc:      TODO
 */

public class RetrofitHelper
{

    private static OkHttpClient mOkHttpClient;

    static
    {
        initOkHttpClient();
    }

    /**
     * 根据传入的baseUrl，和api创建retrofit
     *
     * @param clazz
     * @param baseUrl
     * @param <T>
     * @return
     */
    private static <T> T createApi(Class<T> clazz, String baseUrl)
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(clazz);
    }


    /**
     * 初始化OKHttpClient,设置缓存,设置超时时间,设置打印日志,设置UA拦截器
     */
    private static void initOkHttpClient()
    {

        if (mOkHttpClient == null)
        {
            synchronized (RetrofitHelper.class)
            {
                if (mOkHttpClient == null)
                {
                    mOkHttpClient = new OkHttpClient.Builder()
                            .retryOnConnectionFailure(true)
                            .writeTimeout(10, TimeUnit.MINUTES)
                            .connectTimeout(1, TimeUnit.MINUTES)
                            .readTimeout(30, TimeUnit.SECONDS)
                            //.addInterceptor(getInterceptor())
                            .build();
                }
            }
        }
    }

    private static Interceptor getInterceptor(){
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain)
                    throws IOException
            {
                HttpUrl url = chain.request()
                                   .url();
                return chain.proceed(chain.request());
            }
        };
        return interceptor;
    }
}
