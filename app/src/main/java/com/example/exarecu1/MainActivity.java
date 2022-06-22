package com.example.exarecu1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtCodigo;
    private EditText txtDescripcion;
    private EditText txtUnidad;
    private EditText txtPrecioVenta;
    private EditText txtPrecioCompra;
    private EditText txtCantidad;
    private Button btnEnviar;
    private Button btnLimpiar;
    private EntradaProducto entradaProducto = new EntradaProducto();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        txtCodigo = (EditText) findViewById(R.id.txtCodigo);
        txtDescripcion = (EditText) findViewById(R.id.txtDescripcion);
        txtUnidad = (EditText) findViewById(R.id.txtUnidad);
        txtPrecioVenta = (EditText) findViewById(R.id.txtPrecioVenta);
        txtPrecioCompra = (EditText) findViewById(R.id.txtPrecioCompra);
        txtCantidad = (EditText) findViewById(R.id.txtCantidad);

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtCodigo.setText("");
                txtDescripcion.setText("");
                txtUnidad.setText("");
                txtPrecioVenta.setText("");
                txtPrecioCompra.setText("");
                txtCantidad.setText("");
            }
        });

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtCodigo.getText().toString().matches("")||
                        txtDescripcion.getText().toString().matches("")||
                        txtUnidad.getText().toString().matches("")){

                    Toast.makeText(MainActivity.this,
                            "Falto Capturar Informacion",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                String codigo = txtCodigo.getText().toString();
                String descripcion = txtDescripcion.getText().toString();
                String unidad = txtUnidad.getText().toString();
                String precioventa = txtPrecioVenta.getText().toString();
                String preciocompra = txtPrecioCompra.getText().toString();
                String cantidad = txtCantidad.getText().toString();
                //String altura = txtAltura.getText().toString();
                Intent intent = new Intent( MainActivity.this,EntradaProductoActivity.class);
                //intent.putExtra("codigo",codigo);
                intent.putExtra("descripcion", descripcion);
                intent.putExtra("unidad",unidad);
                intent.putExtra("precioventa", precioventa);
                intent.putExtra("preciocompra",preciocompra);
                intent.putExtra("cantidad", cantidad);;
                startActivity(intent);

            }
        });

    }
}