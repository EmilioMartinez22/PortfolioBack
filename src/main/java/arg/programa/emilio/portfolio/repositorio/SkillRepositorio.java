package arg.programa.emilio.portfolio.repositorio;

import arg.programa.emilio.portfolio.modelo.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillRepositorio extends JpaRepository<Skill, Integer> {
    Optional<Skill> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}