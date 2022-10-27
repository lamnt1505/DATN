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

import poly.edu.DATN.Entity.FeedBack;

@Service
public interface FeedBackService {

    <S extends FeedBack> List<S> findAll(Example<S> example, Sort sort);

    <S extends FeedBack> List<S> findAll(Example<S> example);

    FeedBack getById(Integer id);

    void deleteAll();

    void deleteAll(Iterable<? extends FeedBack> entities);

    FeedBack getOne(Integer id);

    void deleteAllInBatch();

    void deleteAllById(Iterable<? extends Integer> ids);

    <S extends FeedBack, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

    void delete(FeedBack entity);

    void deleteAllByIdInBatch(Iterable<Integer> ids);

    void deleteById(Integer id);

    <S extends FeedBack> boolean exists(Example<S> example);

    long count();

    void deleteAllInBatch(Iterable<FeedBack> entities);

    <S extends FeedBack> long count(Example<S> example);

    void deleteInBatch(Iterable<FeedBack> entities);

    <S extends FeedBack> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends FeedBack> List<S> saveAllAndFlush(Iterable<S> entities);

    boolean existsById(Integer id);

    <S extends FeedBack> S saveAndFlush(S entity);

    void flush();

    <S extends FeedBack> List<S> saveAll(Iterable<S> entities);

    Optional<FeedBack> findById(Integer id);

    List<FeedBack> findAllById(Iterable<Integer> ids);

    List<FeedBack> findAll(Sort sort);

    Page<FeedBack> findAll(Pageable pageable);

    List<FeedBack> findAll();

    <S extends FeedBack> Optional<S> findOne(Example<S> example);

    <S extends FeedBack> S save(S entity);

    List<FeedBack> listFeedBack();

}
