
package com.example.aunshon.weather.Forcast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SnowNight {

    @SerializedName("in")
    @Expose
    private Integer in;
    @SerializedName("cm")
    @Expose
    private Integer cm;

    public Integer getIn() {
        return in;
    }

    public void setIn(Integer in) {
        this.in = in;
    }

    public Integer getCm() {
        return cm;
    }

    public void setCm(Integer cm) {
        this.cm = cm;
    }

}
