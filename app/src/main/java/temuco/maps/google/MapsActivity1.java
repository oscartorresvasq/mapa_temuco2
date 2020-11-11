package temuco.maps.google;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Locale;

public class MapsActivity1 extends AppCompatActivity implements GoogleMap.OnMarkerDragListener,OnMapReadyCallback,GoogleMap.OnMarkerClickListener{

    private GoogleMap mMap;
    private  Marker markerNuevo,markerDrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps1);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

       // aca es la linea de codigo que podemos crear nuestros marcadores

        LatLng Temuco = new LatLng(-38.735945, -72.590342);
        mMap.addMarker(new MarkerOptions().position(Temuco).title("esta en temuco").snippet("Plaza Teodoro Schmidt la Ciudad mas linda de Chile"));

        LatLng PlazaAnibalPinto = new LatLng(-38.740095, -72.590137);
        mMap.addMarker(new MarkerOptions().position(PlazaAnibalPinto).title("Plaza de Armas Anibal Pinto").snippet("La plaza Aníbal Pinto ubicada en la manzana de las calles Arturo Prat"));

        LatLng DagobertoGodoy = new LatLng(-38.736809, -72.597534);
        mMap.addMarker(new MarkerOptions().position(DagobertoGodoy).title("Plaza Dagoberto Godoy").snippet("Plaza Teodoro Schmidt la Ciudad mas linda de Chile"));

        LatLng PlazaTucapel = new LatLng(-38.743023, -72.592254);
        mMap.addMarker(new MarkerOptions().position(PlazaTucapel).title("Plaza Tucapel").snippet("Plaza Teodoro Schmidt la Ciudad mas linda de Chile"));

        LatLng TerminalRuralNarBus = new LatLng(-38.733255, -72.586736);
        mMap.addMarker(new MarkerOptions().position(TerminalRuralNarBus).title("Terminal Rural Nar Bus").snippet("Plaza Teodoro Schmidt la Ciudad mas linda de Chile"));



        // mi marca personal para saber la direccion de gps personalmente
        LatLng nuevo = new LatLng(-38.73679945505228, -72.58981594145222);
        markerNuevo = googleMap.addMarker(new MarkerOptions().position(nuevo).draggable(true).title(" Mi Marca Personal ").snippet("solo esta marca se puede mover sobre el mapa "));

        // longitud y latitud mostrados por pantalla solo prercione y deslice lo muestra en tiewmpo real
        LatLng gpspunto =new LatLng( -38.735119 , -72.602178);
        markerDrag = googleMap.addMarker(new MarkerOptions()
                .position(gpspunto)
                .title("Universidad Santo Tomas")
                .draggable(true)
        );

        // esta linea de codigo define cual va a ser nuestro punto del cual
        // va a ser el punto centro de la camara en la vista aeria
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(nuevo,17));googleMap.setOnMarkerClickListener(this);

        // habilitar el Dragab para señalar latitud longitud a los marcadores
        googleMap.setOnMarkerClickListener(this);
        googleMap.setOnMarkerDragListener(this);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if (marker.equals(markerNuevo)) {
            String lat,lng;
            lat = Double.toString(marker.getPosition().latitude);
            lng = Double.toString(marker.getPosition().longitude);
            Toast.makeText(this, lat + "longitud" + lng , Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    // inicio de drag al cargar el marcador señala que esta cargando la accion
    // de mostrar su longitud y latitud en tiempo real
    // muestra el mensaje de "cargando los cambios realiasados por el ususario"
    @Override
    public void onMarkerDragStart(Marker marker) {
        if (marker.equals(markerDrag)) {
            Toast.makeText(this,"Cargando Localizacion Actual tiempo real",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onMarkerDrag(Marker marker) {


    }

    @Override
    public void onMarkerDragEnd(Marker marker) {

    }
}