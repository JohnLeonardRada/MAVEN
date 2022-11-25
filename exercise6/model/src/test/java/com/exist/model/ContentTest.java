    package com.exist.model;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;

public class ContentTest extends TestCase{
    
    @Test 
    public void testKeyValue(){
        Content content = new Content();

        content.setKey("ABC");
        content.setValue("XYZ");

        Assert.assertEquals(content.concatKeyValue(), "ABC:XYZ");
    }

    @Test
    public void testCreateContent(){
        Content content = new Content("ABC","XYZ");

        Assert.assertEquals(content.getKey(), "ABC");
        Assert.assertEquals(content.getValue(),"XYZ");
    }

    @Test
    public void testChangeContent(){
        Content content = new Content("ABC","XYZ");

        content.setKey("ABC");
        content.setValue("XYZ");

        Assert.assertEquals(content.getKey(), "ABC");
        Assert.assertEquals(content.getValue(), "XYZ");
    }

    // @Test
    // public void testCompareTo() throws Exception {
    //     Content content1 = new Content("ABC");
    //     Content content2 = new Content("XYZ");
        
    //     Assert.assertEquals(content1.compareTo(content2), content1.compareTo(content2));
    // }
}
