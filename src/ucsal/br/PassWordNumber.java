package ucsal.br;

import java.util.Random;


public class PassWordNumber implements Pass {
  public String gerarSenha() {
    //* 65 - 90 = A - Z
    //* 48 - 57 = 0 - 9

    Random generator = new Random();
    String pass = "";

    for (int i = 0; i < 4; i++) {
      int randomCharType = generator.nextInt(2);
      int random;

      if(randomCharType == 0) {
        random = generator.nextInt(25);
        pass = pass + (char) (random + 65);
      } else {
        random = generator.nextInt(9);
        pass = pass + (char) (random + 48);
      }
    }

    return pass;
  }

  public Pass getInstance() {
      return new PassWordNumber();
  }
}
