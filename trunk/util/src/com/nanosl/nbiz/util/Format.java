/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Thilina Ranathunga
 */
public interface Format {

    public static final DateFormat dd_MMMM_yyyy = new SimpleDateFormat("dd - MMMM - yyyy");
    public static final DateFormat dd_MM_yyyy = new SimpleDateFormat("dd-MM-yyyy");
    public static final DateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
    public static final NumberFormat nf3p = new DecimalFormat("#000");
    public static final NumberFormat nf4p = new DecimalFormat("#00000");
    public static final NumberFormat nf0d = new DecimalFormat("#0");
    public static final NumberFormat nf1d = new DecimalFormat("#0.0");
    public static final NumberFormat nf2d = new DecimalFormat("#0.00");
    public static final NumberFormat nf3d = new DecimalFormat("#0.000");
}