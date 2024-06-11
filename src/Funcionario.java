
import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private final String funcao;

    public Funcionario(String nome, BigDecimal salario, String funcao, LocalDate dataNascimento) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void aumentarSalario(BigDecimal percentual) {
        salario = salario.add(salario.multiply(percentual));
    }

    @Override
    public String toString() {
        return super.toString() + ", Salário: " + salario.toString() + ", Função: " + funcao;
    }
}