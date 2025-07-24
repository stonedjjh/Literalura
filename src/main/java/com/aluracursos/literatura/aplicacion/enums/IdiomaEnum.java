package com.aluracursos.literatura.aplicacion.enums;

import java.util.Optional;

public enum IdiomaEnum {
    ES("Español","Espanol","es"),
    EN("Inglés","ingles","en"),
    FR("Francés","Frances","fr");

    private String idioma[];

    IdiomaEnum(String... args){
        this.idioma = args;
    }

    public Optional<IdiomaEnum> buscarIdioma(String idioma){

        for(IdiomaEnum miembrosEnumeracion: IdiomaEnum.values()){
            for(String idiomaEnum : miembrosEnumeracion.idioma){
                if(idioma.equalsIgnoreCase(idiomaEnum)){
                    return Optional.of(miembrosEnumeracion);
                }
            }
        }
        return Optional.empty();
    }


}
