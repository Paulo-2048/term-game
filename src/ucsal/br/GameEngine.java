package ucsal.br;

public class GameEngine {


  private Pass passGameStrategy;
  private String pass;
  private int totalAttempts = 10;
  private int attemptsLeft;
  private boolean isUpper = true;

  public Pass getPassGameStrategy() {
    return passGameStrategy;
  }

  public void setPassGameStrategy(Pass passGameStrategy) {
    this.passGameStrategy = passGameStrategy;
  }

  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  public int getTotalAttempts() {
    return totalAttempts;
  }

  public void setTotalAttempts(int totalAttempts) {
    this.totalAttempts = totalAttempts;
  }

  public int getAttemptsLeft() {
    return attemptsLeft;
  }

  public void setAttemptsLeft(int attemptsLeft) {
    this.attemptsLeft = attemptsLeft;
  }

  public GameEngine(Pass passGameStrategy) {
    this.passGameStrategy = passGameStrategy;
    this.pass = this.passGameStrategy.gerarSenha();
    this.attemptsLeft = this.totalAttempts;
  }

  public String checkPass(String attemptPass) {
    // X: errado | 0: certa no lugar errado | 1: certa no lugar certo

    if(isUpper)
      attemptPass = attemptPass.toUpperCase();

    String tryReturn = "";
    for (int i = 0; i < this.pass.length(); i++) {
      String tryReturnPartial = "X";
      char c = attemptPass.charAt(i);
      for (int n = 0; n < this.pass.length(); n++) {
        char c1 = this.pass.charAt(n);
        if (c == c1) {
          tryReturnPartial = "0";
          if (i == n) {
            tryReturnPartial = "1";
            break;
          }
        }
      }
      tryReturn = tryReturn + tryReturnPartial;
    }

    if(tryReturn != "1111")
      this.attemptsLeft = this.attemptsLeft - 1;

    return tryReturn;
  }

}
