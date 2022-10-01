package estudo.projeto.pessoaApi.service;

import estudo.projeto.pessoaApi.dto.MessageResponseDTO;
import estudo.projeto.pessoaApi.model.Pessoa;
import estudo.projeto.pessoaApi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public MessageResponseDTO createPessoa(Pessoa pessoa){
        Pessoa pessoaSaved =pessoaRepository.save(pessoa);
        return MessageResponseDTO
                .builder()
                .message("Pessoa criada com ID " + pessoaSaved.getId())
                .build();
    }
}
