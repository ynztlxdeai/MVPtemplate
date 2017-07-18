package com.vincent.template.rx;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import io.reactivex.Flowable;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.PublishProcessor;

/**
 * projectName: 	    Template
 * packageName:	        com.vincent.template.rx
 * className:	        RxBus
 * author:	            Luoxiang
 * time:	            2017/7/18	9:00
 * desc:	            升级RXBUG
 *
 * svnVersion:	        $Rev
 * upDateAuthor:	    Vincent
 * upDate:	            2017/7/18
 * upDateDesc:	        TODO
 */
public class RxBus {
    private static RxBus mInstance;

    @SuppressWarnings("rawtypes")
    private ConcurrentHashMap<Object, List<FlowableProcessor>> mProcessorMapper = new ConcurrentHashMap<Object, List<FlowableProcessor>>();

    private RxBus() {}

    public static RxBus getInstance() {
        if (mInstance == null) {
            synchronized (RxBus.class) {
                if (mInstance == null) {
                    mInstance = new RxBus();
                }
            }
        }
        return mInstance;
    }

    public <T> Flowable<T> register(@NonNull Object tag) {
        List<FlowableProcessor> processors = mProcessorMapper.get(tag);
        if (null == processors) {
            processors = new ArrayList<FlowableProcessor>();
            mProcessorMapper.put(tag, processors);
        }
        FlowableProcessor<T> processor;
        processors.add(processor = PublishProcessor.create());
        return processor;
    }

    @SuppressWarnings("rawtypes")
    public void unregister(@NonNull Object tag) {
        List<FlowableProcessor> processors = mProcessorMapper.get(tag);
        if (null != processors) {
            mProcessorMapper.remove(tag);
        }
    }

    /**
     * 取消监听
     * @param tag
     * @param flowable
     * @return
     */
    @SuppressWarnings("rawtypes")
    public RxBus unregister(@NonNull Object tag,
                            @NonNull Flowable<?> flowable) {
        if (null == flowable)
            return getInstance();
        List<FlowableProcessor> processors = mProcessorMapper.get(tag);
        if (null != processors) {
            processors.remove((FlowableProcessor<?>) flowable);
            if (isEmpty(processors)) {
                mProcessorMapper.remove(tag);
            }
        }
        return getInstance();
    }

    public void post(@NonNull Object content) {
        post(content.getClass().getName(), content);
    }

    /**
     * 触发事件
     *
     * @param content
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void post(@NonNull Object tag, @NonNull Object content) {
        List<FlowableProcessor> processors = mProcessorMapper.get(tag);
        if (!isEmpty(processors)) {
            for (FlowableProcessor processor : processors) {
                processor.onNext(content);
            }
        }
    }

    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(Collection<FlowableProcessor> collection) {
        return null == collection || collection.isEmpty();
    }
}
