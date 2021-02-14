package vienpham.core_java.lesson_09.dao;

public class AnimalDaoFactory extends DaoFactory {

	// DaoFactory method override 
	@Override
	public AnimalDAO getDao(String type) throws DataStoreNotFoundException {
		type = type.toLowerCase(); 
		switch(type) {
		case "memory": return new MemoryCacheAnimalDAO();
		case "files" : return new FileAnimalDAO(); 
		case "rdbms" : return new RdbmsAnimalDAO(); 
		}
		throw new DataStoreNotFoundException("Could not find " + type + " data store"); 
	}

}
