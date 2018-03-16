package peace.developer.serj.mapboxproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.google.gson.Gson;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.style.layers.CircleLayer;
import com.mapbox.mapboxsdk.style.layers.Layer;
import com.mapbox.mapboxsdk.style.sources.VectorSource;

import peace.developer.serj.mapboxproject.models.Feature;
import peace.developer.serj.mapboxproject.models.FeatureCollection;
import peace.developer.serj.mapboxproject.models.Geometry;

import static com.mapbox.mapboxsdk.style.layers.Property.NONE;
import static com.mapbox.mapboxsdk.style.layers.Property.VISIBLE;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.visibility;

public class MainActivity extends AppCompatActivity {

    Switch aSwitch;
    MapboxMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aSwitch = findViewById(R.id.switcher);
        final FeatureCollection collection = new Gson().fromJson(Data.data,FeatureCollection.class);

        Mapbox.getInstance(getApplicationContext(), getString(R.string.access_token));
        final MapView mapView = findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(final MapboxMap mapboxMap) {
                map = mapboxMap;


                for (int i = 0; i < collection.getFeatures().size(); i++){
                    final Feature feature = collection.getFeatures().get(i);
                    final MarkerOptions marker = new MarkerOptions().position(createCoordinates(feature.getGeometry()));
                    marker.setTitle(feature.getProperties().getName());
                    mapboxMap.addMarker(marker);
                }



                VectorSource vectorSource = new VectorSource("source","http://api.mapbox.com/v4/serjik-dev.cjerowg8x0e802wqkh6qytzne-7uanm.json?access_token=" + getString(R.string.access_token));

                mapboxMap.addSource(vectorSource);
                CircleLayer circleLayer = new CircleLayer("testing", "source");
                circleLayer.setProperties(visibility(NONE));



                circleLayer.setSourceLayer("test");
                mapboxMap.addLayer(circleLayer);

                aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        toggleLayer(isChecked);
                    }
                });

            }
        });

    }

    private LatLng createCoordinates(Geometry geometry){
        final double lat = geometry.getCoordinates().get(1);
        final double lon = geometry.getCoordinates().get(0);
        return new LatLng(lat,lon);
    }

    private void toggleLayer(boolean checked) {
        Layer layer = map.getLayer("testing");
        if (layer != null) {
            if (!checked) {
                layer.setProperties(visibility(NONE));
            } else {
                layer.setProperties(visibility(VISIBLE));
            }
        }
    }
}
