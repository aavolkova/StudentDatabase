package me.anna.demo;


import me.anna.demo.models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Long> {
}
