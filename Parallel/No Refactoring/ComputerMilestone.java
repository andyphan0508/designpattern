package com.example.codesmell.parallelinheritence;
public class ComputerMileStone implements MileStone {
    @Override
    public String work() {return "Build a Billing MicroService";}
    @Override
    public String target() {return "Has to be finished in 14 PD";}
    @Override
    public String toString() {
        return "ComputerMileStone [work()=" + work() + ", target()=" + target()+ "]";
    }
}
