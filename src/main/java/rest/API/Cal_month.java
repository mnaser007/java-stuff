package rest.API;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/Cal_month")
public class Cal_month {

	public String get() throws Exception {
		List<Date> dates = new ArrayList<Date>();
		String d = "";
		String str_date = "01/01";
		String end_date = "30/12";
		DateFormat formatter;

		formatter = new SimpleDateFormat("dd/MM");
		Date startDate = (Date) formatter.parse(str_date);
		Date endDate = (Date) formatter.parse(end_date);
		long interval = 24 * 1000 * 60 * 60; // 1 hour in millis
		long endTime = endDate.getTime(); // create your endtime here, possibly using Calendar or Date
		long curTime = startDate.getTime();
		while (curTime <= endTime) {
			dates.add(new Date(curTime));
			curTime += interval;
		}
		for (int i = 0; i < dates.size(); i++) {
			Date lDate = (Date) dates.get(i);
			String ds = formatter.format(lDate);
			d += ds + "<br>";

		}
		return "The day and month are: " + d;
	}	
	@Path("last")
	@Produces(MediaType.TEXT_HTML)
    @GET 
    public String getlist() throws Exception {
		Cal_month l=new Cal_month();
        return l.get();
	}
}
