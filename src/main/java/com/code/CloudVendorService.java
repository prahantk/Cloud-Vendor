package com.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CloudVendorService {
	
	@Autowired
	private CloudVendorRepository vendorRepository;
	
	// Get vendor by id
	public CloudVendor getVendorById(Integer vendorId) {
		return vendorRepository.findById(vendorId).get();
		
	}
	
	// Get list of all the vendors
	public List<CloudVendor> getAllVendor(){
		return vendorRepository.findAll();
	}
	
	//Create vendor
	public CloudVendor createVendor(CloudVendor cloudVendor) {
		return vendorRepository.save(cloudVendor);
	}
	
	
	//Delete vendor
	public String deleteVendor(Integer vendorId) {
		vendorRepository.deleteById(vendorId);
		 return "Deleted succesfully";
	}

}
