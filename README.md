Associações (relacionamentos)
-----------------------------

Associação simples,
Agregação (um objeto tem outro(s)),

Navegabilidade (atraversar o grafo)

Banco
-----

```sql
CREATE TABLE fabricantes (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(50)
);

CREATE TABLE produtos (
  id SERIAL PRIMARY KEY,
  descricao VARCHAR(50),
  id_fabricante INTEGER REFERENCES fabricantes (id)
);

SELECT p.descricao, f.nome as fabricante
FROM produtos p 
  INNER JOIN fabricantes f ON p.id_fabricante = f.id
WHERE p.id = 123;

select * from produtos where id_fabricante = 123;
```