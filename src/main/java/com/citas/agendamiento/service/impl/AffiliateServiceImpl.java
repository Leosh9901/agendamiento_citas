package com.citas.agendamiento.service.impl;

import com.citas.agendamiento.entity.Affiliate;
import com.citas.agendamiento.repository.AffiliateRepository;
import com.citas.agendamiento.service.AffiliateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AffiliateServiceImpl implements AffiliateService {

    @Autowired
    private AffiliateRepository affiliateRepository;

    @Override
    public List<Affiliate> getAllAffiliates() {
        return (List<Affiliate>) affiliateRepository.findAll();
    }

    @Override
    public Affiliate getAffiliateById(int affiliateId) {
        return affiliateRepository.findById(affiliateId).orElse(null);
    }

    @Override
    public Affiliate addOrUpdateAffiliate(Affiliate affiliate) {
        return affiliateRepository.save(affiliate);
    }

    @Override
    public Affiliate deletedAffiliate(int affiliateId) throws Exception {
        Affiliate deletedAffiliate = null;
        try {
            deletedAffiliate = affiliateRepository.findById(affiliateId).orElse(null);

            if (deletedAffiliate == null){
                throw new Exception("Affiliate not available");
            }else {
                affiliateRepository.deleteById(affiliateId);
            }
        } catch (Exception ex){
            throw ex;
        }
        return deletedAffiliate;
    }
}
