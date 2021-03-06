package com.example.mastermind;

import java.util.ArrayList;
import java.util.List;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseException;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

public class CategoriesList extends ListActivity {

	private ArrayList<category> categories;
	private ListView categoriesListView;
	private categoryAdaptor categoryAdap; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_categories_list);
		
		Parse.initialize(this, "T1G6lmYaLUDwDKv1W94EG8WBNF9KCmaTq2Azxa1n", "lVBX7Ba8OgAJRXuJeigXU8WMnSdbVUc3406qNgIu");
		
		CategoryAsyncTask asynTask = new CategoryAsyncTask();
		asynTask.execute();
		
		categoriesListView = (ListView) findViewById(android.R.id.list);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
 
		//get selected items
		category selectedCategory = (category) categoryAdap.getItem(position);
		
		Intent viewQuestion = new Intent(this,Question.class);
		viewQuestion.putExtra("category",selectedCategory);
        startActivity(viewQuestion);
        
        overridePendingTransition( R.anim.slide_in_left, R.anim.slide_out_left );
 
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.categories_list, menu);
		return true;
	}

  
	
	class CategoryAsyncTask extends AsyncTask<Void, Void, Void>
	{
		ProgressDialog progressDialog;
		
		@Override
		protected void onPreExecute() {
			progressDialog = new ProgressDialog(CategoriesList.this);
			progressDialog.setMessage("Please Wait!!!");
			progressDialog.show();
			super.onPreExecute();
		}
		
		@Override
		protected Void doInBackground(Void... params) {

			ParseQuery<ParseObject> query = ParseQuery.getQuery("Category");
			List<ParseObject> listObjects = null;
//			query.whereEqualTo("User", userObject);
			 try {
				listObjects = query.find();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			 categories = new ArrayList<category>();
			
			if (listObjects.size() > 0)
			{
				for (ParseObject parseObject : listObjects) {
					String catName = parseObject.getString("Category_Name");
					category category = new category(catName);
					categories.add(category);
				}
				
			}
			return null;
		}
		
		@Override
		protected void onPostExecute(Void result) {
			progressDialog.dismiss();
			loadAdapter();
			super.onPostExecute(result);
		}
	}
	
	private void loadAdapter()
	{
		categoryAdap = new categoryAdaptor(this, android.R.layout.simple_expandable_list_item_1,R.id.title,categories);
		categoriesListView.setAdapter(categoryAdap);

	}

}
