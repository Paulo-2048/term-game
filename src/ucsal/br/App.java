package ucsal.br;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Pass oSenha = setGameType(scan);

        GameEngine game = new GameEngine(oSenha);

        while (true) {
            System.out.println("Digite sua tentativa: ");
            String tentativa = scan.next();
            String retorno = game.checkPass(tentativa);
            if (retorno.equals("1111")) {
                System.out.println("Parabéns, você acertou! A senha era: " + game.getPass());
                break;
            } else if (game.getAttemptsLeft() > 0) {
                System.out.println("De seu palpite para a senha, restam " + game.getAttemptsLeft() + ": " + retorno);
            } else {
                System.out.println("Suas tentativas acabaram, a senha era: " + game.getPass());
                break;
            }
        }

        scan.close();

    }

    public static Pass setGameType(Scanner scan) {
        System.out.println("Escolha o tipo de jogo:");
        System.out.println("1 - Apenas números\n2 - Apenas letras\n3 - Números e letras");
        int gameTypeChosen = scan.nextInt();

        Map<Integer, Pass> factories = new HashMap<>();
        factories.put(1, new PassNumber());
        factories.put(2, new PassWord());
        factories.put(3, new PassWordNumber());

        Pass factory = factories.get(gameTypeChosen);
        if (factory == null) {
            System.out.println("Opção inválida!");
            return null;
        }

        Pass gameType = factory.getInstance();
        return gameType;
    }
}
