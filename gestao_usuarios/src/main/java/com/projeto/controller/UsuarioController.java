package com.projeto.controller;

import java.util.List;
import java.util.Scanner;

import com.projeto.model.Usuario;
import com.projeto.service.*;

public class UsuarioController {
    UsuarioServices usuarioServices = new UsuarioServices();
    static Scanner scanner = new Scanner(System.in);

    public void listarUsuarios() throws Exception {
        List<Usuario> usuarios = usuarioServices.listarUsuarios();
        int quantidade = usuarios.size();

        usuarios.forEach(System.out::println);
        System.out.println("-----------------------------------------");
        System.out.println("\nTotal de usuários: " + quantidade + "\n");
        System.out.println("-----------------------------------------\n");
    }

    public void buscarUsuario() throws Exception {
        System.out.print("Digite o ID do usuário: ");
        String id = scanner.nextLine();

        Usuario usuario = usuarioServices.buscarUsuario(id);

        System.out.println("\n" + usuario);
        System.out.println("-----------------------------------------");
    }

    public void cadastrarUsuario() throws Exception {
        Usuario usuario = new Usuario();

        System.out.print("Nome: ");
        usuario.setNome(scanner.nextLine());

        System.out.print("Email: ");
        usuario.setEmail(scanner.nextLine());

        System.out.print("Telefone: ");
        usuario.setTel(scanner.nextLine());

        System.out.print("Idade: ");
        usuario.setIdade(scanner.nextInt());
        scanner.nextLine();

        Usuario criado = usuarioServices.cadastrarUsuario(usuario);

        System.out.println("------------------------------------------");
        System.out.println("Usuario criado:");
        System.out.println(criado);
    }
}
