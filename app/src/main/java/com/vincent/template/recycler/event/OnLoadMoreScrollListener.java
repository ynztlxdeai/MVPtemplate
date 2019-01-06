package com.vincent.template.recycler.event;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

/**
 * packageName:	    com.vincent.template.recycler.event
 * className:	    OnLoadMoreScrollListener
 * author:	        Luoxiang
 * time:	        2017/7/17	14:57
 * desc:	        滑动监听
 *
 * svnVersion:
 * upDateAuthor:    Vincent
 * upDate:          2017/7/17
 * upDateDesc:      TODO
 */
public abstract class OnLoadMoreScrollListener extends RecyclerView.OnScrollListener {

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        RecyclerView.LayoutManager layoutManager    = recyclerView.getLayoutManager();
        int                        visibleItemCount = layoutManager.getChildCount();


        boolean triggerCondition = visibleItemCount > 0
                && newState == RecyclerView.SCROLL_STATE_IDLE
                && canTriggerLoadMore(recyclerView);

        if (triggerCondition) {
            onLoadMore(recyclerView);
        }
    }

    public boolean canTriggerLoadMore(RecyclerView recyclerView) {
        View                       lastChild      = recyclerView.getChildAt(recyclerView.getChildCount() - 1);
        int                        position       = recyclerView.getChildLayoutPosition(lastChild);
        RecyclerView.LayoutManager layoutManager  = recyclerView.getLayoutManager();
        int                        totalItemCount = layoutManager.getItemCount();
        return totalItemCount - 1 == position;
    }

    public abstract void onLoadMore(RecyclerView recyclerView);
}
