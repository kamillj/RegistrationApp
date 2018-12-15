package pl.kamiljurczak.registration.domain;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Visit {

    private Date date;
    private Timestamp startTime;
    private Timestamp endTime;

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private DateFormat dateTimeFormat = new SimpleDateFormat("hh:mm");

    public Visit(String date, String startTime, String endTime) {
        try {
            this.date = dateFormat.parse(date);
            this.startTime = new Timestamp(dateTimeFormat.parse(startTime).getTime());
            this.endTime = new Timestamp(dateTimeFormat.parse(endTime).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return dateFormat.format(date) + " " + dateTimeFormat.format(startTime) + " - " + dateTimeFormat.format(endTime);
    }
}
