package org.example.v1__03_08_2024.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.v1__03_08_2024.utils.DividersUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {


    @GetMapping("/t2")
    public Object test2() {
        return DividersUtil.task2(9, List.of(7, 404, 204, 1203, 1003, 803, 603, 403, 203));
    }

    @GetMapping("/t3")
    public Object test3(@RequestParam(required = false) String numsString) {

        String[] numsArrayString = numsString.split(",");

        int[] nums = new int[numsArrayString.length];
        for (int i = 0; i < numsArrayString.length; i++) {
            nums[i] = Integer.parseInt(numsArrayString[i]);
        }
        for (int i = 1; i <= 30; i++) {
            for (int j = 0; j <= i; j++) {
                int i1 = DividersUtil.subsetQuantity(j, i - j);
                if (j != 0 && pow(2, i) != i1) {
                    log.info("e={}, z={}, e+z={}, count: {}", j, i - j, i, i1);
                }
            }
        }

        int sum = 0;
        int pow = 0;
        int length = nums.length;
        boolean continueLoop = true;
        while (continueLoop) {
            boolean hasOne = false;
            continueLoop = false;
            for (int i = 0; i < length; i++) {
                hasOne = hasOne || (nums[i] & 1) == 1;
                nums[i] >>= 1;
                continueLoop = continueLoop || nums[i] > 0;
            }
            if (!hasOne) {
                sum -= Math.pow(2, pow + length - 1);
            }
            pow++;
        }
        sum += Math.pow(2, length - 1) * (Math.pow(2, pow) - 1);
        return sum;
    }


    @GetMapping("/t4")
    public Object test4(@RequestParam(required = false) String numsString) {

        String[] numsArrayString = numsString.split(",");

        int[] nums = new int[numsArrayString.length];
        for (int i = 0; i < numsArrayString.length; i++) {
            nums[i] = Integer.parseInt(numsArrayString[i]);
        }
        int result = 0;
        for(int i =0; i<nums.length;i++){
            result |=nums[i];
        }
        return result*Math.pow(2, nums.length-1);
    }

    public static int pow(int value, int powValue) {
        int result = 1;
        for (int i = 1; i <= powValue; i++) {
            result = result * value;
        }
        return result;
    }
    @GetMapping("/t5")
    public Object exersize5(){
        return DividersUtil.exE();
    }    @GetMapping("/t6")
    public Object exersize6(){
        return DividersUtil.exF();
    }
}/*
203 403
203 603
203 803
203 1003
403 603
403 803
403 1003
603 803
603 1003
803 1003
*/