package service;

import models.Card;

import java.util.List;


public interface IService <T extends Card>{
    boolean add(T t);

    List<T> getAll();


}
