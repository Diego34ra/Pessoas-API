package estudo.projeto.pessoaApi.controller.dto.mapper;

import estudo.projeto.pessoaApi.controller.dto.request.PessoaCreateDTO;
import estudo.projeto.pessoaApi.controller.dto.request.PessoaDTO;
import estudo.projeto.pessoaApi.model.Pessoa;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PessoaMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public Pessoa toPessoaCreate(PessoaCreateDTO dto) {
        return MODEL_MAPPER.map(dto, Pessoa.class);
    }

    public PessoaDTO toPessoaDTO (Pessoa pessoa) {
        return MODEL_MAPPER.map(pessoa,PessoaDTO.class);
    }

    public List<PessoaDTO> toPessoaDTOList(List<Pessoa> pessoaList) {
        return pessoaList.stream().map(this::toPessoaDTO).collect(Collectors.toList());
    }

}
