package com.example.tableRelationDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tableRelationDemo.Service.AddressService;
import com.example.tableRelationDemo.entity.AddressEntity;

@RestController
@RequestMapping("/addresses")
public class AddressController {
	 @Autowired
	    private AddressService addressService;

	    @PostMapping
	    public ResponseEntity<AddressEntity> createAddress(@RequestBody AddressEntity address) {
	        AddressEntity createdAddress = addressService.createAddress(address);
	        return new ResponseEntity<>(createdAddress, HttpStatus.CREATED);
	    }

	    @GetMapping
	    public ResponseEntity<List<AddressEntity>> getAllAddresses() {
	        List<AddressEntity> addresses = addressService.getAllAddresses();
	        return new ResponseEntity<>(addresses, HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<AddressEntity> getAddressById(@PathVariable("id") int id) {
	        return addressService.getAddressById(id)
	                .map(address -> new ResponseEntity<>(address, HttpStatus.OK))
	                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<AddressEntity> updateAddress(@PathVariable("id") int id, @RequestBody AddressEntity updatedAddress) {
	        AddressEntity address = addressService.updateAddress(id, updatedAddress);
	        if (address != null) {
	            return new ResponseEntity<>(address, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteAddress(@PathVariable("id") int id) {
	        addressService.deleteAddress(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
}
