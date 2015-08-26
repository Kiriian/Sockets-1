/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets.mathserver;

/**
 *
 * @author sofus
 */
// PlainMathService.java: An implementation of the MathService interface.
public class PlainMathService implements MathService {
public double add(double firstValue, double secondValue) {
return firstValue+secondValue;
}
public double sub(double firstValue,double secondValue) {
return firstValue-secondValue;
}
public double mul(double firstValue,double secondValue) {
return firstValue * secondValue;
}
public double div(double firstValue,double secondValue) {
if (secondValue != 0)
return firstValue / secondValue;
return Double.MAX_VALUE;
}

}