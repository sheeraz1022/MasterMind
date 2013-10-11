package com.example.mastermind;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Question extends Activity {
	
	private TextView question;
	private Button optionA;
	private Button optionB;
	private Button optionC;
	private Button optionD;
	private Button submit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question);
		
		initialize();
		
		submit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent resultIntent = new Intent(v.getContext(),Result.class);
				startActivity(resultIntent);
				overridePendingTransition( R.anim.slide_in_left, R.anim.slide_out_left );
			}
		});
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.question, menu);
		return true;
	}
	
	
	private void initialize(){
		question = (TextView) findViewById(R.id.question);
		optionA = (Button) findViewById(R.id.optionA);
		optionB = (Button) findViewById(R.id.optionB);
		optionC = (Button) findViewById(R.id.optionC);
		optionD = (Button) findViewById(R.id.optionD);
		submit = (Button) findViewById(R.id.submit);	
	}

}
