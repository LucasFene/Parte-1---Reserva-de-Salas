package com.usuario.application.service;

import com.usuario.domain.model.Usuario;
import com.usuario.infrastructure.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import com.usuario.infrastructure.config.RabbitMQConfig;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public List<Usuario> listar() {
        return repository.findAll();
    }

    public Usuario salvar(Usuario usuario) {
        Usuario saved = repository.save(usuario);
        rabbitTemplate.convertAndSend(RabbitMQConfig.RESERVA_QUEUE, "Usuário salvo: " + saved.getId());
        return saved;
    }

    public Optional<Usuario> getUsuario(Long id) {
        return repository.findById(id);
    }

    public Optional<Usuario> buscarPorEmail(String email) {
        return repository.findByEmail(email);
    }
}