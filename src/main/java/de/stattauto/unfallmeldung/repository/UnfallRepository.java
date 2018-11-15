package de.stattauto.unfallmeldung.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.stattauto.unfallmeldung.entity.Unfallmeldung;

@Repository
public interface UnfallRepository extends JpaRepository<Unfallmeldung, Long> {

	Collection<Unfallmeldung> findByFahrer(Long fahrer);
}
