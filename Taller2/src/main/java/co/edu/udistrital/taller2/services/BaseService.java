package co.edu.udistrital.taller2.services;

import java.util.List;

public interface BaseService<F,T,E> {
    F save(T t);
    void delete(Long id);
    F update(T t);
    E findById(Long id);
    List<E> findAll();
}
