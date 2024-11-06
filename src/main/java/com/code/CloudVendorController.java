package com.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/vendor")
public class CloudVendorController {

    @Autowired
    private CloudVendorService cloudVendorService;

    // Get all vendors
    @GetMapping
    public String getAllVendorDetails(Model model) {
        List<CloudVendor> vendors = cloudVendorService.getAllVendor();
        model.addAttribute("vendors", vendors);
        return "vendor"; 
    }

    // Show the form to add a new vendor
    @GetMapping("/new")
    public String showAddVendorForm(Model model) {
        model.addAttribute("cloudVendor", new CloudVendor());
        return "vendor_form"; 
    }

    // Save a new vendor
    @PostMapping
    public String saveCloudVendorDetails(@ModelAttribute CloudVendor cloudVendor, RedirectAttributes redirectAttributes) {
        cloudVendorService.createVendor(cloudVendor);
        redirectAttributes.addFlashAttribute("message", "Vendor Details saved successfully");
        return "redirect:/vendor"; 
    }

    // Show the form to update an existing vendor
    @GetMapping("/edit/{vendorId}")
    public String showEditVendorForm(@PathVariable Integer vendorId, Model model) {
        CloudVendor cloudVendor = cloudVendorService.getVendorById(vendorId);
        model.addAttribute("cloudVendor", cloudVendor);
        return "vendor_form"; 
    }

    // Update an existing vendor
    @PostMapping("/update")
    public String updateCloudVendorDetails(@ModelAttribute CloudVendor cloudVendor, RedirectAttributes redirectAttributes) {
        cloudVendorService.createVendor(cloudVendor);  
        redirectAttributes.addFlashAttribute("message", "Vendor Details updated successfully");
        return "redirect:/vendor"; 
    }

    // Delete a vendor
    @PostMapping("/{vendorId}")
    public String deleteVendorDetailsById(@PathVariable Integer vendorId, RedirectAttributes redirectAttributes) {
        cloudVendorService.deleteVendor(vendorId);
        redirectAttributes.addFlashAttribute("message", "Vendor Details deleted successfully");
        return "redirect:/vendor"; 
    }
}
