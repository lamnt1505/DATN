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
import org.springframework.stereotype.Service;

import poly.edu.DATN.Entity.Product;
import poly.edu.DATN.Repository.ProductRepository;
import poly.edu.DATN.Service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public <S extends Integer> S save(S entity) {
		return productRepository.save(entity);
	}

	@Override
	public <S extends Integer> Optional<S> findOne(Example<S> example) {
		return productRepository.findOne(example);
	}

	@Override
	public List<Integer> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Page<Integer> findAll(Pageable pageable) {
		return productRepository.findAll(pageable);
	}

	@Override
	public List<Integer> findAll(Sort sort) {
		return productRepository.findAll(sort);
	}

	@Override
	public List<Integer> findAllById(Iterable<Product> ids) {
		return productRepository.findAllById(ids);
	}

	@Override
	public Optional<Integer> findById(Product id) {
		return productRepository.findById(id);
	}

	@Override
	public <S extends Integer> List<S> saveAll(Iterable<S> entities) {
		return productRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		productRepository.flush();
	}

	@Override
	public <S extends Integer> S saveAndFlush(S entity) {
		return productRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Product id) {
		return productRepository.existsById(id);
	}

	@Override
	public <S extends Integer> List<S> saveAllAndFlush(Iterable<S> entities) {
		return productRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Integer> Page<S> findAll(Example<S> example, Pageable pageable) {
		return productRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Integer> entities) {
		productRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Integer> long count(Example<S> example) {
		return productRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Integer> entities) {
		productRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return productRepository.count();
	}

	@Override
	public <S extends Integer> boolean exists(Example<S> example) {
		return productRepository.exists(example);
	}

	@Override
	public void deleteById(Product id) {
		productRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Product> ids) {
		productRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Integer entity) {
		productRepository.delete(entity);
	}

	@Override
	public <S extends Integer, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return productRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Product> ids) {
		productRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		productRepository.deleteAllInBatch();
	}

	@Override
	public Integer getOne(Product id) {
		return productRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Integer> entities) {
		productRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		productRepository.deleteAll();
	}

	@Override
	public Integer getById(Product id) {
		return productRepository.getById(id);
	}

	@Override
	public <S extends Integer> List<S> findAll(Example<S> example) {
		return productRepository.findAll(example);
	}

	@Override
	public <S extends Integer> List<S> findAll(Example<S> example, Sort sort) {
		return productRepository.findAll(example, sort);
	}
	
	
}
