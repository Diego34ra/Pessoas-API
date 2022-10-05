package estudo.projeto.pessoaApi.controller;

import estudo.projeto.pessoaApi.controller.dto.MessageResponseDTO;
import estudo.projeto.pessoaApi.controller.dto.mapper.PessoaMapper;
import estudo.projeto.pessoaApi.controller.dto.request.PessoaCreateDTO;
import estudo.projeto.pessoaApi.controller.dto.request.PessoaDTO;
import estudo.projeto.pessoaApi.exception.PessoaNotFoundException;
import estudo.projeto.pessoaApi.model.Pessoa;
import estudo.projeto.pessoaApi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PessoaMapper pessoaMapper;

    @PostMapping
    public ResponseEntity<MessageResponseDTO> createPessoa(@RequestBody @Valid PessoaCreateDTO dto){
        var pessoaCreate = pessoaMapper.toPessoaCreate(dto);
        var pessoa = pessoaService.createPessoa(pessoaCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
    }
    @GetMapping
    public ResponseEntity<List<PessoaDTO>> findAll() {
        List<PessoaDTO> result = pessoaService.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> findById(@PathVariable Long id) throws PessoaNotFoundException {
        Pessoa pessoa = pessoaService.findById(id);
        PessoaDTO pessoaDTO = pessoaMapper.toPessoaDTO(pessoa);
        return ResponseEntity.ok(pessoaDTO);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid PessoaCreateDTO pessoaCreateDTO) throws PessoaNotFoundException {
        Pessoa pessoaUpdate = pessoaMapper.toPessoaCreate(pessoaCreateDTO);
        return pessoaService.update(id,pessoaUpdate);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PessoaNotFoundException {
        pessoaService.delete(id);
    }
}
