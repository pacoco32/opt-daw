package com.actividad4.actividad4.controles;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class tablaControles {

    @GetMapping("/tabla")
    public String tablica (@RequestParam(name= "filas", defaultValue="1") String fila,
                           @RequestParam(name= "columnas", defaultValue="1")String columna) {

        Integer filas;
        Integer columnas;

        //Parsea los String, si no es número o vacio, pone por defecto 1
        try{
            filas = Integer.parseInt(fila);
        } catch (NumberFormatException e) {
            filas = 1;
        }

        try{
            columnas = Integer.parseInt(columna);
        }catch (NumberFormatException e) {
            columnas = 1;
        }

        if(filas < 1){
            filas = 1;

        }else if(filas > 20){
            filas = 20;
        }

        if(columnas < 1){
            columnas = 1;
        }else if(columnas > 20){
            columnas = 20;
        }

        String tablica = "<table border = 1>";
        tablica = tablica + "<caption> Tablica </caption>";

        //Cabecera

        tablica = tablica + "<tr>";
        for(int j = 1; j <= columnas; j++){
            tablica = tablica + "<th>" + j + "</th>";
        }
        tablica = tablica + "</tr>";

        //Cuerpo de la tabla

        for(int i = 1; i <= filas; i++){
            tablica = tablica + "<tr>";

                for(int j = 1; j <= columnas; j++){
                    tablica = tablica + "<td>Fila " + i + " - Columna " + j + "</td>";
                }
        }
        tablica = tablica + "</tr>";

        return tablica;

    }
}
