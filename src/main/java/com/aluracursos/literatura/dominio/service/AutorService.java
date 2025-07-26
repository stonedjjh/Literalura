package com.aluracursos.literatura.dominio.service;

import com.aluracursos.literatura.dominio.entidades.Autor;
import com.aluracursos.literatura.dominio.repositorios.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;



    public boolean guardarAutor (Autor autor){
        try{
            autorRepository.save(autor);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
