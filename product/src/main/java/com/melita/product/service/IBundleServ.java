package com.melita.product.service;

import com.melita.product.dto.ProductBundles;
import com.melita.product.dto.BundleReq;
import com.melita.product.dto.BundleResp;
import com.melita.product.exception.StandarizedException;

public interface IBundleServ {

    BundleResp saveBundle(BundleReq bundleReq, long id) throws StandarizedException;
    ProductBundles getByProductId(long id) throws StandarizedException;

}
