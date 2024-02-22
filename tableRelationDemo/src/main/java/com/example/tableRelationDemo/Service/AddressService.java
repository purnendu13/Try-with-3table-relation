package com.example.tableRelationDemo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tableRelationDemo.entity.AddressEntity;
import com.example.tableRelationDemo.jpa.AddressRepo;

@Service
public class AddressService {
		
    @Autowired
    private AddressRepo  addressRepository;

    // Create operation
    public AddressEntity createAddress(AddressEntity address) {
        return addressRepository.save(address);
    }

    // Read operation
    public List<AddressEntity> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Optional<AddressEntity> getAddressById(int id) {
        return addressRepository.findById(id);
    }

    // Update operation
    public AddressEntity updateAddress(int id, AddressEntity updatedAddress) {
        Optional<AddressEntity> existingAddress = addressRepository.findById(id);
        if (existingAddress.isPresent()) {
            updatedAddress.setAddressId(id);
            return addressRepository.save(updatedAddress);
        } else {
            return null; // Address not found
        }
    }

    // Delete operation
    public void deleteAddress(int id) {
        addressRepository.deleteById(id);
    }

	
}
