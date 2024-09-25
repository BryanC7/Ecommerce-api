package cl.praxis.ecommerce.services.impl;

import cl.praxis.ecommerce.entities.Detail;
import cl.praxis.ecommerce.repositories.DetailRepository;
import cl.praxis.ecommerce.services.IBaseCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailService implements IBaseCrud<Detail> {
    @Autowired
    private DetailRepository detailRepository;

    @Override
    public List<Detail> getAll() {
        return detailRepository.findAll();
    }

    @Override
    public Detail getById(Long id) {
        return detailRepository.findById(id).orElse(null);
    }

    @Override
    public Detail create(Detail detail) {
        return detailRepository.save(detail);
    }

    @Override
    public Detail update(Detail detail) {
        return detailRepository.save(detail);
    }

    @Override
    public boolean delete(Long id) {
        if(detailRepository.existsById(id)) {
            detailRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
