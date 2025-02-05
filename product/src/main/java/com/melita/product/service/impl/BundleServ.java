package com.melita.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.melita.product.dto.ProductBundles;
import com.melita.product.dto.BundleBasic;
import com.melita.product.dto.BundleReq;
import com.melita.product.dto.BundleResp;
import com.melita.product.mapper.IProducBundlesMapper;
import com.melita.product.mapper.IBundleReqMapper;
import com.melita.product.mapper.IBundleRespMapper;
import com.melita.product.repository.IBundleRepo;
import com.melita.product.repository.IProductRepo;
import com.melita.product.service.IBundleServ;

import jakarta.persistence.EntityNotFoundException;

import com.melita.product.entity.Bundle;
import com.melita.product.entity.Product;
import com.melita.product.exception.StandarizedException;

@Service
public class BundleServ implements IBundleServ{

    @Autowired
    IBundleRepo bundleRepo;
    @Autowired
    IProductRepo productRepo;
    @Autowired
    IBundleReqMapper bundleReqMapper;
    @Autowired
    IBundleRespMapper bundleRespMapper;
    @Autowired
    IProducBundlesMapper bundleProductMapper;

    @Override
    public BundleResp saveBundle(BundleReq bundleReq, long id) throws StandarizedException {
        try{
            Product prod = productRepo.getReferenceById(id); //search the product
            Bundle bundle = bundleReqMapper.toBundle(bundleReq); //map to bundle entity
            bundle.setProduct(prod); //add the found product to bundle entity
            Bundle newBundle = bundleRepo.save(bundle); //save the bundle
            newBundle.setProduct(prod); //add prod info to the response
            return bundleRespMapper.toBundleResp(newBundle); //map to dto and return the created bundle and its product

        } catch (EntityNotFoundException ex) {
            throw new StandarizedException("001", "Unable to find product with id=" + id, HttpStatus.NOT_FOUND);
        }
        
    }

    @Override
    public ProductBundles getByProductId(long id) throws StandarizedException {
        try {
            Product prod = productRepo.getReferenceById(id); //search the product
            ProductBundles bundles = bundleProductMapper.toBundleProduct(prod); //map to product dto
            List<Bundle> founBundle = bundleRepo.findBundlesByProduct(id); //search the list of bundles for given product
            List<BundleBasic> bundlesDto = bundleProductMapper.toBundleProductList(founBundle); //map to bundle dto
            bundles.setBundles(bundlesDto); //add bundles to product

            return bundles;
        } catch (EntityNotFoundException ex) {
            throw new StandarizedException("001", "Unable to find product with id=" + id, HttpStatus.NOT_FOUND);
        }
    }

}
