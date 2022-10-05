package estudo.projeto.pessoaApi.service;

import estudo.projeto.pessoaApi.controller.dto.MessageResponseDTO;
import estudo.projeto.pessoaApi.controller.dto.mapper.PessoaMapper;
import estudo.projeto.pessoaApi.controller.dto.request.PessoaDTO;
import estudo.projeto.pessoaApi.model.Pessoa;
import estudo.projeto.pessoaApi.repository.PessoaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static estudo.projeto.pessoaApi.utils.PessoaUtils.createFakeDTO;
import static estudo.projeto.pessoaApi.utils.PessoaUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @Mock
    private PessoaMapper pessoaMapper;

    @InjectMocks
    private PessoaService pessoaService;

    @Test
    void testGivenPersonDTOThenReturnSuccessSavedMessage() {
        Pessoa pessoa = createFakeDTO();
        Pessoa expectedSavedPerson = createFakeEntity();


        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPerson.getId());
        MessageResponseDTO successMessage = pessoaService.createPessoa(pessoa);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedSuccessMessage(Long savedPersonId) {
        return MessageResponseDTO.builder()
                .message("Pessoa criada com ID " + savedPersonId)
                .build();
    }
}
