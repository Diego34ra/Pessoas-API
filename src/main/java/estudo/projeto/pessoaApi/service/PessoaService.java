package estudo.projeto.pessoaApi.service;

import estudo.projeto.pessoaApi.controller.dto.MessageResponseDTO;
import estudo.projeto.pessoaApi.controller.dto.mapper.PessoaMapper;
import estudo.projeto.pessoaApi.controller.dto.request.PessoaDTO;
import estudo.projeto.pessoaApi.model.Pessoa;
import estudo.projeto.pessoaApi.repository.PessoaRepository;
import estudo.projeto.pessoaApi.exception.PessoaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Pessoa findById(Long id) throws PessoaNotFoundException {
        Pessoa pessoa = verificaSeExiste(id);
//        PessoaDTO pessoaDTO = pessoaMapper.toPessoaDTO(pessoa);
        return pessoa;
    }

    public MessageResponseDTO update(Long id, Pessoa pessoaUpdate) throws PessoaNotFoundException {
        Pessoa pessoa = verificaSeExiste(id);

        pessoa.setPrimeiroNome(pessoaUpdate.getPrimeiroNome());
        pessoa.setSobrenome(pessoaUpdate.getSobrenome());
        pessoa.setCpf(pessoaUpdate.getCpf());
        pessoa.setDataDeNascimento(pessoaUpdate.getDataDeNascimento());
        pessoa.setTelefones(pessoaUpdate.getTelefones());

        pessoaRepository.save(pessoa);
        return MessageResponseDTO
                .builder()
                .message("Pessoa com ID " + pessoa.getId() + " atualizada.")
                .build();
    }


    public void delete(Long id) throws PessoaNotFoundException {
        pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException(id));

        pessoaRepository.deleteById(id);
    }

    private Pessoa verificaSeExiste(Long id) throws PessoaNotFoundException {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException(id));
        return pessoa;
    }
}
