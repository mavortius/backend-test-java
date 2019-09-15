package br.com.fcamara.backendtestjava.model;

import java.io.Serializable;

public interface Identifiable<ID extends Serializable> extends Serializable {

    String IDENTIFIER = "id";

    ID getId();
}
