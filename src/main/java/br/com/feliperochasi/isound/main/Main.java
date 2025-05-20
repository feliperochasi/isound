package br.com.feliperochasi.isound.main;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);


    public void initIsound() {
        System.out.println("""
                
                
                ***************** Bem Vindo ao ISOUND *****************
                
                
                """);
        var option = -1;
        while (option != 9) {
            showMenu();
            option = scanner.nextInt();
        }
    }

    private void showMenu() {
        System.out.println("""
                Selecione uma das opcoes abaixo para continuar
                
                1 - Cadastrar artista
                2 - Cadastrar musica
                3 - Listar musicas
                4 - Buscar musica por artista
                5 - Saber mais sobre artista
                6 - Saber mais sobre musica
                
                9 - Sair
                """);
    }


}
