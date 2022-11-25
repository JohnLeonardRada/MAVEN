package com.exist.service.functions;

import java.util.ArrayList;

import com.exist.model.Content;
import com.exist.model.Matrix;

import org.junit.Assert;
import org.junit.Test;

public class SearchTest {
    
    @Test
    public void searchStringTest(){
        ArrayList<ArrayList<Content>> arrayMatrix = new ArrayList<ArrayList<Content>>();
        Matrix matrix = new Matrix(arrayMatrix, 3, 3);

        String search = "G";
        int total = 1;

        Search.searchString(matrix, search, total);
        Assert.assertEquals(search, "G");
    }
}
