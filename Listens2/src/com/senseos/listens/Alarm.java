package com.senseos.listens;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.provider.AlarmClock;

public class Alarm extends Activity {
	public int uur;
	public int minuut;
	public Alarm (int vanaf, int tot ) {
		uur = geefRandomUur(vanaf, tot);
		minuut = geefRandomMinuut();
		setAlarm(uur, minuut);
	}
	public int geefRandomUur(int vanaf, int tot){
		Random r = new Random();
		int uur = r.nextInt(tot - vanaf) + vanaf;	
		return uur;
	}
	public int geefRandomMinuut(){
		Random r = new Random();
		int kwartier = r.nextInt(4);	
		int minuut = kwartier * 15;
		return minuut;
	}
	int minute, hour, day;
	Calendar cal;
	public void setAlarm(int uur, int minuut) {
	    cal = new GregorianCalendar();
	    cal.setTimeInMillis(System.currentTimeMillis());
	    day = cal.get(Calendar.DAY_OF_WEEK);
	    hour = cal.get(Calendar.HOUR_OF_DAY);
	    minute = cal.get(Calendar.MINUTE);

	    Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
	    i.putExtra(AlarmClock.EXTRA_HOUR, hour + uur);
	    i.putExtra(AlarmClock.EXTRA_MINUTES, minute + minuut);
	    i.putExtra(AlarmClock.EXTRA_SKIP_UI, true);
	    
	    startActivity(i);
	}
}
