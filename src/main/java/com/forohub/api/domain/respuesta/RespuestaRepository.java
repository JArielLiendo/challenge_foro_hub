package com.forohub.api.domain.respuesta;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {
    @Query("SELECT r FROM Respuesta r WHERE r.estado=ACTIVO AND r.topico.estado=ACTIVO")
    Page<Respuesta> listarRespuesta(Pageable paginacion);
    @Query("SELECT r FROM Respuesta r WHERE r.topico.id=:id AND r.estado=ACTIVO")
    List<Respuesta> listarRespuestaPorTopico(Long id);
    @Query("SELECT r FROM Respuesta r WHERE r.autorRespuesta.id=:id AND r.estado=ACTIVO")
    List<Respuesta> listarRespuestasPorUsuario(Long id);
}
