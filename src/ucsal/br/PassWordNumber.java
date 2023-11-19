package ucsal.br;

import java.security.SecureRandom;

public class PassWordNumber implements Pass {
  private String senha;
  private int tentativasRestantes;
  private int numeroTentativas;

  public String getSenha() {
    return senha;
  }

  public int getTentativasRestantes() {
    return tentativasRestantes;
  }

  public void setTentativasRestantes(int tentativasRestantes) {
    this.tentativasRestantes = tentativasRestantes;
  }

  public int getNumeroTentativas() {
    return numeroTentativas;
  }

  public void setNumeroTentativas(int numeroTentativas) {
    this.numeroTentativas = numeroTentativas;
    this.tentativasRestantes = numeroTentativas;
  }

  public String geraSenha(int comprimento) {
    senha = "";
    String caracteres = "abcdefghijklmnopqrstuvwxyz0123456789";
    SecureRandom random = new SecureRandom();
    StringBuilder senha = new StringBuilder();

    for (int i = 0; i < comprimento; i++) {
      int indice = random.nextInt(caracteres.length());
      senha.append(caracteres.charAt(indice));
    }

    this.senha = senha.toString();

    return senha.toString();
  }

  public String palpitaSenha(String tentativa) {

    String retorno = "";

    for (int i = 0; i < tentativa.length(); i++) {
      String retornoParcial = "X";
      char c = tentativa.charAt(i);
      for (int n = 0; n < senha.length(); n++) {
        char c1 = senha.charAt(n);
        if (c == c1) {
          retornoParcial = "0";
          if (i == n) {
            retornoParcial = "1";
            break;
          }
        }
      }
      retorno = retorno + retornoParcial;
    }
    if (retorno != "1111") {
      tentativasRestantes = tentativasRestantes - 1;
      if (tentativasRestantes <= 0) {
        tentativasRestantes = 0;
      }
    }

    return retorno;
  }

}
