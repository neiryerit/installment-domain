package com.melita.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.melita.product.dto.ProductBundles;
import com.melita.product.dto.BundleReq;
import com.melita.product.dto.BundleResp;
import com.melita.product.dto.ProductReq;
import com.melita.product.dto.ProductResp;
import com.melita.product.exception.StandarizedException;
import com.melita.product.service.IBundleServ;
import com.melita.product.service.IProductServ;

import jakarta.validation.Valid;

@RestController("/products")
public class ProductController {

    @Autowired
    IProductServ productServ;
    @Autowired
    IBundleServ bundleServ;

    @PostMapping(consumes = { "application/json; charset=UTF-8" }, produces = { "application/json; charset=UTF-8" })
    public ResponseEntity<ProductResp> saveProduct(@Valid @RequestBody ProductReq productReq) {

        ProductResp productResp = productServ.save(productReq);

        return ResponseEntity.status(HttpStatus.CREATED).body(productResp);
    }

    @GetMapping(path = "/{id}", produces = { "application/json; charset=UTF-8" })
    public ResponseEntity<?> getById(@PathVariable long id) throws StandarizedException {

        ProductResp productResp = productServ.getById(id);
        return ResponseEntity.ok().body(productResp);
    }

    @PostMapping(path = "/{id}/bundles", consumes = { "application/json; charset=UTF-8" }, produces = {
            "application/json; charset=UTF-8" })
    public ResponseEntity<BundleResp> saveBundle(@Valid @RequestBody BundleReq pkgReq, @PathVariable long id)
            throws StandarizedException {

        BundleResp bundleResp = bundleServ.saveBundle(pkgReq, id);

        return ResponseEntity.status(HttpStatus.CREATED).body(bundleResp);
    }

    @GetMapping(path = "/{id}/bundles", produces = { "application/json; charset=UTF-8" })
    public ResponseEntity<ProductBundles> getBundlesByProduct(@PathVariable long id) throws StandarizedException {

        ProductBundles bundleProduct = bundleServ.getByProductId(id);
        return ResponseEntity.ok().body(bundleProduct);
    }

}
