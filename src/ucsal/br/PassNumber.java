package ucsal.br;

import java.util.Random;

public class PassNumber {
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

  public void geraSenha() {
    Random gerador = new Random();
    senha = "";
    int numero;
    while (senha.length() < 4) {
      numero = gerador.nextInt(8);

      if (senha.length() == 0) {
        senha = senha + numero;
      } else {

        boolean setNumero = true;
        for (int i = 0; i < senha.length(); i++) {

          if (Character.getNumericValue(senha.charAt(i)) == numero) {

            setNumero = false;

            break;

          }

        }

        if (setNumero) {

          senha = senha + numero;

        }
      }

    }
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
