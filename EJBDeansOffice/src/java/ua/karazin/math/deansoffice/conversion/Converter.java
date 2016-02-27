/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.conversion;


/**
 * интерфейс, который позволяет конвертитовать Entity классы в классы View
 * @author Alyona
 */
public interface Converter<S, T> {
    
       /**
     *
     * @param source объект класса, который нужно преобразовать
     * @param target объект класса, в который помещается результат
     */
    void convert(S source, T target);
    
}
