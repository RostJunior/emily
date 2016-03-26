package ua.com.emily.dao;

import java.util.List;

/**
 *Dao interface for basic CRUD operations 
 *
 * @param C - Entity Class
 * @return
 * 
 * @author Tanskiy R.
 * @version 1.0
 * @since 2015-11-01
 *
 */

public interface GeneralDao <C, N extends Number> {
	
	/*Save the object in the database*/
    void create(C entity);
    
    /*Show  the all object in the database*/
	List<C> getAll();
	
	/*Delete  the object from the database*/
	void delete(C entity);
	
	/*Edit (update)  the object in the database*/
	void edit(C entity);

}
