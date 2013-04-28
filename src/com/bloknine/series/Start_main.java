package com.bloknine.series;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class Start_main extends Activity {
	Button b1,b2,b3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start);
		
		b1= (Button) findViewById(R.id.button1);
		b2= (Button) findViewById(R.id.button2);
		b3= (Button) findViewById(R.id.button3);
		
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Start_main.this, Faster.class));
				}
		});
	}
}
