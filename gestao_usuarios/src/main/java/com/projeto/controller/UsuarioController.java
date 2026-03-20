package com.projeto.controller;

import java.io.IOException;
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

    public void removerUsuario() throws Exception {
        System.out.print("Digite o ID do usuário: ");
        String id = scanner.nextLine();

        Usuario usuario = usuarioServices.buscarUsuario(id);

        System.out.println("-----------------------------------------");
        System.out.print(usuario);
        System.out.println("-----------------------------------------\n");
        System.out.print("Você removerá o usuário em questão, deseja prosseguir? (S/N): ");
        String confirma = scanner.nextLine();

        if (confirma.equalsIgnoreCase("S")) {
            int resposta = usuarioServices.removerUsuario(id);

            if (resposta == 200) {
                System.out.println("Remoção feita com sucesso!");
            }

            return;
        } else if (confirma.equalsIgnoreCase("N")) {
            System.out.println("Remoção cancelada!");
            return;
        } else {
            removerUsuario();
        }
    }

    public void limparTela() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
