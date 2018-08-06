/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch16;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

/**
 *
 * @author Piet
 */

//*******************************************************************
// Fraction
//*******************************************************************
public class Fraction {
    final long numerator;
    final long denominator;
    
    //-----------------------------------------------
    public Fraction(long numerator, long denominator) {
        if (denominator == 0L) throw new IllegalArgumentException("denominator is 0!!!!");
        this.numerator = numerator;
        this.denominator = numerator == 0L ? 1L : denominator;
    }
    
    //-----------------------------------------------
    public Fraction() {
        this(1, 1);
    }
    
    //-----------------------------------------------
    public Fraction(int i) {
        this(i, 1);
    }
    
    //------------------------------------------------
    public Fraction(long d) {
        this(d, 1);
    }
    
    //-----------------------------------------------
    public Fraction(Fraction f) {
        this(f.numerator, f.denominator);
    }
    
    //-----------------------------------------------
    public Fraction add(Fraction f) {
        var result = new Fraction(numerator * f.denominator + denominator * f.numerator, denominator * f.denominator);
        return result;
    }
    
    //-----------------------------------------------
    public Fraction multiply(Fraction f) {
        return new Fraction(numerator * f.numerator, denominator * f.denominator);
    }
    
    //-----------------------------------------------
    public Fraction multiply(long d) {
        return new Fraction(numerator * d, denominator);
    }
    
    //-----------------------------------------------
    public Fraction subtract(Fraction f) {
        return add(f.negate());
    }
    
    //-----------------------------------------------
    public Fraction divide(Fraction f) {
        return multiply(f.reciproke());
    }
    
        
    //-----------------------------------------------
    public Fraction reciproke() {
        return new Fraction(denominator, numerator);
    }
    
    //-----------------------------------------------
    public Fraction negate() {
        return new Fraction(-numerator, denominator);
    }
    
    //-----------------------------------------------
    public double decimalValue() {
        return 1.0 * numerator / denominator;
    }
    
    //-----------------------------------------------
    public Fraction divide(long d) {
        var result = new Fraction(this.numerator, numerator == 0 ? 1L : denominator * d);
        return result;
    }
    
    //-----------------------------------------------
    @Override
    public String toString() {
        return String.format("%s / %s (%.5f)", numerator, denominator, this.decimalValue());
    }
    
    //-----------------------------------------------
    public Fraction middleSpecial(Fraction f) {
        return new Fraction(this.numerator + f.numerator, this.denominator + f.denominator);
    }
    
    //-----------------------------------------------
    public Fraction middle(Fraction f) {
        var result = this.add(f).divide(2);
        return result;
    }
    
    //-----------------------------------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (o instanceof Long || o instanceof Integer) {
            if (this.equals(new Fraction((Long) o))) return true;
            else return false;
        }
        if (o instanceof Fraction) {
            var f = (Fraction) o;
            return numerator * f.denominator == denominator * f.numerator;
        }
        return false;      
    }

    //-----------------------------------------------
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (int) (this.numerator ^ (this.numerator >>> 32));
        hash = 13 * hash + (int) (this.denominator ^ (this.denominator >>> 32));
        return hash;
    }
}

//*******************************************************************
// Paie<K, V>
//*******************************************************************
class Pair<K, V> {
    
    final K k;
    final V v;
    
    //-----------------------------------------------
    Pair(K k, V v) {
        this.k = k;
        this.v = v;
    }
    
    //-----------------------------------------------
    @Override
    public boolean equals(Object p) {
        if (this == p) return true;
        if (p == null) return false;
        if (!(p instanceof Pair)) return false;
        var q = (Pair) p;
        return k.equals(q.k) && v.equals(q.v);
    }

    //-----------------------------------------------
    @Override
    public int hashCode() {
        var hash = 7;
        hash = 53 * hash + Objects.hashCode(this.k);
        hash = 53 * hash + Objects.hashCode(this.v);
        return hash;
    }
    
    //-----------------------------------------------
    @Override
    public String toString() {
        return String.format("(%s, %s)", k, v);
    }   
}

//**************************************************************************
//   Segment
//**************************************************************************
class Segment extends Pair<Fraction, Fraction> {
    
    //-----------------------------------------------
    Segment(Fraction f, Fraction g) {
        super(f, g);
    }
    
    //-----------------------------------------------
    public double length() {
        return Math.abs(k.decimalValue() - v.decimalValue());
    }
    
    //-----------------------------------------------
    public Segment middleSpecial(double d) {
        var newFraction = this.k.middleSpecial(this.v);
        var result = newFraction.decimalValue() < d ? 
            new Segment(newFraction, this.v) : 
            new Segment(this.k, newFraction)
        ;
        return result;
    }
    
    //-----------------------------------------------
    public Segment middle(double d) {
        var newFraction = this.k.add(this.v).divide(2);
        var result = newFraction.decimalValue() < d ?
                         new Segment(newFraction, this.v) :
                         new Segment(this.k, newFraction)
        ;
        return result;
    }
    
    //-----------------------------------------------
    public static Segment determineSegment(double d, double accuracy, UnaryOperator<Segment> function) {
        if (d == 0.0) return new Segment(new Fraction(0, 1), new Fraction(0, 1));
        var start = new Fraction((long) d, 1);
        var eind = new Fraction((long) d + 1, 1);
        var result = Stream.iterate(
                new Segment(start, eind), 
                segment -> segment.length() > accuracy, 
                segment -> function.apply(segment)
            )
            .collect(toList())
        ;
        var segment = result.get(result.size() - 1);
        result.add(function.apply(segment));
        result.forEach(System.out::println);
        return result.get(result.size() - 1);
    }
    
    //-----------------------------------------------
    @Override
    public String toString() {
        return String.format("(%s, %s) (%.5f)", k, v, this.length());
    } 
    
    //-----------------------------------------------
    public static void main(String... args) {
        double f = 7.588, accuracy = 0.001;
//        var t = Segment.determineSegment(f, accuracy, s -> s.middleSpecial(f));
//        System.out.println(t);
//        System.out.println("n*******************************************");
        var t = Segment.determineSegment(f, accuracy, s -> s.middle(f));
        System.out.println(t);
    }
}
