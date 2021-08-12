package com.ksmart.framework.base.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class KBaseDaoImpl<T, ID> extends SimpleJpaRepository<T, ID> implements KBaseDao<T, ID> {

    private static final int BATCH_SIZE = 500;
    private final EntityManager em;
    private final JpaEntityInformation<T, ID> entityInformation;

    public KBaseDaoImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager em) {
        super(entityInformation, em);
        this.em = em;
        this.entityInformation = entityInformation;
    }

    @Override
    @Transactional
    public <S extends T> Iterable<S> batchSave(Iterable<S> entities) {
        Iterator<S> iterator = entities.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            em.persist(iterator.next());
            index++;
            if (index % BATCH_SIZE == 0) {
                em.flush();
                em.clear();
            }
        }
        if (index % BATCH_SIZE != 0) {
            em.flush();
            em.clear();
        }
        return entities;
    }

    @Override
    @Transactional
    public <S extends T> Iterable<S> batchUpdate(Iterable<S> entities) {
        Iterator<S> iterator = entities.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            em.merge(iterator.next());
            index++;
            if (index % BATCH_SIZE == 0) {
                em.flush();
                em.clear();
            }
        }
        if (index % BATCH_SIZE != 0) {
            em.flush();
            em.clear();
        }
        return entities;
    }

    @Override
    @Transactional
    public <S extends T> Iterable<S> batchDelete(Iterable<S> entities) {
        Iterator<S> iterator = entities.iterator();
        int index = 0;
        while (iterator.hasNext()) {
//            em.remove(em.merge(iterator.next()));
            em.remove(iterator.next());
            index++;
            if (index % BATCH_SIZE == 0) {
                em.flush();
                em.clear();
            }
        }
        if (index % BATCH_SIZE != 0) {
            em.flush();
            em.clear();
        }
        return entities;
    }


    @Override
    public <T, I extends Serializable> Slice<T> findPageNoCount(final Specification<T> spec, final Pageable pageable,
                                                                final Class<T> domainClass) {
        final SimpleJpaNoCountRepository<T, I> noCountDao = new SimpleJpaNoCountRepository<>(domainClass, em);
        return noCountDao.findAll(spec, pageable);
    }

    /**
     * Custom repository type that disable count query.
     */
    public static class SimpleJpaNoCountRepository<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> {

        public SimpleJpaNoCountRepository(Class<T> domainClass, EntityManager em) {
            super(domainClass, em);
        }

        @Override
        protected <S extends T> Page<S> readPage(TypedQuery<S> query, Class<S> domainClass, Pageable pageable, Specification<S> spec) {
            query.setFirstResult((int) pageable.getOffset());
            query.setMaxResults(pageable.getPageSize());
            final List<S> content = query.getResultList();
            return new PageImpl<>(content, pageable, content.size());
        }
    }
}
