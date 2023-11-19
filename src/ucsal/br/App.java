package ucsal.br;

import java.util.Scanner;

//X: errado | 0: certa no lugar errado | 1: certa no lugar certo

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Pass oSenha = setGameType(scan);

        oSenha.geraSenha(4);
        oSenha.setNumeroTentativas(10);
        String senha = "XXXX";

        while (!(senha.equals("1111")) && oSenha.getTentativasRestantes() != 0) {
            System.out.printf("De seu palpite para a senha, restam " + oSenha.getTentativasRestantes() + ": ");
            System.out.println("");

            String palpite = scan.next();
            senha = oSenha.palpitaSenha(palpite);
            System.out.println(senha);
        }

        if (senha.equals("1111")) {
            System.out.println("Parabens! A senha está correta!");

        } else {
            System.out.println("Você perdeu! A senha correta é: " + oSenha.getSenha());
        }

        scan.close();

    }

    public static Pass setGameType(Scanner scan) {
        System.out.println("Escolha o tipo de jogo: ");
        System.out.println("1 - Apenas números\n2 - Apenas letras\n3 - Números e letras");
        int gameTypeChosen = scan.nextInt();
        Pass gameType = null;
        boolean validGameType = false;

        while (!validGameType) {
            switch (gameTypeChosen) {
                case 1:
                    gameType = new PassNumber();
                    validGameType = true;
                    break;
                case 2:
                    gameType = new PassWord();
                    validGameType = true;
                    break;
                case 3:
                    gameType = new PassWordNumber();
                    validGameType = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        System.out.println("Class chosen: " + gameType.getClass().getName() + "\n");

        return gameType;
    }
}
