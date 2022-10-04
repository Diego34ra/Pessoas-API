package estudo.projeto.pessoaApi.service;

import estudo.projeto.pessoaApi.dto.MessageResponseDTO;
import estudo.projeto.pessoaApi.dto.mapper.PessoaMapper;
import estudo.projeto.pessoaApi.dto.request.PessoaDTO;
import estudo.projeto.pessoaApi.model.Pessoa;
import estudo.projeto.pessoaApi.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaMapper pessoaMapper;
    @Autowired
    private PessoaRepository pessoaRepository;

    public MessageResponseDTO createPessoa(Pessoa pessoa){
        Pessoa pessoaSaved =pessoaRepository.save(pessoa);
        return MessageResponseDTO
                .builder()
                .message("Pessoa criada com ID " + pessoaSaved.getId())
                .build();
    }

    public List<PessoaDTO> findAll() {
        List<Pessoa> pessoasList = pessoaRepository.findAll();
        List<PessoaDTO> result = pessoaMapper.toPessoaDTOList(pessoasList);
        return result;
    }
}
