package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
/**
 * A repository interface to handle the database operations
 * It is annotated with @Repository: to indicate that it is a repository layer
 * It extends JpaRepository: to provide the CRUD operations
 * JpaRepository is a JPA specific extension of Repository
 * It is a part of the Spring Data JPA project
 * list some of those CRUD operations
 * 1. save: to save an entity
 * 2. findById: to find an entity by its id
 * 3. findAll: to find all entities
 * 4. deleteById: to delete an entity by its id
 * 5. existsById: to check if an entity exists by its id
 * 6. count: to count the number of entities
 * 7. delete: to delete an entity
 * 8. deleteAll: to delete all entities
 * 9. deleteAllInBatch: to delete all entities in a batch
 * 10. flush: to flush the changes to the database
 * 11. saveAndFlush: to save an entity and flush the changes to the database
 * 12. saveAll: to save all entities
 * 13. saveAllAndFlush: to save all entities and flush the changes to the database
 * 14. findAllById: to find all entities by their ids
 * 15. findAllByIdIn: to find all entities by their ids in a list
 * 16. findAllByIdInBatch: to find all entities by their ids in a batch
 */
@Repository
public interface StudentRepository
        extends JpaRepository<Student,Long> {


    /**
     * A function to find a student by email
     * It uses a custom query to find the student
     * when do we use a custom query
     * When we want to perform a complex query that cannot be done using the default methods
     * explain the query
     * selects all the students from the student table where the email is equal to the given email
     * @return
     */
    @Query("SELECT s FROM Student s WHERE s.email =?1")
    Optional<Student> findStudentByEmail(String Email);

    /**
     * What are some of the most common custom queries
     * 1. findByName: to find a student by name
     * 2. findByEmail: to find a student by email
     * 3. findByDob: to find a student by date of birth
     * 4. findById: to find a student by id
     * 5. findByNameAndEmail: to find a student by name and email
     * 6. findByNameOrEmail: to find a student by name or email
     * 7. findByNameLike: to find a student by name like
     * 8. findByNameNotLike: to find a student by name not like
     * 9. findByNameIn: to find a student by name in a list
     * 10. findByNameNotIn: to find a student by name not in a list
     */
}
