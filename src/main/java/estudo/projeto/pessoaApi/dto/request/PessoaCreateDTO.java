package estudo.projeto.pessoaApi.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import estudo.projeto.pessoaApi.model.Telefone;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PessoaCreateDTO {

    @NotEmpty
    @Size(min = 2, max = 100)
    private String primeiroNome;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String sobrenome;

    @NotEmpty
    @CPF
    private String cpf;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataDeNascimento;

    @Valid
    @NotEmpty
    private List<Telefone> telefones;
}
