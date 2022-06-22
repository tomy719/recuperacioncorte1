package com.example.exarecu1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EntradaProductoActivity extends AppCompatActivity {

    private TextView lblNombre,lblTotalPrecioVenta, lblTotalPrecioCompra, lblTotalGanancia, txtTotalPrecioVenta, txtTotalPrecioCompra, txtTotalGanancia;
    private Button btnCalcular, btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada_producto);

        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);
        lblNombre = (TextView) findViewById(R.id.lblNombre);
        lblTotalPrecioVenta = (TextView) findViewById(R.id.lblTotalPrecioVenta);
        lblTotalPrecioCompra = (TextView) findViewById(R.id.lblTotalPrecioCompra);
        lblTotalGanancia = (TextView) findViewById(R.id.lblGanancia);
        txtTotalPrecioVenta = (TextView) findViewById(R.id.txtPrecioVenta);
        txtTotalPrecioCompra = (TextView) findViewById(R.id.txtPrecioCompra);
        txtTotalGanancia = (TextView) findViewById(R.id.txtTotalGanancia);

        EntradaProducto entradaProducto =new EntradaProducto();
        Intent intent = getIntent();
        String descripcion = intent.getStringExtra("descripcion");
        String precioventaa = intent.getStringExtra("precioventa");
        String preciocompraa = intent.getStringExtra("preciocompra");

        lblNombre.setText("Producto: "+descripcion);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float precioventa = Float.parseFloat(precioventaa);
                float preciocompra = Float.parseFloat(preciocompraa);
                entradaProducto.setPrecioVenta(precioventa);
                entradaProducto.setPrecioCompra(preciocompra);

                    txtTotalPrecioVenta.setText(String.valueOf(entradaProducto.calcularPrecioVenta()));
                    txtTotalPrecioCompra.setText(String.valueOf(entradaProducto.calcularPrecioCompra()));
                    txtTotalGanancia.setText(String.valueOf(entradaProducto.calcularGanancia()));
                }
            });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder confirmar = new AlertDialog.Builder(EntradaProductoActivity.this);
                confirmar.setTitle("Regersar?");
                confirmar.setMessage("Se descartara toda la informacion ingresada");
                confirmar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        finish();
                    }
                });
                confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                confirmar.show();
            }
        });



    }
}