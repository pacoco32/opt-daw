package com.actividad6.actividad6.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
public class formularioController {

    Random rand = new Random(); //Para aleatorizar la contraseña
    Map<String, String> usuarios = new HashMap<>(); //Crear clave:valor para el registro de usuarios


    @GetMapping("/registro")
    public String mostrarForm(){
        return "formulario";
    }

    @GetMapping("/login")
    public String mostrarLogin(){
        return "loginFormulario";
    }

    //@ResponseBody - lo que devuelva el metodo se envía directamente como respuesta al navegador
    //@ModelAttribute - sirve para recoger los datos que el usuario
    //ha enviado desde un formulario y guardarlos en un objeto Java (Usuario usuario)

    @PostMapping("/registro")
    @ResponseBody
    public String datosForm(@ModelAttribute Usuario usuario){

        boolean contra = false; //Impresion de la contraseña generada

        //Nombre
        //isBlank() - si está vacio
        if(usuario.getNombre() == null || usuario.getNombre().isBlank()){
            return "Ingrese nombre. Obligatorio";
        }

        //Apellidos
        if(usuario.getContra() == null || usuario.getApellidos().isBlank()){

            usuario.setApellidos("");
        }

        //Correo
        if(usuario.getCorreo() == null || usuario.getCorreo().isBlank()){
            return "Ingrese correo. Obligatorio";
        }

        //Contraseña
        if(usuario.getContra() == null || usuario.getContra().isBlank()){

            int pass = rand.nextInt(1000000);
            String pass2 = String.format("%06d", pass);
            //Pasamos el numérico a cadena de texto, gracias al formato le podemos dar los 6 dígitos
            usuario.setContra(pass2);
            contra = true;

        }

        String respuesta = String.format("Usuario registrado: %s %s<br>Correo: %s<br>",
                usuario.getNombre(), usuario.getApellidos(), usuario.getCorreo());

        //Booleano para añadir la impresión de contraseña
        if(contra){
            respuesta = String.format("%sContraseña generada: %s",respuesta, usuario.getContra());
        }

        //Añadir el usuario creado al mapa (Correo:Contraseña)
        usuarios.put(usuario.getCorreo(), usuario.getContra());

        return respuesta;
    }

    //Requerimos los parámetros del formulario /login
    @PostMapping("/login")
    @ResponseBody
    public String datosUsuario(@RequestParam String usuario,
                               @RequestParam String contra){

        //Cogemos los datos del Map creado antes, usuarios.get()
        //Comprobar si usuario existe
        if(usuarios.get(usuario) == null){
            return "Usuario inexistente";
        }

        //Comprobar contraseña e inicio de sesion
        if(usuarios.get(usuario).equals(contra)){
            return "Inicio de sesión correcto";
        }else{
            return "Contraseña incorrecta";
        }

    }
}
