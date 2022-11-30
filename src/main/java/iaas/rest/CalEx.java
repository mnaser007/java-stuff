package iaas.rest;

import java.util.Calendar;

public class CalEx {
	public String getDate() {
		Calendar cal=Calendar.getInstance();
		//int doy=cal.get(Calendar.DAY_OF_YEAR); //day of year
		 int doy=cal.get(Calendar.DAY_OF_WEEK);
		 String dayName="";
		 for(Day day:Day.values())
			 if(day.ordinal()==doy-1)
				 dayName=day.toString();
				 
				 
		/*//cal.set(1998, 2, 25); naser
		 cal.set(1997, 2, 16); //vinayak
		doy=cal.get(Calendar.DAY_OF_WEEK);
		for(Day day:Day.values())
			 if(day.ordinal()==doy-1)
				 dayName=day.toString();*/
	
	//cal.add(Calendar.DATE, 100); // 100 days
	cal.add(Calendar.YEAR, -100); // before 100 years
	doy=cal.get(Calendar.DAY_OF_WEEK);
	for(Day day:Day.values())
		 if(day.ordinal()==doy-1)
			 dayName=day.toString();

		 return cal.getTime().toString()+"<br>"+doy+"<br>"+dayName;
	}

}
