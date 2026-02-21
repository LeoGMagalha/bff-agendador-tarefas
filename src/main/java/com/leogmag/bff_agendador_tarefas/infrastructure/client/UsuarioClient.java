package com.leogmag.bff_agendador_tarefas.infrastructure.client;


import com.leogmag.bff_agendador_tarefas.business.dto.in.EnderecoDTORequest;
import com.leogmag.bff_agendador_tarefas.business.dto.in.LoginRequestDTO;
import com.leogmag.bff_agendador_tarefas.business.dto.in.TelefoneDTORequest;
import com.leogmag.bff_agendador_tarefas.business.dto.in.UsuarioDTORequest;
import com.leogmag.bff_agendador_tarefas.business.dto.out.TelefoneDTOResponse;
import com.leogmag.bff_agendador_tarefas.business.dto.out.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @PostMapping
    UsuarioDTOResponse salvaUsuario(@RequestBody UsuarioDTORequest usuarioDTO);


    @PostMapping("/login")
    String login(@RequestBody LoginRequestDTO usuarioDTO);

    @GetMapping
    UsuarioDTOResponse buscaUsuarioPorEmail(@RequestParam("email") String email,
                                    @RequestHeader("Authorization") String token);

    @DeleteMapping("/{email}")
    void deletaUsuarioPorEmail(@PathVariable String email,
                               @RequestHeader("Authorization") String token);

    @PutMapping
    UsuarioDTOResponse atualizaDadosUsuario(@RequestBody UsuarioDTORequest dto,
                                    @RequestHeader("Authorization") String token);

    @PutMapping("/endereco")
    UsuarioDTOResponse atualizaEndereco(@RequestBody EnderecoDTORequest dto,
                                @RequestParam("id") Long id,
                                @RequestHeader("Authorization") String token);

    @PutMapping("/telefone")
    UsuarioDTOResponse atualizaTelefone(@RequestBody TelefoneDTORequest dto,
                                @RequestParam("id") Long id,
                                @RequestHeader("Authorization") String token);

    @PostMapping("/endereco")
    UsuarioDTOResponse cadastraEndereco(@RequestBody EnderecoDTORequest dto,
                                @RequestHeader("Authorization") String token);

    @PostMapping("/telefone")
    UsuarioDTOResponse cadastraTelefone(@RequestBody TelefoneDTORequest dto,
                                @RequestHeader("Authorization") String token);

}
