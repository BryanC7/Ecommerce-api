package cl.praxis.ecommerce.services.impl;

import cl.praxis.ecommerce.entities.Pay;
import cl.praxis.ecommerce.repositories.PayRepository;
import cl.praxis.ecommerce.services.IBaseCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayService implements IBaseCrud<Pay> {
    @Autowired
    private PayRepository payRepository;

    @Override
    public List<Pay> getAll() {
        return payRepository.findAll();
    }

    @Override
    public Pay getById(Long id) {
        return payRepository.findById(id).orElse(null);
    }

    @Override
    public Pay create(Pay pay) {
        return payRepository.save(pay);
    }

    @Override
    public Pay update(Pay pay) {
        return payRepository.save(pay);
    }

    @Override
    public boolean delete(Long id) {
        if(payRepository.existsById(id)) {
            payRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
