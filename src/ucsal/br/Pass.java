package ucsal.br;

public interface Pass {
  public String getSenha();
  int getTentativasRestantes();
  public void setTentativasRestantes(int tentativasRestantes);
  public int getNumeroTentativas();
  public void setNumeroTentativas(int numeroTentativas);

  public String geraSenha(int comprimento);
  public String palpitaSenha(String tentativa);
}
