package br.com.viacep.resource;

import br.com.viacep.dto.response.CepDto;
import br.com.viacep.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("cep")
public class CepResource {
    @Autowired
    private CepService cepService;

    @GetMapping("{cep}")
    public ResponseEntity<CepDto> getCep(@PathVariable @Valid String cep){
        CepDto retorno = cepService.buscarCep(cep);
        return ResponseEntity.ok(retorno);
    }
}
