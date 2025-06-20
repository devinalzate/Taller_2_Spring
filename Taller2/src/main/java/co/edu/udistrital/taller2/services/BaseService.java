package co.edu.udistrital.taller2.services;

import java.util.List;
/**
 *  F : Entity
 *  T : Model
 *  E : DTO
 *
 * */
public interface BaseService<F,T,E> {
    F save(T t);
    void delete(Long id);
    F update(T t);
    E findById(Long id);
    List<E> findAll();
}
