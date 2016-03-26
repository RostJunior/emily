package ua.com.emily.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.emily.dao.TypeDao;
import ua.com.emily.domain.Type;
import ua.com.emily.service.TypeService;
/**
 * Plain JPA implementation of {@link TypeService}.
 * 
 * @author Tanskiy R.
 */
@Service("typeService")
public class TypeServiceImpl implements TypeService {

	@Autowired
	private TypeDao dao;

	public void createType(String nameType) {
		Type type = new Type(nameType);
		dao.create(type);

	}

	public List<Type> getAllTypes() {

		return dao.getAll();
	}

	public Type findByIdType(int idType) {

		return dao.findById(idType);
	}

	public void deleteType(int idType) {

		dao.delete(dao.findById(idType));

	}

	public void updateType(int idType, String nameType) {

		Type type = dao.findById(idType);
		type.setNameType(nameType);

		dao.edit(type);
	}

}
