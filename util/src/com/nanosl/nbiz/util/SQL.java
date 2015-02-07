/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.nbiz.util;

/**
 *
 * @author Thilina
 */
interface SQL {

    String ADD_paid_by_credit_card_TO_sale_invoice = "ALTER TABLE `sale_invoice` ADD COLUMN `paid_by_credit_card`  double NULL AFTER `paid_amount`;";
}
