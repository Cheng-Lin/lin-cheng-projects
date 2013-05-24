package com.example.buscience;

import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.view.*;
import android.widget.*;

public class MainActivity extends TabActivity 
{
	TabHost tabHost;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tabHost = (TabHost)findViewById(android.R.id.tabhost);
		
		tabHost.addTab(tabHost.newTabSpec("tab_Home").setIndicator("Home", getResources().getDrawable(R.drawable.icon_home_tab)).setContent(new Intent(this, HomeActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("tab_Reg").setIndicator("Registration", getResources().getDrawable(R.drawable.icon_registration_tab)).setContent(new Intent(this, RegistrationActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("tab_Cert").setIndicator("Certification", getResources().getDrawable(R.drawable.icon_certification_tab)).setContent(new Intent(this, CertificationActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("tab_Eval").setIndicator("Evaluation", getResources().getDrawable(R.drawable.icon_evaluation_tab)).setContent(new Intent(this, EvaluationActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("tab_Contact").setIndicator("Contact", getResources().getDrawable(R.drawable.icon_contact_tab)).setContent(new Intent(this, ContactActivity.class)));
		
	    for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) 
	    {
	    	View v = tabHost.getTabWidget().getChildAt(i);
	    	v.setPadding(0, 0, 0, 0);
	        TextView tv = (TextView)v.findViewById(android.R.id.title);
	        tv.setTextColor(Color.parseColor("#808080"));
	        tv.setTextSize(8.5f);
	    }
	    
		tabHost.setCurrentTab(0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
