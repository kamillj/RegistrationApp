package pl.kamiljurczak.registration.domain;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Visit {

    private int id;
    private Date date;
    private Timestamp startTime;
    private Timestamp endTime;
    private Clinic clinic;

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private DateFormat dateTimeFormat = new SimpleDateFormat("hh:mm");

    public Visit(String date, String startTime, String endTime, String clinic) {
        try {
            this.date = dateFormat.parse(date);
            this.startTime = new Timestamp(dateTimeFormat.parse(startTime).getTime());
            this.endTime = new Timestamp(dateTimeFormat.parse(endTime).getTime());
            this.clinic = new Clinic(clinic);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Clinic getClinic() {
        return clinic;
    }

    @Override
    public String toString(){
        return dateFormat.format(date) + " " + dateTimeFormat.format(startTime) + " - " + dateTimeFormat.format(endTime);
    }
}
