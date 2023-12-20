package org.eapsa;

import java.math.BigInteger;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/labseq")
public class LabSeq {

    @Path("{n}")
    
    @GET
    public BigInteger labseq(int n) {
        if(n < 0) throw new IllegalArgumentException("Number must be non-negative integer");
        return getLabseq(n);
    }

    private BigInteger getLabseq(int n){
        switch (n) {
            case 0:
                return BigInteger.valueOf(0);
            case 1:
                return BigInteger.valueOf(1);
            case 2:
                return BigInteger.valueOf(0);
            case 3:
                return BigInteger.valueOf(1);
            default:
                BigInteger[] result = new BigInteger[n+1];
                result[0] = BigInteger.valueOf(0);
                result[1] = BigInteger.valueOf(1);
                result[2] = BigInteger.valueOf(0);
                result[3] = BigInteger.valueOf(1);
                for (int i=4; i<=n; i++){
                    result[i] = result[i-4].add(result[i-3]);
                }
                return result[n];
        }
    }
}