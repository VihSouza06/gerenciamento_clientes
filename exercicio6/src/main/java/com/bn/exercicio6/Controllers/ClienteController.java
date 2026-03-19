package com.bn.exercicio6.Controllers;

import com.bn.exercicio6.Models.ClienteModel;
import com.bn.exercicio6.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteModel>> findAll(){
        List<ClienteModel> cliente = clienteService.findAll();
        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping("/{id}")
    public ClienteModel buscarClientePorId(@PathVariable Long id){
        return clienteService.buscarClientePorId(id);
    }

    @PostMapping
    public ResponseEntity<ClienteModel> criarCliente(@RequestBody ClienteModel clienteModel){
        ClienteModel clienteCriado = clienteService.criarCliente(clienteModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(clienteModel.getId()).toUri();
        return ResponseEntity.created(uri).body(clienteCriado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCliente(@PathVariable Long id){
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteModel> atualizarCliente
            (@PathVariable Long id, @RequestBody ClienteModel clienteModel){
        ClienteModel clienteAtualizado = clienteService.atualizarCliente(id, clienteModel);
        return ResponseEntity.ok(clienteAtualizado);
    }


}
