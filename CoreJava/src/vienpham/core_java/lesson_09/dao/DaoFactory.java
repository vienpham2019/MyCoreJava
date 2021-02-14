package vienpham.core_java.lesson_09.dao;

public abstract class DaoFactory {
	public abstract AnimalDAO getDao(String type) throws DataStoreNotFoundException;
	
}
