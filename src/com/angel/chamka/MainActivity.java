package com.angel.chamka;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import android.widget.*;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.os.Build;

public class MainActivity extends ActionBarActivity {
	EditText email,passwd;
	Button signup,signin;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		email = (EditText) findViewById(R.id.email);
		passwd = (EditText) findViewById(R.id.passwd);
		signup = (Button) findViewById(R.id.signup);
		signin = (Button) findViewById(R.id.signin);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
			signin.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				HttpClient httpclient = new DefaultHttpClient();
				HttpPost post = new HttpPost(
						"https://chamka-c9-tallguy.c9.io/hello-world.php");
				List<NameValuePair> pairs = new ArrayList<NameValuePair>();
				pairs.add(new BasicNameValuePair("operation", "signin"));
				pairs.add(new BasicNameValuePair("email", email.getText()
						.toString()));
				pairs.add(new BasicNameValuePair("password", passwd.getText()
						.toString()));
				try {
					post.setEntity(new UrlEncodedFormEntity(pairs));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					HttpResponse response = httpclient.execute(post);
					HttpEntity entity = response.getEntity();
					String result = EntityUtils.toString(entity);
					signin.setText(result);
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				setContentView(R.layout.mainpage);
			}

			
		});
	
			
			signup.setOnClickListener(new OnClickListener() {

				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					HttpClient httpclient = new DefaultHttpClient();
					HttpPost post = new HttpPost(
							"https://chamka-c9-tallguy.c9.io/hello-world.php");
					List<NameValuePair> pairs = new ArrayList<NameValuePair>();
					pairs.add(new BasicNameValuePair("operation", "signup"));
					pairs.add(new BasicNameValuePair("email", email.getText()
							.toString()));
					pairs.add(new BasicNameValuePair("password", passwd.getText()
							.toString()));
					try {
						post.setEntity(new UrlEncodedFormEntity(pairs));
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						HttpResponse response = httpclient.execute(post);
						HttpEntity entity = response.getEntity();
						String result = EntityUtils.toString(entity);
						signup.setText(result);
					} catch (ClientProtocolException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	/*
	public void SignUp(View v)
	{
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost post = new HttpPost(
				"https://chamka-c9-tallguy.c9.io/hello-world.php");
		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		pairs.add(new BasicNameValuePair("operation", "SignUp"));
		pairs.add(new BasicNameValuePair("email", email.getText()
				.toString()));
		pairs.add(new BasicNameValuePair("password", passwd.getText()
				.toString()));
		try {
			post.setEntity(new UrlEncodedFormEntity(pairs));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			HttpResponse response = httpclient.execute(post);
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity);
			signup.setText(result);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void SignIn(View v)
	{
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost post = new HttpPost(
				"https://chamka-c9-tallguy.c9.io/hello-world.php");
		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		pairs.add(new BasicNameValuePair("activity", "reg"));
		pairs.add(new BasicNameValuePair("email", email.getText()
				.toString()));
		pairs.add(new BasicNameValuePair("password", passwd.getText()
				.toString()));
		try {
			post.setEntity(new UrlEncodedFormEntity(pairs));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			HttpResponse response = httpclient.execute(post);
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity);
			signin.setText(result);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	*/
	

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
