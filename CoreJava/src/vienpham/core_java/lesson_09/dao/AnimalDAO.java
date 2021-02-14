/*
 * The DAO design pattern secifies the use of an interface to hide implementations. 
 */

package vienpham.core_java.lesson_09.dao;

import java.util.Collection;

import vienpham.core_java.common.animal.*;

public interface AnimalDAO {
	public abstract void create(Animal a); 
	public abstract Animal find(String type, int age, int weight , Sex sex);
	public abstract Collection<Animal> findAll();
	public abstract boolean update(Animal a);
	public abstract void delete(Animal a); 
	public abstract void close(); 
	public abstract void setDebug(boolean in); 
}
