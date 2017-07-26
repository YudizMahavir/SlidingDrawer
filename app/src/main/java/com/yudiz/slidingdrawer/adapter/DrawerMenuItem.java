package com.yudiz.slidingdrawer.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yudiz.slidingdrawer.R;
import com.yudiz.slidingdrawer.databinding.RowDrawerItemBinding;


/**
 * Created by yudiz on 26/07/17.
 */

public class DrawerMenuItem extends RecyclerView.Adapter<DrawerMenuItem.DrawerMenuViewHolder> {

    private int mMenuDrawable[] = new int[]{

            R.mipmap.ic_launcher, R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};
    private int mMenuTitle[] = new int[]{
            R.string.home, R.string.my_submitted_icons, R.string.notifications, R.string.more};
    private LayoutInflater mInflater;
    private Context mContext;

    public DrawerMenuItem(Context context) {
        mInflater = LayoutInflater.from(context);
        mContext = context;
    }

    @Override
    public DrawerMenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.row_drawer_item, parent, false);
        return new DrawerMenuViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DrawerMenuViewHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return mMenuDrawable.length;
    }

    private String getString(int position) {
        return mContext.getString(mMenuTitle[position]);
    }

    public class DrawerMenuViewHolder extends RecyclerView.ViewHolder {

        private RowDrawerItemBinding mRowDrawerItemBinding;

        public DrawerMenuViewHolder(View itemView) {
            super(itemView);
            mRowDrawerItemBinding = DataBindingUtil.bind(itemView);
        }

        public void setData(int position) {
            mRowDrawerItemBinding.rowDrawerTvTitle.setText(getString(position));
            mRowDrawerItemBinding.rowDrawerIvIcon.setImageResource(mMenuDrawable[position]);
        }
    }

}
