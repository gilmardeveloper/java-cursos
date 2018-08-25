package com.gilmarcarlos.developer.gcursos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.gilmarcarlos.developer.gcursos.model.eventos.EventoPresencialLog;

public interface EventoPresencialLogRepository extends CrudRepository<EventoPresencialLog, Long> {
	
	@Query("select e from EventoPresencialLog e order by e.data desc")
	List<EventoPresencialLog> listAll();
	
	@Query("select e from EventoPresencialLog e where e.eventoPresencial.id = :pid order by e.data desc")
	List<EventoPresencialLog> buscarPorEvento(@Param("pid") Long id);
	
	@Query("select e from EventoPresencialLog e where e.id = :pid")
	EventoPresencialLog buscarPor(@Param("pid") Long id);

}
