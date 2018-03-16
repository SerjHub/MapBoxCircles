package peace.developer.serj.mapboxproject.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by macbook on 14.03.2018.
 */

public class Properties {
    @SerializedName("marker-color")
    private String markerColor;
    @SerializedName("marker-size")
    private String markerSize;
    @SerializedName("marker-symbol")
    private String markerSymbol;
    private String name;
    private String color;

    public String getMarkerColor() {
        return markerColor;
    }

    public void setMarkerColor(String markerColor) {
        this.markerColor = markerColor;
    }

    public String getMarkerSize() {
        return markerSize;
    }

    public void setMarkerSize(String markerSize) {
        this.markerSize = markerSize;
    }

    public String getMarkerSymbol() {
        return markerSymbol;
    }

    public void setMarkerSymbol(String markerSymbol) {
        this.markerSymbol = markerSymbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
