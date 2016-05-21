package com.example.krishna.mytvapp.presenter;

import android.content.Context;
import android.graphics.Color;
import android.support.v17.leanback.widget.Presenter;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Navkrishna on May, 21 2016
 */
public class GridTextItemPresenter extends Presenter {
    private static final String TAG = "GridTextItemPresenter";
    private static Context mContext;
    private static final int GRID_ITEM_WIDTH = 313;
    private static final int GRID_ITEM_HEIGHT = 176;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        mContext = parent.getContext();
        TextView textView = new TextView(mContext);
        textView.setLayoutParams(new ViewGroup.LayoutParams(GRID_ITEM_WIDTH, GRID_ITEM_HEIGHT));
        textView.setFocusable(true);
        textView.setFocusableInTouchMode(true);
        textView.setBackgroundColor(Color.BLUE);
        textView.setTextColor(Color.WHITE);
        textView.setGravity(Gravity.CENTER);
        return new ViewHolder(textView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        ((TextView) viewHolder.view).setText((String) item);
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {

    }
}
