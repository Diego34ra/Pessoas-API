package estudo.projeto.pessoaApi.controller;

import estudo.projeto.pessoaApi.dto.MessageResponseDTO;
import estudo.projeto.pessoaApi.dto.mapper.PessoaMapper;
import estudo.projeto.pessoaApi.dto.request.PessoaCreateDTO;
import estudo.projeto.pessoaApi.dto.request.PessoaDTO;
import estudo.projeto.pessoaApi.model.Pessoa;
import estudo.projeto.pessoaApi.repository.PessoaRepository;
import estudo.projeto.pessoaApi.service.PessoaService;
import lombok.AllArgsConstructor;
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
}
