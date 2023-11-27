package ucsal.br;

public interface Pass {
  // * 65 - 90 = A - Z
  // * 97 - 122 = a - z
  // * 48 - 57 = 0 - 9
  
  public String gerarSenha();
  public Pass getInstance();
}
