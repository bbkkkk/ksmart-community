package com.ksmart.framework.base.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface KBaseDao<T, ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
    /**
     * 自定义批量插入，解决jpa saveAll 执行时一条条查询校验再插入引起的性能问题
     *
     * @param entities
     * @param <S>
     * @return
     */
    public <S extends T> Iterable<S> batchSave(Iterable<S> entities);

    /**
     * 自定义批量修改，解决jpa saveAll 执行时一条条查询校验再插入引起的性能问题
     *
     * @param entities
     * @param <S>
     * @return
     */
    public <S extends T> Iterable<S> batchUpdate(Iterable<S> entities);


    /**
     * 自定义批量删除，解决jpa delete前先查询后删除性能问题
     *
     * @param entities
     * @param <S>
     * @return
     */
    public <S extends T> Iterable<S> batchDelete(Iterable<S> entities);


    /**
     * 原生的Slice findAll 中readPage方法一定会执行总量统计，sql条件比较复杂的时候性能较差
     * 通过重写readPage方法不做总数统计提升性能，如果
     *
     * @param spec
     * @param pageable
     * @param domainClass
     * @param <T>
     * @param <I>
     * @return
     */
    public <T, I extends Serializable> Slice<T> findPageNoCount(final Specification<T> spec, final Pageable pageable,
                                                                final Class<T> domainClass);
}
