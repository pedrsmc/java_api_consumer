package com.projeto.controller;

import java.util.List;

import com.projeto.model.Usuario;
import com.projeto.service.*;

public class UsuarioController {
    UsuarioServices usuarioServices = new UsuarioServices();

    public void listarUsuarios() throws Exception {
        List<Usuario> usuarios = usuarioServices.listarUsuarios();
        int quantidade = usuarios.size();

        System.out.println("Total de usuários: " + quantidade + "\n\n");
        usuarios.forEach(System.out::println);
        System.out.println("-----------------------------------------");
    }

    public void buscarUsuario(String id) throws Exception {
        Usuario usuario = usuarioServices.buscarUsuario(id);

        System.out.println("\n" + usuario);
        System.out.println("-----------------------------------------");
    }
}
