package cl.praxis.ecommerce.services.impl;

import cl.praxis.ecommerce.entities.Address;
import cl.praxis.ecommerce.repositories.AddressRepository;
import cl.praxis.ecommerce.services.IBaseCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService implements IBaseCrud<Address> {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address getById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public Address create(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address update(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public boolean delete(Long id) {
        if(addressRepository.existsById(id)) {
            addressRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
