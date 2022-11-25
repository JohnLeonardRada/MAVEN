package com.exist.service.functions;

import java.util.ArrayList;

import com.exist.model.Content;
import com.exist.model.Matrix;

import org.junit.Assert;
import org.junit.Test;

public class EditTest {
    
    @Test
    public void editStringKeyTest(){
        ArrayList<ArrayList<Content>> arrayMatrix = new ArrayList<ArrayList<Content>>();
        Matrix matrix = new Matrix(arrayMatrix, 3, 3);

        String searchKey = "ABC";
        String newValue = "XYZ";

        Edit.editStringKey(matrix, searchKey, newValue);
        Assert.assertEquals(searchKey, "ABC");
    }

    @Test
    public void editStringValueTest(){
        ArrayList<ArrayList<Content>> arrayMatrix = new ArrayList<ArrayList<Content>>();
        Matrix matrix = new Matrix(arrayMatrix, 3, 3);

        String searchKey = "ABC";
        String newValue = "XYZ";

        Edit.editStringValue(matrix, searchKey, newValue);
        Assert.assertEquals(searchKey, "ABC");
    }
}
