package com.citas.agendamiento.service;

import com.citas.agendamiento.entity.Affiliate;

import java.util.List;

public interface AffiliateService {

    List<Affiliate> getAllAffiliate();

    Affiliate getAffiliateById(int affiliateId);

    Affiliate addOrUpdateAffiliate(Affiliate affiliate);

    Affiliate deletedAffiliate(int affiliateId) throws Exception;
}
