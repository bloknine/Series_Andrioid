package com.bloknine.series;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeScreen extends Activity {
	Question q;
	int[] ques;
	int hiddenIndex;
	int marks;
	
	TextView tvQues,tvMarks,tvExplain,tt;
	Button bCheck,bNext;
	EditText etNumber;
	CountDownTimer ct;
	String hh,mm,ss;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_screen);
		
		ques = new int[11];
		q = new Question(10);
		tvQues = (TextView) findViewById(R.id.textView3);tvQues.setText("");
		tvMarks = (TextView) findViewById(R.id.textView2);tvMarks.setText("0");
		tt=(TextView) findViewById(R.id.textView4);tt.setText("00:00:00");
		//tvExplain = (TextView) findViewById(R.id.textView2);tvExplain.setText("");
		bCheck = (Button) findViewById(R.id.button1);
		bNext = (Button) findViewById(R.id.button2);
		etNumber = (EditText) findViewById(R.id.editText1);
		
		ques = q.generateQuestion(Question.EASY);
		hiddenIndex = new java.util.Random().nextInt(8);
		for (int i = 0; i < 8; i++) {
			if (i!=hiddenIndex && i!=7)
			{
				tvQues.setText(tvQues.getText().toString() + ques[i] + ", ");
			}
			else if(i==hiddenIndex && i!=7)
			{
				tvQues.setText(tvQues.getText().toString() + "?, ");
			}
			else if (i!=hiddenIndex)
			{
				tvQues.setText(tvQues.getText().toString() + ques[i]);
			}
			else 
			{
				tvQues.setText(tvQues.getText().toString() + "?");
			}
		}
		ct=new CountDownTimer(120000,1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				// TODO Auto-generated method stub
				hh="00";
				mm="0"+(millisUntilFinished/1000/60)+"";
				ss=((millisUntilFinished/1000)%60)+"";
				tt.setText(hh+":"+mm+":"+ss);
				
			}
			
			@Override
			public void onFinish() {
				// TODO Auto-generated method stub
				tt.setText("SUckaaaaaaaa");
			}
		}.start();
		bCheck.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String s=" ";
				
				if(etNumber.getText().toString().length()>0)
				{
					 if(Integer.parseInt(etNumber.getText().toString()) == ques[hiddenIndex])
					{
						s="Correct!!";
						marks += q.getMarks();
						tvMarks.setText(marks+"");
						tvQues.setText("");
						etNumber.setText("");
					}
				else
					{
						tvQues.setText("");
						etNumber.setText("");
						s="Incorrect";
					}
				Toast.makeText(HomeScreen.this, s, Toast.LENGTH_SHORT).show();
				//tvExplain.setText(q.getExplanation());
				ques = q.generateQuestion(Question.EASY);
				hiddenIndex = new java.util.Random().nextInt(8);
				for (int i = 0; i < 8; i++) {
					if (i!=hiddenIndex && i!=7)
					{
						tvQues.setText(tvQues.getText().toString() + ques[i] + ", ");
					}
					else if(i==hiddenIndex && i!=7)
					{
						tvQues.setText(tvQues.getText().toString() + "?, ");
					}
					else if (i!=hiddenIndex)
					{
						tvQues.setText(tvQues.getText().toString() + ques[i]);
					}
					else 
					{
						tvQues.setText(tvQues.getText().toString() + "?");
					}
				}
				
			}
			}
		});
		
		
		bNext.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				//tvExplain.setText("");tvQues.setText("");
				tvQues.setText("");
				etNumber.setText("");
				ques = q.generateQuestion(Question.MEDIUM);
				hiddenIndex = new java.util.Random().nextInt(8);
				for (int i = 0; i < 8; i++) {
					if (i!=hiddenIndex && i!=7)
					{
						tvQues.setText(tvQues.getText().toString() + ques[i] + ", ");
					}
					else if(i==hiddenIndex && i!=7)
					{
						tvQues.setText(tvQues.getText().toString() + "?, ");
					}
					else if (i!=hiddenIndex)
					{
						tvQues.setText(tvQues.getText().toString() + ques[i]);
					}
					else 
					{
						tvQues.setText(tvQues.getText().toString() + "?");
					}
				}		
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_screen, menu);
		return true;
	}

}
