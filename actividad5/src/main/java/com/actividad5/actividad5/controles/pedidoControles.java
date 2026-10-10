package com.actividad5.actividad5.controles;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

        @RestController
        public class pedidoControles {

            @PostMapping("/pedido")
            //Solo pedimos pedido porque en esa clase ya tenemos el Cliente y los Productos
            public String crearPedido(@RequestBody pedido pedido) {

                int totalProductos = 0;
                double precioTotal = 0;

                for (int i = 0; i < pedido.getProductos().length; i++) {
                    totalProductos = totalProductos + pedido.getProductos()[i].getCantidad();

                    precioTotal = precioTotal + pedido.getProductos()[i].getCantidad()
                            * pedido.getProductos()[i].getPrecioUnitario();
                }

                return String.format(
                        "{\n" +
                                "  \"cliente\": \"%s\",\n" +
                                "  \"totalProductos\": %d,\n" +
                                "  \"precioTotal\": %.2f,\n" +
                                "  \"mensaje\": \"Pedido recibido correctamente\"\n" +
                                "}",
                        pedido.getCliente().getNombre(), totalProductos, precioTotal
                );
            }
        }





