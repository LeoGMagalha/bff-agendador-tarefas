package com.leogmag.bff_agendador_tarefas.business;

import com.leogmag.bff_agendador_tarefas.business.dto.in.LoginRequestDTO;
import com.leogmag.bff_agendador_tarefas.business.dto.out.TarefasDTOResponse;
import com.leogmag.bff_agendador_tarefas.infrastructure.enums.StatusNotificacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.core.Local;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CronService {
    private final TarefasService service;
    private final EmailService emailService;
    private final UsuarioService usuarioService;

    @Value("${usuario.email}")
    private String email;

    @Value("${usuario.senha}")
    private String senha;

    @Scheduled(cron = "${cron.horario}")
    public void buscaTarefasProximaHora() {
        String token = login(convertParaRequestDTO());
        log.info("Iniciada a busca de tarefas");
        LocalDateTime horafutura = LocalDateTime.now().plusHours(1);
        LocalDateTime horafuturaMaisCinco = LocalDateTime.now().plusHours(1).plusMinutes(20);
        List<TarefasDTOResponse> listaTarefas = service.buscaTarefasAgendadasPorPeriodo(horafutura, horafuturaMaisCinco, token);
        log.info("Numero de Tarefas encontradas " + listaTarefas.size());
        listaTarefas.forEach(tarefa -> {
            emailService.enviaEmail(tarefa);
            log.info("Email enviado para o usuario " + tarefa.getEmailUsuario());
            service.alteraStatus(StatusNotificacao.NOTIFICADO, tarefa.getId(),
                    token);
        });
    }

    public String login(LoginRequestDTO dto) {
        return usuarioService.loginUsuario(dto);
    }

    public LoginRequestDTO convertParaRequestDTO() {
        return LoginRequestDTO.builder()
                .email(email)
                .senha(senha)
                .build();
    }
}
