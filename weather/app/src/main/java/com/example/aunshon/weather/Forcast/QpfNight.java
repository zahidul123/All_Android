
package com.example.aunshon.weather.Forcast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QpfNight {

    @SerializedName("in")
    @Expose
    private Integer in;
    @SerializedName("mm")
    @Expose
    private Integer mm;

    public Integer getIn() {
        return in;
    }

    public void setIn(Integer in) {
        this.in = in;
    }

    public Integer getMm() {
        return mm;
    }

    public void setMm(Integer mm) {
        this.mm = mm;
    }

}
