
package InicioSesion.Model.Interfaces;

import java.io.Serializable;
import java.util.ArrayList;


public interface DAOInterface<T, Id extends Serializable> {

    public int insertar(T object);

    public boolean actualizar(T object);

    public boolean borrar(int id);

    public ArrayList<T> traerTodos();

    public boolean borrarTodos();

    public T traerPorId(int id);

}
