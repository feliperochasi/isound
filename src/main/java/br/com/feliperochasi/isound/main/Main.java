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
            readOption(option);
        }
    }

    private void showMenu() {
        System.out.println("""
                Selecione uma das opcoes abaixo para continuar
                
                1 - Cadastrar artista
                2 - Cadastrar musica
                3 - Cadastrar Album
                4 - Listar musicas
                5 - Buscar musica por artista
                6 - Buscar musica por album
                7 - Saber mais sobre artista
                8 - Saber mais sobre musica
                
                9 - Sair
                """);
    }

    private void readOption(Integer selectOption) {
        switch (selectOption) {
            case 1:
                createNewArtisct();
                break;
            case 2:
                createNewMusic();
                break;
            case 3:
                createNewAlbum();
                break;
            case 4:
                listAllMusics();
                break;
            case 5:
                searchMusicFromArtisct();
                break;
            case 6:
                searchMusicFromAlbum();
                break;
            case 7:
                queryArtisctIA();
                break;
            case 8:
                queryMusicIA();
                break;
            case 9:
                System.out.println("Encerrando....");
                break;
            default:
                System.out.println("Opcao invalida, tente novamente!");
                break;
        }


    }

    private void createNewArtisct() {

    }

    private void createNewMusic() {

    }

    private void createNewAlbum() {

    }

    private void listAllMusics() {

    }

    private void searchMusicFromArtisct() {

    }

    private void searchMusicFromAlbum() {

    }

    private void queryArtisctIA() {

    }

    private void queryMusicIA() {
    }

}
