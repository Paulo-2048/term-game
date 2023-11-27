package ucsal.br;
import java.util.Random;

public class PassNumber implements Pass {
  public String gerarSenha() {
    // * 48 - 57 = 0 - 9
    Random generator = new Random();
    String pass = "";

    for (int i = 0; i < 4; i++) {
      int random = generator.nextInt(9);
      pass = pass + (char) (random + 48);
    }

    return pass;
  }

  public Pass getInstance() {
      return new PassNumber();
  }

}
