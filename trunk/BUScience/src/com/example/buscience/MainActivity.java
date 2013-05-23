package com.example.buscience;

import android.os.Bundle;
import android.app.TabActivity;
import android.view.Menu;
import android.widget.TabHost;

public class MainActivity extends TabActivity 
{
	TabHost tabHost;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tabHost = (TabHost)findViewById(android.R.id.tabhost);
		tabHost.addTab(tabHost.newTabSpec("tab_Home").setIndicator("Home").setContent(R.id.tab1));
		tabHost.addTab(tabHost.newTabSpec("tab_Reg").setIndicator("Registration").setContent(R.id.tab2));
		tabHost.addTab(tabHost.newTabSpec("tab_Cert").setIndicator("Certification").setContent(R.id.tab3));
		tabHost.addTab(tabHost.newTabSpec("tab_Eval").setIndicator("Evaluation").setContent(R.id.tab4));
		tabHost.addTab(tabHost.newTabSpec("tab_Contact").setIndicator("Contact").setContent(R.id.tab5));
		tabHost.setCurrentTab(0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
