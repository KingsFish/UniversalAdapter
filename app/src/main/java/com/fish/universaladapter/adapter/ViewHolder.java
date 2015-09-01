package com.fish.universaladapter.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ViewHolder {

	private SparseArray<View> data;
	private View convertView;
	private int position;
	
	public static ViewHolder getInstance(Context context, View convertView, ViewGroup parent, int layoutId, int position) {
		if (convertView == null) {
			return new ViewHolder(context, parent, layoutId, position);
		} else {
			ViewHolder holder = (ViewHolder)convertView.getTag();
			holder.position = position;
			return holder;
		}
	}
	
	private ViewHolder(Context context, ViewGroup parent, int layoutId, int position){
		this.position = position;
		data = new SparseArray<View>();
		convertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
		convertView.setTag(this);
	}
	
	/**
	 * 通过控件ID获取控件
	 * @param viewId 控件ID
	 * @return 控件
	 */
	public <T extends View> T getView(int viewId){
		View view = data.get(viewId);
		
		if (view == null) {
			view = convertView.findViewById(viewId);
			data.put(viewId, view);
		}
		
		return (T)view;
	}
	
	public View getConvertView(){
		return convertView;
	}
	
	public ViewHolder setText(int viewId, String text){
		TextView tv = getView(viewId);
		tv.setText(text);
		return this;
	}
	
}
