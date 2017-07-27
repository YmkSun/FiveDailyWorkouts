package entity;

import java.io.Serializable;

/**
 * Created by Ymk Sun on 3/12/2016.
 */
public class Centers implements Serializable {

    private String name;
    private double ltt;
    private double lgt;

    public Centers(){
    }

    public Centers(String name, double ltt, double lgt) {
        this.name = name;
        this.ltt = ltt;
        this.lgt = lgt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLtt() {
        return ltt;
    }

    public void setLtt(double ltt) {
        this.ltt = ltt;
    }

    public double getLgt() {
        return lgt;
    }

    public void setLgt(double lgt) {
        this.lgt = lgt;
    }
}
