package com.citas.agendamiento.controller;

import com.citas.agendamiento.entity.Affiliate;
import com.citas.agendamiento.service.AffiliateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/affiliates")
public class AffiliatesController {

    @Autowired
    private AffiliateService affiliateService;

//    try {
//        // see note 1
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .body(this.userService.chkCredentials(accessKey, secretKey, timestamp));
//    }
//    catch(ChekingCredentialsFailedException e) {
//        e.printStackTrace(); // see note 2
//        return ResponseEntity
//                .status(HttpStatus.FORBIDDEN)
//                .body("Error Message");
//    }
    // https://hc.apache.org/httpclient-legacy/apidocs/org/apache/commons/httpclient/HttpStatus.html


    @GetMapping("/allAffiliates")
    public ResponseEntity<List<Affiliate>> getAllAffiliate() {

        List<Affiliate> affiliates = null;

        try {
            affiliates = affiliateService.getAllAffiliates();
        } catch (Exception ex) {
            ex.getMessage();
        }

        return new ResponseEntity<List<Affiliate>>(affiliates, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Affiliate> getAffiliateByUd(@PathVariable("id") int affiliateId) {

        Affiliate affiliates = null;

        try {
            affiliates = affiliateService.getAffiliateById(affiliateId);
        } catch (Exception ex) {
            ex.getMessage();
        }

        return new ResponseEntity<Affiliate>(affiliates, HttpStatus.OK);
    }

    @PostMapping("/addAffiliate")
    public ResponseEntity<Affiliate> addAffiliate(@RequestBody Affiliate affiliate) {

        Affiliate affiliates = null;

        try {
            affiliates = affiliateService.addOrUpdateAffiliate(affiliate);
            System.out.println(affiliate);
            System.out.println(affiliateService.addOrUpdateAffiliate(affiliate));
        } catch (Exception ex) {
            ex.getMessage();
        }

        return new ResponseEntity<Affiliate>(affiliates, HttpStatus.CREATED);
    }

    @PutMapping("/updateAffiliate")
    public ResponseEntity<Affiliate> updateAffiliate(@RequestBody Affiliate affiliate) {

        Affiliate affiliates = null;

        try {
            affiliates = affiliateService.addOrUpdateAffiliate(affiliate);
        } catch (Exception ex) {
            ex.getMessage();
        }

        return new ResponseEntity<Affiliate>(affiliates, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Affiliate> deletedAffiliate(@PathVariable("id") int affiliateId) {

        Affiliate affiliates = null;

        try {
            affiliates = affiliateService.deletedAffiliate(affiliateId);
        } catch (Exception ex) {
            ex.getMessage();
        }

        return new ResponseEntity<Affiliate>(affiliates, HttpStatus.OK);
    }

}
