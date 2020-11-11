package temuco.maps.google;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnUbicacion,btnSitios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSitios = (Button) findViewById(R.id.btn_sitiosturisticos);

        btnSitios.setOnClickListener(new View.OnClickListener() {
            // aca decaramos la variable para poder tener una accion del boton declarado
            // en una clase para pode hacer el cambio de activity :
            // esto significa que pasa del menu, al mapa predefinido de google maps
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MapsActivity1.class);
                startActivity(intent);
            }
        });
    }
}