package entity;

import java.io.Serializable;

/**
 * Created by Ymk Sun on 3/12/2016.
 */
public class Daily implements Serializable {

    private int dailyId;
    private String day;
    private String workoutOne;
    private String workOutTwo;
    private String workOutThree;
    private String workOutFour;
    private String workOutFive;

    public Daily () {}

    public Daily(int dailyId, String day, String workoutOne, String workOutTwo, String workOutThree, String workOutFour, String workOutFive) {
        this.dailyId = dailyId;
        this.day = day;
        this.workoutOne = workoutOne;
        this.workOutTwo = workOutTwo;
        this.workOutThree = workOutThree;
        this.workOutFour = workOutFour;
        this.workOutFive = workOutFive;
    }

    public int getDailyId() {
        return dailyId;
    }

    public void setDailyId(int dailyId) {
        this.dailyId = dailyId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getWorkoutOne() {
        return workoutOne;
    }

    public void setWorkoutOne(String workoutOne) {
        this.workoutOne = workoutOne;
    }

    public String getWorkOutTwo() {
        return workOutTwo;
    }

    public void setWorkOutTwo(String workOutTwo) {
        this.workOutTwo = workOutTwo;
    }

    public String getWorkOutThree() {
        return workOutThree;
    }

    public void setWorkOutThree(String workOutThree) {
        this.workOutThree = workOutThree;
    }

    public String getWorkOutFour() {
        return workOutFour;
    }

    public void setWorkOutFour(String workOutFour) {
        this.workOutFour = workOutFour;
    }

    public String getWorkOutFive() {
        return workOutFive;
    }

    public void setWorkOutFive(String workOutFive) {
        this.workOutFive = workOutFive;
    }
}
