package com.actividad5.actividad5.controles;

public class pedido {

    cliente cliente;
    productos[] productos;

    public pedido(){

    }

    public cliente getCliente() {
        return cliente;
    }

    public void setCliente(cliente cliente) {
        this.cliente = cliente;
    }

    public productos[] getProductos() {
        return productos;
    }

    public void setProductos(productos[] productos) {
        this.productos = productos;
    }
}
