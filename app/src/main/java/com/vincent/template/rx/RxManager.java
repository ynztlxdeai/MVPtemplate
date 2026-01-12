package com.vincent.template.rx;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;


/**
 * projectName: 	    Template
 * packageName:	        com.vincent.template.rx
 * className:	        RxManager
 * author:	            Luoxiang
 * time:	            2017/7/18	10:05
 * desc:	            TODO
 *
 * svnVersion:	        $Rev
 * upDateAuthor:	    Vincent
 * upDate:	            2017/7/18
 * upDateDesc:	        TODO
 */
public class RxManager {
    public  RxBus                    mRxBus        = RxBus.getInstance();
    //管理rxbus订阅
    private Map<String, Flowable<?>> mProcessorMap = new HashMap<>();
    private CompositeDisposable mDisposable   = new CompositeDisposable();

    public <T> void on(String eventName, Consumer<T> consumer) {
        Flowable<T> flowable = mRxBus.register(eventName);
        mProcessorMap.put(eventName, flowable);
        mDisposable.add(flowable.observeOn(AndroidSchedulers.mainThread())
                                .subscribe(consumer, throwable -> {
                                            throwable.printStackTrace();
                                        }));
    }

    public <T> void on(String eventName,
                       Consumer<T> consumer,
                       Consumer<? extends Throwable> throwable)
    {
        Flowable<T> flowable = mRxBus.register(eventName);
        mProcessorMap.put(eventName, flowable);
        mDisposable.add(flowable.observeOn(AndroidSchedulers.mainThread())
                                .subscribe(consumer, (Consumer<? super Throwable>) throwable));
    }

    public <T> void on(String eventName, Scheduler scheduler,
                       Consumer<T> consumer,
                       Consumer<? extends Throwable> throwable)
    {
        Flowable<T> flowable = mRxBus.register(eventName);
        mProcessorMap.put(eventName, flowable);
        mDisposable.add(flowable.observeOn(scheduler)
                                .subscribe(consumer, (Consumer<? super Throwable>) throwable));
    }

    public void add(Disposable disposable){
        mDisposable.add(disposable);
    }

    /**
     * 单个presenter生命周期结束，取消订阅和所有rxbus观察
     */
    public void clear() {
        // 取消所有订阅
        mDisposable.clear();
        for (Map.Entry<String, Flowable<?>> entry : mProcessorMap.entrySet()) {
            mRxBus.unregister(entry.getKey(), entry.getValue());// 移除rxbus观察
        }
    }

    //发送rxbus
    public void post(Object tag, Object content) {
        mRxBus.post(tag, content);
    }
}
