/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diakogiannis.metropolitan.paper.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author diakogiannis
 */
public class PaceCalculationServiceTest {
    
    public PaceCalculationServiceTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of calculatePaceFormated method, of class PaceCalculationService.
     */
    @Test
    public void testCalculatePaceFormated() {
        PaceCalculationService instance = new PaceCalculationService();
        String expResult = "6";
        String result = instance.calculatePaceFormated(5000, 1800000);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculatePace method, of class PaceCalculationService.
     */
    @Test
    public void testCalculatePace() {
        PaceCalculationService instance = new PaceCalculationService();
        Double expResult = 6d;
        Double result = instance.calculatePace(5000, 1800000);
        assertEquals(expResult, result);
    }
    
}
