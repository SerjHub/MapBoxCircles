package peace.developer.serj.mapboxproject.models;

import java.util.List;

/**
 * Created by macbook on 14.03.2018.
 */

public class FeatureCollection {
    private String type;
    private List<Feature> features;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }
}
