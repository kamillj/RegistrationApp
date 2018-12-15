package pl.kamiljurczak.registration.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Visit {

    private int id;
    private Date date;
    private Timestamp startTime;
    private Timestamp endTime;
    private Clinic clinic;

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private DateFormat dateTimeFormat = new SimpleDateFormat("hh:mm");

    public Visit() {
    }

    public Visit(Date date, Timestamp startTime, Timestamp endTime, Clinic clinic) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        setClinic(clinic);
    }

    public Visit(String date, String startTime, String endTime, String clinic) {
        try {
            this.date = dateFormat.parse(date);
            this.startTime = new Timestamp(dateTimeFormat.parse(startTime).getTime());
            this.endTime = new Timestamp(dateTimeFormat.parse(endTime).getTime());
            setClinic(new Clinic(clinic));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public void setDateTimeFormat(DateFormat dateTimeFormat) {
        this.dateTimeFormat = dateTimeFormat;
    }

    @Override
    public String toString() {
        return clinic.toString() + ": " + dateFormat.format(date) + " " + dateTimeFormat.format(startTime) + " - " + dateTimeFormat.format(endTime);
    }
}
