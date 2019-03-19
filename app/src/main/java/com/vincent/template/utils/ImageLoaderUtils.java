package com.vincent.template.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.vincent.template.R;

import java.io.File;

/**
 * packageName:	    com.vincent.template.utils
 * className:	    ImageLoaderUtils
 * author:	        Luoxiang
 * time:	        19/03/2019	5:20 PM
 * desc:	        TODO
 *
 * svnVersion:
 * upDateAuthor:    luoxiang
 * upDate:          19/03/2019
 * upDateDesc:      TODO
 */

public class ImageLoaderUtils {

    public static void display(Context context,
                               ImageView imageView,
                               String url,
                               int placeholder,
                               int error)
    {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        RequestOptions options = new RequestOptions();
        options.placeholder(placeholder);
        options.error(error);
        Glide.with(context)
             .load(url)
             .apply(options)
             .into(imageView);
    }

    public static void display(Context context, ImageView imageView, String url) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        RequestOptions options = new RequestOptions();
        options.placeholder(R.mipmap.ic_image_loading);
        options.error(R.mipmap.ic_empty_picture);
        options.centerCrop();
        Glide.with(context)
             .load(url)
             .apply(options)
             .into(imageView);
    }

    public static void display4Corner(Context context, ImageView imageView, String url) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        RequestOptions options = new RequestOptions();
        RoundedCorners corners = new RoundedCorners(12);
        options.placeholder(R.mipmap.ic_image_loading);
        options.error(R.mipmap.ic_empty_picture);
        options.centerCrop();
        options.optionalTransform(corners);

        Glide.with(context)
             .load(url)
             .apply(options)
             .into(imageView);
    }



    public static void display4Listener(Context context, ImageView imageView, String url , RequestListener<Drawable> listener){
        RequestOptions options = new RequestOptions();
        options.placeholder(R.mipmap.ic_image_loading);
        options.error(R.mipmap.ic_empty_picture);
        options.centerCrop();
        Glide.with(context)
             .load(url)
             .listener(listener)
             .apply(options)
             .into(imageView);
    }

    public static void display4Header(Context context, ImageView imageView, String url , String headerKey , String  headerValue){
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        GlideUrl glideUrl = new GlideUrl(url , new LazyHeaders.Builder().addHeader(headerKey , headerValue).build());
        RequestOptions options = new RequestOptions();
        options.placeholder(R.mipmap.ic_image_loading);
        options.error(R.mipmap.ic_empty_picture);
        options.centerCrop();
        Glide.with(context)
             .load(glideUrl)
             .apply(options)
             .into(imageView);
    }

    public static void display(Context context, ImageView imageView, File url) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        RequestOptions options = new RequestOptions();
        options.placeholder(R.mipmap.ic_image_loading);
        options.error(R.mipmap.ic_empty_picture);
        options.centerCrop();
        Glide.with(context)
             .load(url)
             .into(imageView);
    }

    public static void displaySmallPhoto(Context context, ImageView imageView, String url) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }

        RequestOptions options = new RequestOptions();
        options.placeholder(R.mipmap.ic_image_loading);
        options.error(R.mipmap.ic_empty_picture);
        options.centerCrop();
        Glide.with(context)
             .load(url)
             .apply(options)
             .thumbnail(0.5f)
             .into(imageView);
    }

    public static void displaySmallPhoto(Context context, ImageView imageView, String url , int place) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }

        RequestOptions options = new RequestOptions();
        options.placeholder(place);
        options.error(place);
        options.centerCrop();
        Glide.with(context)
             .load(url)
             .apply(options)
             .thumbnail(0.5f)
             .into(imageView);
    }

    public static void displayBigPhoto(Context context, ImageView imageView, String url) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }


        RequestOptions options = new RequestOptions();
        options.placeholder(R.mipmap.ic_image_loading);
        options.error(R.mipmap.ic_empty_picture);

        Glide.with(context)
             .load(url)
             .apply(options)
             .into(imageView);
    }

    public static void display(Context context, ImageView imageView, int url) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }

        RequestOptions options = new RequestOptions();
        options.placeholder(R.mipmap.ic_image_loading);
        options.error(R.mipmap.ic_empty_picture);
        options.centerCrop();
        Glide.with(context)
             .load(url)
             .apply(options)
             .into(imageView);
    }

    public static void displayRound(Context context, ImageView imageView, String url) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }

        RequestOptions options = new RequestOptions();
        options.error(R.mipmap.toux2);
        options.centerCrop();
        options.circleCrop();
        Glide.with(context)
             .load(url)
             .apply(options)
             .into(imageView);
    }

}
