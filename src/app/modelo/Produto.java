package app.modelo;

// ORM: Object/Relational Mapping
// Mapeamento Objeto/Relacional
// Classe/Tabela
// Atributo/Coluna
// Instância/Registro

public class Produto { // produtos
  
  private boolean ativo; // ativo TINYINT
  private Integer codigo; // codigo SERIAL
  private String descricao; // descricao VARCHAR
  private Fabricante fabricante; // id_fabricante no Banco

  public Produto() {
    //this.fabricante = f;
  }

  public Integer getCodigo() {
    return codigo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setCodigo(Integer codigo) {
    this.codigo = codigo;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public void setFabricante(Fabricante fabricante) {
    // ligar as duas pontas do bidirecional
    if (this.fabricante != null) {
      this.fabricante.removeProduto(this); // NullPointerException (NPE, NRE)
      this.fabricante = null; // perder a referência
    }
    if (fabricante != null) {
      this.fabricante = fabricante;
      fabricante.addProduto(this);
    }
  }

  public Fabricante getFabricante() {
    return fabricante;
  }

  @Override
  public String toString() {
    return descricao;
  }

}
