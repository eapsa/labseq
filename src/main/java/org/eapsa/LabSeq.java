package org.eapsa;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/labseq")
public class LabSeq {

    @Path("{n}")
    @GET
    public int labseq(int n) {
        return getLabseq(n);
    }

    private int getLabseq(int n){
        int[] result = new int[n+1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 0;
        result[3] = 1;
        for (int i=4; i<=n; i++){
            result[i] = Math.abs(result[i-4]) + result[i-3];
        }
        return result[n];
    }
}