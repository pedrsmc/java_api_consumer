package com.projeto;

import com.projeto.controller.*;

import java.io.IOException;
import java.util.Scanner;

public final class Main {
    static UsuarioController usuarioController = new UsuarioController();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        boolean repetir = true;

        do {
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

            System.out.println("Bem vindo ao programa de gestão de usuários!");
            System.out.println("--------------------------------------------\n");
            System.out.println("1 - Listar usuários cadastrados.");
            System.out.println("2 - Buscar usuário pelo ID.");
            System.out.println("3 - Cadastrar um novo usuário.");
            System.out.println("5 - Sair do programa.\n");
            System.out.println("");
            System.out.print("Por favor, digite a opção desejada: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
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

                    usuarioController.listarUsuarios();

                    System.out.print("\nAperte Enter para retornar ao menu...");
                    scanner.nextLine();
                    break;
                case 2:
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

                    try {
                        usuarioController.buscarUsuario();
                    } catch (Exception e) {
                        System.out.println("\nErro ao buscar o usuário: " + e);
                    }

                    System.out.print("\nAperte Enter para retornar ao menu...");
                    scanner.nextLine();
                    break;
                case 3:
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

                    try {
                        usuarioController.cadastrarUsuario();
                    } catch (Exception e) {
                        System.out.println("\nErro no cadastro do usuário: " + e);
                    }

                    System.out.print("\nAperte Enter para retornar ao menu...");
                    scanner.nextLine();
                    break;
                case 5:
                    repetir = false;
                    break;
            }
        } while (repetir);
    }
}
