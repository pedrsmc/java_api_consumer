package com.projeto.service;

import com.projeto.model.Usuario;
import com.projeto.repository.*;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UsuarioServices {
    UsuarioRepository usuarioRepository = new UsuarioRepository();
    ObjectMapper mapper = new ObjectMapper();

    public List<Usuario> listarUsuarios() throws Exception {
        String json = usuarioRepository.listarUsuarios();

        List<Usuario> usuarios = mapper.readValue(
                json,
                new TypeReference<List<Usuario>>() {
                });

        return usuarios;
    }

    public Usuario buscarUsuario(String id) throws Exception {
        String json = usuarioRepository.buscarUsuario(id);

        Usuario usuario = mapper.readValue(json, Usuario.class);

        return usuario;
    }

    public Usuario cadastrarUsuario(Usuario usuario) throws Exception {
        String json = mapper.writeValueAsString(usuario);

        String resposta = usuarioRepository.cadastrarUsuario(json);

        Usuario usuarioCriado = mapper.readValue(resposta, Usuario.class);

        return usuarioCriado;
    }
}
