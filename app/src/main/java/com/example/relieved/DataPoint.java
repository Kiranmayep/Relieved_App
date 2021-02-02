package com.example.relieved;

public class DataPoint {
    long editdate;
    int editrate;

    public DataPoint() {

    }
    public DataPoint(long editdate, int editrate){
        this.editdate = editdate;
        this.editrate = editrate;
    }
    public long geteditdate()
    {
        return editdate;
    }
    public int geteditrate(){
        return editrate;
    }
}
