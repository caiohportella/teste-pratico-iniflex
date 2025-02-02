## Projeto Prático de Gerenciamento de Funcionários

Projeto feito de acordo com as instruções do teste prático de gerenciamento de funcionários.

## Estrutura de Pastas

O projeto contém uma pasta principal:

- `src`: pasta que mantém o código fonte.

Enquanto isso, os arquivos de saída compilados serão gerados na pasta `bin` por padrão.

## Descrição e Requisitos

Levando em consideração a tabela abaixo, desenvolva os seguintes requisitos:

| Nome    | Data Nascimento | Salário    | Função         |
|--------|----------------|------------|----------------|
| Maria  | 18/10/2000     | 2009.44    | Operador       |
| João   | 12/05/1990     | 2284.38    | Operador       |
| Caio   | 02/05/1961     | 9836.14    | Coordenador    |
| Miguel | 14/10/1988     | 19119.88   | Diretor        |
| Alice  | 05/01/1995     | 2234.68    | Recepcionista  |
| Heitor | 19/11/1999     | 1582.72    | Operador       |
| Arthur | 31/03/1993     | 4071.84    | Contador       |
| Laura  | 08/07/1994     | 3017.45    | Gerente        |
| Heloísa| 24/05/2003     | 1606.85    | Eletricista    |
| Helena | 02/09/1996     | 2799.93    | Gerente        |

1. Classe `Pessoa` com os atributos: `nome` (String) e `dataNascimento` (LocalDate).
2. Classe `Funcionário` que estenda a classe `Pessoa`, com os atributos: `salário` (BigDecimal) e `função` (String).
3. Deve conter uma classe `Principal` para executar as seguintes ações:
   1. Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
   2. Remover o funcionário “João” da lista.
   3. Imprimir todos os funcionários com todas suas informações, sendo que:
      - informação de data deve ser exibido no formato dd/mm/aaaa;
      - informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.
   4. Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
   5. Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
   6. Imprimir os funcionários, agrupados por função.
   8. Imprimir os funcionários que fazem aniversário no mês 10 e 12.
   9. Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
   10. Imprimir a lista de funcionários por ordem alfabética.
   11. Imprimir o total dos salários dos funcionários.
   12. Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.