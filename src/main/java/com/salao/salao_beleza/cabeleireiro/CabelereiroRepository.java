package com.salao.salao_beleza.cabeleireiro;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CabelereiroRepository extends JpaRepository<Cabeleireiro, Long> {
    Page<Cabeleireiro> findAllByAtivoTrue(Pageable paginacao);
}
