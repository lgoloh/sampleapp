package com.example.leslieg.sampleapp;

import android.content.Context;
import android.gesture.Gesture;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class ContactListClickListener implements RecyclerView.OnItemTouchListener {

    private ClickListener mlistener;
    private GestureDetector gestureDetector;
    private Context mContext;

    public ContactListClickListener(Context context, final RecyclerView recyclerView, final ClickListener listener) {
        mContext = context;
        mlistener = listener;
        gestureDetector = new GestureDetector(mContext, new GestureDetector.SimpleOnGestureListener(){
            //consumes the tap event
            @Override
            public boolean onSingleTapUp(MotionEvent e) {return true;}
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent e) {
        View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
        if(child != null && mlistener != null && gestureDetector.onTouchEvent(e)) {
            mlistener.onClick(child, recyclerView.getChildAdapterPosition(child));
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent e){}

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept){}

}
