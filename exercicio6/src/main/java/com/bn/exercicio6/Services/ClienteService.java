package com.bn.exercicio6.Services;

import com.bn.exercicio6.Models.ClienteModel;
import com.bn.exercicio6.Repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteModel> findAll(){
        return clienteRepository.findAll();
    }

    public ClienteModel criarCliente(ClienteModel clienteModel){
        return clienteRepository.save(clienteModel);
    }

    public void deletarCliente(Long id){
        clienteRepository.deleteById(id);
    }

    public ClienteModel buscarClientePorId(Long id){
        return clienteRepository.findById(id).get();
    }

    public ClienteModel atualizarCliente(Long id, ClienteModel clienteModel){
        ClienteModel novoCliente = clienteRepository.findById(id).get();
        novoCliente.setNome(clienteModel.getNome());
        novoCliente.setEmail(clienteModel.getEmail());
        novoCliente.setTelefone(clienteModel.getTelefone());
        return clienteRepository.save(novoCliente);
    }

}
