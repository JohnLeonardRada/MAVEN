package com.exist.service.view;

import org.junit.Assert;
import org.junit.Test;

public class MatrixViewTest{
    MatrixView mv = new MatrixView();
    
    @Test
    public void testActionMenu(){
        Assert.assertEquals("--------MENU--------", mv.actionMenu());
    }

    @Test
    public void testAddRow(){
        Assert.assertEquals("-------Add Row-------", mv.addRow());
    }

    @Test
    public void testAddCol(){
        Assert.assertEquals("-------Add Col-------", mv.addCol());
    }

    @Test
    public void testSearchString(){
        Assert.assertEquals("-------Search-------", mv.searchString());
    }

    @Test
    public void testSearchCtr(){
        final int ctr = 0;
        Assert.assertEquals("\nNumber of matches: " , mv.searchCtr(ctr));
    }

    @Test
    public void testEditString(){
        Assert.assertEquals("-------Edit-------", mv.editString());
    }

    @Test
    public void testPrintMatrix(){
        Assert.assertEquals("-------Matrix-------", mv.printMatrix());
    }
    
    @Test
    public void testSortMatrix(){
        Assert.assertEquals("-------Sort-------", mv.sortMatrix());
    }

    @Test
    public void testResetMatrix(){
        Assert.assertEquals("-------Reset-------", mv.resetMatrix());
    }

    @Test
    public void testInvalidInput(){
        Assert.assertEquals("Invalid Input! Try Again!", mv.invallidInput());
    }

    @Test
    public void testDisplayAction(){
        String display= "\n[1]=[Add Row]\n[2]=[Add Col]\n[3]=[Search]\n[4]=[Edit]\n[5]=[Print]\n[6]=[Sort]\n[7]=[Reset]\n[0]=[Exit]";

        Assert.assertEquals(display, mv.displayAction());
    }
}
