package poly.edu.DATN.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import poly.edu.DATN.Entity.Product;


public interface ProductService {

	<S extends Integer> List<S> findAll(Example<S> example, Sort sort);

	<S extends Integer> List<S> findAll(Example<S> example);

	Integer getById(Product id);

	void deleteAll();

	void deleteAll(Iterable<? extends Integer> entities);

	Integer getOne(Product id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Product> ids);

	<S extends Integer, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(Integer entity);

	void deleteAllByIdInBatch(Iterable<Product> ids);

	void deleteById(Product id);

	<S extends Integer> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<Integer> entities);

	<S extends Integer> long count(Example<S> example);

	void deleteInBatch(Iterable<Integer> entities);

	<S extends Integer> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Integer> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Product id);

	<S extends Integer> S saveAndFlush(S entity);

	void flush();

	<S extends Integer> List<S> saveAll(Iterable<S> entities);

	Optional<Integer> findById(Product id);

	List<Integer> findAllById(Iterable<Product> ids);

	List<Integer> findAll(Sort sort);

	Page<Integer> findAll(Pageable pageable);

	List<Integer> findAll();

	<S extends Integer> Optional<S> findOne(Example<S> example);

	<S extends Integer> S save(S entity);

}
