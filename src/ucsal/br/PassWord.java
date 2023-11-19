package ucsal.br;

import java.util.Random;

public class PassWord implements Pass {
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
    Random gerador = new Random();
    senha = "";
    String letra;
    while (senha.length() < 4) {
      letra = String.valueOf((char) (gerador.nextInt(26) + 'a'));

      if (senha.length() == 0) {
        senha = senha + letra;
      } else {

        boolean setNumero = true;
        for (int i = 0; i < senha.length(); i++) {

          if (senha.charAt(i) == letra.charAt(0)) {

            setNumero = false;

            break;

          }

        }

        if (setNumero) {

          senha = senha + letra;

        }
      }

    }
    return senha;
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
