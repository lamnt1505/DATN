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

import poly.edu.DATN.Entity.FeedBack;
import poly.edu.DATN.Repository.FeedBackRepository;
import poly.edu.DATN.Service.FeedBackService;
@Service
public class FeedBackServiceImpl implements FeedBackService{
    
    @Autowired
    FeedBackRepository feedBackRepository;

    @Override
    public List<FeedBack> listFeedBack() {
        return feedBackRepository.listFeedBack();
    }

    @Override
    public <S extends FeedBack> S save(S entity) {
        return feedBackRepository.save(entity);
    }

    @Override
    public <S extends FeedBack> Optional<S> findOne(Example<S> example) {
        return feedBackRepository.findOne(example);
    }

    @Override
    public List<FeedBack> findAll() {
        return feedBackRepository.findAll();
    }

    @Override
    public Page<FeedBack> findAll(Pageable pageable) {
        return feedBackRepository.findAll(pageable);
    }

    @Override
    public List<FeedBack> findAll(Sort sort) {
        return feedBackRepository.findAll(sort);
    }

    @Override
    public List<FeedBack> findAllById(Iterable<Integer> ids) {
        return feedBackRepository.findAllById(ids);
    }

    @Override
    public Optional<FeedBack> findById(Integer id) {
        return feedBackRepository.findById(id);
    }

    @Override
    public <S extends FeedBack> List<S> saveAll(Iterable<S> entities) {
        return feedBackRepository.saveAll(entities);
    }

    @Override
    public void flush() {
        feedBackRepository.flush();
    }

    @Override
    public <S extends FeedBack> S saveAndFlush(S entity) {
        return feedBackRepository.saveAndFlush(entity);
    }

    @Override
    public boolean existsById(Integer id) {
        return feedBackRepository.existsById(id);
    }

    @Override
    public <S extends FeedBack> List<S> saveAllAndFlush(Iterable<S> entities) {
        return feedBackRepository.saveAllAndFlush(entities);
    }

    @Override
    public <S extends FeedBack> Page<S> findAll(Example<S> example, Pageable pageable) {
        return feedBackRepository.findAll(example, pageable);
    }

    @Override
    public void deleteInBatch(Iterable<FeedBack> entities) {
        feedBackRepository.deleteInBatch(entities);
    }

    @Override
    public <S extends FeedBack> long count(Example<S> example) {
        return feedBackRepository.count(example);
    }

    @Override
    public void deleteAllInBatch(Iterable<FeedBack> entities) {
        feedBackRepository.deleteAllInBatch(entities);
    }

    @Override
    public long count() {
        return feedBackRepository.count();
    }

    @Override
    public <S extends FeedBack> boolean exists(Example<S> example) {
        return feedBackRepository.exists(example);
    }

    @Override
    public void deleteById(Integer id) {
        feedBackRepository.deleteById(id);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> ids) {
        feedBackRepository.deleteAllByIdInBatch(ids);
    }

    @Override
    public void delete(FeedBack entity) {
        feedBackRepository.delete(entity);
    }

    @Override
    public <S extends FeedBack, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
        return feedBackRepository.findBy(example, queryFunction);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> ids) {
        feedBackRepository.deleteAllById(ids);
    }

    @Override
    public void deleteAllInBatch() {
        feedBackRepository.deleteAllInBatch();
    }

    @Override
    public FeedBack getOne(Integer id) {
        return feedBackRepository.getOne(id);
    }

    @Override
    public void deleteAll(Iterable<? extends FeedBack> entities) {
        feedBackRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        feedBackRepository.deleteAll();
    }

    @Override
    public FeedBack getById(Integer id) {
        return feedBackRepository.getById(id);
    }

    @Override
    public <S extends FeedBack> List<S> findAll(Example<S> example) {
        return feedBackRepository.findAll(example);
    }

    @Override
    public <S extends FeedBack> List<S> findAll(Example<S> example, Sort sort) {
        return feedBackRepository.findAll(example, sort);
    }
    
    
    
}
