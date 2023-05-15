package app;

import java.util.List;

import app.modelo.Fabricante;
import app.modelo.Produto;

class App {
  public static void main(String[] args) {

    // Multiplicidade:
    // um para um, um para muitos, muitos para muitos

    Fabricante lg = new Fabricante();
    lg.setCodigo(1);
    lg.setNome("LG");

    Fabricante samsung = new Fabricante();
    samsung.setCodigo(2);
    samsung.setNome("Samsung");

    Produto tv1 = new Produto();
    tv1.setCodigo(1);
    tv1.setDescricao("TV 32\"");

    Produto tv2 = new Produto();
    tv2.setCodigo(2);
    tv2.setDescricao("TV 45\"");

    tv1.setFabricante(lg);
    tv2.setFabricante(lg);

    System.out.println(lg.getProdutos()); // [TV 32, TV 45]

    System.out.println(tv2.getFabricante()); // LG

    System.out.println(tv2.getFabricante().getProdutos()); // [TV 32, TV 45]

    // memory leak
    //lg = null;

    tv1.setFabricante(samsung);
    System.out.println(samsung.getProdutos()); // [TV 32];
    System.out.println(lg.getProdutos()); // [TV 45];

    tv1.setFabricante(null);
    System.out.println(samsung.getProdutos()); // [];

    // conectar as duas pontas da relação
    // tv1.setFabricante(lg);
    // lg.getProdutos().add(tv1);

  }
}