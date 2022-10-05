package estudo.projeto.pessoaApi.utils;

import estudo.projeto.pessoaApi.controller.dto.request.PessoaDTO;
import estudo.projeto.pessoaApi.model.Pessoa;

import java.time.LocalDate;
import java.util.Collections;

public class PessoaUtils {

    private static final String FIRST_NAME = "Rodrigo";
    private static final String LAST_NAME = "Peleias";
    private static final String CPF_NUMBER = "369.333.878-79";
    private static final long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 1);

    public static Pessoa createFakeDTO() {
        return Pessoa.builder()
                .primeiroNome(FIRST_NAME)
                .sobrenome(LAST_NAME)
                .cpf(CPF_NUMBER)
                .telefones(Collections.singletonList(TelefoneUtils.createFakeDTO()))
                .build();
    }

    public static Pessoa createFakeEntity() {
        return Pessoa.builder()
                .id(PERSON_ID)
                .primeiroNome(FIRST_NAME)
                .sobrenome(LAST_NAME)
                .cpf(CPF_NUMBER)
                .dataDeNascimento(BIRTH_DATE)
                .telefones(Collections.singletonList(TelefoneUtils.createFakeEntity()))
                .build();
    }
}
