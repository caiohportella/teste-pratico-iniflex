

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        //inserção de funcionários
        funcionarios.add(new Funcionario("Maria", new BigDecimal("2009.44"), "Operador", LocalDate.of(2000, 10, 18)));
        funcionarios.add(new Funcionario("João", new BigDecimal("2284.36"), "Operador", LocalDate.of(1990, 5, 12)));
        funcionarios.add(new Funcionario("Caio", new BigDecimal("9836.14"), "Coordenador", LocalDate.of(1961, 5, 2)));
        funcionarios.add(new Funcionario("Miguel", new BigDecimal("19119.88"), "Diretor", LocalDate.of(1988, 10, 14)));
        funcionarios.add(new Funcionario("Alice", new BigDecimal("2234.68"), "Recepcionista", LocalDate.of(1995, 1, 5)));
        funcionarios.add(new Funcionario("Heitor", new BigDecimal("1582.82"), "Operador", LocalDate.of(1999, 11, 19)));
        funcionarios.add(new Funcionario("Arthur", new BigDecimal("4071.84"), "Contador", LocalDate.of(1993, 3, 31)));
        funcionarios.add(new Funcionario("Laura", new BigDecimal("3017.45"), "Gerente", LocalDate.of(1994, 7, 8)));
        funcionarios.add(new Funcionario("Heloisa", new BigDecimal("1606.85"), "Eletricista", LocalDate.of(2003, 5, 24)));
        funcionarios.add(new Funcionario("Helena", new BigDecimal("2799.93"), "Gerente", LocalDate.of(1996, 9, 2)));

        System.out.println("Lista de funcionários:");
        funcionarios.forEach(System.out::println);
        System.out.println();

        //Remoção do funcionário João
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));

        System.out.println("Lista de funcionários sem João:");
        funcionarios.forEach(System.out::println);
        System.out.println();

        //Aumento do salário dos funcionários em 10%
        funcionarios.forEach(funcionario -> funcionario.aumentarSalario(new BigDecimal("0.1")));

        System.out.println("Lista de funcionários após aumento de salário:");
        funcionarios.forEach(System.out::println);
        System.out.println();

        //Agrupando funcionários por função
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        System.out.println("Funcionários listados por função:");
        funcionariosPorFuncao.forEach((funcao, listaFuncionarios) -> {
            System.out.println("Função: " + funcao);
            listaFuncionarios.forEach(System.out::println);
            System.out.println();
        });

        //Filtrando funcionários pelo aniversário em outubro e dezembro
        List<Funcionario> funcionariosAniversarioOutDez = funcionarios.stream()
                .filter(funcionario -> {
                    int mesNascimento = funcionario.getDataNascimento().getMonthValue();
                    return mesNascimento == 10 || mesNascimento == 12;
                })
                .collect(Collectors.toList());

        System.out.println("Funcionários com aniversário em Outubro e Dezembro:");
        funcionariosAniversarioOutDez.forEach(System.out::println);
        System.out.println();

        //Obtendo funcionário com maior idade
        Funcionario funcionarioMaiorIdade = Collections.max(funcionarios, Comparator.comparing(funcionario -> {
            LocalDate dataNascimento = funcionario.getDataNascimento();
            LocalDate hoje = LocalDate.now();
            return hoje.getYear() - dataNascimento.getYear();
        }));

        LocalDate dataNascimentoMaiorIdade = funcionarioMaiorIdade.getDataNascimento();
        LocalDate hoje = LocalDate.now();
        int idadeMaiorIdade = hoje.getYear() - dataNascimentoMaiorIdade.getYear();
        System.out.println("Funcionário com maior idade: " + funcionarioMaiorIdade.getNome()
                + ", Idade: " + idadeMaiorIdade);
        System.out.println();

        //Ordenando funcionários por ordem alfabética
        Collections.sort(funcionarios, Comparator.comparing(Funcionario::getNome));

        System.out.println("Lista de funcionários em ordem alfabética:");
        funcionarios.forEach(System.out::println);
        System.out.println();

        //Total dos salários dos funcionários
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("Total dos salários dos funcionários: " + NumberFormat.getCurrencyInstance().format(totalSalarios));
        System.out.println();

        //Quantos salários mínimos cada funcionário recebe
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        Map<Funcionario, BigDecimal> salariosMinimosPorFuncionario = new HashMap<>();
        funcionarios.forEach(funcionario -> salariosMinimosPorFuncionario.put(funcionario,
                funcionario.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP)));

        System.out.println("Quantos salários mínimos cada funcionário recebe:");
        salariosMinimosPorFuncionario.forEach((funcionario, qtdSalariosMinimos) -> {
            System.out.println(funcionario.getNome() + ": " + qtdSalariosMinimos);
        });
    }
}
