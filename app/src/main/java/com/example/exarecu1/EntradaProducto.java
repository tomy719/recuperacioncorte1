package com.example.exarecu1;


public class EntradaProducto extends EntradaProductoActivity {

    private float precioVenta, precioCompra,unidad;

    public EntradaProducto(float precioVenta, float precioCompra, float unidad) {
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
        this.unidad = unidad;
    }

    public EntradaProducto(){

    }

    public EntradaProducto(EntradaProducto entradaProducto){

    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public float getUnidad() {
        return unidad;
    }

    public void setUnidad(float unidad) {
        this.unidad = unidad;
    }

    public float calcularPrecioVenta(){
        float resultado = 0.0f;
      resultado = precioVenta*unidad;


        return resultado;

    }
    public float calcularPrecioCompra(){
        float resultado = 0.0f;
        resultado=precioCompra*unidad;

        return resultado;

    }

    public float calcularGanancia(){
        float resultado;
        resultado= calcularPrecioVenta()-calcularPrecioCompra();

        return resultado;

    }
}
