package br.com.feliperochasi.isound.main;

import br.com.feliperochasi.isound.model.Artistic;
import br.com.feliperochasi.isound.repository.ArtisticRepository;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private final ArtisticRepository artisticRepository;

    public Main(ArtisticRepository artisticRepository) {
        this.artisticRepository = artisticRepository;
    }
    public void initIsound() {
        System.out.println("""
                
                
                ***************** Bem Vindo ao ISOUND *****************
                
                
                """);
        var option = -1;
        while (option != 9) {
            showMenu();
            option = scanner.nextInt();
            clearLine();
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
                createNewArtistic();
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
                searchMusicFromArtistic();
                break;
            case 6:
                searchMusicFromAlbum();
                break;
            case 7:
                queryArtisticIA();
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

    private void createNewArtistic() {
        var leave = 0;
        while (leave == 0) {
            System.out.println("***************** Cadastro de um novo artista *****************");
            System.out.println("Nome do artista:");
            var name = scanner.nextLine();
            System.out.println("Tipo de artista:");
            var type = scanner.nextLine();
            System.out.println("Ano de inicio da carreira:");
            var date = scanner.nextLine();
            var artistic = new Artistic(name, type, date);
            artisticRepository.save(artistic);
            System.out.println("Deseja cadastrar mais um artista? (n/s)");
            var s = scanner.nextLine();
            if (!s.equalsIgnoreCase("s")) {
                leave = 1;
            }
        }
    }

    private void createNewMusic() {

    }

    private void createNewAlbum() {

    }

    private void listAllMusics() {

    }

    private void searchMusicFromArtistic() {

    }

    private void searchMusicFromAlbum() {

    }

    private void queryArtisticIA() {

    }

    private void queryMusicIA() {
    }

    private void clearLine() {
        scanner.nextLine();
    }

}
