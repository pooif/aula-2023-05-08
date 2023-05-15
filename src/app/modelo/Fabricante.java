package app.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fabricante {

  private Integer codigo;
  private String nome;
  private List<Produto> produtos = new ArrayList<>();

  public Integer getCodigo() {
    return codigo;
  }

  public String getNome() {
    return nome;
  }

  public void setCodigo(Integer codigo) {
    this.codigo = codigo;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public List<Produto> getProdutos() {
    // return Collections.unmodifiableList(produtos);
    return new ArrayList<>(produtos); // cópia
  }

  // sem poder setar a lista
  // public void setProdutos(List<Produto> produtos) {
  //   this.produtos = produtos;
  // }
  
  @Override
  public String toString() {
    return nome;
  }

  /* package private */ void addProduto(Produto produto) {
    this.produtos.add(produto);
  }

  public void removeProduto(Produto produto) {
    this.produtos.remove(produto);
  }
}
