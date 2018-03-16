package peace.developer.serj.mapboxproject.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macbook on 14.03.2018.
 */

public class Geometry {
    private String type;
    private List<Double> coordinates;

    public Geometry (){
        coordinates = new ArrayList<>();
    }

    public String getType() {
        return type;
    }


    public List<Double> getCoordinates() {
        return coordinates;
    }

}
