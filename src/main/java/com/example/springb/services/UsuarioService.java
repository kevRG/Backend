package com.example.springb.services;

import com.example.springb.dto.CreateUsuarioDTO;
import com.example.springb.models.Usuario;
import com.example.springb.structures.CustomLinkedList;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UsuarioService {

    private final CustomLinkedList<Usuario> listaUsuarios = new CustomLinkedList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public UsuarioService() {
        crearInicial("Mario Cortés", "mario_c", "mario.cortes@municipio.gob.mx", "hash123", "2221000001", "Administrador", "Hoy", "Activo");
        crearInicial("Ana Valdés", "ana_v", "ana.valdes@municipio.gob.mx", "hash123", "2221000002", "Técnico", "Hoy", "Activo");
        crearInicial("Jorge Ríos", "jorge_r", "jorge.rios@municipio.gob.mx", "hash123", "2221000003", "Ciudadano", "Hoy", "Activo");
        crearInicial("Sofía Lara", "sofia_l", "sofia.lara@municipio.gob.mx", "hash123", "2221000004", "Ciudadano", "Hace 4 días", "Activo");
    }

    private void crearInicial(String nombre, String username, String correo, String pass, String tel, String rol, String acceso, String estado) {
        Usuario u = new Usuario(idGenerator.getAndIncrement(), nombre, username, correo, pass, tel, rol, acceso, estado);
        listaUsuarios.add(u);
    }

    public List<Usuario> listarTodos() {
        return listaUsuarios.toList();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return listaUsuarios.find(u -> u.getIdUsuario().equals(id));
    }

    public Usuario crear(CreateUsuarioDTO dto) {
        Usuario nuevo = new Usuario(
                idGenerator.getAndIncrement(),
                dto.getNombreCompleto(),
                dto.getNombreUsuario(),
                dto.getCorreo(),
                dto.getContrasena(),
                dto.getTelefono(),
                dto.getRol(),
                "Hoy",
                "Activo"
        );
        listaUsuarios.add(nuevo);
        return nuevo;
    }
}