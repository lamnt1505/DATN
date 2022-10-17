package poly.edu.DATN.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import poly.edu.DATN.Entity.User;
import poly.edu.DATN.Repository.UserRepository;
import poly.edu.DATN.Service.UserService;

public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userReporsitory;

	@Override
	public <S extends User> S save(S entity) {
		return userReporsitory.save(entity);
	}
	
	@Override
	public Optional<User> findByPhone(String phone){
		return userReporsitory.findByPhone(phone);
	}
	
	@Override
	public <S extends User> Optional<S> findOne(Example<S> example) {
		return userReporsitory.findOne(example);
	}

	@Override
	public List<User> findAll() {
		return userReporsitory.findAll();
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		return userReporsitory.findAll(pageable);
	}

	@Override
	public List<User> findAll(Sort sort) {
		return userReporsitory.findAll(sort);
	}

	@Override
	public List<User> findAllById(Iterable<Integer> ids) {
		return userReporsitory.findAllById(ids);
	}

	@Override
	public Optional<User> findById(Integer id) {
		return userReporsitory.findById(id);
	}

	@Override
	public <S extends User> List<S> saveAll(Iterable<S> entities) {
		return userReporsitory.saveAll(entities);
	}

	@Override
	public void flush() {
		userReporsitory.flush();
	}

	@Override
	public <S extends User> S saveAndFlush(S entity) {
		return userReporsitory.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Integer id) {
		return userReporsitory.existsById(id);
	}

	@Override
	public <S extends User> List<S> saveAllAndFlush(Iterable<S> entities) {
		return userReporsitory.saveAllAndFlush(entities);
	}

	@Override
	public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
		return userReporsitory.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<User> entities) {
		userReporsitory.deleteInBatch(entities);
	}

	@Override
	public <S extends User> long count(Example<S> example) {
		return userReporsitory.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<User> entities) {
		userReporsitory.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return userReporsitory.count();
	}

	@Override
	public <S extends User> boolean exists(Example<S> example) {
		return userReporsitory.exists(example);
	}

	@Override
	public void deleteById(Integer id) {
		userReporsitory.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		userReporsitory.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(User entity) {
		userReporsitory.delete(entity);
	}

	@Override
	public <S extends User, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return userReporsitory.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		userReporsitory.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		userReporsitory.deleteAllInBatch();
	}

	@Override
	public User getOne(Integer id) {
		return userReporsitory.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends User> entities) {
		userReporsitory.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		userReporsitory.deleteAll();
	}

	@Override
	public User getById(Integer id) {
		return userReporsitory.getById(id);
	}

	@Override
	public <S extends User> List<S> findAll(Example<S> example) {
		return userReporsitory.findAll(example);
	}

	@Override
	public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
		return userReporsitory.findAll(example, sort);
	}
	
	
}
