package com.vincent.template.recycler.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.vincent.template.recycler.MultiItemTypeSupport;
import com.vincent.template.recycler.ViewHolderHelper;

import java.util.List;

/**
 * packageName:	    com.vincent.template.recycler.adapter
 * className:	    MultiItemRecycleViewAdapter
 * author:	        Luoxiang
 * time:	        2017/6/8	14:31
 * desc:	        多类型条目
 *
 * svnVersion:
 * upDateAuthor:    Vincent
 * upDate:          2017/6/8
 * upDateDesc:      TODO
 */
public abstract class MultiItemRecycleViewAdapter<T> extends CommonRecycleViewAdapter<T>
{

    protected MultiItemTypeSupport<T> mMultiItemTypeSupport;

    public MultiItemRecycleViewAdapter(Context context, List<T> datas,
                                       MultiItemTypeSupport<T> multiItemTypeSupport)
    {
        super(context, -1, datas);
        mMultiItemTypeSupport = multiItemTypeSupport;

        if (mMultiItemTypeSupport == null)
            throw new IllegalArgumentException("the mMultiItemTypeSupport can not be null.");
    }
    public MultiItemRecycleViewAdapter(Context context, MultiItemTypeSupport<T> multiItemTypeSupport)
    {
        super(context, -1);
        mMultiItemTypeSupport = multiItemTypeSupport;

        if (mMultiItemTypeSupport == null)
            throw new IllegalArgumentException("the mMultiItemTypeSupport can not be null.");
    }

    @Override
    public int getItemViewType(int position)
    {
        if (mMultiItemTypeSupport != null)
            return mMultiItemTypeSupport.getItemViewType(position, mDatas.get(position));
        return super.getItemViewType(position);
    }

    @Override
    public ViewHolderHelper onCreateViewHolder(ViewGroup parent, int viewType)
    {
        if (mMultiItemTypeSupport == null) return super.onCreateViewHolder(parent, viewType);

        int layoutId = mMultiItemTypeSupport.getLayoutId(viewType);
        ViewHolderHelper holder = ViewHolderHelper.get(mContext, null, parent, layoutId, -1);
        setListener(parent, holder, viewType);
        return holder;
    }

}
