package com.Project.VendorProject.apiTest;

import com.Project.VendorProject.api.AssetApi;
import com.Project.VendorProject.model.Asset;
import com.Project.VendorProject.model.Vendor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserApiTest {

    @Mock
    private AssetApi assetApi;

    @Test
    public void testGetAsset() {
        List<Asset> assetList = new ArrayList<>();
        when(assetApi.getAsset()).thenReturn(assetList);

        List<Asset> result = assetApi.getAsset();

        assertEquals(assetList, result);
    }

    @Test
    public void testSaveAsset() {
        Asset asset = new Asset();
        when(assetApi.saveAsset(asset)).thenReturn(asset);

        Asset result = assetApi.saveAsset(asset);

        assertEquals(asset, result);
    }

    @Test
    public void testStoreVendor() {
        int assetSiNo = 1;
        Vendor vendor = new Vendor();
        Asset asset = new Asset();

        when(assetApi.storeVendor(assetSiNo, vendor)).thenReturn(asset);

        Asset result = assetApi.storeVendor(assetSiNo, vendor);

        assertEquals(asset, result);
    }
}
