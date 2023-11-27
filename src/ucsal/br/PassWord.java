package ucsal.br;

import java.util.Random;

public class PassWord implements Pass {
  public String gerarSenha() {
    // * 65 - 90 = A - Z
    Random generator = new Random();
    String pass = "";

    for (int i = 0; i < 4; i++) {
      int random = generator.nextInt(25);
      pass = pass + (char) (random + 65);
    }

    return pass;
  }

  public Pass getInstance() {
      return new PassWord();
  }
}
