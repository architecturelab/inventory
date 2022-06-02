package com.architecturelab.inventory.infra.jpa.repository.type;

import com.architecturelab.inventory.infra.jpa.dao.TypeDao;
import com.architecturelab.inventory.infra.jpa.domain.Type;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class TypeJpaRepositoryImpl implements TypeJpaRepository {

    @Autowired
    private TypeDao typeDao;

    @Override
    public Type save(Type entity) {
        return typeDao.save(entity);
    }

    @Override
    public Iterable<Type> getAll() {
        return typeDao.findAll();
    }

    @Override
    public Optional<Type> getById(Long id) {
        return typeDao.findById(id);
    }
}
