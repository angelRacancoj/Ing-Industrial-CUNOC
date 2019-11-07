/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Produce;

import Group.Group;
import Production.Production;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import org.testng.annotations.Test;
import org.testng.Assert;

/**
 *
 * @author angelrg
 */
public class HistoryTest {

    @Test
    public void testSetAndGetIdGroup() throws Exception {
        // Arrange
        History history = new History();
        int testVal = 100;

        // Act
        history.setHistory_id(testVal);
        int result = history.getHistory_id();

        // Assert
        Assert.assertEquals(result, testVal);
    }

    @Test
    public void testSetAndGetStartDate() throws Exception {
        //Arrange
        History history = new History();
        LocalDate testDate = LocalDate.now();

        //Act
        history.setStartDate(testDate);
        LocalDate result = history.getStartDate();

        //Assert
        Assert.assertEquals(result, testDate);
    }

    @Test
    public void testSetAndGetEndDate() throws Exception {
        //Arrange
        History history = new History();
        LocalDate testDate = LocalDate.now();

        //Act
        history.setEndDate(testDate);
        LocalDate result = history.getEndDate();

        //Assert
        Assert.assertEquals(result, testDate);
    }

    @Test
    public void testSetAndGetTotalCost() throws Exception {
        //Arrange
        History history = new History();
        double testVal = 123.45;

        //Act
        history.setTotalCost(testVal);
        double result = history.getTotalCost();

        //Assert
        Assert.assertEquals(result, testVal);
    }

    @Test
    public void testSetAndGetbatchesProduced() throws Exception {
        //Arrange
        History history = new History();
        int testVal = 123;

        //Act
        history.setBatchesProduced(testVal);
        int result = history.getBatchesProduced();

        //Assert
        Assert.assertEquals(result, testVal);
    }

    @Test
    public void testSetAndGetIsActive() throws Exception {
        //Arrange
        History history = new History();
        boolean testBool = true;

        //Act
        history.setIsActive(testBool);
        boolean result = history.isIsActive();

        //Assert
        Assert.assertEquals(result, testBool);
    }

    @Test
    public void testSetAndGetProduction() throws Exception {
        //Arrange
        History history = new History();
        Production production = new Production();

        //Act
        history.setProduction(production);
        Production result = history.getProduction();

        //Assert
        Assert.assertEquals(result, production);
    }

    @Test
    public void testSetAndGetGroup() throws Exception {
        //Arrange
        History history = new History();
        Group testGroup = new Group();

        //Act
        history.setGroup(testGroup);
        Group result = history.getGroup();

        //Assert
        Assert.assertEquals(result, testGroup);
    }

}
