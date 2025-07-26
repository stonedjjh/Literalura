package com.aluracursos.literatura.aplicacion.enums;

import java.util.Optional;

public enum IdiomaEnum {
    ES("español","espanol","es", "spanish"),
    EN("inglés","ingles","en","english"),
    FR("francés","frances","fr", "french");

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
