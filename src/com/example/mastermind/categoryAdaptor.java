package com.example.mastermind;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class categoryAdaptor extends ArrayAdapter<category>{
	private ArrayList<category> categories;
	public categoryAdaptor(Context context, int resource, int textViewResourceId,
			List<category> categories) {
		
		super(context, resource, textViewResourceId, categories);
		
		this.categories = (ArrayList<category>)categories;
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) getContext()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View row = inflater.inflate(R.layout.category_item, parent,false);
		
		TextView tv = (TextView) row.findViewById(R.id.text1);
		tv.setText(categories.get(position).getCategoryName());

		return row;
	}

}
