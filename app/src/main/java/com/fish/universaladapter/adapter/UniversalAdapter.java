package com.fish.universaladapter.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class UniversalAdapter<T> extends BaseAdapter {

	protected Context context;
	protected int layoutId;
	protected LayoutInflater inflater;
	protected List<T> data;

	public UniversalAdapter(Context context, List<T> data, int layoutId) {
		this.context = context;
		this.inflater = LayoutInflater.from(context);
		this.layoutId = layoutId;
		this.data = data;
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public T getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = ViewHolder.getInstance(context, convertView,
				parent, layoutId, position);

		update(holder, getItem(position));

		return holder.getConvertView();
	}

	public abstract void update(ViewHolder holder, T data);
}
