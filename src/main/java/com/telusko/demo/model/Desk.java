package com.telusko.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Desk {
    @Id
    int seat;
    String date;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "SeatDate{" +
                "date='" + date + '\'' +
                ", seat=" + seat +
                '}';
    }
}
