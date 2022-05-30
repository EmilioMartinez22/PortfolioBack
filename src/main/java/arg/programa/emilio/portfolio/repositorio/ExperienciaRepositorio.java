package arg.programa.emilio.portfolio.repositorio;

import arg.programa.emilio.portfolio.modelo.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExperienciaRepositorio extends JpaRepository<Experiencia, Integer> {
    Optional<Experiencia> findByEmpresa(String empresa);
    boolean existsByEmpresa(String empresa);
}

